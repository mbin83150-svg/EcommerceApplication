package com.eco.ecommerceapplication.programs.vendor;

import com.eco.ecommerceapplication.programs.vendor.dtos.VendorRequestDTO;
import com.eco.ecommerceapplication.programs.vendor.dtos.VendorResponseDTO;

public interface VendorService {
    VendorResponseDTO registerVendor(VendorRequestDTO request);
    VendorResponseDTO getVendorById(Long vendorId);
}
