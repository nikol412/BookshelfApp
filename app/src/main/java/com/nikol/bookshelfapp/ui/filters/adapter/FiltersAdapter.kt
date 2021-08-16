package com.nikol.bookshelfapp.ui.filters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.databinding.ItemBookFilterListBinding

class FiltersAdapter(private val listener: OnFilterClickListener, selectedPosition: Int? = null) :
    RecyclerView.Adapter<FilterViewHolder>() {
    private var filterList = mutableListOf<BookFilterItem>()
    private var selectedItemPosition = -1

    init {
        selectedPosition?.let { pos ->
            selectedItemPosition = pos
        }
    }

    override fun getItemCount(): Int = filterList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        return FilterViewHolder(
            ItemBookFilterListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.onBind(filterList[position], selectedItemPosition == position) {

            if (selectedItemPosition == -1 ||
                selectedItemPosition == holder.adapterPosition
            ) return@onBind

            val lastSelectedPosition = selectedItemPosition
            selectedItemPosition = holder.adapterPosition
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedItemPosition)

            listener.onClick(filterList[holder.adapterPosition])
        }
    }

    fun setItems(newItems: List<BookFilterItem>) {
        filterList = newItems.toMutableList()
        notifyDataSetChanged()
    }
}

interface OnFilterClickListener {
    fun onClick(param: BookFilterItem)
}
