package edu.school21.java_RESTful_API.controller;

import edu.school21.java_RESTful_API.controller.description.SupplierApi;
import edu.school21.java_RESTful_API.dto.AddressDto;
import edu.school21.java_RESTful_API.dto.SupplierDto;
import edu.school21.java_RESTful_API.mapper.AddressMapper;
import edu.school21.java_RESTful_API.mapper.SupplierMapper;
import edu.school21.java_RESTful_API.model.Supplier;
import edu.school21.java_RESTful_API.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController implements SupplierApi {

    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;
    private final AddressMapper addressMapper;

    public SupplierController(SupplierService supplierService, SupplierMapper supplierMapper, AddressMapper addressMapper) {
        this.supplierService = supplierService;
        this.supplierMapper = supplierMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    @Transactional
    public ResponseEntity<String> createSupplier(SupplierDto supplierDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Supplier or Address not valid", HttpStatus.BAD_REQUEST);

        Supplier newSupplier = supplierService.save(supplierMapper.toEntity(supplierDto), addressMapper.toEntity(supplierDto.getAddressDto()));
        if (newSupplier == null)
            return ResponseEntity.badRequest().build();
        else {
            URI locationNewSupplier = URI.create("http://localhost:8082/api/v1/supplier/" + newSupplier.getId());
            return ResponseEntity.created(locationNewSupplier).build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> updateAddressFromSupplierById(Long id, AddressDto addressDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Address not valid", HttpStatus.BAD_REQUEST);
        ResponseEntity<SupplierDto> response = getSupplierById(id);
        if (response.getStatusCode() == HttpStatus.BAD_REQUEST)
            return ResponseEntity.badRequest().build();
        else if (response.getStatusCode() == HttpStatus.NOT_FOUND)
            return ResponseEntity.notFound().build();

        supplierService.updateAddress(id, addressMapper.toEntity(addressDto));

        SupplierDto updatedSupplier = getSupplierById(id).getBody();

        if (updatedSupplier != null && !updatedSupplier.getAddressDto().equals(addressDto))
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SupplierDto> getSupplierById(Long id) {
        if (id < 0)
            return ResponseEntity.badRequest().body(null);
        SupplierDto supplierDto = supplierMapper.toDTO(supplierService.getById(id).get());
        if (supplierDto == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(supplierDto);
    }

    @Override
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
        List<SupplierDto> listSupplierDto = supplierMapper.toDTOList(supplierService.getAll());
        return ResponseEntity.ok(listSupplierDto);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleted(Long id) {
        if (supplierService.delete(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}
