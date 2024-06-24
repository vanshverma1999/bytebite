package com.bytebite.restaurant_service.exception;

public class RestaurantFoundException extends RuntimeException{
    public RestaurantFoundException(String message){
        super(message);
    }
}
