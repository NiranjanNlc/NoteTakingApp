package com.example.notetakingapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakingapp.databinding.NotesItemBinding
import com.example.notetakingapp.model.data.Notes


class NotesAdapter(var notesList: List<Notes>?,var clickListener: onNotesClickListener) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

   public interface onNotesClickListener
    {
       public fun onClick()
    }
     class NotesViewHolder(private val binding: NotesItemBinding,private val clickListener: onNotesClickListener ) :
        RecyclerView.ViewHolder(binding.root)
    {
        init {
             binding.root.setOnClickListener {
                 clickListener.onClick()
             }
        }
        fun bind(notes: Notes) {
            binding.notes = notes
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, clickListener: onNotesClickListener): NotesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NotesItemBinding.inflate(layoutInflater, parent, false)
                return NotesViewHolder(binding,clickListener)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder.from(parent,clickListener)
    }

    override fun getItemCount(): Int = notesList!!.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val notes = notesList!![position]
        holder.bind(notes)
    }

    fun setList(list: List<Notes>) {
        val diffUtil = notesList?.let { NotesDiffUtil(it, list) }
        val differResult = diffUtil?.let { DiffUtil.calculateDiff(it) }
        this.notesList = list
        if (differResult != null) {
            differResult.dispatchUpdatesTo(this)
        }
    }
}