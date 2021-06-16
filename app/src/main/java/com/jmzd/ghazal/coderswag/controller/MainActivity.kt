package com.jmzd.ghazal.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmzd.ghazal.coderswag.R
import com.jmzd.ghazal.coderswag.adapters.CategoryAdapter
import com.jmzd.ghazal.coderswag.adapters.CategoryRecycleAdapter
import com.jmzd.ghazal.coderswag.databinding.ActivityMainBinding
import com.jmzd.ghazal.coderswag.model.Category
import com.jmzd.ghazal.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
   // lateinit var adapter: ArrayAdapter<Category>
    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            DataService.categories
//        ) // context , layout , data

        adapter = CategoryRecycleAdapter(this, DataService.categories)
        binding.categoryListView.adapter = adapter

        // ریسایکلر ویو برعکس لیست ویو نیاز به layout manager دارد. چند تا حالت دارد.
        // linearLayout -> ریسایکل ویو افقی | Grid
        val layoutManager = LinearLayoutManager(this)
        binding.categoryListView.layoutManager = layoutManager
        binding.categoryListView.setHasFixedSize(true)
}}