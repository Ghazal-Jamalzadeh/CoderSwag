package com.jmzd.ghazal.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmzd.ghazal.coderswag.R
import com.jmzd.ghazal.coderswag.adapters.CategoryRecycleAdapter
import com.jmzd.ghazal.coderswag.databinding.ActivityMainBinding
import com.jmzd.ghazal.coderswag.services.DataService
import com.jmzd.ghazal.coderswag.utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {
   // lateinit var adapter: ArrayAdapter<Category>
    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
          // Toast.makeText(this, "${category.title}" , Toast.LENGTH_SHORT).show()
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)//we need to know what category is clicked
            startActivity(productIntent)
        }
        binding.categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        binding.categoryListView.layoutManager = layoutManager
        binding.categoryListView.setHasFixedSize(true)
    }
}