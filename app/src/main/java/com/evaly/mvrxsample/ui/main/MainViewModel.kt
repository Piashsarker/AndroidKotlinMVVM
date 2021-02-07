package com.evaly.mvrxsample.ui.main

import com.evaly.dindinnproject.repository.RestaurantRepository
import com.evaly.mvrxsample.ScheduleProvider
import com.evaly.mvrxsample.core.BaseViewModel

class MainViewModel(appRepository: RestaurantRepository, schedulerProvider: ScheduleProvider) :
    BaseViewModel(appRepository, schedulerProvider)