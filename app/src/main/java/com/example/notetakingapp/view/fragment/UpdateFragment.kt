package com.example.notetakingapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notetakingapp.R
import com.example.notetakingapp.databinding.FragmentAddBinding
import com.example.notetakingapp.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment()
{
    private var _binding: FragmentUpdateBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return  binding.root
    }

}