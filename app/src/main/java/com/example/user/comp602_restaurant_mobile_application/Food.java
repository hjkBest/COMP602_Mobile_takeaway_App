package com.example.user.comp602_restaurant_mobile_application;

public class Food {
    private int mFoodAmount;
    private String mFoodName;
    private int mFoodPrice;
    private String mProvidedBy;

    public  Food(int foodAmount,String foodName,int foodPrice,String providedBy)
    {
        this.mFoodAmount=foodAmount;
        this.mFoodName=foodName;
        this.mFoodPrice=foodPrice;
        this.mProvidedBy=providedBy;
    }

    public int getFoodAmount() {
        return mFoodAmount;
    }

    public String getFoodName() {
        return mFoodName;
    }

    public int getFoodPrice() {
        return mFoodPrice;
    }

    public String getProvidedBy() {
        return mProvidedBy;
    }

    public void setFoodAmount(int foodAmount) {
        mFoodAmount = foodAmount;
    }

    public void setFoodName(String foodName) {
        mFoodName = foodName;
    }

    public void setFoodPrice(int mfoodPrice) {
        this.mFoodPrice = mfoodPrice;
    }

    public void setProvidedBy(String providedBy) {
        mProvidedBy = providedBy;
    }
}
