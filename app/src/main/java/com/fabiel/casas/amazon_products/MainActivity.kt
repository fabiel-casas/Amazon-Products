package com.fabiel.casas.amazon_products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fabiel.casas.amazon_products.data.models.Product
import com.fabiel.casas.amazon_products.view.adapter.ProductAdapter
import com.fabiel.casas.amazon_products.view.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_amazon_product_list.*
import kotlinx.android.synthetic.main.product_item_list.view.*
import kotlinx.android.synthetic.main.products_list.*

class MainActivity : AppCompatActivity() {

    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amazon_product_list)
        setSupportActionBar(toolbar)
        toolbar.title = title
        setupProducts()
    }

    private fun setupProducts() {
        val adapter = ProductAdapter()
        model.productList.observe(this, Observer {
            productsRecyclerView.isVisible = true
            adapter.setItems(it)
        })
        model.productListError.observe(this, Observer {
            productsRecyclerView.isVisible = false
            Snackbar.make(productsRecyclerView, it, Snackbar.LENGTH_LONG).show()
        })
        productsRecyclerView.adapter = adapter
        productsRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onResume() {
        super.onResume()
        model.getProducts()
    }
}