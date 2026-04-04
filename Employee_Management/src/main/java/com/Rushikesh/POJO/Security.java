package com.Rushikesh.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Security extends Employee {
	
	@Column(name = "Current Shift")
	int currentShift;
	
	Security()
	{
		
	}
	
	Security(int id, String name, float experiance, String designation, double salary, String location, int shift)
	{
		super(id, name, experiance, designation, salary, location);
		this.currentShift = shift;
	}

	public int getCurrentShift() {
		return currentShift;
	}

	public void setCurrentShift(int currentShift) {
		this.currentShift = currentShift;
	}

	@Override
	public String toString() {
	    return super.toString() +
	           "Security Details:\n" +
	           "Current Shift: " + currentShift + "\n" +
	           "=========================\n";
	}
	
	public int changeShift()
	{
		if(currentShift < 3)
		{
			currentShift++;
		}
		else {
			currentShift = 1;
		}
		
		return currentShift;
	}
	
	@Override
	public double calculateSalary() {
//	    if (currentShift("Night")) {
//	        return basicSalary + 2000;
//	    }
	    return basicSalary;
	}
}
