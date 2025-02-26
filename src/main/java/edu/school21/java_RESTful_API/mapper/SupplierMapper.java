package edu.school21.java_RESTful_API.mapper;

import edu.school21.java_RESTful_API.dto.SupplierDto;
import edu.school21.java_RESTful_API.model.Supplier;

import java.util.List;

public interface SupplierMapper {
    Supplier toEntity(SupplierDto supplierDto);

    SupplierDto toDTO(Supplier supplier);

    List<SupplierDto> toDTOList(List<Supplier> suppliers);
}
