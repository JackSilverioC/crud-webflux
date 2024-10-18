package com.dev.crud_webflux.controller;

import com.dev.crud_webflux.service.CarService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/{car-id}")
    public Mono<ResponseEntity<CarResponseDto>> findCar(
            @PathVariable("car-id") Integer carId
    ){
        return carService.findCar(carId).map(ResponseEntity::ok);
    }

    @PostMapping
    public Mono<ResponseEntity<CarResponseDto>> createCar(
            @RequestBody CarRequestDto request
    ){
        return carService.createCar(request).map(ResponseEntity::ok);
    }

    @PutMapping("/{car-id}")
    public Mono<ResponseEntity<CarResponseDto>> updateCar(
            @PathVariable("car-id") Integer carId, @RequestBody CarRequestDto request
    ){
        return carService.updateCar(carId, request).map(ResponseEntity::ok);
    }

    @DeleteMapping("/{car-id}")
    public Mono<ResponseEntity<Void>> deleteCar(
            @PathVariable("car-id") Integer carId
    ){
        return carService.deleteCar(carId).map(ResponseEntity::ok);
    }

    @GetMapping("/")
    public ResponseEntity<Flux<CarResponseDto>> findAll(){
        Flux<CarResponseDto> cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }
}
