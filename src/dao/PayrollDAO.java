package dao;

import model.Payroll;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PayrollDAO {

    public void insertPayroll(
            int empId,
            Payroll payroll,
            String month
    ) {

        String sql = "INSERT INTO payroll " +
                "(emp_id, hra, da, pf, tax, net_salary, month) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, empId);
            ps.setDouble(2, payroll.getHra());
            ps.setDouble(3, payroll.getDa());
            ps.setDouble(4, payroll.getPf());
            ps.setDouble(5, payroll.getTax());
            ps.setDouble(6, payroll.getNetSalary());
            ps.setString(7, month);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
