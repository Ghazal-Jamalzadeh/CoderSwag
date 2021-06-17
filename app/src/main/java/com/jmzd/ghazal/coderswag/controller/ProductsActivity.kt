package com.jmzd.ghazal.coderswag.controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.jmzd.ghazal.coderswag.R
import com.jmzd.ghazal.coderswag.adapters.ProductsAdapter
import com.jmzd.ghazal.coderswag.databinding.ActivityProductsBinding
import com.jmzd.ghazal.coderswag.services.DataService
import com.jmzd.ghazal.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {
    lateinit var adapter : ProductsAdapter
    lateinit var binding : ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        binding = ActivityProductsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        Toast.makeText(this,categoryType , Toast.LENGTH_SHORT ).show()
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))
        //we pass into it a string, which is our categoryType. and that is going to return to us the correct list of products based on the category that we clicked on in our MainActivity.


        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        binding.productsListView.layoutManager = layoutManager
        binding.productsListView.adapter = adapter
    }
}