package com.eco.ecommerceapplication.Exceptions;

<<<<<<< HEAD



public class ProductNotFoundException extends ResourceNotFoundException {
=======
public class ProductNotFoundException extends RuntimeException {
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
    public ProductNotFoundException(String message) {
        super(message);
    }
}
