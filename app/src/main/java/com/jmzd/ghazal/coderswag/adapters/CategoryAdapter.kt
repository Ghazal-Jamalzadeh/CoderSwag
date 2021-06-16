package com.jmzd.ghazal.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jmzd.ghazal.coderswag.R
import com.jmzd.ghazal.coderswag.model.Category


class CategoryAdapter( val context: Context, val categories: List<Category>) : BaseAdapter(){
    // R-click -> move to constructor
//    val context = context
//    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder : ViewHolder

        if (convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder
            println("I exist for the first time...")
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            //reusing the cells
            println("go green , recycle ")
        }
// تو لیست ویو برای هر ردیف یک بارها و هربار این فرایند تکرار می‌شود و اصلا بهینه نیست. راه حل : ویو هلدر است که ویوهای تکراری را ریسایکل میکند و از اول نمیسازد و Heavy Computing اتفاق نمی افتد. بدون استفاده از ویوهلدر هم لیست ویو به خوبی کار می کند ولی در بک گراند پردازش سنگین صورت می گیرد.

        val category = categories[position]
        //convert image name to resource id
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    // this is a method that defines a unique ID for each row. but we don't need it for now.
    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    // this view holder is going to hold a reference to our categoryImage & categoryName
    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}