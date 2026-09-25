package com.eco.ecommerceapplication.programs.vendor;

import com.eco.ecommerceapplication.Exceptions.BadRequestException;
import com.eco.ecommerceapplication.Exceptions.ResourceNotFoundException;
import com.eco.ecommerceapplication.programs.vendor.dtos.VendorRequestDTO;
import com.eco.ecommerceapplication.programs.vendor.dtos.VendorResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendorServiceImplementation implements VendorService {
   private final  VendorRepo vendorRepo;

    @Override
    public VendorResponseDTO registerVendor(VendorRequestDTO request) {
        if (request == null || request.getBusinessName() == null || request.getBusinessName().isBlank()) {
            throw new BadRequestException("Business name is required");
        }
        Vendor vendor = Vendor.builder()
                .businessName(request.getBusinessName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        Vendor saved = vendorRepo.save(vendor);
        return mapToResponseDTO(saved);
    }

    @Override
    public VendorResponseDTO getVendorById(Long vendorId) {
        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found with ID: " + vendorId));
        return mapToResponseDTO(vendor);
    }

    private VendorResponseDTO mapToResponseDTO(Vendor vendor) {
        return VendorResponseDTO.builder()
                .vendorId(vendor.getVendorId())
                .businessName(vendor.getBusinessName())
                .email(vendor.getEmail())
                .phone(vendor.getPhone())
                .build();
    }
}

