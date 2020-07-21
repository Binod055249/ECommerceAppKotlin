package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_all_json_object.*

class ShowAllJsonObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_json_object)

        txtAllProducts.setOnClickListener {

            val allProductsUrl:String="http://192.168.42.115/ECommerc/present_json_array.php"
            var allProductsString:String=""
             val requestQ:RequestQueue=Volley.newRequestQueue(this@ShowAllJsonObjectActivity)
            val jsonAR=JsonArrayRequest(Request.Method.GET,allProductsUrl,null,
            Response.Listener {response ->
             for(productIndex in 0.until(response.length())) {
//                 allProductsString+=response.getJSONObject(productIndex).getString("name")+" - "+
//                              response.getJSONObject(productIndex).getString("price")
                 var id=response.getJSONObject(productIndex).getInt("id")
                 var pn=response.getJSONObject(productIndex).getString("name")
                 var pp=response.getJSONObject(productIndex).getInt("price")
                 allProductsString= allProductsString + id+" - "+pp + " - "+pn+"\n"
                 txtAllProducts.text=allProductsString
             }
            },Response.ErrorListener { error ->
                  txtAllProducts.text=error.message
                })
  requestQ.add(jsonAR)
        }
    }
}