package com.jmzd.ghazal.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jmzd.ghazal.coderswag.R
import com.jmzd.ghazal.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        Toast.makeText(this,categoryType , Toast.LENGTH_SHORT ).show()

    }
}