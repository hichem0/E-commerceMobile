package com.fges.rizomm.m1.ecommercemobile.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.fges.rizomm.m1.ecommercemobile.R
import com.fges.rizomm.m1.ecommercemobile.Register
import com.fges.rizomm.m1.ecommercemobile.ui.fragment.BlankFragment
import com.fges.rizomm.m1.ecommercemobile.ui.fragment.BlankFragment2
import kotlinx.android.synthetic.main.activity_main2.*




class Main2Activity : AppCompatActivity() {

    private val blankFragment: Fragment = BlankFragment()


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

            item -> when (item.itemId) {

            R.id.navigation_home -> {
                val mHomeFragmentr = BlankFragment2()
                replaceFragment(mHomeFragmentr)
                return@OnNavigationItemSelectedListener true

            }




//            R.id.navigation_home -> {
//                message.setText(R.string.title_home)
//                return@OnNavigationItemSelectedListener true
//            }


            R.id.navigation_login -> {
                val intent = Intent(this, Register::class.java)
                this.startActivity(intent)
            }
            R.id.navigation_order -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_question -> {
                val mHomeFragment = BlankFragment()
                replaceFragment(mHomeFragment)

                return@OnNavigationItemSelectedListener true
            }


            R.id.action_settings -> {
                // User chose the "Settings" item, show the app settings UI...
                true
            }

            R.id.action_favorite -> {
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                true
            }

            else -> {
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
            }
        }


        false
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    }


