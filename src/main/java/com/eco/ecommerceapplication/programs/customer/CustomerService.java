package com.eco.ecommerceapplication.programs.customer;



import com.eco.ecommerceapplication.programs.customer.dtos.CustomerRequestDTO;
import com.eco.ecommerceapplication.programs.customer.dtos.CustomerResponseDTO;



public interface CustomerService {

     CustomerResponseDTO registerCustomer(CustomerRequestDTO request );
     CustomerResponseDTO getCustomer(Long customerId);

}
