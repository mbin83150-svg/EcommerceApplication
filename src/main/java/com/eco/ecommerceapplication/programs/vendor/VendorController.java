package com.eco.ecommerceapplication.programs.vendor;

import com.eco.ecommerceapplication.shared.response.ApiResponse;
import com.eco.ecommerceapplication.programs.vendor.dtos.VendorRequestDTO;
import com.eco.ecommerceapplication.programs.vendor.dtos.VendorResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vendors")
public class VendorController {

    private  VendorService vendorService;

    @PostMapping
    public ResponseEntity<ApiResponse<VendorResponseDTO>> registerVendor(
            @RequestBody VendorRequestDTO request) {
        VendorResponseDTO vendor = vendorService.registerVendor(request);
        return ResponseEntity.ok(ApiResponse.success(vendor));
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<ApiResponse<VendorResponseDTO>> getVendor(
            @PathVariable Long vendorId) {
        VendorResponseDTO vendor = vendorService.getVendorById(vendorId);
        return ResponseEntity.ok(ApiResponse.success(vendor));
    }
}

