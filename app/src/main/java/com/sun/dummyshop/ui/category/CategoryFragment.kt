package com.sun.dummyshop.ui.category

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sun.dummyshop.R
import com.sun.dummyshop.base.BaseFragment
import com.sun.dummyshop.data.model.Product
import com.sun.dummyshop.databinding.FragmentCategoryBinding
import com.sun.dummyshop.ui.adapter.ProductAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    override val layoutResource get() = R.layout.fragment_category
    override val viewModel by viewModel<CategoryViewModel>()
    override var bottomNavigationViewVisibility = View.GONE

    private val adapter = ProductAdapter(::clickProduct)
    private val args: CategoryFragmentArgs by navArgs()

    override fun setupViews() {
        binding?.textCategoryTitle?.text = args.category.name
    }

    override fun setupData() {
        recyclerProductsOfCategory.adapter = adapter
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            categoryVM = viewModel
        }
        viewModel.getProductsOfCategory(args.category.id)
    }

    override fun setupActions() {
        buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
        textSearch.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryToSearch()
            findNavController().navigate(action)
        }
    }

    private fun clickProduct(product: Product) {
        val action = CategoryFragmentDirections.actionCategoryToDetail(product)
        findNavController().navigate(action)
    }
}
