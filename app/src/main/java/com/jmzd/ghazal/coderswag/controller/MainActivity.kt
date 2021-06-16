package com.jmzd.ghazal.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.jmzd.ghazal.coderswag.R
import com.jmzd.ghazal.coderswag.databinding.ActivityMainBinding
import com.jmzd.ghazal.coderswag.model.Category
import com.jmzd.ghazal.coderswag.services.DataService

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            DataService.categories
        ) // context , layout , data
        binding.categoryListView.adapter = adapter
    }
}