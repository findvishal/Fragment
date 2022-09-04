package com.example.recylerviewyt.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recylerviewyt.adapter.MyAdapter
import com.example.recylerviewyt.model.Article
import com.example.recylerviewyt.model.News
import com.example.recylerviewyt.retrofit.NewsInterface
import com.example.recylerviewyt.retrofit.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {
    lateinit var newsList: MutableLiveData<List<Article>>
    lateinit var myAdapter: MyAdapter

    init {
        newsList= MutableLiveData()

        myAdapter= MyAdapter(listOf())
    }
    fun getAdapter():MyAdapter{
        return myAdapter
    }
    fun setAdapterData(data: List<Article>){
        myAdapter.setNews(data)
        myAdapter.notifyDataSetChanged()
    }
    fun getObserver(): MutableLiveData<List<Article>> {
        return newsList
    }

    fun fetchNews(){
        val retroInstance= RetroInstance.getInstance()
        val retroService= retroInstance.create(NewsInterface::class.java)
        val call= retroService.getHeadlines("in",1)
        call.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                newsList.postValue(response.body()?.articles)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                newsList.postValue(null)
            }

        })
    }


}