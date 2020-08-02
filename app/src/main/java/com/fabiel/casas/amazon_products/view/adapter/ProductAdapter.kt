package com.fabiel.casas.amazon_products.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fabiel.casas.amazon_products.R
import com.fabiel.casas.amazon_products.data.models.Product
import kotlinx.android.synthetic.main.product_item_list.view.*

class ProductAdapter :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var values: List<Product> = mutableListOf()

    private val onClickListener: View.OnClickListener = View.OnClickListener { v ->
        val item = v.tag as Product
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.productName.text = item.productName
        holder.productPrice.text = "$${item.salesPriceIncVat}"
        Glide.with(holder.itemView.context)
            .load(item.productImage)
            .into(holder.productImage)
        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    fun setItems(products: List<Product>) {
        values = products
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productName: TextView = view.productName
        val productPrice: TextView = view.productPrice
        val productImage: ImageView = view.productImage
    }
}
