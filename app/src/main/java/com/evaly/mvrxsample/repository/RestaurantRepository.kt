package com.evaly.dindinnproject.repository

import com.evaly.dindinnproject.data.ApiService
import com.evaly.mvrxsample.data.response.CommonSuccessResponse
import com.evaly.mvrxsample.data.response.RestaurantMenuItem
import io.reactivex.Observable

class RestaurantRepository(private val apiService: ApiService) {

        fun loadFoodItemsFromServer(): Observable<CommonSuccessResponse<List<RestaurantMenuItem>>> =
            apiService.getFoodItems()

    }
