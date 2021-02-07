package com.evaly.mvrxsample.ui.epoxy

import android.view.View
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.evaly.mvrxsample.R
import com.evaly.mvrxsample.data.response.FoodItem
import com.evaly.mvrxsample.databinding.ItemFoodLargeBinding
import com.evaly.mvrxsample.utils.BindingUtils

@EpoxyModelClass(layout = R.layout.item_food_large)
abstract class FoodItemModel : DataBindingEpoxyModel() {

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    @EpoxyAttribute
    var foodItem: FoodItem? = null

    override fun bind(holder: DataBindingHolder) {
        super.bind(holder)
        val binding: ItemFoodLargeBinding = holder.dataBinding as ItemFoodLargeBinding
        binding.tvRestaurantName.text = foodItem!!.name
        if (foodItem!!.description == null) {
            binding.tvRestaurantType.text = "A short description about foods!"
        } else {
            binding.tvRestaurantType.text = foodItem!!.description
        }
        binding.txtQuantity.text = "200 PCs"
        BindingUtils.setUserImageURL(binding.ivFoodImage, foodItem!!.image)
        binding.btnAddToCart.text = "$" + foodItem!!.price+" USD"
        binding.btnAddToCart.setOnClickListener(clickListener)
    }

    override fun setDataBindingVariables(binding: ViewDataBinding) {}
}