/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01classesandobjects;

/**
 *
 * @author ProBook
 */
// Represents an employee with a unique automatically assigned ID
public class Employee {

    // Static counter shared by all Employee objects
    private static int nextEmployeeId = 1;

    // Instance fields store each employee's information
    private int employeeId;
    private String name;
    private String department;
    private double salary;

    // Assigns the next available ID to each new employee
    private void assignEmployeeId() {
        employeeId = nextEmployeeId;
        nextEmployeeId++;
    }

    // Constructor 1: Creates an employee with default details
    public Employee() {
        assignEmployeeId();
        name = "Unknown";
        department = "Unassigned";
        salary = 0.0;
    }

    // Constructor 2: Accepts the employee's name
    public Employee(String name) {
        assignEmployeeId();
        this.name = name;
        department = "Unassigned";
        salary = 0.0;
    }

    // Constructor 3: Accepts name, department and salary
    public Employee(String name, String department, double salary) {
        assignEmployeeId();
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Copy constructor creates a new employee using another employee's details
    public Employee(Employee other) {
        assignEmployeeId();
        this.name = other.name;
        this.department = other.department;
        this.salary = other.salary;
    }

    // Displays employee information
    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("--------------------");
    }
}

