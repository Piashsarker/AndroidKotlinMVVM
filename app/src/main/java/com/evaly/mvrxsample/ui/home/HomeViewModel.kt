package com.evaly.mvrxsample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.evaly.dindinnproject.repository.RestaurantRepository
import com.evaly.mvrxsample.ScheduleProvider
import com.evaly.mvrxsample.core.BaseViewModel
import com.evaly.mvrxsample.data.response.CommonSuccessResponse
import com.evaly.mvrxsample.data.response.FoodItem
import com.evaly.mvrxsample.data.response.RestaurantMenuItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(appRepository: RestaurantRepository, schedulerProvider: ScheduleProvider) :
    BaseViewModel(appRepository, schedulerProvider) {

    private var _data = MutableLiveData<List<RestaurantMenuItem>>()
    val data: LiveData<List<RestaurantMenuItem>> get() = _data
    private var _cartList = MutableLiveData<List<FoodItem>>()
    val cart: LiveData<List<FoodItem>> get() = _cartList

    private var cartList: ArrayList<FoodItem> = ArrayList()

    init {
        getRestaurantList()
    }


    private fun getRestaurantList() {

        this.compositeDisposable.add(
            getAppRepository().loadFoodItemsFromServer()
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(this::loadData)
        )

    }

    private fun loadData(response: CommonSuccessResponse<List<RestaurantMenuItem>>) {
        _data.value = response.data
    }

    fun addToCart(foodItem: FoodItem){
        cartList.add(foodItem)
        this._cartList.value =cartList
    }

    fun removeFromCart(foodItem: FoodItem){
       cartList.remove(foodItem)
       this._cartList.value = cartList
    }




    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}