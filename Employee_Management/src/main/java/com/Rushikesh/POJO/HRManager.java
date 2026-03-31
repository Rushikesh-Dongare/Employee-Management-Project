package com.Rushikesh.POJO;

public class HRManager extends Employee{
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
	
	
	
}
