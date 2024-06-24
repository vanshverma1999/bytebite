package com.bytebite.restaurant_service.controller;

import com.bytebite.restaurant_service.model.MenuItem;
import com.bytebite.restaurant_service.service.IMenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuItemController {
    private final IMenuItemService menuItemService;

    @PostMapping("restaurant/{restaurantId}/menuItem/")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem, @PathVariable Long restaurantId) {
        return ResponseEntity.ok(menuItemService.addMenuItem(menuItem, restaurantId));
    }

    @PutMapping("restaurant/{restaurantId}/menuItem/")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem updatedMenuItem, @PathVariable Long restaurantId) {
        return ResponseEntity.ok(menuItemService.updateMenuItem(updatedMenuItem, restaurantId));
    }

    @DeleteMapping("/menuItem/{menuItem}")
    public ResponseEntity deleteMenuItem(@PathVariable Long menuItem) {
        menuItemService.deleteMenuItem(menuItem);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
