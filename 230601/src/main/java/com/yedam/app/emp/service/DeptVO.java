package com.yedam.app.emp.service;


public class DeptVO {
//	DEPARTMENT_ID
//	DEPARTMENT_NAME
//	MANAGER_ID
//	LOCATION_ID
	
	private String departmentName;
	private int managerId;
	private int locationId;
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
}
