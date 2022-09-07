package com.shop.sweattreat.execption;

public class CourierNotFoundException extends RuntimeException
{
    public CourierNotFoundException(String exception){
        super(exception);
    }
}
