package com.evaly.mvrxsample.data.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.evaly.mvrxsample.data.response.addon.AddonResponse;
import com.evaly.mvrxsample.data.response.addon.VariantResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodItem implements Parcelable {

    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };
    @SerializedName("in_campaign")
    @Expose
    private final Boolean inCampaign;
 
    @SerializedName("image")
    private String image;
    @SerializedName("is_variable_price")
    private boolean isVariablePrice;
    @SerializedName("price")
    private double price;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("discount")
    private double discount;
    @SerializedName("id")
    private int id;
    @SerializedName("discount_type")
    private String discountType;
    @SerializedName("status")
    private String status;
    @SerializedName("has_sd")
    private boolean hasSD;
    @SerializedName("number_of_addons_required")
    private int numberOfAddonsRequired;
    @SerializedName("addons_required")
    private List<AddonResponse> addonsRequired;
    @SerializedName("addons_optional")
    private List<AddonResponse> addonsOptional;
    @SerializedName(value = "item_variants", alternate = "variants")
    private List<VariantResponse> itemVariants;
    private int quantity = 0;
    

    @SerializedName("within_menu_hours")
    @Expose
    private boolean inMenuHour;


    protected FoodItem(Parcel in) {
        image = in.readString();
        isVariablePrice = in.readByte() != 0;
        price = in.readDouble();
        hasSD = in.readInt() == 1;
        name = in.readString();
        description = in.readString();
        discount = in.readDouble();
        id = in.readInt();
        discountType = in.readString();
        status = in.readString();
        quantity = in.readInt();
        this.inMenuHour = in.readInt() == 1;
        numberOfAddonsRequired = in.readInt();
        inCampaign = in.readInt() == 1;
    }


    public boolean isInMenuHour() {
        return inMenuHour;
    }

    public void setInMenuHour(boolean inMenuHour) {
        this.inMenuHour = inMenuHour;
    }



    public boolean isHasSD() {
        return hasSD;
    }

    public void setHasSD(boolean hasSD) {
        this.hasSD = hasSD;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIsVariablePrice() {
        return isVariablePrice;
    }

    public void setIsVariablePrice(boolean isVariablePrice) {
        this.isVariablePrice = isVariablePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVariablePrice() {
        return isVariablePrice;
    }

    public void setVariablePrice(boolean variablePrice) {
        isVariablePrice = variablePrice;
    }

    public List<AddonResponse> getAddonsRequired() {
        return addonsRequired;
    }

    public void setAddonsRequired(List<AddonResponse> addonsRequired) {
        this.addonsRequired = addonsRequired;
    }

    public List<AddonResponse> getAddonsOptional() {
        return addonsOptional;
    }

    public void setAddonsOptional(List<AddonResponse> addonsOptional) {
        this.addonsOptional = addonsOptional;
    }

    public List<VariantResponse> getItemVariants() {
        return itemVariants;
    }

    public void setItemVariants(List<VariantResponse> itemVariants) {
        this.itemVariants = itemVariants;
    }

    public int getNumberOfAddonsRequired() {
        return numberOfAddonsRequired;
    }

    public void setNumberOfAddonsRequired(int numberOfAddonsRequired) {
        this.numberOfAddonsRequired = numberOfAddonsRequired;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "image='" + image + '\'' +
                ", isVariablePrice=" + isVariablePrice +
                ", price=" + price +
                ", has_sd=" + hasSD +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", id=" + id +
                ", discountType='" + discountType + '\'' +
                ", status='" + status + '\'' +
                ", addonsRequired=" + addonsRequired +
                ", addonsOptional=" + addonsOptional +
                ", itemVariants=" + itemVariants +
                ", in_campaign=" + inCampaign +
                ", inMenuHour=" + inMenuHour +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(image);
        parcel.writeByte((byte) (isVariablePrice ? 1 : 0));
        parcel.writeDouble(price);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeDouble(discount);
        parcel.writeInt(id);
        parcel.writeString(discountType);
        parcel.writeString(status);
        parcel.writeInt(quantity);
        parcel.writeInt(numberOfAddonsRequired);
        parcel.writeInt(hasSD ? 1 : 0);
        parcel.writeInt(inCampaign ? 1 : 0);
        parcel.writeInt(this.inMenuHour ? 1 : 0);
    }


}