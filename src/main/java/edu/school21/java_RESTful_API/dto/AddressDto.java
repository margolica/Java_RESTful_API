package edu.school21.java_RESTful_API.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO для адреса") // Описание схемы
public class AddressDto {

    @Schema(description = "Страна", example = "Россия")
    @NotBlank
    String country;

    @Schema(description = "Город", example = "Москва")
    @NotBlank
    String city;

    @Schema(description = "Улица", example = "Ленина")
    @NotBlank
    String street;
}