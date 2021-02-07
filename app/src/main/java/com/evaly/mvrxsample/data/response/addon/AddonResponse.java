package com.evaly.mvrxsample.data.response.addon;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AddonResponse implements Parcelable {

	@SerializedName("addon_name")
	private String addonName;

	@SerializedName("price")
	private double price;

	@SerializedName("addon_key")
	private Object addonKey;

	@SerializedName("item_name")
	private String itemName;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private String status;

	private boolean selected = false;

	protected AddonResponse(Parcel in) {
		addonName = in.readString();
		price = in.readDouble();
		itemName = in.readString();
		id = in.readInt();
		status = in.readString();
		selected = in.readByte() != 0;
	}

	public static final Creator<AddonResponse> CREATOR = new Creator<AddonResponse>() {
		@Override
		public AddonResponse createFromParcel(Parcel in) {
			return new AddonResponse(in);
		}

		@Override
		public AddonResponse[] newArray(int size) {
			return new AddonResponse[size];
		}
	};

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public void setAddonName(String addonName){
		this.addonName = addonName;
	}

	public String getAddonName(){
		return addonName;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setAddonKey(Object addonKey){
		this.addonKey = addonKey;
	}

	public Object getAddonKey(){
		return addonKey;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getItemName(){
		return itemName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"AddonResponse{" + 
			"addon_name = '" + addonName + '\'' + 
			",price = '" + price + '\'' + 
			",addon_key = '" + addonKey + '\'' + 
			",item_name = '" + itemName + '\'' + 
			",id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(addonName);
		parcel.writeDouble(price);
		parcel.writeString(itemName);
		parcel.writeInt(id);
		parcel.writeString(status);
		parcel.writeByte((byte) (selected ? 1 : 0));
	}
}