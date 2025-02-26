package edu.school21.java_RESTful_API.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO для поставщика")
public class SupplierDto {

    @Schema(description = "Наименовние посавщика", example = "ООО Полис")
    @NotBlank
    String name;

    @Schema(description = "Номер телефона", example = "+79012053848")
    @NotBlank
    String phone;

    @Schema(description = "Страна", example = "Россия")
    @NotBlank
    String country;

    @Schema(description = "Город", example = "Москва")
    @NotBlank
    String city;

    @Schema(description = "Улица", example = "Ленина")
    @NotBlank
    String street;

    @JsonIgnore
    public void setAddressDto(AddressDto addressDto) {
        this.country = addressDto.getCountry();
        this.city = addressDto.getCity();
        this.street = addressDto.getStreet();
    }

    @JsonIgnore
    public AddressDto getAddressDto() {
        AddressDto addressDto = new AddressDto();

        addressDto.setCountry(this.country);
        addressDto.setCity(this.city);
        addressDto.setStreet(this.street);

        return addressDto;
    }
}
