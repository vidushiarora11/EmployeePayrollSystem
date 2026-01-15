package model;

public class Employee {

    private String name;
    private String designation;
    private String department;
    private double basicSalary;

    public Employee(String name, String designation, String department, double basicSalary) {
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}
