package com.Rushikesh.Service;

import java.util.ArrayList;
import java.util.List;

import com.Rushikesh.POJO.Employee;

public class EmployeeService {
	
	List<Employee> AllEmployees = new ArrayList<Employee>();

	public List<Employee> getAllEmployees() {
		return AllEmployees;
	}

	public void setAllEmployees(List<Employee> allEmployees) {
		AllEmployees = allEmployees;
	}
	
	public boolean AddEmployee(Employee e)
	{
		for(Employee emp: AllEmployees)
		{
			if(emp.getEmployeeId() == e.getEmployeeId())
			{
				System.out.println("This ID Already Exist");
				return false;
			}
		}
		AllEmployees.add(e);
		System.out.println(AllEmployees.toString());
		return true;
	}
	
	public List<Employee> RemoveEmployee(Employee e)
	{
		AllEmployees.remove(e);
		return AllEmployees;
	}
	
	public Employee getEmployeeFromId(int id)
	{
		
		for(Employee e: AllEmployees)
		{
			if(e.getEmployeeId() == id)
			{
				return e;
			}
			else {
				return AllEmployees.getFirst();
			}
		}
		return null;
	}
	
}
