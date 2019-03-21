package com.fges.rizomm.m1.ecommercemobile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Register : AppCompatActivity() {

    lateinit var mbtninscription: Button
    lateinit var mnameuser: EditText
    lateinit var mpassworduser: EditText
    lateinit var memailuser: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        memailuser = findViewById(R.id.emailuser)
        mnameuser = findViewById(R.id.nameuser)
        mpassworduser = findViewById(R.id.passworduser)
        mbtninscription = findViewById(R.id.btninscription)

        mbtninscription.setOnClickListener {
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}