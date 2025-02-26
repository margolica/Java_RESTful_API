package edu.school21.java_RESTful_API.service;

import edu.school21.java_RESTful_API.model.Address;
import edu.school21.java_RESTful_API.model.Supplier;
import edu.school21.java_RESTful_API.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService  {

    private final AddressService addressService;
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(AddressService addressService, SupplierRepository supplierRepository) {
        this.addressService = addressService;
        this.supplierRepository = supplierRepository;
    }

    public Supplier save(Supplier supplier, Address address) {
        Supplier savedSupplier = supplier;
        supplier.setAddress(address);
        return supplierRepository.save(supplier);
    }

    public void updateAddress(Long id, Address address) {
        addressService.update(getById(id).get().getAddress().getId(), address);

    }

    public Optional<Supplier> getById(Long id) {
        return supplierRepository.findById(id);
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public boolean delete(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()) {
            supplierRepository.delete(supplier.get());
            return true;
        } else {
            return false;
        }
    }
}
