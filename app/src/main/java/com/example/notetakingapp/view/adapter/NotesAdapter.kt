package com.example.notetakingapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakingapp.model.data.Notes


class NotesAdapter(var todoList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(private val binding: NotesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Notes) {
            binding.todoData = todo
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NotesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NotesItemBinding.inflate(layoutInflater, parent, false)
                return NotesViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder.from(parent)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val todo = todoList[position]
        holder.bind(todo)
    }

    fun setList(list: List<Notes>) {
        val diffUtil = NotesDiffUtil(todoList, list)
        val differResult = DiffUtil.calculateDiff(diffUtil)
        this.todoList = list
        differResult.dispatchUpdatesTo(this)
    }