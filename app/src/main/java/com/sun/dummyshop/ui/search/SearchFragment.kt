package com.sun.dummyshop.ui.search

import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.findNavController
import com.sun.dummyshop.R
import com.sun.dummyshop.base.BaseFragment
import com.sun.dummyshop.data.model.Keyword
import com.sun.dummyshop.databinding.FragmentSearchBinding
import com.sun.dummyshop.ui.adapter.KeywordAdapter
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutResource get() = R.layout.fragment_search
    override val viewModel by viewModel<SearchViewModel>()

    private val adapter = KeywordAdapter(::clickKeyword, ::clickDeleteButtonOfKeyword)

    override fun setupViews() {
    }

    override fun setupData() {
        recyclerSearchHistory.adapter = adapter
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            searchVM = viewModel
        }
    }

    override fun setupActions() {
        buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
        buttonSearch.setOnClickListener {
            search(editTextSearch.text.toString())
        }
        textClearAll.setOnClickListener {
            viewModel.deleteAllKeywords()
        }
        editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                search(editTextSearch.text.toString())
            }
            false
        }
    }

    private fun search(text: String) {
        viewModel.insertKeyword(Keyword(text))
        editTextSearch.text.clear()
    }

    private fun clickKeyword(keyword: Keyword) {
        search(keyword.keyword)
    }

    private fun clickDeleteButtonOfKeyword(keyword: Keyword) {
        viewModel.deleteKeyword(keyword)
    }
}
