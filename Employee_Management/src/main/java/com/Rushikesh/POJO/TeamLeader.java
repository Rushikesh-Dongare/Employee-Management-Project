package com.Rushikesh.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class TeamLeader extends Employee {
	
	@Column(name = "Total Team Members")
	int totalTeamMembers;
	
	public TeamLeader()
	{
		
	}
	
	public TeamLeader(int id, String name, float experiance, String designation, double salary, String location, int totalMembers)
	{
		super(id, name, experiance, designation, salary, location);
		this.totalTeamMembers = totalMembers;
	}

	public int getTotalTeamMembers() {
		return totalTeamMembers;
	}

	public void setTotalTeamMembers(int totalTeamMembers) {
		this.totalTeamMembers = totalTeamMembers;
	}

	@Override
	public String toString() {
		return "TeamLeader [totalTeamMembers=" + totalTeamMembers + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", totalExperiance=" + totalExperiance + ", designation=" + designation
				+ ", basicSalary=" + basicSalary + ", location=" + location + "]";
	}
	
	@Override
	public double calculateSalary() {
	    double bonus = totalTeamMembers * 500;
	    return basicSalary + bonus;
	}
	
}
