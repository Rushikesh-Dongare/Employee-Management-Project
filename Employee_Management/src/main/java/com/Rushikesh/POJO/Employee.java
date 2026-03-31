package com.Rushikesh.POJO;

import java.util.Scanner;

public abstract class Employee {
	
	static String companyName;
	
	Scanner sc = new Scanner(System.in);
	
	int employeeId;
	String employeeName;
	float totalExperiance;
	String designation;
	double basicSalary;
	String location;
	
	Employee()
	{
		
	}
	
	Employee(int id, String name, float experiance, String designation, double salary, String location)
	{
		this.employeeId = id;
		this.employeeName = name;
		this.totalExperiance = experiance;
		this.designation = designation;
		this.basicSalary = salary;
		this.location = location;
	}

	public static String getCompanyName() {
		return companyName;
	}

	public static void setCompanyName(String companyName) {
		Employee.companyName = companyName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public float getTotalExperiance() {
		return totalExperiance;
	}

	public void setTotalExperiance(float totalExperiance) {
		this.totalExperiance = totalExperiance;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void printDetails() {
	    System.out.println("Employee ID: " + employeeId);
	    System.out.println("Name: " + employeeName);
	    System.out.println("Experience: " + totalExperiance);
	    System.out.println("Designation: " + designation);
	    System.out.println("Salary: " + basicSalary);
	    System.out.println("Location: " + location);
	    System.out.println();
	}
	
}
