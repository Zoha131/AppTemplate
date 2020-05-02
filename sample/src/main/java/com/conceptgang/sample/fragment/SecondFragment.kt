package com.conceptgang.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.conceptgang.component.epoxy.DefaultItemDecoration
import com.conceptgang.sample.databinding.FragmentBaseBinding

class SecondFragment : Fragment(){

    lateinit var binding: FragmentBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.epoxyRecycler.addItemDecoration(DefaultItemDecoration())

        binding.epoxyRecycler.withModels {

        }
    }

}