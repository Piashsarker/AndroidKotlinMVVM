package com.evaly.mvrxsample.data.response.addon;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class VariantResponse implements Parcelable {

	@SerializedName("price")
	private double price;

	@SerializedName("attribute_name")
	private String attributeName;

	@SerializedName("id")
	private int id;

	@SerializedName("attribute_value")
	private String attributeValue;

	private boolean selected = false;

	public VariantResponse(){

	}

	protected VariantResponse(Parcel in) {
		price = in.readDouble();
		attributeName = in.readString();
		id = in.readInt();
		attributeValue = in.readString();
		selected = in.readByte() != 0;
	}

	public static final Creator<VariantResponse> CREATOR = new Creator<VariantResponse>() {
		@Override
		public VariantResponse createFromParcel(Parcel in) {
			return new VariantResponse(in);
		}

		@Override
		public VariantResponse[] newArray(int size) {
			return new VariantResponse[size];
		}
	};

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setAttributeName(String attributeName){
		this.attributeName = attributeName;
	}

	public String getAttributeName(){
		return attributeName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAttributeValue(String attributeValue){
		this.attributeValue = attributeValue;
	}

	public String getAttributeValue(){
		return attributeValue;
	}

	@Override
 	public String toString(){
		return 
			"VariantResponse{" + 
			"price = '" + price + '\'' + 
			",attribute_name = '" + attributeName + '\'' + 
			",id = '" + id + '\'' + 
			",attribute_value = '" + attributeValue + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeDouble(price);
		parcel.writeString(attributeName);
		parcel.writeInt(id);
		parcel.writeString(attributeValue);
		parcel.writeByte((byte) (selected ? 1 : 0));
	}

}