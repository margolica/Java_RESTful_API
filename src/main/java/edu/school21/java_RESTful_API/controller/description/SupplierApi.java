package edu.school21.java_RESTful_API.controller.description;

import edu.school21.java_RESTful_API.dto.AddressDto;
import edu.school21.java_RESTful_API.dto.SupplierDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Suppliers")
public interface SupplierApi {

    @Operation(
            summary = "Метод для добавления поставщика",
            tags = "Suppliers",
            operationId = "createSupplier",
            description = "Добовлет поставщика на основе JSON"
    )
    @PostMapping
    public ResponseEntity<String> createSupplier(@Valid @RequestBody SupplierDto supplierDto, BindingResult bindingResult);

    @Operation(
            summary = "Метод для изменения адресса поставщика по иднтификатору",
            tags = "Suppliers",
            operationId = "updateAddressFromSupplierById",
            description = "Изменения адресса поставщика"
    )
    @PatchMapping("/{id}/address")
    public ResponseEntity<String> updateAddressFromSupplierById(@PathVariable Long id, @Valid @RequestBody AddressDto addressDto, BindingResult bindingResult);

    @Operation(
            summary = "Метод получения поставщика по идентификатору",
            tags = "Suppliers",
            operationId = "getSupplierById",
            description = "Отображение поставщика по идентификатору"
    )
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathVariable Long id);

    @Operation(
            summary = "Метод для получения всех поставщика",
            tags = "Suppliers",
            operationId = "getAllSuppliers",
            description = "Отображение всех поставщика"
    )
    @GetMapping("/all")
    public ResponseEntity<List<SupplierDto>> getAllSuppliers();

    @Operation(
            summary = "Метод удаления поставщика",
            tags = "Suppliers",
            operationId = "deletedSupplier",
            description = "Удаление поставщика"
    )
    @DeleteMapping
    public ResponseEntity<Void> deleted(Long id);
}
