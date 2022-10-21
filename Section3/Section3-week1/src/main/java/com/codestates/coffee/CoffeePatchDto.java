package com.codestates.coffee;

public class CoffeePatchDto {
    private String korName;
    private String engName;
    private int price;
    private long coffeeId;


    public String getKorName() {return korName;}
    public void setKorName(String korName){this.korName = korName;}

    public String getEngName() {return engName;}
    public void setEngName(String engName) { this.engName = engName;}

    public int getPrice() {return price;}
    public void setPrice(int price){this.price = price;}

    public long getCoffeeId() {return coffeeId;}
    public void setCoffeeId(long coffeeId){this.coffeeId = coffeeId;}
}
