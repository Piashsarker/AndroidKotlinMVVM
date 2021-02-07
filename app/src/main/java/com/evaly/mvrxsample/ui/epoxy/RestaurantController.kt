package com.evaly.mvrxsample.ui.epoxy

import android.os.CountDownTimer
import com.airbnb.epoxy.EpoxyController
import com.evaly.mvrxsample.data.response.FoodItem
import com.evaly.mvrxsample.databinding.ItemFoodLargeBinding
import java.util.*


class RestaurantController : EpoxyController() {

    private var list: List<FoodItem> = ArrayList<FoodItem>()
    private var listener: RestaurantListener? = null

    fun setListener(listener: RestaurantListener?) {
        this.listener = listener
    }

    fun setList(list: List<FoodItem>) {
        this.list = list
    }


    override fun buildModels() {
        for (mainItem in list) {
            FoodItemModel_()
                .id(mainItem.name + mainItem.id)
                .foodItem(mainItem)
                .clickListener { model, parentView, clickedView, position ->
                    val binding: ItemFoodLargeBinding =
                        parentView.dataBinding as ItemFoodLargeBinding
                    binding.btnAddToCart.text = "+1 added"
                    object : CountDownTimer(1000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                        }

                        override fun onFinish() {
                            binding.btnAddToCart.text = "$" + model.foodItem()!!.price + " USD"
                        }
                    }.start()
                    listener!!.onFoodCartAddClick(mainItem)
                }
                .addTo(this)
        }

    }


    interface RestaurantListener {
        fun onFoodCartAddClick(model: FoodItem?)
    }
}
