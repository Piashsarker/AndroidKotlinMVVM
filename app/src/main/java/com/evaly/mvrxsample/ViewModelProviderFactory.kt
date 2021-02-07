package com.evaly.mvrxsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.evaly.dindinnproject.repository.RestaurantRepository
import com.evaly.mvrxsample.ui.home.HomeViewModel
import com.evaly.mvrxsample.ui.main.MainViewModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ViewModelProviderFactory @Inject constructor(
    appRepository: RestaurantRepository,
    schedulerProvider: ScheduleProvider
) :
    NewInstanceFactory() {
    private val appRepository: RestaurantRepository = appRepository
    private val schedulerProvider: ScheduleProvider = schedulerProvider

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(appRepository, schedulerProvider) as T
        }
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(
                appRepository,
                schedulerProvider
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}
