package com.example.recylerviewyt.model

data class News(val articles: List<Article>)
data class Article(val author:String, val title:String,val description:String,val url:String,val urlToImage:String)