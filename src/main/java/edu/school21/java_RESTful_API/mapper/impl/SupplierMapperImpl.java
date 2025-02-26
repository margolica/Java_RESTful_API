package edu.school21.java_RESTful_API.mapper.impl;

import edu.school21.java_RESTful_API.dto.SupplierDto;
import edu.school21.java_RESTful_API.mapper.SupplierMapper;
import edu.school21.java_RESTful_API.model.Supplier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Override
    public Supplier toEntity(SupplierDto supplierDto) {
        if ( supplierDto == null ) {
            return null;
        }

        Supplier.SupplierBuilder supplier = Supplier.builder();
        supplier.name(supplierDto.getName());
        supplier.phoneNumber(supplierDto.getPhone());

        return supplier.build();
    }

    @Override
    public SupplierDto toDTO(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDto supplierDto = new SupplierDto();

        supplierDto.setName(supplier.getName());
        supplierDto.setPhone(supplier.getPhoneNumber());
        supplierDto.setCountry(supplier.getAddress().getCountry());
        supplierDto.setCity(supplier.getAddress().getCity());
        supplierDto.setStreet(supplier.getAddress().getStreet());

        return supplierDto;
    }

    @Override
    public List<SupplierDto> toDTOList(List<Supplier> suppliers) {
        if ( suppliers == null ) {
            return null;
        }

        List<SupplierDto> list = new ArrayList<SupplierDto>( suppliers.size() );
        for ( Supplier supplier : suppliers ) {
            list.add( toDTO( supplier ) );
        }

        return list;
    }

}
