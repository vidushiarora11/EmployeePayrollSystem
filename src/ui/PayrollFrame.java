package ui;

import model.Employee;
import model.Payroll;
import util.PDFGenerator;

import javax.swing.*;

import dao.EmployeeDAO;
import dao.PayrollDAO;

public class PayrollFrame extends JFrame {

    // Declare input fields
    private JTextField txtName;
    private JTextField txtDesignation;
    private JTextField txtDepartment;
    private JTextField txtSalary;
    private JTextField txtMonth;

    private JButton btnGenerate;

    public PayrollFrame() {

        setTitle("Employee Payroll Generator - Admin Dashboard");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // absolute layout (simple for beginners)

        // Labels
        JLabel lblName = new JLabel("Employee Name:");
        lblName.setBounds(50, 40, 120, 25);
        add(lblName);

        JLabel lblDesignation = new JLabel("Designation:");
        lblDesignation.setBounds(50, 80, 120, 25);
        add(lblDesignation);

        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setBounds(50, 120, 120, 25);
        add(lblDepartment);

        JLabel lblSalary = new JLabel("Basic Salary:");
        lblSalary.setBounds(50, 160, 120, 25);
        add(lblSalary);

        JLabel lblMonth = new JLabel("Month:");
        lblMonth.setBounds(50, 200, 120, 25);
        add(lblMonth);

        // Text Fields
        txtName = new JTextField();
        txtName.setBounds(180, 40, 200, 25);
        add(txtName);

        txtDesignation = new JTextField();
        txtDesignation.setBounds(180, 80, 200, 25);
        add(txtDesignation);

        txtDepartment = new JTextField();
        txtDepartment.setBounds(180, 120, 200, 25);
        add(txtDepartment);

        txtSalary = new JTextField();
        txtSalary.setBounds(180, 160, 200, 25);
        add(txtSalary);

        txtMonth = new JTextField();
        txtMonth.setBounds(180, 200, 200, 25);
        add(txtMonth);

        // Button
        btnGenerate = new JButton("Generate Payroll");
        btnGenerate.setBounds(150, 260, 180, 30);
        btnGenerate.addActionListener(e -> handleGeneratePayroll());
        add(btnGenerate);


        setVisible(true);
    }

  /*  
    private void handleGeneratePayroll() {

    String name = txtName.getText().trim();
    String designation = txtDesignation.getText().trim();
    String department = txtDepartment.getText().trim();
    String month = txtMonth.getText().trim();
    String salaryText = txtSalary.getText().trim();

    // Basic validation
    if (name.isEmpty() || designation.isEmpty() || department.isEmpty()
            || month.isEmpty() || salaryText.isEmpty()) {

        JOptionPane.showMessageDialog(this,
                "All fields are mandatory!",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    double basicSalary;

    try {
        basicSalary = Double.parseDouble(salaryText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Basic Salary must be a number!",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // STEP 3B: Create backend objects
Employee employee = new Employee(
        name,
        designation,
        department,
        basicSalary
);

Payroll payroll = new Payroll();

// STEP 3C: Calculate salary
payroll.calculateSalary(employee.getBasicSalary());

// Fetch calculated values
double netSalary = payroll.getNetSalary();

// STEP 3D: Display salary breakdown
String salaryDetails =
        "Employee Name: " + employee.getName() + "\n" +
        "Designation: " + employee.getDesignation() + "\n" +
        "Department: " + employee.getDepartment() + "\n\n" +
        "Basic Salary: ₹" + employee.getBasicSalary() + "\n" +
        "HRA: ₹" + payroll.getHra() + "\n" +
        "DA: ₹" + payroll.getDa() + "\n" +
        "PF: ₹" + payroll.getPf() + "\n" +
        "Tax: ₹" + payroll.getTax() + "\n\n" +
        "Net Salary: ₹" + payroll.getNetSalary();

JOptionPane.showMessageDialog(this,
        salaryDetails,
        "Salary Breakdown",
        JOptionPane.INFORMATION_MESSAGE);



}
*/
private void handleGeneratePayroll() {

    String name = txtName.getText().trim();
    String designation = txtDesignation.getText().trim();
    String department = txtDepartment.getText().trim();
    String month = txtMonth.getText().trim();
    String salaryText = txtSalary.getText().trim();

    if (name.isEmpty() || designation.isEmpty() ||
        department.isEmpty() || month.isEmpty() || salaryText.isEmpty()) {

        JOptionPane.showMessageDialog(this,
                "All fields are mandatory!",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    double basicSalary;

    try {
        basicSalary = Double.parseDouble(salaryText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Basic Salary must be numeric",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Backend objects
    Employee employee = new Employee(
            name,
            designation,
            department,
            basicSalary
    );

    Payroll payroll = new Payroll();
    payroll.calculateSalary(basicSalary);

    // Database operations
    EmployeeDAO empDao = new EmployeeDAO();
    int empId = empDao.insertEmployee(employee);

    if (empId == -1) {
        JOptionPane.showMessageDialog(this,
                "Failed to save employee",
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        return;
    }

    PayrollDAO payDao = new PayrollDAO();
    payDao.insertPayroll(empId, payroll, month);
    PDFGenerator.generateSalarySlip(employee, payroll, month);

    JOptionPane.showMessageDialog(this,
            "Payroll generated and saved successfully!",
            "Success",
            JOptionPane.INFORMATION_MESSAGE);
}

}
