package demo.povarnicin.firstapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import demo.povarnicin.firstapp.R
import demo.povarnicin.firstapp.utils.SharedPrefWrapper
import demo.povarnicin.firstapp.data.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentUser = intent.getSerializableExtra("user") as User
        setContentView(R.layout.activity_main)
        imageView.setImageResource(currentUser.imageView)
        if (currentUser == null) {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        etName!!.text = currentUser.name
        etSurname!!.text = currentUser.surname
        etEmail!!.text = currentUser.email
        bLogout.setOnClickListener {
            logoutAcc()
        }
    }

    private fun logoutAcc() {
        val sharedPrefWrapper = SharedPrefWrapper(this)
        sharedPrefWrapper.setUserLoggedOut()
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}