package com.fges.rizomm.m1.ecommercemobile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.fges.rizomm.m1.ecommercemobile.ui.Main2Activity


class SplashActivity : AppCompatActivity() {
        private var mDelayHandler: Handler? = null
        private val SPLASH_DELAY: Long = 1000 //3 seconds

        internal val mRunnable: Runnable = Runnable {
            if (!isFinishing) {

                val intent = Intent(applicationContext, Main2Activity::class.java)
                startActivity(intent)
                finish()
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash)

            //Initialize the Handler
            mDelayHandler = Handler()

            //Navigate with delay
            mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

        }

        public override fun onDestroy() {

            if (mDelayHandler != null) {
                mDelayHandler!!.removeCallbacks(mRunnable)
            }

            super.onDestroy()
        }

    }