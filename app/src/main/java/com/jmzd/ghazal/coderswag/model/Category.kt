package com.jmzd.ghazal.coderswag.model

class Category(val title: String, val image: String) {
   // قبل از اد کردن این متد لیست را به صورت string نمایش نمیدهد داخل listView
    override fun toString(): String {
        return title
    }
}