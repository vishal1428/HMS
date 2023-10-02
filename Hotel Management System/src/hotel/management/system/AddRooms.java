package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox typecombo, availablecombo, cleancombo;

    AddRooms() {

        getContentPane().setBackground(Color.getHSBColor(35, 85, 68));
        setLayout(null);
        setBounds(160, 90, 900, 550);
        setVisible(true);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(60, 80, 140, 30);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);

        String availableoptions[] = {"available", "occupied"};
        availablecombo = new JComboBox(availableoptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        String cleanoptions[] = {"Clean", "Dirty"};
        cleancombo = new JComboBox(cleanoptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);

        String typeoptions[] = {"Single Bed", "Double Bed"};
        typecombo = new JComboBox(typeoptions);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.white);
        add(typecombo);

        add = new JButton("Add Rooms");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400, 30, 500, 300);
        add(l15);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

            try {
                Conn c = new Conn();
                String str = "INSERT INTO room values( '" + roomnumber + "', '" + availability + "', '" + status + "','" + price + "', '" + type + "')";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Successfully Added");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
