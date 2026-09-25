package com.eco.ecommerceapplication.programs.customer.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDTO {
    private long customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;

}
