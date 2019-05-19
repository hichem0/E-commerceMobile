package com.fges.rizomm.m1.ecommercemobile.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import android.widget.FrameLayout
import com.fges.rizomm.m1.ecommercemobile.R
import com.fges.rizomm.m1.ecommercemobile.model.Product
import com.fges.rizomm.m1.ecommercemobile.network.ProductService
import com.fges.rizomm.m1.ecommercemobile.ui.Adapter.ProductsAdapter

import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Main2Activity : AppCompatActivity() {

    private val url = "https://techtools.herokuapp.com/produits/"


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
            R.id.navigation_order -> {
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

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retrofit.create(ProductService::class.java)

        val produitRequest = service.listProduits()

        produitRequest.enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {

                val allProduit = response.body()

                recycler_view.apply {
                    layoutManager = GridLayoutManager(this@Main2Activity, 2)
                    adapter = allProduit?.let { ProductsAdapter(it) }
               }
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                error("No products found.")
            }
        })

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
