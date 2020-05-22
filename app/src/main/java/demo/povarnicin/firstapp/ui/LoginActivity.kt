package demo.povarnicin.firstapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import demo.povarnicin.firstapp.*
import demo.povarnicin.firstapp.data.User
import demo.povarnicin.firstapp.utils.SharedPrefWrapper
import demo.povarnicin.firstapp.utils.UserStorage
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPrefWrapper = SharedPrefWrapper(this)
        val id = sharedPrefWrapper.id
        if (sharedPrefWrapper.checkIfUserLoggedIn() && id != -1) {
            val result = UserStorage()
            val user = result.find(id)
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
            finish()
        }
        bLogin.setOnClickListener {
            checkUserData()
        }
    }

    private fun checkUserData() {
        var user: User? = null
        var flag1 = false
        var flag2 = false
        var flag3 = false
        val matcher = Pattern.compile(
                "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}").matcher(etPassword!!.text.toString())
        if (matcher.matches()) {
            flag1 = true
        }
        val matcher2 = Pattern.compile(
                "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+").matcher(etEmail!!.text.toString().trim { it <= ' ' })
        if (matcher2.matches()) {
            flag3 = true
        }
        val result = UserStorage()
        var i = 0
        while (i < result.arraylist.size) {
            if (result.arraylist[i].password == etPassword!!.text.toString().trim { it <= ' ' } && result.arraylist[i].email == etEmail!!.text.toString().trim { it <= ' ' }) {
                flag2 = true
                user = result.arraylist[i]
                val sharedPrefWrapper = SharedPrefWrapper(this)
                sharedPrefWrapper.saveUserLoggedIn()
                sharedPrefWrapper.saveId(user.id)
            }
            i++
        }
        if (flag1 && flag2 && flag3) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Incorrect data", Toast.LENGTH_SHORT).show()
        }
    }
}