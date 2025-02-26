package edu.school21.java_RESTful_API.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Schema(description = "DTO для клиента") // Описание схемы
public class ClientDto {

    @Schema(description = "Имя клиента", example = "Vlad")
    @NotBlank(message = "Имя клиента не должно быть пустым")
    String firstName;

    @Schema(description = "Фамилия клиента", example = "Vlad")
    @NotBlank
    String lastName;

    @Schema(description = "Дата рождения клиента", example = "1990-01-01")
    @DateTimeFormat
    @NotNull
    LocalDate birthday;

    @Schema(description = "Пол клиента (0 - Не указан, 1 - Мужчина, 2 - Женщина, 9 - Не имеет значения)", example = "1")
    @NotNull
    int gender;

    @Schema(description = "Дата регистрации клиента", example = "2023-10-05")
    @DateTimeFormat
    @NotNull
    LocalDate registrationDate;

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