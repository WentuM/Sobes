package demo.povarnicin.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etEmail, etPassword; //поля, куда вводятся данные, здесь не нужны

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_login);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        SharedPrefWrapper sharedPrefWrapper = new SharedPrefWrapper(this);
        int id = sharedPrefWrapper.getId();
        if (sharedPrefWrapper.checkIfUserLoggedIn() && id != -1) {
            ListUser result = new ListUser();
            User user = result.find(id);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
            finish();
        }

        bLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //знаю, что одно условие, оставлю на случай, если будут другие кнопки
        //например, регистрация, вспомнить пароль и т.д.
        switch (v.getId()) {
            case R.id.bLogin:
                User user = null;
                boolean flag1 = false;
                boolean flag2 = false;
                boolean flag3 = false;
                Matcher matcher = Pattern.compile(
                        "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}").matcher(etPassword.getText().toString());
                if (matcher.matches()) {
                    flag1 = true;
                }
                Matcher matcher2 = Pattern.compile(
                        "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+").matcher(etEmail.getText().toString().trim());
                if (matcher2.matches()) {
                    flag3 = true;
                }
                ListUser result = new ListUser();
                for (int i = 0; i < result.getArraylist().size(); i++) {
                    if (result.getArraylist().get(i).getPassword().equals(etPassword.getText().toString().trim()) &&
                            result.getArraylist().get(i).getEmail().equals(etEmail.getText().toString().trim())) {
                        flag2 = true;
                        user = result.getArraylist().get(i);
                        SharedPrefWrapper sharedPrefWrapper = new SharedPrefWrapper(this);
                        sharedPrefWrapper.saveUserLoggedIn();
                        sharedPrefWrapper.saveId(user.getId());
                    }
                }
                if (flag1 && flag2 && flag3) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Incorrect data", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
