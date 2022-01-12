package com.example.notetakingapp.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notetakingapp.R
import com.example.notetakingapp.databinding.FragmentAddBinding
import com.example.notetakingapp.databinding.FragmentUpdateBinding
import com.example.notetakingapp.utils.ViewModelUtil
import com.example.notetakingapp.viewmodel.ViewModal


class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private lateinit var viewModal : ViewModal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        viewModal = context?.let { ViewModelUtil.getViewModel(it) }!!
        observeValue()
        return  binding.root
    }

    private fun observeValue() {
        viewModal.updateStatus.observe(viewLifecycleOwner,{
            if (it) {
                println(" upaddt section  ${it.toString()}")
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_menu -> {
                insertData()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertData() {
        viewModal.addData(binding.notes)
    }


}