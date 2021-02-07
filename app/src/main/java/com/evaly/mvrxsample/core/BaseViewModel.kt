package com.evaly.mvrxsample.core

import androidx.lifecycle.ViewModel
import com.evaly.dindinnproject.repository.RestaurantRepository
import com.evaly.mvrxsample.ScheduleProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    appRepository: RestaurantRepository,
    schedulerProvider: ScheduleProvider
) : ViewModel() {
    private val mSchedulerProvider: ScheduleProvider
    val compositeDisposable: CompositeDisposable
    private val appRepository: RestaurantRepository

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun getAppRepository(): RestaurantRepository {
        return appRepository
    }


    val schedulerProvider: ScheduleProvider
        get() = mSchedulerProvider


    init {
        compositeDisposable = CompositeDisposable()
        this.appRepository = appRepository
        mSchedulerProvider = schedulerProvider
    }
}
