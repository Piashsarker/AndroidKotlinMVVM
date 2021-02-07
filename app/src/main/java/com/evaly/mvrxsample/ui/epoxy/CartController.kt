package com.evaly.mvrxsample.ui.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.evaly.mvrxsample.data.response.FoodItem
import java.util.ArrayList

class CartController: EpoxyController() {

    private var list: List<FoodItem> = ArrayList<FoodItem>()
    private var listener: CartListener? = null

    fun setListener(listener: CartListener){
        this.listener = listener;
    }

    fun setList(list: List<FoodItem>) {
        this.list = list
    }

    fun getList(): List<FoodItem> {
        return this.list
    }

    override fun buildModels() {
        for (mainItem in list) {
            CartItemModel_()
                .id(mainItem.name + mainItem.id)
                .foodItem(mainItem)
                .clickListener(View.OnClickListener {
                    listener!!.onFoodRemoveClick(mainItem)
                })
                .addTo(this)
        }

    }

    interface CartListener {
        fun onFoodRemoveClick(model: FoodItem?)
    }


}
