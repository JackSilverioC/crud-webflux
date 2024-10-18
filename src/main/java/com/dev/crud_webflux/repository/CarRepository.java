package com.dev.crud_webflux.repository;

import com.dev.crud_webflux.model.CarEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CarRepository extends R2dbcRepository<CarEntity, Integer> {


}
