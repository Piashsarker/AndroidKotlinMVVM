package com.evaly.mvrxsample.ui.epoxy

import android.view.View
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.evaly.mvrxsample.R
import com.evaly.mvrxsample.data.response.FoodItem
import com.evaly.mvrxsample.databinding.ItemCartBinding
import com.evaly.mvrxsample.databinding.ItemFoodLargeBinding
import com.evaly.mvrxsample.utils.BindingUtils

@EpoxyModelClass(layout = R.layout.item_cart)
abstract class CartItemModel : DataBindingEpoxyModel() {

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    @EpoxyAttribute
    var foodItem: FoodItem? = null

    override fun bind(holder: DataBindingHolder) {
        super.bind(holder)
        val binding: ItemCartBinding = holder.dataBinding as ItemCartBinding
        binding.tvRestaurantName.text = foodItem!!.name
        binding.txtPrice.text = foodItem!!.price.toString()
        BindingUtils.setUserImageURL(binding.ivFoodImage, foodItem!!.image)
        binding.imgDelete.setOnClickListener(clickListener)
    }

    override fun setDataBindingVariables(binding: ViewDataBinding) {}
}