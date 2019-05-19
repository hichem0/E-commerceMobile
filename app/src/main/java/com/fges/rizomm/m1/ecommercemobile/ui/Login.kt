package com.fges.rizomm.m1.ecommercemobile.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.fges.rizomm.m1.ecommercemobile.R

public class Login : AppCompatActivity() {

    lateinit var mbtnconnecter: Button
    lateinit var mname: EditText
    lateinit var mpassword: EditText
    lateinit var mcreatelogin: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        mbtnconnecter= findViewById(R.id.btnconnecter)
        mname= findViewById(R.id.name)
        mpassword= findViewById(R.id.password)
        mcreatelogin=findViewById(R.id.logincreatebtn)

        mcreatelogin.setOnClickListener {
            val intent= Intent(applicationContext, Register::class.java)
            startActivity(intent)
            finish()
        }
    }


}
