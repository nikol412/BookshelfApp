package com.nikol.bookshelfapp.ui.filters.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.databinding.ItemBookFilterListBinding

class FilterViewHolder(private val binding: ItemBookFilterListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(filterItem: BookFilterItem, isSelect: Boolean, listener: () -> Unit) {
        binding.textViewFilterTitle.text = filterItem.title

        binding.imageViewSelected.visibility = if (isSelect) View.VISIBLE else View.INVISIBLE

        binding.layoutRoot.setOnClickListener {
            listener.invoke()
        }
    }


}