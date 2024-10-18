package com.dev.crud_webflux.mapper;

import com.dev.crud_webflux.controller.CarRequestDto;
import com.dev.crud_webflux.controller.CarResponseDto;
import com.dev.crud_webflux.model.CarEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CarMapper {

    public CarResponseDto fromCarToCarResponseDto(CarEntity car){
        return new CarResponseDto(
                car.getId(),
                car.getBrand(),
                car.getKilowatt()
        );
    }

    public CarEntity fromCarRequestDtoToCar(CarRequestDto request){
        return CarEntity.builder()
                .id(request.id())
                .brand(request.brand())
                .kilowatt(request.kilowatt())
                .build();
    }
}
