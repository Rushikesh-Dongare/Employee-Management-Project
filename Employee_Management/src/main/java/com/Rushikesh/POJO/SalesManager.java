package com.Rushikesh.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SalesManager extends Employee{
	
	@Column(name = "Monthly Target")
	int target;
	
	@Column(name = "Incentive")
	double incentive;
	
	public SalesManager()
	{
		
	}
	
	public SalesManager(int id, String name, float experiance, String designation, double salary, String location, int target, double incentive)
	{
		super(id, name, experiance, designation, salary, location);
		this.target = target;
		this.incentive = incentive;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}

	@Override
	public String toString() {
	    return super.toString() +
	           "Sales Manager Details:\n" +
	           "Target: " + target + "\n" +
	           "Incentive: " + incentive + "\n" +
	           "=========================\n";
	}
	
	
}
