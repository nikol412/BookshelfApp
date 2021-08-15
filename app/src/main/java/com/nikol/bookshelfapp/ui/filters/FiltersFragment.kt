package com.nikol.bookshelfapp.ui.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nikol.bookshelfapp.R
import com.nikol.bookshelfapp.databinding.FragmentFiltersBinding
import com.nikol.bookshelfapp.ui.filters.adapter.FiltersAdapter
import org.koin.android.ext.android.inject

class FiltersFragment : Fragment() {
    private val viewModel by inject<FiltersViewModel>()
    private lateinit var binding: FragmentFiltersBinding
    private val filtersAdapter by lazy {
        FiltersAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFiltersBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerViewFilters.adapter = filtersAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filtersAdapter.setItems(viewModel.filterList)
    }

}