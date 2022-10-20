package com.codestates.coffee;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
/*해당 클래스가 REST API의 리소스를 처리하기 위한 API 엔드포인트로 동작함을 정의
 * @RestController가 추가된 클래스는 로딩시 Spring Bean 등록*/
@RequestMapping(value = "/v1/coffees", produces = MediaType.APPLICATION_JSON_VALUE)
/*클라이언트의 요청과 클라이언트의 요청을 처리하는 핸들러 메서드를 매핑해주는 역할*/

public class CoffeeController {
    @PostMapping
    public String postCoffee(@RequestParam("korName") String korName,
                             @RequestParam("engName") String engName,
                             @RequestParam("price") int price){
        System.out.println("# korName : " + korName);
        System.out.println("# engName : " + engName);
        System.out.println("# price : " + price);

        String response = "{\"" +
                "email\":\""+korName+"\"," +
                "\"name\":\""+engName+"\",\"" +
                "phone\":\"" + price+
                "\"}";
        return response;
    }

    @GetMapping("/{coffee-id}")
    public String getCoffee(@PathVariable("coffee-id") long coffeeId){
        System.out.println("# coffeeId : " + coffeeId);
        return null;
    }

    @GetMapping
    public String getCoffees(){
        System.out.println("# get Coffees");
        return null;
    }
}
