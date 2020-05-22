package demo.povarnicin.firstapp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class SharedPrefWrapper(private val context: Context) {
    private val sPref: SharedPreferences
    fun saveUserLoggedIn() {
        val editor = sPref.edit()
        editor.putBoolean(USER_LOGGED_IN, true)
        editor.apply()
    }

    fun setUserLoggedOut() {
        val editor = sPref.edit()
        editor.putBoolean(USER_LOGGED_IN, false)
        editor.apply()
    }

    fun checkIfUserLoggedIn(): Boolean {
        val flag = sPref.getBoolean(USER_LOGGED_IN, false)
        return sPref.getBoolean(USER_LOGGED_IN, false)
    }

    fun saveId(id: Int) {
        val editor = sPref.edit()
        editor.putInt(USER_ID, id)
        editor.apply()
    }

    val id: Int
        get() = sPref.getInt(USER_ID, -1)

    companion object {
        private const val USER_LOGGED_IN = "userLoggedIn"
        private const val USER_ID = "userLoggedId"
    }

    init {
        sPref = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    }
}