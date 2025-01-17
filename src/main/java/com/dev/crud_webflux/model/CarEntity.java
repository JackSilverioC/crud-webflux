package com.dev.crud_webflux.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("car")
public class CarEntity {

    @Id
    private Integer id;
    private String brand;
    private Integer kilowatt;
}
