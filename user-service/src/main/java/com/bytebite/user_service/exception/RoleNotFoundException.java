package com.bytebite.user_service.exception;

import lombok.Getter;

@Getter
public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String message){
        super(message);
    }
}
