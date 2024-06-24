package com.bytebite.restaurant_service.service;

import com.bytebite.restaurant_service.model.MenuItem;
import com.bytebite.restaurant_service.model.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant registerRestaurant(Restaurant restaurant);
    Restaurant getById(Long id);
    Restaurant updateRestaurant(Restaurant updatedRestaurant);
    void deleteRestaurant(Long id);
    List<MenuItem> getRestaurantMenu(Long restaurantId);
}
