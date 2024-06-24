package com.bytebite.restaurant_service.service.impl;

import com.bytebite.restaurant_service.model.MenuItem;
import com.bytebite.restaurant_service.model.Restaurant;
import com.bytebite.restaurant_service.repository.MenuItemRepository;
import com.bytebite.restaurant_service.service.IMenuItemService;
import com.bytebite.restaurant_service.service.IRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuItemService implements IMenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final IRestaurantService restaurantService;
    @Override
    public MenuItem addMenuItem(MenuItem menuItem, Long restaurantId) {
        Restaurant restaurant = restaurantService.getById(restaurantId);
        menuItem.setRestaurant(restaurant);
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(MenuItem updatedMenuItem, Long restaurantId) {
        MenuItem menuItem = menuItemRepository.findById(updatedMenuItem.getId()).orElseThrow();
        if(updatedMenuItem.getAvailability()!=null){
            menuItem.setAvailability(updatedMenuItem.getAvailability());
        }
        if(updatedMenuItem.getDescription()!=null){
            menuItem.setDescription(updatedMenuItem.getDescription());
        }
        if(updatedMenuItem.getName()!=null){
            menuItem.setName(updatedMenuItem.getName());
        }
        if(updatedMenuItem.getPrice()!=null){
            menuItem.setPrice(updatedMenuItem.getPrice());
        }
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void deleteMenuItem(Long menuItemId) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElseThrow();
        menuItem.setDeleted(true);
        menuItemRepository.save(menuItem);
    }
}
