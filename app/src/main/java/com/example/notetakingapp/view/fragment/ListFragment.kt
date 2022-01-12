package com.example.notetakingapp.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.notetakingapp.R
import com.example.notetakingapp.databinding.FragmentListBinding
import com.example.notetakingapp.utils.ViewModelUtil
import com.example.notetakingapp.view.adapter.NotesAdapter
import com.example.notetakingapp.viewmodel.ViewModal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var viewModal: ViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        setOnclickListener()
        viewModal = context?.let { ViewModelUtil.getViewModel(it) }!!
        viewModal.notes.observe(viewLifecycleOwner,{
            binding.listRecyclerView.adapter = NotesAdapter(it)
        })
        return  binding.root
    }

    private fun setOnclickListener() {
        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }


}