package com.fges.rizomm.m1.ecommercemobile

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.FrameLayout
import com.fges.rizomm.m1.ecommercemobile.data.Product
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URI
import java.net.URL

class Main2Activity : AppCompatActivity() {

    private var content: FrameLayout? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

            item -> when (item.itemId) {

            R.id.navigation_home -> {
               // message.setText(R.string.title_dashboard)
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
            R.id.navigation_order-> {
               // message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_question -> {


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        doAsync {
            val json = URL("https://techtools.herokuapp.com/produits").readText()

            uiThread {
                val products = Gson().fromJson(json, Array<Product>::class.java).toList()

                recycler_view.apply {
                    layoutManager = GridLayoutManager(this@Main2Activity, 2)
                    adapter = ProductsAdapter(products)
                }

            }

        }



    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
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
}
