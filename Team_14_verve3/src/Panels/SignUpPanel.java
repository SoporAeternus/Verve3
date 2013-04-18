package Panels;

import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import Accounts.*;
import Database.Database;
import team_14_verve3.UserNameValidation;

public class SignUpPanel extends JPanel implements ActionListener, KeyListener {

    public static JFrame application;
    public static String[] args;
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField addressField;
    private JButton create;
    private JButton cancel;

    public SignUpPanel() {
        welcomeLabel = new JLabel("Creating new account:");
        usernameLabel = new JLabel("New username:");
        passwordLabel = new JLabel("New password:");
        nameLabel = new JLabel("       Your name:");
        addressLabel = new JLabel("  Your address:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        create = new JButton("Create account");
        cancel = new JButton("Cancel");

        create.addActionListener(this);
        cancel.addActionListener(this);
        passwordField.addKeyListener(this);
        usernameField.addKeyListener(this);
        nameField.addKeyListener(this);
        addressField.addKeyListener(this);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        panel1.add(welcomeLabel);
        panel2.add(usernameLabel);
        panel2.add(usernameField);
        panel3.add(passwordLabel);
        panel3.add(passwordField);
        panel4.add(nameLabel);
        panel4.add(nameField);
        panel5.add(addressLabel);
        panel5.add(addressField);
        panel6.add(create);
        panel6.add(cancel);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);
    }

    public static void main(String[] args) {
        application = new JFrame();
        SignUpPanel signUpPanel = new SignUpPanel();
        application.setTitle("Creating new account");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(450, 480);
        application.setResizable(false);
        application.add(signUpPanel);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            application.setVisible(false);
            StartPanel.main(args);
        }
        if (e.getSource() == create) {
            System.out.println("create pressed");

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String name = nameField.getText();
            String address = addressField.getText();

            UserNameValidation newUsername = new UserNameValidation(username);
            if (!newUsername.isValid()) {
                JOptionPane.showMessageDialog(null, "Your username is incorrect!");
                return;
            }
            
            if ((username.equals("")) || (password.equals("")) || (name.equals(""))
                    || (address.equals(""))){
                JOptionPane.showMessageDialog(null, "Please Complete All Fields");
                return;
            }
            for (Account user:Database.AccountList)
            {
                if (user.getUserName().equals(username)) 
                {
                    JOptionPane.showMessageDialog(null, "Such username already exists!");
                    return;
                }
            }

            Client newClient = new Client();
            newClient.setName(name);
            newClient.setPassword(password);
            newClient.setUserName(newUsername.getUserName());
            newClient.setAddress(address);
            Database.AccountList.add(newClient);
            JOptionPane.showMessageDialog(null, "Congratulations, You can now Log In");
            application.setVisible(false);
            StartPanel.main(args);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) // corresponds to Enter button
        {
            create.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
