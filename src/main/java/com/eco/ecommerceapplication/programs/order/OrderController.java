package com.eco.ecommerceapplication.programs.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eco.ecommerceapplication.shared.response.ApiResponse;

import lombok.RequiredArgsConstructor;
@RestController 
@RequestMapping ("/api/orders")
@RequiredArgsConstructor 
public class OrderController {
    private final OrderService orderService;


    @PostMapping ("/checkout/{customerId}")
    public ResponseEntity<ApiResponse<OrderResponseDTO>>checkout(@PathVariable Long customerId){
               OrderResponseDTO orderRepsonseDTO =  orderService.checkout(customerId);
        return ResponseEntity.ok(ApiResponse.success(orderRepsonseDTO));
    }
}
