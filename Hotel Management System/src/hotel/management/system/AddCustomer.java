package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfname, tfdeposit;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;

    AddCustomer() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel text = new JLabel("New Customer form");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        JLabel b1 = new JLabel("ID");
        b1.setBounds(35, 80, 100, 20);
        b1.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b1);

        String options[] = {"Aadhaar Card", "Passport", "Driving License", "Voter Id Card or EPIC", "Ration card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200, 80, 150, 25);
        comboid.setBackground(Color.cyan);
        add(comboid);


        JLabel b2 = new JLabel("Number");
        b2.setBounds(35, 120, 100, 20);
        b2.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b2);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);

        JLabel b3 = new JLabel("Name");
        b3.setBounds(35, 160, 100, 20);
        b3.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b3);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        JLabel b4 = new JLabel("Gender");
        b4.setBounds(35, 200, 100, 20);
        b4.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b4);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.white);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.white);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);

        // add boundaries for male and female selection
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);


        JLabel b5 = new JLabel("Country");
        b5.setBounds(35, 240, 100, 20);
        b5.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b5);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);

        JLabel b6 = new JLabel("Room Number");
        b6.setBounds(35, 280, 150, 20);
        b6.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b6);

        croom = new Choice();
        croom = new Choice();

        try {
            Conn conn = new Conn();
            String query = "select * from room where availability = 'available'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        croom.setBounds(200, 280, 150, 25);
        add(croom);

        JLabel b7 = new JLabel("Check In Time");
        b7.setBounds(35, 320, 150, 20);
        b7.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b7);

        Date date = new Date();

        checkintime = new JLabel("" + date);  // doublecollon is used as we need String
        checkintime.setBounds(200, 320, 150, 25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 10));
        add(checkintime);

        JLabel b8 = new JLabel("Deposit");
        b8.setBounds(35, 360, 150, 25);
        b8.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(b8);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(200, 410, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);


        setBounds(200, 40, 800, 550);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String Gender = null;

            if (rmale.isSelected()) {
                Gender = "Male";

            } else {
                Gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into customer values('" + id + "','" + number + "','" + name + "','" + Gender + "','" + country + "','" + room + "','" + time + "','" + deposit + "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '" + room + "'";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");

                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}