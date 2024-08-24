package com.makersharks.MakerSharks.Repo;

import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.makersharks.MakerSharks.Entity.Supplier;
import com.makersharks.MakerSharks.Enums.NatureOfBusiness;
import com.makersharks.MakerSharks.Enums.ManufacturingProcess;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    
	   @Query("SELECT s FROM Supplier s JOIN s.manufacturingProcesses mp " +
	           "WHERE s.location = :location " +
	           "AND s.natureOfBusiness = :natureOfBusiness " +
	           "AND mp IN :manufacturingProcesses")
	    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcesses(
	        @Param("location") String location,
	        @Param("natureOfBusiness") NatureOfBusiness natureOfBusiness,
	        @Param("manufacturingProcesses") List<ManufacturingProcess> manufacturingProcesses,
	        Pageable pageable);
}
