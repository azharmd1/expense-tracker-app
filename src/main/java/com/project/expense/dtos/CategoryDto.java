package com.project.expense.dtos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CategoryDto", description = "Data Transfer Object for Category to transfer data between client and server")

public record CategoryDto(Long id,
                          @Schema(
                                  description = "Name of the category"
                          ) String name) {

}
