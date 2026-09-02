package com.eco.ecommerceapplication.shared.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder().data(data).timestamp(LocalDateTime.now()).success(true).message(message).build();
    }
    public static <T> ApiResponse<T> success(T data) {
        return success(data, "Request Processed Successfully");

    }

    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse .<T>builder()
                .success(false)
                .message(message)
                .build();
    }

}
