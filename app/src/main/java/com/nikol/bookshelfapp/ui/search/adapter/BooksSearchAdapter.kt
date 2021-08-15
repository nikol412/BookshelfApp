package com.nikol.bookshelfapp.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
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
        booksList = newItems.toMutableList()

        notifyDataSetChanged()
    }
}

class BookViewHolder(private val binding: ItemBooksSearchListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(book: SearchBookItem) {
        with(binding) {
            textViewBookTitle.text = book.title
            textViewBookAuthors.text = book.authors
        }
    }
}

data class SearchBookItem(
    val title: String?,
    val imageUrl: String? = null,
    val authors: String? = null
)

