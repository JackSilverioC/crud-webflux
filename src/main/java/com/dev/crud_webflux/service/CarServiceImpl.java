package com.dev.crud_webflux.service;

import com.dev.crud_webflux.controller.CarRequestDto;
import com.dev.crud_webflux.controller.CarResponseDto;
import com.dev.crud_webflux.mapper.CarMapper;
import com.dev.crud_webflux.model.CarEntity;
import com.dev.crud_webflux.repository.CarRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository repository;
    private final CarMapper mapper;

    @Override
    public Mono<CarResponseDto> findCar(Integer carId) {
        return repository.findById(carId)
                .map(mapper::fromCarToCarResponseDto);
    }

    @Override
    public Mono<CarResponseDto> createCar(CarRequestDto request) {
        return repository
                .save(mapper.fromCarRequestDtoToCar(request))
                .map(mapper::fromCarToCarResponseDto);
    }

    @Override
    public Mono<CarResponseDto> updateCar(Integer carId, CarRequestDto request) {
        var carFound = repository.findById(carId)
                .switchIfEmpty(Mono.error(new Exception("Car with ID: " + carId + " not found")));
        var carUpdated = carFound.flatMap(carEntity -> {
            mergerCar(carEntity, request);
            return repository.save(carEntity);
        });
        return carUpdated.map(mapper::fromCarToCarResponseDto);
    }

    private void mergerCar(CarEntity car, CarRequestDto request) {
        if (StringUtils.isNotBlank(request.brand())){
            car.setBrand(request.brand());
        }
        if (StringUtils.isNotBlank(request.kilowatt().toString())){
            car.setKilowatt(request.kilowatt());
        }
    }

    @Override
    public Mono<Void> deleteCar(Integer carId) {
        return repository.deleteById(carId);
    }

    @Override
    public Flux<CarResponseDto> findAll() {
        return repository.findAll()
                .map(mapper::fromCarToCarResponseDto);
    }
}
