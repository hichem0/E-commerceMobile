package com.fges.rizomm.m1.ecommercemobile.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import android.widget.FrameLayout
import com.fges.rizomm.m1.ecommercemobile.R
import kotlinx.android.synthetic.main.activity_main2.*
import android.support.v4.app.Fragment
import com.fges.rizomm.m1.ecommercemobile.Login
import com.fges.rizomm.m1.ecommercemobile.Register
import com.fges.rizomm.m1.ecommercemobile.ui.LoginFragment
import kotlinx.android.synthetic.main.login.*

class Main2Activity : AppCompatActivity() {
    private val list_of_product : Fragment = List_Of_Product()
    private val contactFragment : Fragment = ContactFragment()
    private val loginFragment  :  Fragment = LoginFragment()

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
//                val loginf = LoginFragment()
//                replaceFragment(loginf)
//                return@OnNavigationItemSelectedListener true


                    val intent= Intent(applicationContext, Login::class.java)
                    startActivity(intent)
                    //  finish()
                }

            R.id.navigation_order -> {
                val mHomeFragmen = List_Of_Product()
                replaceFragment(mHomeFragmen)
                return@OnNavigationItemSelectedListener true
            }
        R.id.navigation_question -> {
            val mHomeFragment = ContactFragment()
            replaceFragment(mHomeFragment)

            return@OnNavigationItemSelectedListener true
        }
//            R.id.action_settings -> {
//                // User chose the "Settings" item, show the app settings UI...
//                true
//            }
//
//            R.id.action_favorite -> {
//                // User chose the "Favorite" action, mark the current item
//                // as a favorite...
//                true
//            }

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

//        val service = RetrofitFactory.makeRetrofitService()
//        CoroutineScope(Dispatchers.IO).launch {
//            val request = service.listProduits()
//            withContext(Dispatchers.Main) {
//                try {
//                    val response = request.await()
//                    if (response.isNotEmpty()) {
//
//                        recycler_view.apply {
//                            layoutManager = GridLayoutManager(this@Main2Activity, 2)
//                            adapter = ProductsAdapter(response.toList())
//                        }
//                    } else {
//                        toast("Error")
//                    }
//                } catch (e: HttpException) {
//                    toast("Exception ${e.message}")
//                } catch (e: Throwable) {
//                    toast("Ooops: Something else went wrong")
//                }
//            }
//        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
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
