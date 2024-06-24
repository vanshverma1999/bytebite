package com.bytebite.restaurant_service.controller;

import com.bytebite.restaurant_service.model.MenuItem;
import com.bytebite.restaurant_service.model.Restaurant;
import com.bytebite.restaurant_service.service.IRestaurantService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final IRestaurantService restaurantService;

    @PostMapping("/")
    public ResponseEntity<Restaurant> registerRestaurant(@RequestBody Restaurant restaurant){
        return ResponseEntity.ok(restaurantService.registerRestaurant(restaurant));
    }

    @PutMapping("/")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant){
        return ResponseEntity.ok(restaurantService.updateRestaurant(restaurant));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id){
        return ResponseEntity.ok(restaurantService.getById(id));
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity deleteRestaurantById(@PathVariable Long restaurantId){
        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<List<MenuItem>> getRestaurantMenu(@PathVariable Long restaurantId){
        return ResponseEntity.ok(restaurantService.getRestaurantMenu(restaurantId));
    }
}

