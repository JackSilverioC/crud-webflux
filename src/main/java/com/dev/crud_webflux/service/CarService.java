package com.dev.crud_webflux.service;

import com.dev.crud_webflux.controller.CarRequestDto;
import com.dev.crud_webflux.controller.CarResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {

    Mono<CarResponseDto> findCar(Integer carId);
    Mono<CarResponseDto> createCar(CarRequestDto request);
    Mono<CarResponseDto> updateCar(Integer carId, CarRequestDto request);
    Mono<Void> deleteCar(Integer carId);
    Flux<CarResponseDto> findAll();
}
