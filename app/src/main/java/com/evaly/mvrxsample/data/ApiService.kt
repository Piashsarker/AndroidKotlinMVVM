package com.evaly.dindinnproject.data

import com.evaly.mvrxsample.data.response.CommonSuccessResponse
import com.evaly.mvrxsample.data.response.RestaurantMenuItem
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiService {

    @GET("efood-search/api/v1.0.0/users/items/the-burger-blast-kalabagan,-dhaka-jcgmj")
    fun getFoodItems(): Observable<CommonSuccessResponse<List<RestaurantMenuItem>>>

    // Request URL: https://api.evaly.com.bd/efood-search/api/v1.0.0/users/items/the-burger-blast-kalabagan,-dhaka-jcgmj?name=
}