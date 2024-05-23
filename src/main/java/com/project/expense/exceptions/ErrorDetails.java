package com.project.expense.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Schema(name = "ErrorDetails", description = "Error Details DTO to transfer error response details between client and server")
@Getter
@Setter
public class ErrorDetails {
    @Schema(description = "Timestamp of the error")
    private LocalDate timestamp;
    @Schema(description = "Error message")
    private String message;
    @Schema(description = "Error details")
    private String details;
    @Schema(description = "Error code")
    private String errorCode;
}
