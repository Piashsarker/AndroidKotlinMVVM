package com.evaly.mvrxsample.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.evaly.mvrxsample.BR
import com.evaly.mvrxsample.R
import com.evaly.mvrxsample.ViewModelProviderFactory
import com.evaly.mvrxsample.core.BaseFragment
import com.evaly.mvrxsample.data.response.RestaurantMenuItem
import com.evaly.mvrxsample.databinding.FragmentHomeBinding
import com.evaly.mvrxsample.ui.adapter.FoodItemViewPagerAdapter
import com.evaly.mvrxsample.ui.adapter.HomeViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(baseActivity, factory!!)[HomeViewModel::class.java]


    fun HomeFragment() {}

    private lateinit var binding: FragmentHomeBinding

    @Inject
    @JvmField
    var factory: ViewModelProviderFactory? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = viewDataBinding
        addSlider()
        subscribeLiveDataEvent()

        binding.fab.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_homeFragment_to_cartFragment)
        }
    }


    private fun subscribeLiveDataEvent() {
        this.viewModel.data.observe(viewLifecycleOwner, Observer {
            Log.d("List", Gson().toJson(it))
            createTabMenus(it)
        })
        this.viewModel.cart.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                binding.fab.show()
                binding.txtCount.visibility = View.VISIBLE
                binding.txtCount.text = it.size.toString()
            }else{
                binding.fab.hide()
                binding.txtCount.visibility = View.GONE
            }
        })

    }

    private fun createTabMenus(data: List<RestaurantMenuItem>?) {
        val adapter = activity.let {
            FoodItemViewPagerAdapter(
                baseActivity,
                data!!.size,
                data
            )
        }
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = data!!.get(position).cuisineName
        }.attach()

    }

    private fun addSlider() {
        val onBoardingAdapter = activity.let { HomeViewPagerAdapter(baseActivity, 3) }
        binding.viewPager1.adapter = onBoardingAdapter
        TabLayoutMediator(this.binding.tabDots, binding.viewPager1) { tab, position ->
            //Some implementation
        }.attach()
    }


}