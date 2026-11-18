/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dashboards;
import LoginPages.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author aryankeshri
 */
public class Household_Consumer_Menu_Bar implements ActionListener {
    JMenuBar MenuBar;
    JMenu User;
    JMenu Credits;
    JMenu Appliances;
    JMenu Complaints;
    
    JMenuItem Logout;
    JMenuItem UserInfo;
    JMenuItem Buy_Credits;
    JMenuItem Current_Credit;
    JPopupMenu.Separator CreditsMenuSep;
    JMenuItem Consumption_Projections;
    JMenuItem Credits_Consumed;
    JMenu Consumption;
    JMenuItem Current_Consumption;
    JMenuItem Add_Appliance;
    JMenuItem View_Power_Rating;
    JMenuItem New_Complaints;
    JMenuItem View_Complaints;
    
    String user;
    String pass;
    JFrame frame;
    
    
    
    public JMenuBar Consumer_MenuBar(){
        
        
        MenuBar = new JMenuBar();
        User = new JMenu(); User.setText("User");
        Credits = new JMenu(); Credits.setText("Credits");
        Appliances = new JMenu(); Appliances.setText("Appliances");
        Complaints = new JMenu(); Complaints.setText("Complaints");
       
        MenuBar.add(User);
        MenuBar.add(Credits);
        MenuBar.add(Appliances);
        MenuBar.add(Complaints);
       
        
        // User Menu Items
        UserInfo = new JMenuItem(); UserInfo.setText("User Info");
        Logout = new JMenuItem(); Logout.setText("Log Out");
        User.add(UserInfo);
        User.add(Logout);
        Logout.addActionListener(this);
        UserInfo.addActionListener(this);
        
        
        // Credits Menu Items
        Buy_Credits = new JMenuItem("Buy Credits");
        Current_Credit = new JMenuItem("Current Credit");
        CreditsMenuSep = new JPopupMenu.Separator();
        Consumption_Projections = new JMenuItem("Consumption Projection");
        Credits_Consumed = new JMenuItem("Credits Consumed");
        
        Credits.add(Buy_Credits); 
        Credits.add(Current_Credit);
        Credits.add(CreditsMenuSep);
        Credits.add(Consumption_Projections);
        Credits.add(Credits_Consumed);
        
        Buy_Credits.addActionListener(this);
        Current_Credit.addActionListener(this);
        Consumption_Projections.addActionListener(this);
        Credits_Consumed.addActionListener(this);
        
        
        // Appliance Menu
        Consumption = new JMenu("Consumption");
//        Current_Consumption = new JMenuItem("Current Consumption");
        Add_Appliance = new JMenuItem("Add Appliance");
        View_Power_Rating = new JMenuItem("View Power Rating");
        
        Appliances.add(Consumption);
        Appliances.add(View_Power_Rating);
//        Consumption.add(Current_Consumption);
        Consumption.add(Add_Appliance);
        
        View_Power_Rating.addActionListener(this);
        Add_Appliance.addActionListener(this);
//        Current_Consumption.addActionListener(this);
        
        
        
        // Complaint Menu
        New_Complaints = new JMenuItem("New Complaint");
        View_Complaints = new JMenuItem("View Complaints");
        Complaints.add(New_Complaints);
        Complaints.add(View_Complaints);
        
        New_Complaints.addActionListener(this);
        View_Complaints.addActionListener(this);

        return MenuBar;
    
    }
    
    public JMenuBar Consumer_MenuBar(String Username, String Password, JFrame frame){
        
        this.user = Username;
        this.pass = Password;
        this.frame = frame;
        
        MenuBar = new JMenuBar();
        User = new JMenu(); User.setText("User");
        Credits = new JMenu(); Credits.setText("Credits");
        Appliances = new JMenu(); Appliances.setText("Appliances");
        Complaints = new JMenu(); Complaints.setText("Complaints");
       
        MenuBar.add(User);
        MenuBar.add(Credits);
        MenuBar.add(Appliances);
        MenuBar.add(Complaints);
       
        
        
        // User Menu Items
        UserInfo = new JMenuItem(); UserInfo.setText("User Info");
        Logout = new JMenuItem(); Logout.setText("Log Out");
        User.add(UserInfo);
        User.add(Logout);
        Logout.addActionListener(this);
        UserInfo.addActionListener(this);
        
        
        // Credits Menu Items
        Buy_Credits = new JMenuItem("Buy Credits");
        Current_Credit = new JMenuItem("Current Credit");
        CreditsMenuSep = new JPopupMenu.Separator();
        Consumption_Projections = new JMenuItem("Consumption Projection");
        Credits_Consumed = new JMenuItem("Credits Consumed");
        
        Credits.add(Buy_Credits); 
        Credits.add(Current_Credit);
        Credits.add(CreditsMenuSep);
        Credits.add(Consumption_Projections);
        Credits.add(Credits_Consumed);
        
        Buy_Credits.addActionListener(this);
        Current_Credit.addActionListener(this);
        Consumption_Projections.addActionListener(this);
        Credits_Consumed.addActionListener(this);
        
        
        // Appliance Menu
        Consumption = new JMenu("Consumption");
//        Current_Consumption = new JMenuItem("Current Consumption");
        Add_Appliance = new JMenuItem("Add Appliance");
        View_Power_Rating = new JMenuItem("View Power Rating");
        
        Appliances.add(Consumption);
        Appliances.add(View_Power_Rating);
//        Consumption.add(Current_Consumption);
        Consumption.add(Add_Appliance);
        
        View_Power_Rating.addActionListener(this);
        Add_Appliance.addActionListener(this);
//        Current_Consumption.addActionListener(this);
        
        
        
        // Complaint Menu
        New_Complaints = new JMenuItem("New Complain");
        View_Complaints = new JMenuItem("View Complaints");
        Complaints.add(New_Complaints);
        Complaints.add(View_Complaints);
        
        New_Complaints.addActionListener(this);
        View_Complaints.addActionListener(this);

        return MenuBar;
    
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Logout){
            frame.dispose();
            new Login_Startup().setVisible(true);
        }
        
        if(e.getSource() == UserInfo){
            frame.dispose();
            new About_Household_Consumer(user, pass).setVisible(true);
        }
        
        if(e.getSource() == Buy_Credits){
            new Household_Consumer_Buy_Creds(user, pass).setVisible(true);
        }
        
        if(e.getSource() == Current_Credit){
            new Household_Consumer_Current_Credit(user, pass).setVisible(true);
        }
        
        if(e.getSource() == Consumption_Projections){
            new Consumption_Projections(user,pass).setVisible(true);
        }
//        if(e.getSource()==Consumption_Projections){
//            new Consumption_
//        }
        if(e.getSource() == Credits_Consumed){
            new Household_Consumption_History(user, pass).setVisible(true);
        }
        
        if(e.getSource() == Add_Appliance){
            new AddAppliance(user, pass).setVisible(true);
        }
        
        if(e.getSource() == View_Power_Rating){
            new PowerRating().setVisible(true);
        }
    
//        if(e.getSource() == Current_Consumption){
//            new CurrentConsumption().setVisible(true);
//        }
        
        if(e.getSource() == New_Complaints){
            new Household_New_Complaint(user, pass).setVisible(true);
        }
        
        if(e.getSource() == View_Complaints){
            new HouseholdViewComplains(user, pass).setVisible(true);
        }
        
    }
    
}   
