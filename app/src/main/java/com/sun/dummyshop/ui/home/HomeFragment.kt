package com.sun.dummyshop.ui.home

import com.sun.dummyshop.R
import com.sun.dummyshop.base.BaseFragment
import com.sun.dummyshop.data.model.Category
import com.sun.dummyshop.data.model.Product
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.sun.dummyshop.databinding.FragmentHomeBinding
import com.sun.dummyshop.ui.adapter.CategoryAdapter
import com.sun.dummyshop.ui.adapter.ProductAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutResource get() = R.layout.fragment_home
    override val viewModel by viewModel<HomeViewModel>()

    private val categoryAdapter = CategoryAdapter(::clickCategory)
    private val topRatingAdapter = ProductAdapter(::clickProduct)
    private val topSellingAdapter = ProductAdapter(::clickProduct)

    override fun setupViews() {
    }

    override fun setupData() {
        recyclerCategories.adapter = categoryAdapter
        recyclerTopSelling.adapter = topSellingAdapter
        recyclerTopRating.adapter = topRatingAdapter
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            homeVM = viewModel
        }
    }

    override fun setupActions() {
    }

    private fun clickCategory(category: Category) {
    }

    private fun clickProduct(product: Product) {
    }
}
