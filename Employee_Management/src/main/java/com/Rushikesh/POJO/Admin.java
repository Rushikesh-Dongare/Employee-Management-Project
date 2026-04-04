package com.Rushikesh.POJO;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Employee {
	public Admin()
	{
		
	}
	
	public Admin(int id, String name, float experiance, String designation, double salary, String location)
	{
		super(id, name, experiance, designation, salary, location);
	}
	
	@Override
	public String toString() {
	    return super.toString() +
	           "Admin Details:\n" +
	           "=========================\n";
	}
	
	@Override
	public double calculateSalary() {
	    return basicSalary + 1000; // fixed admin bonus
	}
}
