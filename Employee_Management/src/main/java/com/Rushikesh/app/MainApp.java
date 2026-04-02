package com.Rushikesh.app;

import java.util.List;
import java.util.Scanner;

import com.Rushikesh.POJO.*;
import com.Rushikesh.Service.EmployeeService;
import com.Rushikesh.helper.EmployeeData;

public class MainApp {

    static Scanner sc = new Scanner(System.in);
    static EmployeeService service = new EmployeeService();

    public static void main(String[] args) {

        System.out.println("Welcome");

        int choice = 0;

        while (choice != 5) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    removeEmployee();
                    break;

                case 3:
                    showAllEmployees();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;
                   
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {

        System.out.println("\nChoose Employee Type:");
        System.out.println("1. Manager");
        System.out.println("2. Team Leader");
        System.out.println("3. Sales Manager");
        System.out.println("4. Admin");
        System.out.println("5. HR Manager");

        int choice = sc.nextInt();

        // ✅ Get common data once
        EmployeeData base = getBasicDetails();

        switch (choice) {

            case 1:
                System.out.print("Enter number of teams: ");
                int teams = sc.nextInt();

                Employee manager = new Manager(
                        base.getId(),
                        base.getName(),
                        base.getExperience(),
                        base.getDesignation(),
                        base.getSalary(),
                        base.getLocation(),
                        teams
                );

                service.AddEmployee(manager);
                break;

            case 2:
                System.out.print("Enter team members: ");
                int members = sc.nextInt();

                // ⚠️ Replace with TeamLeader class later
                Employee teamLeader = new TeamLeader(
                		base.getId(),
                        base.getName(),
                        base.getExperience(),
                        base.getDesignation(),
                        base.getSalary(),
                        base.getLocation(),
                        members
                );

                service.AddEmployee(teamLeader);
                break;
                
            case 3:
                System.out.print("Enter Taarget: ");
                int target = sc.nextInt();
                System.out.println("Enter Incentive after completing target: ");
                int incentive = sc.nextInt();

                // ⚠️ Replace with TeamLeader class later
                Employee salesManager = new SalesManager(
                		base.getId(),
                        base.getName(),
                        base.getExperience(),
                        base.getDesignation(),
                        base.getSalary(),
                        base.getLocation(),
                        target,
                        incentive
                );

                service.AddEmployee(salesManager);
                break;

            case 4:
                Employee admin = new Admin(
                		base.getId(),
                        base.getName(),
                        base.getExperience(),
                        base.getDesignation(),
                        base.getSalary(),
                        base.getLocation()
                );

                service.AddEmployee(admin);
                break;
             
            case 5:
            	System.out.println("Enter total Employees Handeled by this HR");
            	int employees = sc.nextInt();
                Employee hrManager = new HRManager(
                		base.getId(),
                        base.getName(),
                        base.getExperience(),
                        base.getDesignation(),
                        base.getSalary(),
                        base.getLocation(),
                        employees
                );

                service.AddEmployee(hrManager);
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
    }
    static Manager getManagerDetails() {

        System.out.println("\n--- Enter Manager Details ---");

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // fix buffer issue

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Experience: ");
        float experience = sc.nextFloat();
        sc.nextLine();

        System.out.print("Designation: ");
        String designation = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Location: ");
        String location = sc.nextLine();

        System.out.print("Teams under manager: ");
        int teams = sc.nextInt();

        return new Manager(id, name, experience, designation, salary, location, teams);
    }

    static Employee getTeamLeaderDetails() {

        System.out.println("\n--- Enter Team Leader Details ---");

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Experience: ");
        float experience = sc.nextFloat();
        sc.nextLine();

        System.out.print("Designation: ");
        String designation = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Location: ");
        String location = sc.nextLine();

        System.out.print("Team Members: ");
        int teamMembers = sc.nextInt();

        // ⚠️ You should ideally use TeamLeader class here
        return new Manager(id, name, experience, designation, salary, location, teamMembers);
    }
    
    static EmployeeData getBasicDetails() {
        EmployeeData data = new EmployeeData();

        System.out.print("Enter ID: ");
        data.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Name: ");
        data.setName(sc.nextLine());

        System.out.print("Experience: ");
        data.setExperience(sc.nextFloat());
        sc.nextLine();

        System.out.print("Designation: ");
        data.setDesignation(sc.nextLine());

        System.out.print("Salary: ");
        data.setSalary(sc.nextDouble());
        sc.nextLine();

        System.out.print("Location: ");
        data.setLocation(sc.nextLine());

        return data;
    }
    
    static void removeEmployee()
    {
    	System.out.println("Enter ID of an Employee you want to remove: ");
    	int id = sc.nextInt();
    	
    	if(service.getAllEmployees().isEmpty())
		{
			System.out.println("List is Empty, No Employees Registered!");
		}
		
		if(service.RemoveEmployee(id))
		{
			System.out.println("Employee Removed from System");
		}
		else {
			System.out.println("This Employee Does not Exist in Our System");
		}
	}
    
    public static void showAllEmployees()
    {
    	List<Employee> empList = service.getAllEmployees();
    	
    	for(Employee e: empList)
    	{
    		System.out.println(e.toString());
    	}
    }
    
    static void searchById()
    {
    	System.out.println("Enter an Employee id: ");
    	int id = sc.nextInt();
    	
    	Employee e = service.getEmployeeFromId(id);
    }
}