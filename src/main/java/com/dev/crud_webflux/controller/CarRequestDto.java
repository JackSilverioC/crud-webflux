package com.dev.crud_webflux.controller;

public record CarRequestDto(
        Integer id,
        String brand,
        Integer kilowatt
) {
}
