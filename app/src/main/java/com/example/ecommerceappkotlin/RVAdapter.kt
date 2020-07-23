package com.example.ecommerceappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(var context: Context, var arrayList: ArrayList<EProducts>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var productView=LayoutInflater.from(context).inflate(R.layout.rv_row,parent,false)
        return ProductViewHolder(productView)
    }

    override fun getItemCount(): Int {
    return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ProductViewHolder).initializeUIComponents(arrayList[position].id,
            arrayList[position].name,arrayList[position].price,arrayList[position].productPicture)
    }

    inner class ProductViewHolder(myView:View):RecyclerView.ViewHolder(myView){

        var rv_row_pId=myView.findViewById<TextView>(R.id.rv_row_pId)
        var rv_row_pName=myView.findViewById<TextView>(R.id.rv_row_pName)
        var rv_row_pPrice=myView.findViewById<TextView>(R.id.rv_row_pPrice)
        var rv_row_productImage=myView.findViewById<ImageView>(R.id.rv_row_productImage)

        fun initializeUIComponents(rv_row_pId:Int,rv_row_pName:String,rv_row_pPrice:Int,rv_row_productImage:Int){

            this.rv_row_pId.text=rv_row_pId.toString()
            this.rv_row_pName.text=rv_row_pName.toString()
            this.rv_row_pPrice.text=rv_row_pPrice.toString()
            this.rv_row_productImage.setImageResource(rv_row_productImage)

        }

    }

}