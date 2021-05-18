package com.sun.dummyshop.ui.detail

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sun.dummyshop.R
import com.sun.dummyshop.base.BaseFragment
import com.sun.dummyshop.data.model.Product
import com.sun.dummyshop.databinding.FragmentDetailBinding
import com.sun.dummyshop.ui.adapter.ProductAdapter
import com.sun.dummyshop.utils.Constants
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override val layoutResource get() = R.layout.fragment_detail
    override val viewModel by viewModel<DetailViewModel>()

    private val adapter = ProductAdapter(::clickProduct)
    private val args: DetailFragmentArgs by navArgs()

    override fun setupViews() {
    }

    override fun setupData() {
        getProductRelateInformation(args.product)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            detailVM = viewModel
            recyclerSimilar.adapter = adapter
        }
    }

    override fun setupActions() {
        buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
        buttonAddToCart.setOnClickListener {
            viewModel.addToCart()
        }
        buttonFavorite.setOnClickListener {
            viewModel.setFavorite()
        }
    }

    private fun clickProduct(product: Product) {
        getProductRelateInformation(product)
        nestedScroll.smoothScrollTo(Constants.TOP_POSITION, Constants.TOP_POSITION)
    }

    private fun getProductRelateInformation(product: Product) {
        viewModel.apply {
            currentProduct.value = product
            getSimilar()
            getProductById()
            checkFavorite()
        }
    }
}