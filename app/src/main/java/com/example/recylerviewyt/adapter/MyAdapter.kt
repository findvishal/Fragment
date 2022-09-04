package com.example.recylerviewyt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recylerviewyt.R
import com.example.recylerviewyt.databinding.ListItemBinding
import com.example.recylerviewyt.model.Article
import com.example.recylerviewyt.ui.fragment.DetailedFragment

class MyAdapter(private var newsList: List<Article>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    fun setNews(newsList: List<Article>){
        this.newsList=newsList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding=ListItemBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        newsList?.let {
        it[position]}?.let { holder.bind(it) }
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            val demoFragment=DetailedFragment()

            override fun onClick(v: View?) {
                val activity=v!!.context as AppCompatActivity
                activity.supportFragmentManager.beginTransaction().replace(R.id.frame_layout,demoFragment)
                    .addToBackStack(null).commit()
              holder.binding?.artcleItem?.let { demoFragment.setData(it) }
            }


        })
    }

    override fun getItemCount(): Int {
        return newsList?.let { it.size }?:0
    }

    class MyViewHolder (val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Article){
            binding.artcleItem=data
            binding.executePendingBindings()
        }

    }
    companion object{
        @JvmStatic
        @androidx.databinding.BindingAdapter("loadImage")
        fun loadImage(newsImage: ImageView, url:String?){
            Glide.with(newsImage)
                .load(url)
                .into(newsImage)
        }
    }
}