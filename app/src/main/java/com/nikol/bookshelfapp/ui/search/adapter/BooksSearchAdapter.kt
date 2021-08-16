package com.nikol.bookshelfapp.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.databinding.ItemBooksSearchListBinding

class BooksSearchAdapter : RecyclerView.Adapter<BookViewHolder>() {
    private var booksList = mutableListOf<SearchBookItem>()

    override fun getItemCount(): Int = booksList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemBooksSearchListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.onBind(booksList[position])
    }

    fun setItems(newItems: List<SearchBookItem>) {
        val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = booksList.size
            override fun getNewListSize(): Int = newItems.size
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                booksList[oldItemPosition] == newItems[newItemPosition]

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                booksList[oldItemPosition] == newItems[newItemPosition]
        })
        booksList = newItems.toMutableList()
        result.dispatchUpdatesTo(this)
    }
}


