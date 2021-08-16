package com.nikol.bookshelfapp.ui.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikol.bookshelfapp.R
import com.nikol.bookshelfapp.databinding.MainFragmentBinding
import com.nikol.bookshelfapp.ui.search.adapter.BooksSearchAdapter
import com.nikol.bookshelfapp.utils.safeLet
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchFragment : Fragment() {
    //TODO Refactor all project
    private val viewModel by sharedViewModel<SearchViewModel>()

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

        addItemDecoration(binding.recyclerViewBooks)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.booksListLD.observe(viewLifecycleOwner) { booksList ->
            binding.textViewPlaceholder.visibility =
                if (booksList.isEmpty()) View.VISIBLE else View.GONE

            booksSearchAdapter.setItems(booksList)
        }
    }

    @SuppressLint("UnsafeOptInUsageError")
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

//        val badgeDrawable = BadgeDrawable.create(requireContext())
//        badgeDrawable.backgroundColor = Color.MAGENTA
//        badgeDrawable.badgeGravity = TOP_END
//        val toolbar: Toolbar = requireActivity().findViewById(R.id.toolbar)
//        BadgeUtils.attachBadgeDrawable(badgeDrawable, toolbar, R.id.action_filter)
        //TODO implement badges
        val searchItem: MenuItem = menu.findItem(R.id.action_search)
        searchItem.expandActionView()
        val searchView: SearchView = searchItem.actionView as SearchView
        with(searchView) {
            queryHint = context.getString(R.string.search_label)
            setIconifiedByDefault(false)
            isIconified = false
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.fetchData(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.fetchData(newText)
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                viewModel.booksListLD.value = emptyList()
                findNavController().navigate(R.id.filtersFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addItemDecoration(recyclerView: RecyclerView) {
        val orientation = (recyclerView.layoutManager as? LinearLayoutManager)?.orientation
        val divider =
            AppCompatResources.getDrawable(recyclerView.context, R.drawable.layout_divider)

        safeLet(orientation, divider) { orientation, divider ->
            val itemDecoration = DividerItemDecoration(recyclerView.context, orientation)
            itemDecoration.setDrawable(divider)
            recyclerView.addItemDecoration(itemDecoration)
        }
    }

}