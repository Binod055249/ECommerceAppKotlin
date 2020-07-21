 package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*


 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGetData.setOnClickListener {

            val serverUrl:String="http://192.168.42.115/PHPTest/test_file.php"
            var requestQ:RequestQueue=Volley.newRequestQueue(this@MainActivity)
           var stringRequest=StringRequest(Request.Method.GET,serverUrl,
               Response.Listener { response ->

                   txtHelloWorld.text=response
               },Response.ErrorListener {error ->

                     txtHelloWorld.text=error.message
               })
            requestQ.add(stringRequest)
        }
    }
}