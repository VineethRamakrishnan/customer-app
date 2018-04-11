package com.example.basic.dto;

public class EmployeeDTO {

	private String employeeName;
	
	private String employeeAddress;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public EmployeeDTO(String employeeName, String employeeAddress) {
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	public EmployeeDTO() {
		super();
		
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeName=" + employeeName + ", employeeAddress=" + employeeAddress + "]";
	}
	
	
}
