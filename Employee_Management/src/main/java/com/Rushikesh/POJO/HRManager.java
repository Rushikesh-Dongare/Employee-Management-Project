package com.Rushikesh.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class HRManager extends Employee{
	
	@Column(name = "Total Pepole Managing")
	int employeesUnder;
	
	public HRManager()
	{
		
	}
	
	public HRManager(int id, String name, float experiance, String designation, double salary, String location, int employees)
	{
		super(id, name, experiance, designation, salary, location);
		this.employeesUnder = employees;
	}

	public int getEmployeesUnder() {
		return employeesUnder;
	}

	public void setEmployeesUnder(int employeesUnder) {
		this.employeesUnder = employeesUnder;
	}

	@Override
	public String toString() {
	    return super.toString() +
	           "HR Manager Details:\n" +
	           "Employees Managed: " + employeesUnder + "\n" +
	           "=========================\n";
	}
	
	@Override
	public double calculateSalary() {
	    double bonus = employeesUnder * 300;
	    return basicSalary + bonus;
	}
	
}
