package com.eco.ecommerceapplication.programs.customer;

import com.eco.ecommerceapplication.Exceptions.BadRequestException;
import com.eco.ecommerceapplication.Exceptions.ResourceNotFoundException;
import com.eco.ecommerceapplication.programs.customer.dtos.CustomerRequestDTO;
import com.eco.ecommerceapplication.programs.customer.dtos.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerServiceImplementation implements CustomerService {


    private final CustomerRepo customerRepo;



    @Override
    public CustomerResponseDTO registerCustomer(CustomerRequestDTO request ){
                              if (request == null || request.getCustomerName() == null || request.getCustomerName().isBlank()) {
                                  throw new BadRequestException("Customer name is required");
                              }
                              Customer customer = Customer.builder()
                                      .customerName(request.getCustomerName())
                                      .customerEmail(request.getCustomerEmail())
                                      .customerPhone(request.getCustomerPhone())
                                      .customerAddress(request.getCustomerAddress())
                                      .build();

                              Customer saved = customerRepo.save(customer);

                             return mapToResponseDTO(saved);
         }




    @Override
    public CustomerResponseDTO getCustomer(Long customerId){
                     Customer customer = customerRepo.findById(customerId)

                             .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + customerId));
                     return mapToResponseDTO(customer);
         }


private CustomerResponseDTO mapToResponseDTO(Customer customer){
                    return CustomerResponseDTO.builder()
                            .customerId(customer.getCustomerId())
                            .customerName(customer.getCustomerName())
                            .customerAddress(customer.getCustomerAddress())
                            .customerEmail((customer.getCustomerEmail()))
                            .customerPhone(customer.getCustomerPhone())
                            .build();
         }

}
