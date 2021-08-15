package com.nikol.bookshelfapp.ui.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.databinding.ItemBooksSearchListBinding

class BookViewHolder(private val binding: ItemBooksSearchListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(book: SearchBookItem) {
        with(binding) {
            textViewBookTitle.text = book.title
            textViewBookAuthors.text = book.authors
        }
    }
}