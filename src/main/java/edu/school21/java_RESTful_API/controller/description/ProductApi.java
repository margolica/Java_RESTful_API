package edu.school21.java_RESTful_API.controller.description;

import edu.school21.java_RESTful_API.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Products", description = "API для управления товарами")
public interface ProductApi {

    @Operation(
            summary = "Метод для добавления товара",
            tags = "Products",
            operationId = "createProduct",
            description = "Добавляет товар на основе JSON"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Товар успешно создан"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
    })
    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult);

    @Operation(
            summary = "Метод для уменьшения количества товара",
            tags = "Products",
            operationId = "updateAvailableStock",
            description = "Метод для уменьшения количества товара"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Количество товара успешно обновлено"),
            @ApiResponse(responseCode = "404", description = "Товар не найден"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
    })
    @PatchMapping("/availableStock/{id}")
    public ResponseEntity<Void> updateAvailableStock(
            @PathVariable Long id,
            @RequestParam int count
    );

    @Operation(
            summary = "Метод получения товара по идентификатору",
            tags = "Products",
            operationId = "getProductById",
            description = "Отображение товара по идентификатору"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товар успешно найден"),
            @ApiResponse(responseCode = "400", description = "Некорректные данные"),
            @ApiResponse(responseCode = "404", description = "Товар не найден")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    @Operation(
            summary = "Метод для получения всех доступных товаров",
            tags = "Products",
            operationId = "getAllProducts",
            description = "Отображение всех доступных товаров"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список товаров успешно получен"),
    })
    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts();

    @Operation(
            summary = "Метод удаления товара",
            tags = "Products",
            operationId = "deletedProduct",
            description = "Удаление товара"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Товар успешно удален"),
            @ApiResponse(responseCode = "404", description = "Товар не найден"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleted(@PathVariable Long id);
}
