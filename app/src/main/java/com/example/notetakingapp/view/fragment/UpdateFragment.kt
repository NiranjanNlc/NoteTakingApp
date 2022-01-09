package com.example.notetakingapp.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.notetakingapp.R
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
        setHasOptionsMenu(true)
        return  binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_menu -> {
                updateData()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateData() {


    }

}