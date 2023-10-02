package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard() {
        setBounds(0, 0, 1500, 1000);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        setBounds(0, 0, 1550, 1000);
        add(Image);

        JLabel text = new JLabel("The Taj Group Welcomes You ");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.BOLD, 46));
        text.setForeground(Color.white);
        Image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        Image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.black);
        mb.add(hotel);

        JMenuItem Reception = new JMenuItem("RECEPTION");
        Reception.addActionListener(this);
        hotel.add(Reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.black);
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("ADD DRIVERS")) {
            new AddDriver();
        } else if (ae.getActionCommand().equals("RECEPTION")) {
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
