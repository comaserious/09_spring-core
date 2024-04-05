package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{

    private Date bakedDate; // 제조시간

    public Bread(){}

    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return super.toString()+" "+this.bakedDate;
    }
}
