package com.Rushikesh.POJO;

public class TeamLeader extends Employee {
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
	
	
}
