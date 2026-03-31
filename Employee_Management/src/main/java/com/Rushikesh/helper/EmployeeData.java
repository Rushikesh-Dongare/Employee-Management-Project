package com.Rushikesh.helper;

public class EmployeeData {
	int id;
    String name;
    float experience;
    String designation;
    double salary;
    String location;
    
    public EmployeeData()
    {
    	
    }
    
    public EmployeeData(int id, String name, float experiance, String designaton, double salary, String location)
    {
    	this.name = name;
    	this.experience = experiance;
    	this.designation = designaton;
    	this.salary = salary;
    	this.location = location;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
    public void printDetails()
    {
    	System.out.println("Employee Id: "+this.id);
    	System.out.println("Name: "+this.name);
    	System.out.println("Total Experiance: "+this.experience);
    	System.out.println("Designation: "+this.designation);
    	System.out.println("Salary: "+this.salary);
    	System.out.println("Location: "+this.location);
    }
}
