package com.eco.ecommerceapplication.programs.vendor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorResponseDTO {
    private Long vendorId;
    private String businessName;
    private String email;
    private String phone;
}
