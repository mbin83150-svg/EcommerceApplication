package com.eco.ecommerceapplication.programs.customer.dtos;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDTO {
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;


}
