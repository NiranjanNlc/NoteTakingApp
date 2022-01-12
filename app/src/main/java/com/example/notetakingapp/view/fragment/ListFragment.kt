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


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding
        get() = _binding!!
    private lateinit var notesAdapter: NotesAdapter

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
        notesAdapter= NotesAdapter(viewModal.notes.value)
       viewModal.notes.observe(viewLifecycleOwner,{
            println(" our list " + it.toString())
            binding.listRecyclerView.adapter = notesAdapter
            notesAdapter.setList(it)
        })
        viewModal.notes.observe(viewLifecycleOwner,{
            println(" our list " + it.toString())
          //  binding.listRecyclerView.adapter
        })
        return  binding.root
    }

    private fun setOnclickListener() {
        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }


}