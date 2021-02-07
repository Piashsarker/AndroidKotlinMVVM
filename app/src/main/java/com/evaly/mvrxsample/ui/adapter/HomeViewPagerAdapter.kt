package com.evaly.mvrxsample.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evaly.mvrxsample.ui.home.OnBoardingFragment

class HomeViewPagerAdapter(activity: FragmentActivity, private val itemsCount: Int) :
        FragmentStateAdapter(activity) {

        override fun getItemCount(): Int {
            return itemsCount
        }

        override fun createFragment(position: Int): Fragment {
            return OnBoardingFragment.getInstance(position)
        }
}