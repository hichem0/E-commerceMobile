package com.fges.rizomm.m1.ecommercemobile.ui
import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.fges.rizomm.m1.ecommercemobile.R
import com.fges.rizomm.m1.ecommercemobile.Register
import com.fges.rizomm.m1.ecommercemobile.ui.Main2Activity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*


class LoginFragment : android.support.v4.app.Fragment() {
    private val TAG = "Login"
    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialise()



    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login, container, false)
    }
    private fun initialise() {
        mAuth = FirebaseAuth.getInstance()

        logincreatebtn.setOnClickListener(){
            val intent = Intent(activity,Register::class.java)
            startActivity(intent)

        }
        btnconnecter!!.setOnClickListener { loginUser() }
    }

    private fun loginUser() {
        var email = email?.text.toString()
        var password = password?.text.toString()
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            Log.d(TAG, "Logging in user.")
            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val intent = Intent(activity, Main2Activity::class.java)
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            activity, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        } else {
            Toast.makeText(activity, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }






    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }

}



