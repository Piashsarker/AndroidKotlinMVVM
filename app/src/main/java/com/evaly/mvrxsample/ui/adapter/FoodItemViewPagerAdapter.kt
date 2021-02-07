package com.evaly.mvrxsample.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evaly.mvrxsample.data.response.RestaurantMenuItem
import com.evaly.mvrxsample.ui.home.FoodItemFragment

class FoodItemViewPagerAdapter(
    activity: FragmentActivity,
    private val itemsCount: Int,
    private var list: List<RestaurantMenuItem>
) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return FoodItemFragment.getInstance(position, list.get(position).items)
    }
}