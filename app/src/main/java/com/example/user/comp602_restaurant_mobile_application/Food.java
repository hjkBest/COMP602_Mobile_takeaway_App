package com.example.user.comp602_restaurant_mobile_application;

public class Food {
    private int mFoodAmount;
    private String mFoodName;
    private int mfoodPrice;
    public  Food(int foodAmount,String foodName,int foodPrice)
    {
        this.mFoodAmount=foodAmount;
        this.mFoodName=foodName;
        this.mfoodPrice=foodPrice;
    }

    public int getFoodAmount() {
        return mFoodAmount;
    }

    public String getFoodName() {
        return mFoodName;
    }

    public int getMfoodPrice() {
        return mfoodPrice;
    }

    public void setFoodAmount(int foodAmount) {
        mFoodAmount = foodAmount;
    }

    public void setFoodName(String foodName) {
        mFoodName = foodName;
    }

    public void setMfoodPrice(int mfoodPrice) {
        this.mfoodPrice = mfoodPrice;
    }
}
