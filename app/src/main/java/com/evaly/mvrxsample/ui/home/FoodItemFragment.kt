package com.evaly.mvrxsample.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.evaly.mvrxsample.BR
import com.evaly.mvrxsample.R
import com.evaly.mvrxsample.ViewModelProviderFactory
import com.evaly.mvrxsample.core.BaseFragment
import com.evaly.mvrxsample.data.response.FoodItem
import com.evaly.mvrxsample.databinding.FragmentFoodItemBinding
import com.evaly.mvrxsample.ui.epoxy.RestaurantController
import javax.inject.Inject

class FoodItemFragment : BaseFragment<FragmentFoodItemBinding, HomeViewModel>(),
    RestaurantController.RestaurantListener {

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_food_item
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(baseActivity, factory!!)[HomeViewModel::class.java]


    companion object {
        private const val ARG_POSITION = "ARG_POSITION"
        private const val ARG_LIST = "ARG_LIST"

        fun getInstance(position: Int, list: List<FoodItem>) = FoodItemFragment().apply {
            arguments = bundleOf(ARG_LIST to list, ARG_POSITION to position)
        }
    }

    private lateinit var binding: FragmentFoodItemBinding

    @Inject
    @JvmField
    var factory: ViewModelProviderFactory? = null

    var controller: RestaurantController? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = viewDataBinding
        setupAdapter()

    }

    private fun setupAdapter() {
        controller = RestaurantController()
        controller!!.setListener(this)
        binding.rvFoods.adapter = controller!!.adapter
        var rvLayoutManager = LinearLayoutManager(baseActivity)
        binding.rvFoods.layoutManager = rvLayoutManager
        binding.rvFoods.isNestedScrollingEnabled = false
        controller!!.setList(requireArguments()[ARG_LIST] as List<FoodItem>)
        controller!!.requestModelBuild()
    }

    override fun onFoodCartAddClick(model: FoodItem?) {
        viewModel.addToCart(model!!)
    }

}