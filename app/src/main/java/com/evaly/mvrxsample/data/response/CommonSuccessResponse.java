package com.evaly.mvrxsample.data.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommonSuccessResponse<T> {

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName(value = "meta", alternate = {"meta_data", "meta_info"})
    @Expose
    private Meta meta;

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
