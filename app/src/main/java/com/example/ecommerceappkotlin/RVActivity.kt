package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_r_v.*

class RVActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_v)

        var myProductList=ArrayList<EProducts>()
        myProductList.add(EProducts(0,"IPhone",1000,R.drawable.iphone))
        myProductList.add(EProducts(1,"IPad",2000,R.drawable.ipad))
        myProductList.add(EProducts(2,"AppleTv",1000,R.drawable.appletv))
        myProductList.add(EProducts(3,"AppleWatch",2000,R.drawable.applewatch))
        myProductList.add(EProducts(4,"IPodnano",1000,R.drawable.ipodnano))
        myProductList.add(EProducts(5,"IMac",2000,R.drawable.imac))
        myProductList.add(EProducts(6,"Macpro",1000,R.drawable.macpro))
        myProductList.add(EProducts(7,"MacBookAir",2000,R.drawable.macbookair))

        var rvAdapter=RVAdapter(this@RVActivity,myProductList)

        recyclerView.layoutManager=LinearLayoutManager(this@RVActivity)
        recyclerView.adapter=rvAdapter


    }
}