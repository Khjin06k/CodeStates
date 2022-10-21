package com.codestates.coffee;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class CoffeePatchDto {
    //@Positive
    private long coffeeId;
    @NotBlank
    private String korName;
    @Pattern(regexp = "^[a-zA-Z]+(\\s?[a-zA-Z]+)*$")
    private String engName;
    @Range(min=100, max=50000)
    private int price;

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId){
        this.coffeeId = coffeeId;
    }

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName){
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName){
        this.engName = engName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
