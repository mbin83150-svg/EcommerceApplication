package com.eco.ecommerceapplication.Exceptions;

import com.eco.ecommerceapplication.shared.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleNotFound_shouldReturn404() {
        ResponseEntity<ApiResponse<Object>> response =
                handler.handleNotFound(new ResourceNotFoundException("Customer not found"));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertFalse(response.getBody().isSuccess());
        assertEquals("Customer not found", response.getBody().getMessage());
    }

    @Test
    void handleBadRequest_shouldReturn400() {
        ResponseEntity<ApiResponse<Object>> response =
                handler.handleBadRequest(new BadRequestException("Quantity must be positive"));

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertFalse(response.getBody().isSuccess());
        assertEquals("Quantity must be positive", response.getBody().getMessage());
    }
}
