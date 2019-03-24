package com.fges.rizomm.m1.ecommercemobile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*

public class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"
    private var mAuth: FirebaseAuth? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


       initialise()
    }
    private fun initialise() {
        mAuth = FirebaseAuth.getInstance()

        logincreatebtn.setOnClickListener {
            val intent= Intent(applicationContext,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnconnecter!!.setOnClickListener { loginUser() }
    }
    private fun loginUser() {
        var email = email?.text.toString()
        var password = password?.text.toString()
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            Log.d(TAG, "Logging in user.")
            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(this@LoginActivity, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }
}
