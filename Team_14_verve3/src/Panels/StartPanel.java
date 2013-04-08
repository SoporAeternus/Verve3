package Panels;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import team_14_verve3.*;

public class StartPanel extends JPanel implements ActionListener, KeyListener {

    public static String[] args;
    public static JFrame application;
    private JLabel welcomeLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton login;
    private JButton signUp;

    public StartPanel() {

        welcomeLabel = new JLabel("Welcome to verve3!");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        login = new JButton("Login");
        signUp = new JButton("Sign Up");

        login.addActionListener(this);
        signUp.addActionListener(this);
        passwordField.addKeyListener(this);
        usernameField.addKeyListener(this);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.add(welcomeLabel);
        panel2.add(usernameLabel);
        panel2.add(usernameField);
        panel3.add(passwordLabel);
        panel3.add(passwordField);
        panel4.add(login);
        panel4.add(signUp);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

    }

    public static void main(String[] args) {
        application = new JFrame();
        StartPanel startPanel = new StartPanel();
        application.setTitle("verve3 MediaStore");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(350, 200);
        application.setResizable(false);
        application.add(startPanel);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean found = false;
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        try {
            if (e.getSource() == login) {
                System.out.println("Login pressed");
                for (int i = 0; i < 3; i++) {
                    if (ItemList.managerList[i].getUserName().equals(username)) {
                        if (ItemList.managerList[i].getPassword().equals(password)) {
                            found = true;
                            ItemList.chosenClientIndex = i;
                            application.setVisible(false);
                            ManagerPanel.main(args);
                            break;
                        }
                    }
                }
                for (int i = 0; i < ItemList.clientSize; i++) {
                    if (ItemList.clientList[i].getUserName().equals(username)) {
                        if (ItemList.clientList[i].getPassword().equals(password)) {
                            found = true;
                            ItemList.chosenClientIndex = i;
                            application.setVisible(false);
                            ClientPanel.main(args);
                            System.out.println("Password is correct");
                        }
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Wrong username and password!");
                }
            }
        } catch (NullPointerException npe) {
            if(username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null, "Please Complete All Fields");
            }        
        }
        if (e.getSource() == signUp) {
            System.out.println("signUp pressed");
            application.setVisible(false);
            SignUpPanel.main(args);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10){ // corresponds to Enter button     
            login.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
