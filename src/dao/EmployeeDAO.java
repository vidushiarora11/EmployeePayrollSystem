package dao;

import model.Employee;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDAO {

    // Inserts employee and returns generated emp_id
    public int insertEmployee(Employee employee) {

        int generatedId = -1;

        String sql = "INSERT INTO employee (name, designation, department, basic_salary) VALUES (?, ?, ?, ?)";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDesignation());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getBasicSalary());

            ps.executeUpdate();

            // Get generated emp_id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedId;
    }
}
