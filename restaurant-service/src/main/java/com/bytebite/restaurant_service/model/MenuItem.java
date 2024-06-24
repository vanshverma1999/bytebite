package com.bytebite.restaurant_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
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
public class MenuItem {

    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean availability;

    @ManyToOne
    @JoinTable(name = "restaurant_menu")
    private Restaurant restaurant;

    @Builder.Default
    private Boolean deleted = Boolean.FALSE;
}
