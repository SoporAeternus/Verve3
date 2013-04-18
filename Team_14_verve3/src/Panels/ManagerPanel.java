package Panels;

import Database.Database;
import Products.*;
import Accounts.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import team_14_verve3.*;

public class ManagerPanel extends JPanel implements ActionListener, ItemListener{

    public static JFrame application;
    public static String[] args;
    private JLabel welcomeLabel;
    private static Account currentManager;
    private JPanel output = new JPanel(new BorderLayout());
            
    private JButton home = new JButton("Home");
    private JButton addContent = new JButton("Add Content");
    private JButton report = new JButton("Report");
    private JButton customerInfo = new JButton("Customer Info");
    private JButton logout = new JButton("Logout");

    private JPanel homePanel = new JPanel();
    private JPanel addContentPanel = new JPanel(new GridLayout(10,1));
    private JPanel reportPanel = new JPanel();
    private JPanel customerInfoPanel = new JPanel();
    
    //addContentPanel components
    private JComboBox itemType = new JComboBox(new String[]{"", "Book", "DVD", "Music"});
    private String chosenType = "";
    private JTextField productID = new JTextField(8);
    private JTextField title = new JTextField(20);
    private JTextField author = new JTextField(20);
    private JTextField producer = new JTextField(20);
    private JTextField artist = new JTextField(20);
    private JTextField price = new JTextField(5);
    private JButton addItem = new JButton("Add Item");
    
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
    public ManagerPanel(Account user) {
        welcomeLabel = new JLabel("Welcome "
                +user.getName() + "!");
        add(welcomeLabel);
        
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill  = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        
        // this is buttons array, used only for testing laying out
        JButton[] panel = new JButton[100];
        for (int i = 0; i < 100; i++)
        {
            panel[i] = new JButton("button" + i);
            
        }
        
        // empty panels to create nice layout
        JPanel[] panels = new JPanel[100];
        for (int i = 0; i < 100; i++)
        {
            panels[i] = new JPanel();
            // panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
        }
        
        panels[4].setAlignmentY(100);
        panels[4].add(welcomeLabel);
        
        
        // first line with label
        for (int i = 0; i < 8; i++)
        {
            constraints.gridx = i;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panels[i], constraints);
            add(panels[i]);
        
        }
        
        
        // second line
        for (int i = 0; i < 8; i++)
        {
            constraints.gridx = i;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panels[8+i], constraints);
            add(panels[8+i]);
        
        }
        
        output.setBorder(BorderFactory.createLineBorder(Color.black));
        output.setBackground(Color.LIGHT_GRAY);
        
        // pink panel
        output.setToolTipText("output");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 8;
        constraints.gridheight = 23;
        layout.setConstraints(output, constraints);
        add(output);
        
        remove(panels[2]);
        remove(panels[3]);
        remove(panels[4]);  // *need to modify panels4
        remove(panels[5]);
        remove(panels[6]);
        
        
        // the panel with label
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        layout.setConstraints(panels[4], constraints);
        panels[4].setBorder(null);
        add(panels[4]);
        
        constraints.fill = GridBagConstraints.BOTH;
        
        
        for (int i = 1; i < 15; i++)
        {
            constraints.gridx = 0;
            constraints.gridy = i;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panel[10+i], constraints);
            add(panel[10+i]);
        }
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 13;
        layout.setConstraints(panel[10], constraints);
        add(panel[10]);
        
            
        home.addActionListener(this);
        addContent.addActionListener(this);
        customerInfo.addActionListener(this);
        report.addActionListener(this);
        logout.addActionListener(this);
        
        constraints.gridx = 10;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(home, constraints);
        add(home);
        
        constraints.gridx = 10;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(addContent, constraints);
        add(addContent);
                
        constraints.gridx = 10;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(report, constraints);
        add(report);
        
        constraints.gridx = 10;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(customerInfo, constraints);
        add(customerInfo);
        
        constraints.gridx = 10;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        layout.setConstraints(logout, constraints);
        add(logout);
        
        // east line below five buttons
        for (int i = 0; i < 20; i++)
        {
            constraints.gridx = 10;
            constraints.gridy = 5+i;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            layout.setConstraints(panels[16+i], constraints);
            add(panels[16+i]);
        
        }
        
        
        
        homePanel.add(new JLabel("Home Page"));
        reportPanel.add(new JLabel("Report"));
        customerInfoPanel.add(new JLabel("Customer Info"));

        
        output.add(homePanel);
        
        //addContent panel description
        itemType.addItemListener(this);
        
        JPanel ac_1 = new JPanel();
        ac_1.add(new JLabel("Fill out the info to add content"));
        JPanel ac_2 = new JPanel();
        JPanel ac_3 = new JPanel();
        
        JPanel productIDPanel = new JPanel();
        productID.setText(Item.generateID());
        productIDPanel.add(new JLabel("ProductID:"));
        productIDPanel.add(productID);
        productID.setEditable(false);
        
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("          Title:"));
        titlePanel.add(title);
        
        JPanel authorPanel = new JPanel();
        authorPanel.add(new JLabel("      Author:"));
        authorPanel.add(author);
        
        JPanel producerPanel = new JPanel();
        producerPanel.add(new JLabel(" Producer:"));
        producerPanel.add(producer);
        
        JPanel artistPanel = new JPanel();
        artistPanel.add(new JLabel("       Artist:"));
        artistPanel.add(artist);
        
        JPanel pricePanel = new JPanel();
        pricePanel.add(new JLabel("   Price:"));
        pricePanel.add(price);
        
        ac_2.add(new JLabel("Choose item type:"));
        ac_2.add(itemType);
        
        ac_3.add(addItem);
        addItem.addActionListener(this);
        
        addContentPanel.add(ac_1);
        addContentPanel.add(ac_2);
        addContentPanel.add(productIDPanel);
        addContentPanel.add(titlePanel);
        addContentPanel.add(authorPanel);
        addContentPanel.add(producerPanel);
        addContentPanel.add(artistPanel);
        addContentPanel.add(pricePanel);
        addContentPanel.add(ac_3);
             
        
    }

    public class InfoPanel extends JPanel
    {  
        private JTable table;
        private Object[][] data;
        private String[] columnNames;
        
        public InfoPanel()
        {
            JPanel header = new JPanel();       
            header.add(new JLabel("Users:"));
            add(header, BorderLayout.NORTH);
            String[] columnNames = {"Account Type","Username","Password","Name","Address","Balance"};
            int N = Database.AccountList.size();
            Object[][] data = new Object[N][6];
            for(int i = 0;i<N;i++)
            {
                Account user = Database.AccountList.get(i);
                data[i][0] = user.getAccountType();
                data[i][1] = user.getUserName();
                data[i][2] = user.getPassword();
                data[i][3] = user.getName();
                data[i][4] = user.getAddress();
                if(user.getAccountType().equals("C"))
                {
                    Client c = (Client) user;
                    data[i][5] = c.getBalance();
                }
                else
                {
                    data[i][5] = "N/A";
                }    
            }
                table = new JTable(data, columnNames); 
                table.getTableHeader().setReorderingAllowed(false);
                JScrollPane scrollPane = new JScrollPane(table);   
                this.add(scrollPane);
        }
    }
    
    public class OrderPanel extends JPanel
    {  
        private JTable table;
        private Object[][] data;
        private String[] columnNames;
        
        public OrderPanel()
        {
            JPanel header = new JPanel();       
            header.add(new JLabel("Users:"));
            add(header, BorderLayout.NORTH);
            String[] columnNames = {"Client Name","Item ID","Quantity"};
            int N = Database.Orders.size();
            Object[][] data = new Object[N][3];
            for(int i = 0;i<N;i++)
            {
                Order o = Database.Orders.get(i);
                data[i][0] = o.getName();
                data[i][1] = o.getPID();
                data[i][2] = o.getQuantity();  
            }
                table = new JTable(data, columnNames); 
                table.getTableHeader().setReorderingAllowed(false);
                JScrollPane scrollPane = new JScrollPane(table);   
                this.add(scrollPane);
        }
    }
    
    public static void main(String[] args,Account user) {
        application = new JFrame();
        currentManager = user;
        ManagerPanel managerPanel = new ManagerPanel(user);
        application.setTitle("verve3 Manager Panel");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(800, 600);
        application.setResizable(false);
        application.setLocationRelativeTo(null);
        application.add(managerPanel);
        application.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == home)
        {
            output.removeAll();
            output.add(homePanel);
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == addContent)
        {
            productID.setText(Item.generateID());
            output.removeAll();
            output.add(addContentPanel);
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == report)
        {
            output.removeAll();
            output.add(new OrderPanel());
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == customerInfo)
        {
            output.removeAll();
            output.add(new InfoPanel());
            output.revalidate();
            output.repaint();
        }
        
        if (e.getSource() == logout)
        {
            application.setVisible(false);
            StartPanel.main(args);
        }
        
        if (e.getSource() == addItem)
        {
               
            if (chosenType.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please, choose item type!");
                return;
            }
            
            try // need to check the price field, to avoid error
            {
                Double.parseDouble(price.getText());
            }
            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null, "Price field is invalid, check it");
                return;
            }
             
            if (chosenType.equals("Book"))
            {
                Book newBook = new Book();
                newBook.setTitle(title.getText());
                newBook.setAuthor(author.getText());
                newBook.setPrice(Double.parseDouble(price.getText()));
                if(Database.addBook(newBook))
                {
                    JOptionPane.showMessageDialog(null, "You succesfully added a new Book!");
                    productID.setText(Item.generateID());
                    title.setText("");
                    producer.setText("");
                    artist.setText("");
                    author.setText("");
                    price.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Item Exists");
                }
            }
            
            if (chosenType.equals("DVD"))
            {        
                DVD newDVD= new DVD();
                newDVD.setTitle(title.getText());
                newDVD.setProducer(producer.getText());
                newDVD.setPrice(Double.parseDouble(price.getText()));

                if( Database.addDVD(newDVD))
                {
                    JOptionPane.showMessageDialog(null, "You succesfully added a new DVD!");
                    productID.setText(Item.generateID());
                    title.setText("");
                    producer.setText("");
                    artist.setText("");
                    author.setText("");
                    price.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Item Exists");
                }
                
            }
            
            if (chosenType.equals("Music"))
            {
 
                Music newMusic = new Music();
                newMusic.setTitle(title.getText());
                newMusic.setArtist(artist.getText());
                newMusic.setPrice(Double.parseDouble(price.getText()));
                if(Database.addMusic(newMusic))
                {
                    JOptionPane.showMessageDialog(null, "You succesfully added a new Music!");
                    productID.setText(Item.generateID());
                    title.setText("");
                    producer.setText("");
                    artist.setText("");
                    author.setText("");
                    price.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Item Exists");
                }
            }
        }
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        chosenType = itemType.getSelectedItem().toString();
        
        if (chosenType.equals("Book"))
        {
            producer.setEditable(false);
            producer.setFocusable(false);
            artist.setEditable(false);
            artist.setFocusable(false);
            author.setEditable(true);   // only this can be applied to book
            author.setFocusable(true);
        }
        
        if (chosenType.equals("DVD"))
        {
            producer.setEditable(true); // only this can be applied to DVD
            producer.setFocusable(true);
            artist.setEditable(false);
            artist.setFocusable(false);
            author.setEditable(false);  
            author.setFocusable(false);
        }
        
        if (chosenType.equals("Music"))
        {
            producer.setEditable(false);
            producer.setFocusable(false);
            artist.setEditable(true);   // only this can be applied to music
            artist.setFocusable(true);
            author.setEditable(false);   
            author.setFocusable(false);
        }
    }
}
