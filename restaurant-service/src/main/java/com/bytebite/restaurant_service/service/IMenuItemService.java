package com.bytebite.restaurant_service.service;

import com.bytebite.restaurant_service.model.MenuItem;

public interface IMenuItemService {
    MenuItem addMenuItem(MenuItem menuItem, Long restaurantId);
    MenuItem updateMenuItem(MenuItem updatedMenuItem, Long restaurantId);
    void deleteMenuItem(Long menuItemId);
}
