package com.Rushikesh.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Rushikesh.POJO.*;

public class EmployeeService {

    Configuration con = new Configuration()
            .configure()
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Manager.class)
            .addAnnotatedClass(Admin.class)
            .addAnnotatedClass(HRManager.class)
            .addAnnotatedClass(SalesManager.class)
            .addAnnotatedClass(TeamLeader.class);

    SessionFactory factory = con.buildSessionFactory();

    // ================= ADD =================
    public boolean AddEmployee(Employee e) {

        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();

        session.persist(e);

        tr.commit();
        session.close();

        return true;
    }

    // ================= REMOVE =================
    public boolean RemoveEmployee(int id) {

        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();

        Employee emp = session.find(Employee.class, id);

        if (emp != null) {
            session.remove(emp);
            tr.commit();
            session.close();
            return true;
        }

        session.close();
        return false;
    }

    // ================= GET ALL =================
    public List<Employee> getAllEmployees() {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery("FROM Employee", Employee.class).getResultList();

        session.close();

        return list;
    }

    // ================= GET BY ID =================
    public Employee getEmployeeFromId(int id) {

        Session session = factory.openSession();

        Employee emp = session.find(Employee.class, id);

        session.close();

        return emp;
    }

    // ================= SEARCH =================
    public List<Employee> searchByName(String name) {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery(
                "FROM Employee e WHERE e.employeeName LIKE :name", Employee.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();

        session.close();

        return list;
    }

    public List<Employee> searchByDesignation(String designation) {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery(
                "FROM Employee e WHERE e.designation = :des", Employee.class)
                .setParameter("des", designation)
                .getResultList();

        session.close();

        return list;
    }

    public List<Employee> searchBySalary(double min, double max) {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery(
                "FROM Employee e WHERE e.basicSalary BETWEEN :min AND :max", Employee.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();

        session.close();

        return list;
    }

    // ================= PAGINATION =================
    public List<Employee> getEmployeesWithPagination(int page, int size) {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery("FROM Employee", Employee.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();

        session.close();

        return list;
    }

    // ================= SORTING =================
    public List<Employee> sortBySalary() {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery(
                "FROM Employee e ORDER BY e.basicSalary DESC", Employee.class)
                .getResultList();

        session.close();

        return list;
    }

    public List<Employee> sortByExperience() {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery(
                "FROM Employee e ORDER BY e.totalExperiance DESC", Employee.class)
                .getResultList();

        session.close();

        return list;
    }

    public List<Employee> sortByName() {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery(
                "FROM Employee e ORDER BY e.employeeName ASC", Employee.class)
                .getResultList();

        session.close();

        return list;
    }

    // ================= DASHBOARD =================
    public long getTotalEmployees() {

        Session session = factory.openSession();

        long count = session.createQuery(
                "SELECT COUNT(e) FROM Employee e", Long.class)
                .getSingleResult();

        session.close();

        return count;
    }

    public double getAverageSalary() {

        Session session = factory.openSession();

        double avg = session.createQuery(
                "SELECT AVG(e.basicSalary) FROM Employee e", Double.class)
                .getSingleResult();

        session.close();

        return avg;
    }

    public Employee getHighestSalaryEmployee() {

        Session session = factory.openSession();

        Employee emp = session.createQuery(
                "FROM Employee e ORDER BY e.basicSalary DESC", Employee.class)
                .setMaxResults(1)
                .uniqueResult();

        session.close();

        return emp;
    }

    public Map<String, Long> countByDesignation() {

        Session session = factory.openSession();

        List<Object[]> results = session.createQuery(
                "SELECT e.designation, COUNT(e) FROM Employee e GROUP BY e.designation")
                .getResultList();

        Map<String, Long> map = new HashMap<>();

        for (Object[] row : results) {
            map.put((String) row[0], (Long) row[1]);
        }

        session.close();

        return map;
    }

    // ================= BUSINESS LOGIC =================
    public double calculateSalary(int id) {

        Employee emp = getEmployeeFromId(id);

        if (emp == null) return 0;

        return emp.calculateSalary(); // polymorphism
    }
}