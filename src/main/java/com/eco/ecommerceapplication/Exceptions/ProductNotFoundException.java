package com.eco.ecommerceapplication.Exceptions;




public class ProductNotFoundException extends ResourceNotFoundException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
