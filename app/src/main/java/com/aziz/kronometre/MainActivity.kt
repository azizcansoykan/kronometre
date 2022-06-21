package com.aziz.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     var runnable : Runnable = Runnable {  }
     var number = 0
     var handler : Handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun start (view: View){

        number = 0
        button2.visibility = View.INVISIBLE
        button4.visibility = View.VISIBLE
        imageViewSarı.visibility = View.INVISIBLE
        imageViewKırmızı.visibility = View.VISIBLE

         runnable = object : Runnable {
             override fun run() {
                 number++
                 kronometre.text = "süre:" + number
                 handler.postDelayed(this,1000)
             }

         }
        handler.post(runnable)
    }

    fun restart(view: View) {
        handler.removeCallbacks(runnable)
        kronometre.text = "süre: 0"
        button4.visibility = View.INVISIBLE
        button2.visibility = View.VISIBLE
        imageViewSarı.visibility = View.VISIBLE
        imageViewKırmızı.visibility = View.INVISIBLE
    }


}