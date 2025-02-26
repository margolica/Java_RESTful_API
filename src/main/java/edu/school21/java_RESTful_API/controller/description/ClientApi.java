package edu.school21.java_RESTful_API.controller.description;

import edu.school21.java_RESTful_API.dto.AddressDto;
import edu.school21.java_RESTful_API.dto.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clients", description = "API для управления клиентами")
public interface ClientApi {

    @Operation(
            summary = "Метод для получения всех клиентов с ограничениями",
            tags = "Clients",
            operationId = "getAllClientsLimitOffset",
            description = "Отображение всех клиентов с ограничениями",
            parameters = {
                    @Parameter(name = "limit", description = "Количество клиентов на странице", required = true),
                    @Parameter(name = "offset", description = "Смещение (начальная позиция)", required = true)
            }
    )
    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClientsWithLimitOffset(int limit, int offset);

    @Operation(
            summary = "Метод для получения всех клиентов",
            tags = "Clients",
            operationId = "getAllClients",
            description = "Отображение всех клиентов"
    )
    @GetMapping("/all")
    public ResponseEntity<List<ClientDto>> getAllClients();

    @Operation(
            summary = "Метод получения клиента по идентификатору",
            tags = "Clients",
            operationId = "getClientById",
            description = "Отображение клиента по идентификатору"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Клиент найден"),
            @ApiResponse(responseCode = "404", description = "Клиент не найден"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id);

    @Operation(
            summary = "Метод для добавления клиента",
            tags = "Clients",
            operationId = "createClient",
            description = "Добавляет клиента на основе JSON"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Клиент успешно создан"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody ClientDto clientDto, BindingResult bindingResult);

    @Operation(
            summary = "Метод удаления клиента",
            tags = "Clients",
            operationId = "deleteClient",
            description = "Удаление клиента"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Клиент успешно удален"),
            @ApiResponse(responseCode = "404", description = "Клиент не найден")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(
            summary = "Метод для изменения адреса клиента по идентификатору",
            tags = "Clients",
            operationId = "updateAddressFromClientById",
            description = "Изменение адреса клиента"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Адрес успешно обновлен"),
            @ApiResponse(responseCode = "404", description = "Клиент не найден"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @PatchMapping("/{id}/address")
    public ResponseEntity<String> updateAddressFromClientById(@PathVariable Long id, @Valid @RequestBody AddressDto addressDto, BindingResult bindingResult);
}