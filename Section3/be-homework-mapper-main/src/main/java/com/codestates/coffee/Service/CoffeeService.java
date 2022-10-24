package com.codestates.coffee.Service;

import com.codestates.coffee.entity.Coffee;
import java.util.*;

public class CoffeeService {

    public Coffee createCoffee(Coffee coffee){
        Coffee createCoffee = coffee;
        return createCoffee;
    }

    public Coffee updateCoffee(Coffee coffee){
        Coffee updateCoffee = coffee;
        return updateCoffee;
    }

    public Coffee findCoffee(long coffeeId){
        Coffee coffee = new Coffee(coffeeId, "아메리카노", "Americano", 2500);
        return coffee;
    }

    public List<Coffee> findCoffees(){
        List<Coffee> coffees = List.of(new Coffee(1, "아메리카노", "American", 2500),
                new Coffee(2, "카라멜 라떼", "Caramel Lattee", 5000));
        return coffees;
    }

    public void deleteCoffee(long coffeeId){    }
}
