package com.bytebite.restaurant_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Where(clause = "deleted = false")
public class Restaurant {

    @Id
    private Long id;
    private String name;
    private String address;
    private String CuisineType;
    private Double Rating;
    private Long contactInfo;

    @Builder.Default
    private Boolean deleted = Boolean.FALSE;
}
