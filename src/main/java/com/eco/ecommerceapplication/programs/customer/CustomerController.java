package com.eco.ecommerceapplication.programs.customer;

import com.eco.ecommerceapplication.programs.customer.dtos.CustomerRequestDTO;
import com.eco.ecommerceapplication.programs.customer.dtos.CustomerResponseDTO;
import com.eco.ecommerceapplication.shared.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> registerCustomer(
            @RequestBody CustomerRequestDTO request
                ){
        CustomerResponseDTO customer = customerService.registerCustomer(request);
            return ResponseEntity.ok(ApiResponse.success(customer));
        }
    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomer(
            @PathVariable Long customerId
    ){
        CustomerResponseDTO customer = customerService.getCustomer(customerId);
        return ResponseEntity.ok(ApiResponse.success(customer));
    }



    }

