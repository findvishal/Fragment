package com.example.recylerviewyt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recylerviewyt.BR
import com.example.recylerviewyt.R
import com.example.recylerviewyt.databinding.FragmentHomeBinding
import com.example.recylerviewyt.model.Article

class HomeFragment : Fragment() {
    var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        setViewModel()
        return binding.root
    }



    fun setViewModel() :HomeViewModel{
        val viewModel= ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.homeFrag=viewModel
        viewModel.getObserver().observe(viewLifecycleOwner, Observer{
            it?.let {
                viewModel.setAdapterData(it)
            }
        })

        viewModel.fetchNews()
        return viewModel
    }

}