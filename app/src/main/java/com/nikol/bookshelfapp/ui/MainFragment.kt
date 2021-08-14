package com.nikol.bookshelfapp.ui

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nikol.bookshelfapp.R
import com.nikol.bookshelfapp.databinding.MainFragmentBinding
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private val viewModel by inject<MainViewModel>()

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchData()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        searchItem.expandActionView()
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                if (newText.isNotBlank()) {
                    Toast.makeText(context, "some query", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "empty text", Toast.LENGTH_SHORT).show()
                }
                return true
            }
        })
    }

}