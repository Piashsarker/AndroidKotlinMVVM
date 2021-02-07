package com.evaly.mvrxsample.data.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("count")
    @Expose
    private Integer count;

    @SerializedName(value = "debit", alternate = {"total_debit"})
    @Expose
    private Double debit;


    @SerializedName(value = "credit", alternate = {"total_credit"})
    @Expose
    private Double credit;

    @SerializedName("settleupTotal")
    @Expose
    private String settleupTotal;
    @SerializedName("remindTotal")
    @Expose
    private String remindTotal;

    @SerializedName("page_size")
    @Expose
    private Integer pageSize;
    @SerializedName("next")
    @Expose
    private Integer next;
    @SerializedName("previous")
    @Expose
    private Object previous;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }


    public String getSettleupTotal() {
        return settleupTotal;
    }

    public void setSettleupTotal(String settleupTotal) {
        this.settleupTotal = settleupTotal;
    }

    public String getRemindTotal() {
        return remindTotal;
    }

    public void setRemindTotal(String remindTotal) {
        this.remindTotal = remindTotal;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}