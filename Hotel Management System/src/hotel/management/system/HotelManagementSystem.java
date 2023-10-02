package hotel.management.system;

import java.awt.*;
import javax.swing.*; // importing java swing from java extented package
import java.awt.event.*; // to trigger event
import java.util.EventListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
  /* for making the frame which comes from Jframe class
    which comes from swing package & swing package comes from java extented package */

    HotelManagementSystem() {    // constructor called
        // setting up Frame Size :-
        setSize(1400, 700);          // setContentPane(300,300,1366,390);   frame size
        setLayout(null);
        setLocation(100, 100);
        setVisible(true); // by default visibilty is false

        // placing image icon from icon folder
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        // placing icon on frame
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1400, 700);
        add(image); // adding image component of Jlabel component placing on frame

        JLabel text = new JLabel("HOTEL MANAGMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.black);
        text.setFont(new Font("serif", Font.BOLD, 30));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.blue);
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);

        // dipper funcanility in text
        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception c) {
                c.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception c) {
                c.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        // overriding
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {

        new HotelManagementSystem(); // class object to run the class
    }

}

