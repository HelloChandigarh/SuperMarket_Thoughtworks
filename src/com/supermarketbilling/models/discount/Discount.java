package com.supermarketbilling.models.discount;


public  class  Discount {

    private DiscountType discountType;
    private  double discountAmount;
    private int buy;
    private int free;


    public Discount (DiscountType discountType, double discountAmount,int buy ,int free){
        this.discountType=discountType;
        this.discountAmount=discountAmount;
        this.buy=buy;
        this.free=free;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }


}
