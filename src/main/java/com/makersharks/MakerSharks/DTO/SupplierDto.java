package com.makersharks.MakerSharks.DTO;

import com.makersharks.MakerSharks.Enums.ManufacturingProcess;
import com.makersharks.MakerSharks.Enums.NatureOfBusiness;
import java.util.List;

import jakarta.validation.constraints.*;


public class SupplierDto {

	    
	    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public NatureOfBusiness getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public SupplierDto() {
		super();
		// TODO Auto-generated constructor stub
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

		@NotBlank
	    private String location;
	    
	    @NotNull
	    private NatureOfBusiness natureOfBusiness;
	    
	    @NotEmpty
	    private List<ManufacturingProcess> manufacturingProcesses;
	

}
