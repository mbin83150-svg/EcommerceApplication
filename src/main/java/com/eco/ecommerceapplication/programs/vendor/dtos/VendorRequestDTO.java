package com.eco.ecommerceapplication.programs.vendor.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VendorRequestDTO {
    private String businessName;
    private String email;
    private String phone;
}
