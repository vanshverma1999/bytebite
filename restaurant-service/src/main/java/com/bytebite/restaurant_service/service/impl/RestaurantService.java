package com.bytebite.restaurant_service.service.impl;

import com.bytebite.restaurant_service.exception.RestaurantNotFoundException;
import com.bytebite.restaurant_service.model.MenuItem;
import com.bytebite.restaurant_service.model.Restaurant;
import com.bytebite.restaurant_service.repository.MenuItemRepository;
import com.bytebite.restaurant_service.repository.RestaurantRepository;
import com.bytebite.restaurant_service.service.IRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService implements IRestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;
    @Override
    public Restaurant registerRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id: "+ id));
    }

    @Override
    public Restaurant updateRestaurant(Restaurant updatedRestaurant) {
        Restaurant restaurant =
                getById(updatedRestaurant.getId());
        if(updatedRestaurant.getName()!=null){
            restaurant.setName(updatedRestaurant.getName());
        }
        if(updatedRestaurant.getAddress()!=null){
            restaurant.setAddress(updatedRestaurant.getAddress());
        }
        if(updatedRestaurant.getContactInfo()!=null){
            restaurant.setContactInfo(updatedRestaurant.getContactInfo());
        }
        if(updatedRestaurant.getCuisineType()!=null){
            restaurant.setCuisineType(updatedRestaurant.getCuisineType());
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant restaurant = getById(id);
        restaurant.setDeleted(true);
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<MenuItem> getRestaurantMenu(Long restaurantId) {
        return menuItemRepository.findByRestaurant_Id(restaurantId);
    }
}
