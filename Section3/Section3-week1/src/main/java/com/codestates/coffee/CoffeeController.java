package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.http.MediaType;
import com.codestates.coffee.CoffeePatchDto;
import  com.codestates.coffee.CoffeePostDto;

@RestController
/*해당 클래스가 REST API의 리소스를 처리하기 위한 API 엔드포인트로 동작함을 정의
 * @RestController가 추가된 클래스는 로딩시 Spring Bean 등록*/
@RequestMapping("/v1/coffees")
/*클라이언트의 요청과 클라이언트의 요청을 처리하는 핸들러 메서드를 매핑해주는 역할*/

public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@RequestBody CoffeePostDto coffeePostDto){
        /*System.out.println("# korName : " + korName);
        System.out.println("# engName : " + engName);
        System.out.println("# price : " + price);

        String response = "{\"" +
                "email\":\""+korName+"\"," +
                "\"name\":\""+engName+"\",\"" +
                "phone\":\"" + price+
                "\"}";*/
        return new ResponseEntity<>(coffeePostDto, HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId){
        System.out.println("# coffeeId : " + coffeeId);
        //return null;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(){
        System.out.println("# get Coffees");
        //return null;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{coffee-id)")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                      @RequestBody CoffeePatchDto coffeePatchDto){
        coffeePatchDto.setCoffeeId(coffeeId);
        return new ResponseEntity(coffeePatchDto, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
