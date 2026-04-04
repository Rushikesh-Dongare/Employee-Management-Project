package com.Rushikesh.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Manager extends Employee {
	
	@Column(name = "Total Teams Under Management")
	 private int totalTeamsUnderManagement;
	
	public Manager()
	{
		
	}
	
	public Manager(int id, String name, float experiance, String designation, double salary, String location, int teams)
	{
		super(id, name, experiance, designation, salary, location);
		this.totalTeamsUnderManagement = teams;
	}

	public int getTotalTeamsUnderManagement() {
		return totalTeamsUnderManagement;
	}

	public void setTotalTeamsUnderManagement(int totalTeamsUnderManagement) {
		this.totalTeamsUnderManagement = totalTeamsUnderManagement;
	}

	@Override
	public String toString() {
	    return super.toString() +
	           "Manager Details:\n" +
	           "Teams Managed: " + totalTeamsUnderManagement + "\n" +
	           "=========================\n";
	}

	@Override
	public double calculateSalary() {
	    double bonus = totalTeamsUnderManagement * 1000; // per team bonus
	    return basicSalary + bonus;
	}
	
}
