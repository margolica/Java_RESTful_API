package edu.school21.java_RESTful_API.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO для продукта")
public class ProductDto {

    @Schema(description = "Наименование товра", example = "Ёлка")
    @NotBlank
    String name;

    @Schema(description = "Ктегория товра", example = "Новый год")
    @NotBlank
    String category;

    @Schema(description = "Цена", example = "500")
    @NotNull
    int price;

    @Schema(description = "Количество в наличии", example = "100")
    @NotNull
    int stock;

    @Schema(description = "Дата полследнегго пополнения товара")
    @DateTimeFormat
    @NotNull
    LocalDate lastUpdateDate;
}
