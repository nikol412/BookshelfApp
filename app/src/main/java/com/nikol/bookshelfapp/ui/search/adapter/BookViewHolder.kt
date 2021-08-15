package com.nikol.bookshelfapp.ui.search.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.R
import com.nikol.bookshelfapp.databinding.ItemBooksSearchListBinding
import com.nikol.bookshelfapp.utils.loadImage

class BookViewHolder(private val binding: ItemBooksSearchListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(book: SearchBookItem) {
        with(binding) {
            textViewBookTitle.text = book.title
            textViewBookAuthors.text = book.authors
            imageViewBook.loadImage(
                book.imageUrl,
                AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.ic_image_placeholder
                )
            )
        }
    }
}