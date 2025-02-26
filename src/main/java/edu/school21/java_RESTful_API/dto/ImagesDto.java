package edu.school21.java_RESTful_API.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "DTO для изображения")
public class ImagesDto {
    @Schema(description = "010101101", example = "Двоичный код")
    @NotNull
    byte[] data;

    public ImagesDto() {}

    public ImagesDto(byte[] data) {
        this.data = data;
    }
}
