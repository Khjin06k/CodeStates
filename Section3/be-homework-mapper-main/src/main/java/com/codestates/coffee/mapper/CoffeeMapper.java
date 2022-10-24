package com.codestates.coffee.mapper;

import com.codestates.coffee.entity.Coffee;
import com.codestates.coffee.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    Coffee coffeeToCoffeeResponseDto(Coffee coffee);
}
