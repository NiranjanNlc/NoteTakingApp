package com.example.notetakingapp.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.notetakingapp.model.data.Notes

class NotesDiffUtil(val oldList: List<Notes>, val newList: List<Notes>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size


    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
    {
       return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].description == newList[newItemPosition].description
                && oldList[oldItemPosition].fidility == newList[newItemPosition].fidility
    }

}
