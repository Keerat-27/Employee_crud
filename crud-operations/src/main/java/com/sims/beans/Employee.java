package com.sims.beans;

public class Employee {
	private int empId;
	private String empName;
	private double empSal;
	private String empMail;
	
	public Employee() {}
	
	public Employee(int empId, String empName, double empSal, String empMail) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empMail = empMail;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empMail=" + empMail
				+ "]";
	}
}
