package com.evaly.mvrxsample.ui.home

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.evaly.mvrxsample.data.response.RestaurantMenuItem

data class HomePageState(val foodItemsList : Async<List<RestaurantMenuItem>> = Uninitialized): MavericksState {
}