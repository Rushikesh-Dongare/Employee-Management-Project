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

        int choice = 0;

        while (choice != 8) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Pagination");
            System.out.println("6. Sorting");
            System.out.println("7. Dashboard / Analytics");
            System.out.println("8. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: removeEmployee(); break;
                case 3: showAllEmployees(); break;
                case 4: searchEmployee(); break;
                case 5: paginateEmployees(); break;
                case 6: sortEmployees(); break;
                case 7: dashboard(); break;
                case 8: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // ================= ADD =================
    static void addEmployee() {

        System.out.println("\n1. Manager\n2. Team Leader\n3. Sales Manager\n4. Admin\n5. HR Manager");
        int choice = sc.nextInt();

        EmployeeData base = getBasicDetails();

        switch (choice) {
            case 1:
                System.out.print("Teams: ");
                service.AddEmployee(new Manager(base.getId(), base.getName(), base.getExperience(),
                        base.getDesignation(), base.getSalary(), base.getLocation(), sc.nextInt()));
                break;

            case 2:
                System.out.print("Members: ");
                service.AddEmployee(new TeamLeader(base.getId(), base.getName(), base.getExperience(),
                        base.getDesignation(), base.getSalary(), base.getLocation(), sc.nextInt()));
                break;

            case 3:
                System.out.print("Target: ");
                int target = sc.nextInt();
                System.out.print("Incentive: ");
                int inc = sc.nextInt();

                service.AddEmployee(new SalesManager(base.getId(), base.getName(), base.getExperience(),
                        base.getDesignation(), base.getSalary(), base.getLocation(), target, inc));
                break;

            case 4:
                service.AddEmployee(new Admin(base.getId(), base.getName(), base.getExperience(),
                        base.getDesignation(), base.getSalary(), base.getLocation()));
                break;

            case 5:
                System.out.print("Employees Managed: ");
                service.AddEmployee(new HRManager(base.getId(), base.getName(), base.getExperience(),
                        base.getDesignation(), base.getSalary(), base.getLocation(), sc.nextInt()));
                break;
        }
    }

    // ================= BASIC INPUT =================
    static EmployeeData getBasicDetails() {

        EmployeeData data = new EmployeeData();

        System.out.print("ID: ");
        data.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Name: ");
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

    // ================= REMOVE =================
    static void removeEmployee() {
        System.out.print("Enter ID: ");
        if (service.RemoveEmployee(sc.nextInt()))
            System.out.println("Removed!");
        else
            System.out.println("Not found!");
    }

    // ================= VIEW =================
    static void showAllEmployees() {
        printList(service.getAllEmployees());
    }

    // ================= SEARCH =================
    static void searchEmployee() {

        System.out.println("\n1. ID\n2. Name\n3. Designation\n4. Salary Range");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("ID: ");
                System.out.println(service.getEmployeeFromId(sc.nextInt()));
                break;

            case 2:
                sc.nextLine();
                System.out.print("Name: ");
                printList(service.searchByName(sc.nextLine()));
                break;

            case 3:
                sc.nextLine();
                System.out.print("Designation: ");
                printList(service.searchByDesignation(sc.nextLine()));
                break;

            case 4:
                System.out.print("Min Salary: ");
                double min = sc.nextDouble();
                System.out.print("Max Salary: ");
                double max = sc.nextDouble();
                printList(service.searchBySalary(min, max));
                break;
        }
    }

    // ================= PAGINATION =================
    static void paginateEmployees() {

        System.out.print("Enter page number: ");
        int page = sc.nextInt();

        System.out.print("Enter page size: ");
        int size = sc.nextInt();

        printList(service.getEmployeesWithPagination(page, size));
    }

    // ================= SORTING =================
    static void sortEmployees() {

        System.out.println("\nSort By:");
        System.out.println("1. Salary");
        System.out.println("2. Experience");
        System.out.println("3. Name");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                printList(service.sortBySalary());
                break;

            case 2:
                printList(service.sortByExperience());
                break;

            case 3:
                printList(service.sortByName());
                break;
        }
    }

    // ================= DASHBOARD =================
    static void dashboard() {

        System.out.println("\n===== DASHBOARD =====");

        System.out.println("Total Employees: " + service.getTotalEmployees());
        System.out.println("Average Salary: " + service.getAverageSalary());

        System.out.println("\nHighest Paid Employee:");
        System.out.println(service.getHighestSalaryEmployee());

        System.out.println("\nEmployees By Role:");
        service.countByDesignation().forEach((role, count) ->
                System.out.println(role + " : " + count));
    }

    // ================= BUSINESS LOGIC =================
    static void calculateSalary() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        double salary = service.calculateSalary(id);

        System.out.println("Calculated Salary: " + salary);
    }

    // ================= HELPER =================
    static void printList(List<Employee> list) {

        if (list == null || list.isEmpty()) {
            System.out.println("No Data Found!");
            return;
        }

        for (Employee e : list) {
            System.out.println(e);
        }
    }
}