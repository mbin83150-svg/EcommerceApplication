package com.eco.ecommerceapplication.programs.order.orderitem;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter 
@Builder 
@AllArgsConstructor 
@NoArgsConstructor 
public class OrderItemResponseDTO {
        private long orderItemId;
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}

