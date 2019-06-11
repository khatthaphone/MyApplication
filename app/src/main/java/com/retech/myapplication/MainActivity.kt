package com.retech.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

val username = "admin"
val password = "1234"

class MainActivity : AppCompatActivity() {

    val MY_SHARED_PREFS = "MY_APP_SHARED_PREFS"

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var checkbox: CheckBox

    lateinit var sharedPrefs: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, CalculatorActivity::class.java)
//        startActivity(intent)

        sharedPrefs = getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE)
        editor = sharedPrefs.edit()

        initViews()


        onLogin()

        onChecked()

    }

    private fun onChecked() {
        checkbox.setOnClickListener {
            if (checkbox.isChecked) {
                Toast.makeText(this, "Remember Username", Toast.LENGTH_LONG).show()

                val username = etUsername.text.toString()

                editor.putString("username", username).commit()

            } else {
                Toast.makeText(this, "Do not Remember Username", Toast.LENGTH_LONG).show()

                editor.putString("username", "").commit()

            }
        }
    }

    private fun onLogin() {
        btnLogin.setOnClickListener {
            val enterUsername = etUsername.text.toString()
            val enterPassword = etPassword.text.toString()

            Log.e("MainActivity", "enter username: $enterUsername == $username = ${enterUsername == username}")
            Log.e("MainActivity", "enter password: $enterPassword == $password = ${enterPassword == password}")

            if (enterUsername == username && enterPassword == password) {
                Toast.makeText(applicationContext, "Correct Username and Password", Toast.LENGTH_LONG).show()

                val intent = Intent(this, DesignActivity::class.java)
                intent.putExtra("username", enterUsername)
                intent.putExtra("password", enterPassword)

                startActivity(intent)
    //                finish()

            } else {
                Toast.makeText(applicationContext, "Incorrect Username and Password", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun initViews() {
        etUsername = et_username
        etPassword = et_password
        btnLogin = btn_login
        checkbox = cb_remember_username

        val username = sharedPrefs.getString("username", "")

        if (!username.isBlank()) {

            checkbox.isChecked = true

            etUsername.setText(username)
        }

        // Detect First run
        val firstRun = sharedPrefs.getBoolean("firstRun", true)

        if (firstRun) {
            Toast.makeText(this, "Hello new User", Toast.LENGTH_LONG).show()

            editor.putBoolean("firstRun", false).commit()
        }

    }
}
