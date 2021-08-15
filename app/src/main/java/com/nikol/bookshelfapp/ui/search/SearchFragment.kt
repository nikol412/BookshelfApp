package com.nikol.bookshelfapp.ui.search

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.nikol.bookshelfapp.R
import com.nikol.bookshelfapp.databinding.MainFragmentBinding
import com.nikol.bookshelfapp.ui.search.adapter.BooksSearchAdapter
import org.koin.android.ext.android.inject

class SearchFragment : Fragment() {

    private val viewModel by inject<SearchViewModel>()

    private lateinit var binding: MainFragmentBinding

    private val booksSearchAdapter by lazy {
        BooksSearchAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerViewBooks.adapter = booksSearchAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.booksListLD.observe(viewLifecycleOwner) { booksList ->
            booksSearchAdapter.setItems(booksList)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        searchItem.expandActionView()
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { q ->
                    viewModel.fetchData(q)
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                if (newText.isNotBlank()) {
                    viewModel.fetchData(newText)
                }

                return true
            }
        })
    }

}