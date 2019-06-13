package com.retech.myapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.retech.myapplication.R
import kotlinx.android.synthetic.main.activity_design.*

class DesignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design)

        val username = intent.extras.getString("username")
        val password = intent.extras.getString("password")

        et_username.setText(username)
        et_password.setText(password)

        val v: View

    }
}
