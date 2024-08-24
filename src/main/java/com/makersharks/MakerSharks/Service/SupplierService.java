package com.makersharks.MakerSharks.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.makersharks.MakerSharks.Enums.ManufacturingProcess;
import com.makersharks.MakerSharks.Enums.NatureOfBusiness;
import com.makersharks.MakerSharks.Repo.SupplierRepo;
import com.makersharks.MakerSharks.Entity.Supplier;
@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepository;
    
    public Page<Supplier> searchSuppliers(
        String location, 
        NatureOfBusiness natureOfBusiness, 
        List<ManufacturingProcess> manufacturingProcesses, 
        int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(
            location, natureOfBusiness, manufacturingProcesses, pageable);
    }
    
    public Supplier saveSupplier(Supplier supplier) {
    	supplierRepository.save(supplier);
    	return supplier;
    }
    
}
