package com.Rushikesh.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Rushikesh.POJO.Admin;
import com.Rushikesh.POJO.Employee;
import com.Rushikesh.POJO.HRManager;
import com.Rushikesh.POJO.Manager;
import com.Rushikesh.POJO.SalesManager;
import com.Rushikesh.POJO.TeamLeader;
import com.mysql.cj.protocol.Security;

public class EmployeeService {
	
	Configuration con = new Configuration()
	        .configure()
	        .addAnnotatedClass(Employee.class)
	        .addAnnotatedClass(Manager.class)
	        .addAnnotatedClass(Admin.class)
	        .addAnnotatedClass(HRManager.class)
	        .addAnnotatedClass(SalesManager.class)
	        .addAnnotatedClass(TeamLeader.class)
	        .addAnnotatedClass(Security.class);
	SessionFactory factory = con.buildSessionFactory();
	
	List<Employee> AllEmployees = new ArrayList<Employee>();

	public List<Employee> getAllEmployees() {
		return AllEmployees;
	}

	public void setAllEmployees(List<Employee> allEmployees) {
		AllEmployees = allEmployees;
	}
	
	public boolean AddEmployee(Employee e)
	{
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		for(Employee emp: AllEmployees)
		{
			if(emp.getEmployeeId() == e.getEmployeeId())
			{
				System.out.println("This ID Already Exist");
				return false;
			}
		}
		session.persist(e);
		System.out.println("Added Sucessfully");
		tr.commit();
		return true;
	}
	
	public boolean RemoveEmployee(int id)
	{
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		
		Employee emp = session.find(Employee.class, id);
		
		if(emp != null)
		{
			session.remove(emp);
			System.out.println("Object Removed Sucessfully!");
			return true;
		}
		tr.commit();
		return false;
	}
	
	public Employee getEmployeeFromId(int id)
	{
		Session session = factory.openSession();
		
		return (Employee) session.find(Employee.class, id);
		
	}
	
}
