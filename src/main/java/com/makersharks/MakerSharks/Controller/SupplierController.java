package com.makersharks.MakerSharks.Controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.makersharks.MakerSharks.DTO.SupplierDto;
import com.makersharks.MakerSharks.Entity.Supplier;
import com.makersharks.MakerSharks.Service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;
    
    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
    	    @Valid @RequestBody SupplierDto request,
    	    @RequestParam(defaultValue = "0") int page,
    	    @RequestParam(defaultValue = "10") int size)
    {
    	    Page<Supplier> suppliers = supplierService.searchSuppliers(
    	        request.getLocation(), 
    	        request.getNatureOfBusiness(), 
    	        request.getManufacturingProcesses(), 
    	        page, size);
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }
    
    @PostMapping("/new")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier sup = supplierService.saveSupplier(supplier);
        return new ResponseEntity<>(sup, HttpStatus.CREATED);
    }
}
