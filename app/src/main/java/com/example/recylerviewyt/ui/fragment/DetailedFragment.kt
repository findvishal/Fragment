package com.example.recylerviewyt.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recylerviewyt.databinding.FragmentDetailedBinding
import com.example.recylerviewyt.model.Article


class DetailedFragment : Fragment() {
    var _binding:FragmentDetailedBinding?=null
    private val binding get() = _binding!!
    var article:Article?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        //new
        // Inflate the layout for this fragment
        _binding=FragmentDetailedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.articleItem=article
        binding.executePendingBindings()
    }


     fun setData(article: Article) {
        this.article=article
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