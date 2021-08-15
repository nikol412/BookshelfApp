package com.nikol.bookshelfapp.ui.filters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.databinding.ItemBookFilterListBinding

//TODO implement onClick Listener
class FiltersAdapter : RecyclerView.Adapter<FilterViewHolder>() {
    private var filterList = mutableListOf<BookFilterItem>()

    override fun getItemCount(): Int = filterList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        return FilterViewHolder(
            ItemBookFilterListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.onBind(filterList[position])
    }

    fun setItems(newItems: List<BookFilterItem>) {
        filterList = newItems.toMutableList()
        notifyDataSetChanged()
    }
}
