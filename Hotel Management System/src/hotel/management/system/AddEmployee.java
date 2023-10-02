package hotel.management.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame {  //Third Frame
// global declaration

    JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
    JComboBox cbjob;
    JRadioButton Female, NewRadioButton;
    JButton submit;

    public AddEmployee() {
        getContentPane().setForeground(Color.getHSBColor(35, 85, 68));
        setBounds(350, 200, 850, 540);
        setVisible(true);

        getContentPane().setBackground(Color.getHSBColor(35, 85, 68));
        setTitle("ADD EMPLOYEE DETAILS");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        // Delracing Name
        JLabel Passportno = new JLabel("NAME");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(60, 30, 150, 27);
        add(Passportno);

        // making text field
        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        submit = new JButton("SUBMIT");
        submit.setBounds(200, 420, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        // submit.addActionListener(this);
        add(submit);

        // Age decleration
        JLabel Pnrno = new JLabel("AGE");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Pnrno.setBounds(60, 80, 150, 27);
        add(Pnrno);
        // age text field
        textField_1 = new JTextField();
        textField_1.setBounds(200, 80, 150, 27);
        add(textField_1);

        // defining gender
        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Gender.setBounds(60, 120, 150, 27);
        add(Gender);

        // RadioButton for Male and Female
        NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        NewRadioButton.setBounds(200, 120, 70, 27);
        add(NewRadioButton);

        Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Female.setBounds(280, 120, 70, 27);
        add(Female);

        // grouping two button
        ButtonGroup bg = new ButtonGroup();
        bg.add(NewRadioButton);
        bg.add(Female);


        JLabel Address = new JLabel("JOB");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        String course[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        // passing course as array of strings im JCombo Box
        cbjob = new JComboBox(course);
        cbjob.setBackground(Color.WHITE);
        cbjob.setBounds(200, 170, 150, 30);
        add(cbjob);

        JLabel Nationality = new JLabel("SALARY");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 220, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel Name = new JLabel("PHONE");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 270, 150, 27);
        add(Name);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        JLabel Phno = new JLabel("AADHAAR");
        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Phno.setBounds(60, 320, 150, 27);
        add(Phno);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 320, 150, 27);
        add(textField_5);


        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.black);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        // to scale the image
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        // setBounds is for croping the image
        image.setBounds(410, 80, 480, 410);
        add(image);


        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = textField.getText();
                String age = textField_1.getText();
                String salary = textField_3.getText();
                String phone = textField_4.getText();
                String aadhaar = textField_5.getText();
                String email = textField_6.getText();

                String gender = null;
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name should not be empty");
                    return;
                }
                if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email is Invalid");
                    return;
                }

                if (NewRadioButton.isSelected()) {
                    gender = "male";

                } else if (Female.isSelected()) {
                    gender = "female";
                }


                String job = (String) cbjob.getSelectedItem();

                try {
                    // connecting Database
                    Conn c = new Conn();
                    String query = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + job + "', '" + salary + "', '" + phone + "','" + aadhaar + "','" + email + "')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900, 600);
        setVisible(true);
        setLocation(330, 100);

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}

