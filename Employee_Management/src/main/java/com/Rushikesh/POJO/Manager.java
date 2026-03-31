package com.Rushikesh.POJO;


public class Manager extends Employee {
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

	
	
}
