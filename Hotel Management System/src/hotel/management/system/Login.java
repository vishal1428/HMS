package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password; // speacial field for password
    JButton Login, Cancel;

    Login() {

        setBounds(500, 200, 620, 310);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel user = new JLabel("username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("username");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        Login = new JButton("Login");
        Login.setBounds(40, 150, 120, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(180, 150, 120, 30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        password.setBounds(150, 70, 150, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); // image class object cannot directly be placed in JLabel
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 150, 150);
        add(image);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Login) { // get source is using for determination weather the login or cancel is clicked
            String user = username.getText();
            String pass = password.getText();
            try {
                Conn c = new Conn();

                String query = "select * from login where username='" + user + "' and password='" + pass + "'";

                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else { // POP-UP FOR INVALID LOGIN
                    JOptionPane.showMessageDialog(null, "Invalid login, 3 Attempt Left!");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] arg) {

        new Login();
    }
}
