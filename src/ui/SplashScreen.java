package ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

public class SplashScreen extends JWindow {

    private JProgressBar progressBar;
    private Timer timer;

    public SplashScreen() {
        setSize(600, 350);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        JLabel title = new JLabel("Employee Payroll System");
        title.setBounds(120, 80, 400, 50);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        add(title);

        JLabel subtitle = new JLabel("Loading Application...");
        subtitle.setBounds(220, 130, 300, 30);
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        add(subtitle);

        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(100, 250, 400, 20);
        progressBar.setStringPainted(true);
        add(progressBar);

        startLoading();
    }

    private void startLoading() {
        timer = new Timer(30, e -> {
            int value = progressBar.getValue();
            if (value < 100) {
                progressBar.setValue(value + 1);
            } else {
                timer.stop();
                dispose();
                new LoginFrame().setVisible(true);
            }
        });
        timer.start();
    }
}
