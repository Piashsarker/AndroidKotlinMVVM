package com.evaly.mvrxsample.di

import com.evaly.mvrxsample.ui.cart.CartFragment
import com.evaly.mvrxsample.ui.home.FoodItemFragment
import com.evaly.mvrxsample.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment
    @ContributesAndroidInjector
    abstract fun provideFoodItemFragment(): FoodItemFragment
    @ContributesAndroidInjector
    abstract fun provideCartFragment(): CartFragment

}