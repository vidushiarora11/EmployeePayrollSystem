package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.DBConnection;

public class UserDAO {

    public boolean authenticate(User user) {

        String sql = "SELECT * FROM users WHERE userid = ? AND password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUserid());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            return rs.next();   // true if record exists

        } catch (Exception e) {
            System.out.println("Login Error: " + e);
            return false;
        }
    }
}
