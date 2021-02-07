package com.evaly.mvrxsample.ui.cart

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.evaly.mvrxsample.BR
import com.evaly.mvrxsample.R
import com.evaly.mvrxsample.ViewModelProviderFactory
import com.evaly.mvrxsample.core.BaseFragment
import com.evaly.mvrxsample.data.response.FoodItem
import com.evaly.mvrxsample.databinding.FragmentCartBinding
import com.evaly.mvrxsample.ui.epoxy.CartController
import com.evaly.mvrxsample.ui.home.HomeViewModel
import javax.inject.Inject

class CartFragment : BaseFragment<FragmentCartBinding, HomeViewModel>(),
    CartController.CartListener {

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_cart
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(baseActivity, factory!!)[HomeViewModel::class.java]

    fun CartFragment() {}

    private lateinit var binding: FragmentCartBinding

    @Inject
    @JvmField
    var factory: ViewModelProviderFactory? = null

    var controller: CartController? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = viewDataBinding
        setupAdapter()
        subscribeLiveDataEvent()
        binding.topAppBar.setNavigationOnClickListener {
            baseActivity.onBackPressed()
        }
    }

    private fun subscribeLiveDataEvent() {
        viewModel.cart.observe(viewLifecycleOwner, Observer {
            controller!!.setList(it)
            controller!!.requestModelBuild()
        })
    }

    private fun setupAdapter() {
        controller = CartController()
        controller!!.setListener(this)
        binding.rvCarts.adapter = controller!!.adapter
        var rvLayoutManager = LinearLayoutManager(baseActivity)
        binding.rvCarts.layoutManager = rvLayoutManager
        controller!!.requestModelBuild()
    }

    override fun onFoodRemoveClick(model: FoodItem?) {
        viewModel.removeFromCart(model!!)
    }


}