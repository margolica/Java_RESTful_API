package edu.school21.java_RESTful_API.controller.description;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Images")
public interface ImagesApi {
    @Operation(
            summary = "Метод для добавления изображения",
            tags = "Images",
            operationId = "createImage",
            description = "Добавляет изображение в бинарном формате"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Изображение успешно создано"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    @PostMapping(consumes = "application/octet-stream")
    public ResponseEntity<Void> create(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
                required = true,
                content = @Content(
                        mediaType = "application/octet-stream",
                        schema = @Schema(
                                type = "string",
                                format = "binary",
                                description = "Бинарные данные изображения"
                        )
                )
        )
       @RequestBody byte[] imagesDto
    );

    @Operation(
            summary = "Метод для изменения изображения",
            tags = "Images",
            operationId = "updateImages",
            description = "Метод для изменения изображения"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Изображение успешно обновлено"),
            @ApiResponse(responseCode = "404", description = "Изображение не найдено"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateImages(UUID id,
         @io.swagger.v3.oas.annotations.parameters.RequestBody(
                 required = true,
                 content = @Content(
                         mediaType = "application/octet-stream",
                         schema = @Schema(
                                 type = "string",
                                 format = "binary",
                                 description = "Бинарные данные изображения"
                         )
                 )
         )
         @RequestBody byte[] imagesDto
    );


    @Operation(
            summary = "Метод получения изображения по идентификатору товара",
            tags = "Images",
            operationId = "getImageProductId",
            description = "Отображение изображения по идентификатору товара"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Изображение успешно получено"),
            @ApiResponse(responseCode = "404", description = "Продукт или изображение не найдено"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные")
    })
    @GetMapping("/products/{id}")
    public ResponseEntity<byte[]> getImageProductId(@PathVariable("id") Long id);

    @Operation(
            summary = "Метод получения изображения по идентификатору",
            tags = "Images",
            operationId = "getImageById",
            description = "Отображение изображения по идентификатору"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Изображение успешно получено"),
            @ApiResponse(responseCode = "404", description = "Изображение не найдено")
    })
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable UUID id);

    @Operation(
            summary = "Метод удаления изображения по идентификатору",
            tags = "Images",
            operationId = "deletedImages",
            description = "Удаление изображения"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Изображение успешно удалено"),
            @ApiResponse(responseCode = "404", description = "Изображение не найдено")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleted(@PathVariable UUID id);
}
