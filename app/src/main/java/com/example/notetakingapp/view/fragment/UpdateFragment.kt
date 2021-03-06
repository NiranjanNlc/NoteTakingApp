package com.example.notetakingapp.view.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notetakingapp.R
import com.example.notetakingapp.databinding.FragmentUpdateBinding
import com.example.notetakingapp.model.data.Notes
import com.example.notetakingapp.utils.AppUtil
import com.example.notetakingapp.viewmodel.ViewModal


class UpdateFragment : Fragment()
{
    private lateinit var _binding: FragmentUpdateBinding
    private lateinit var viewModal: ViewModal;
    lateinit var builder: AlertDialog.Builder
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return  _binding.apply {
            builder = AlertDialog.Builder(requireContext())
            val notes = arguments?.get("notes") as Notes
            println( " notes reieved  $notes" )
            _binding!!.notes = notes
            setHasOptionsMenu(true)
            viewModal = context?.let { AppUtil.getViewModel(it) }!!
            observeValue()
        }.root
    }

    private fun observeValue()
    {
     viewModal.updateStatus.observe(viewLifecycleOwner,{
         if (it) {
             println(" updat section  ${it.toString()}")
             dialog.dismiss()
             findNavController().navigate(R.id.action_updateFragment_to_listFragment)
         }
     })
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

    private fun updateData()
    {
 
        if(_binding.notes !=null)
        {
            println(" Our notes ${_binding.notes}")
            showLoadngDalog()
            viewModal.addData(_binding.notes)
        }
    }
 
    private fun showLoadngDalog() {
        builder.setView(layoutInflater.inflate(R.layout.activity_loading_layout,null))
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.show()
    }

}