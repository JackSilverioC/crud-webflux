package com.dev.crud_webflux.controller;

public record CarResponseDto(
        Integer id,
        String brand,
        Integer kilowatt
) {
}
