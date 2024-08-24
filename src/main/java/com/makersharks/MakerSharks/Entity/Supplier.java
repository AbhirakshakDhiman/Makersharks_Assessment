package com.makersharks.MakerSharks.Entity;

import java.util.List;
import com.makersharks.MakerSharks.Enums.ManufacturingProcess;
import com.makersharks.MakerSharks.Enums.NatureOfBusiness;

import jakarta.persistence.*;
/*1. supplier_id : unique identifier for each supplier
2. company_name
3. website
4. location : city, assuming one supplier_id maps to just one location
5. nature_of_business : Possible values: small_scale, medium_scale, large_scale
6. manufacturing_processes : Possible values for POC: moulding, 3d_printing, casting, coating
*/
@Entity
@Table(name = "suppliers")
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    private String companyName;
    private String website;
    private String location;
    
    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "supplier_manufacturing_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Enumerated(EnumType.STRING)
    private List<ManufacturingProcess> manufacturingProcesses;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public NatureOfBusiness getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(NatureOfBusiness natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	public List<ManufacturingProcess> getManufacturingProcesses() {
		return manufacturingProcesses;
	}

	public void setManufacturingProcesses(List<ManufacturingProcess> manufacturingProcesses) {
		this.manufacturingProcesses = manufacturingProcesses;
	}

	public Supplier() {
		super();
	}
    
}

