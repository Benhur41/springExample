package com.yedam.app.emp.service;


public class DeptVO {
//	DEPARTMENT_ID
//	DEPARTMENT_NAME
//	MANAGER_ID
//	LOCATION_ID
	
	private String departmentName;
	private String managerId;
	private String locationId;
	private String departmentId;
	private String orderColumn;
	public String[] getDeptArr() {
		return departmentId.split(",");
	}
	
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
}
