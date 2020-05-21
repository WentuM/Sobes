package demo.povarnicin.firstapp;

import android.content.Context;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPrefWrapper {

    private static final String USER_LOGGED_IN = "userLoggedIn";
    private static final String USER_ID = "userLoggedId";
    private Context context;
    private SharedPreferences sPref;

    public SharedPrefWrapper(Context context) {
        this.context = context;
        sPref = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE);
    }

    void saveUserLoggedIn() {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putBoolean(USER_LOGGED_IN, true);
        editor.apply();
    }

    void setUserLoggedOut() {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putBoolean(USER_LOGGED_IN, false);
        editor.apply();
    }

    boolean checkIfUserLoggedIn() {
        boolean flag = sPref.getBoolean(USER_LOGGED_IN, false);
        return sPref.getBoolean(USER_LOGGED_IN, false);
    }

    void saveId(int id) {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt(USER_ID, id);
        editor.apply();
    }

    public int getId() {
        return sPref.getInt(USER_ID, -1);
    }
}
