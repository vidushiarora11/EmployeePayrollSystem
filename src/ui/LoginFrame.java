package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UserDAO;
import model.User;

public class LoginFrame extends JFrame {

    private JTextField userid;
    private JPasswordField password;

    public LoginFrame() {

        setTitle("Admin Login");
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLbl = new JLabel("User ID:");
        userLbl.setBounds(50, 50, 100, 30);
        add(userLbl);

        userid = new JTextField();
        userid.setBounds(150, 50, 180, 30);
        add(userid);

        JLabel passLbl = new JLabel("Password:");
        passLbl.setBounds(50, 110, 100, 30);
        add(passLbl);

        password = new JPasswordField();
        password.setBounds(150, 110, 180, 30);
        add(password);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(140, 180, 100, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> doLogin());
    }

    private void doLogin() {

        String uid = userid.getText();
        char[] pwd = password.getPassword();

        User user = new User();
        user.setUserid(uid);
        user.setPassword(new String(pwd));

        UserDAO dao = new UserDAO();

        boolean success = dao.authenticate(user);

        if (success) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            dispose();
            new PayrollFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }
}
