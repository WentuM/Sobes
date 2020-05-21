package demo.povarnicin.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogout;
    TextView etName, etEmail, etSurname;

    @SuppressLint({"CutPasteId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.test1));

        User currentUser = (User) getIntent().getSerializableExtra("user");
        if (currentUser == null) {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        etName = (TextView) findViewById(R.id.etName);
        etName.setText("" + currentUser.getName());
        etSurname = (TextView) findViewById(R.id.etSurname);
        etSurname.setText("" + currentUser.getSurname());
        etEmail = (TextView) findViewById(R.id.etEmail);
        etEmail.setText("" + currentUser.getEmail());
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //знаю, что одно условие, оставлю на случай, если будут другие кнопки
        switch (v.getId()) {
            case R.id.bLogout:
                SharedPrefWrapper sharedPrefWrapper = new SharedPrefWrapper(this);
                sharedPrefWrapper.setUserLoggedOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
