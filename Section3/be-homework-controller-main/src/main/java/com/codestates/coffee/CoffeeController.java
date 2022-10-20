package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {
    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> coffee1 = new HashMap<>();
        long coffeeId = 1L;
        coffee1.put("coffeeId", coffeeId);
        coffee1.put("korName", "바닐라 라떼");
        coffee1.put("engName", "Vanilla Latte");
        coffee1.put("price", 4500);

        coffees.put(coffeeId, coffee1);
    }

    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
    // 1. 커피 정보 수정을 위한 핸들러 메서드 구현
    @PostMapping
    public ResponseEntity changeCoffee(@RequestParam("coffeeId") long coffeeId,
                                       @RequestParam("korName") String korName,
                                       @RequestParam("price") int price) {

        Map<String, Object> changeCoffee  = coffees.get(coffeeId);
        //만약 존재하지 않는다면
        if(!coffees.containsValue(coffeeId)){
            System.out.println("해당 memberId는 데이터에 존재하지 않습니다.");
        }
        //데이터가 존재한다면
        changeCoffee.put("korName", korName);
        changeCoffee.put("price", price);

        return new ResponseEntity(changeCoffee, HttpStatus.OK);
    }

    // 2. 커피 정보 삭제를 위한 핸들러 서드 구현
    @PostMapping("/delete/{coffee-id}")
    public ResponseEntity deleteMember(@RequestParam("coffeeId") long coffeeId) {
        //만약 존재하지 않는다면
        if(!coffees.containsValue(coffeeId)){
            System.out.println("삭제할 데이터가 존재하지 않습니다.");
        }
        //데이터가 존재한다면
        coffees.remove(coffeeId);

        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
