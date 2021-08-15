package com.nikol.bookshelfapp.ui.filters.adapter

import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.databinding.ItemBookFilterListBinding

class FilterViewHolder(private val binding: ItemBookFilterListBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(filterItem: BookFilterItem) {
        binding.textViewFilterTitle.text = filterItem.title
        //TODO implement listener on click
    }

}