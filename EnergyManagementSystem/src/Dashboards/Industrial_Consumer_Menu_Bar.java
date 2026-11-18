/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dashboards;
import LoginPages.About_Industrial_Consumer;
import LoginPages.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author aryankeshri
 */
public class Industrial_Consumer_Menu_Bar implements ActionListener {
    JMenuBar MenuBar;
    JMenu User;
    JMenu Credits;
    JMenu Trade;
    JMenu Complaints;
    
    JMenuItem Logout;
    JMenuItem UserInfo;
    JMenuItem Buy_Credits;
    JMenuItem Current_Credit;
    JPopupMenu.Separator CreditsMenuSep;
    JMenuItem Consumption_Projection;
    JMenuItem Credits_Consumed;
//    JMenu Consumption;
    JMenuItem Current_Consumption;
//    JMenuItem Add_Appliance;
//    JMenuItem View_Power_Rating;
    JMenuItem Trade_Permits;
    JMenuItem New_Complaints;
    JMenuItem View_Complaints;
    
    String user;
    String pass;
    JFrame frame;
    
    
    public JMenuBar Industrial_Consumer_MenuBar(){
        
        
        MenuBar = new JMenuBar();
        User = new JMenu(); User.setText("User");
        Credits = new JMenu(); Credits.setText("Credits");
        Trade = new JMenu(); Trade.setText("Trade");
        Complaints = new JMenu(); Complaints.setText("Complaints");
       
        MenuBar.add(User);
        MenuBar.add(Credits);
        MenuBar.add(Trade);
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
//        CreditsMenuSep = new JPopupMenu.Separator();
//        Consumption_Projection = new JMenuItem("Consumption Projection");
//        Credits_Consumed = new JMenuItem("Credits Consumed");
        
        Credits.add(Buy_Credits); 
        Credits.add(Current_Credit);
//        Credits.add(CreditsMenuSep);
//        Credits.add(Consumption_Projection);
//        Credits.add(Credits_Consumed);
        
        Buy_Credits.addActionListener(this);
        Current_Credit.addActionListener(this);
//        Consumption_Projection.addActionListener(this);
//        Credits_Consumed.addActionListener(this);
        
        
        // Appliance Menu
//        Consumption = new JMenu("Consumption");
//        Current_Consumption = new JMenuItem("Current Consumption");
//        Add_Appliance = new JMenuItem("Add Appliance");
//        View_Power_Rating = new JMenuItem("View Power Rating");
        Trade_Permits = new JMenuItem("Trade Permits");
        Trade.add(Trade_Permits);
        Trade_Permits.addActionListener(this);
//        Trade.add(Consumption);
//        Trade.add(View_Power_Rating);
//        Consumption.add(Current_Consumption);
//        Consumption.add(Add_Appliance);
        
//        View_Power_Rating.addActionListener(this);
//        Add_Appliance.addActionListener(this);
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
    
    public JMenuBar Industrial_Consumer_MenuBar(String Username, String Password, JFrame frame){
        
        this.user = Username;
        this.pass = Password;
        this.frame = frame;
        
        MenuBar = new JMenuBar();
        User = new JMenu(); User.setText("User");
        Credits = new JMenu(); Credits.setText("Credits");
        Trade = new JMenu(); Trade.setText("Trade");
        Complaints = new JMenu(); Complaints.setText("Complaints");
       
        MenuBar.add(User);
        MenuBar.add(Credits);
        MenuBar.add(Trade);
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
        Consumption_Projection = new JMenuItem("Consumption Projection");
        Credits_Consumed = new JMenuItem("Credits Consumed");
        
        Credits.add(Buy_Credits); 
        Credits.add(Current_Credit);
//        Credits.add(CreditsMenuSep);
//        Credits.add(Consumption_Projection);
//        Credits.add(Credits_Consumed);
        
        Buy_Credits.addActionListener(this);
        Current_Credit.addActionListener(this);
//        Consumption_Projection.addActionListener(this);
//        Credits_Consumed.addActionListener(this);
        
        
        // Appliance Menu
//        Consumption = new JMenu("Consumption");
//        Current_Consumption = new JMenuItem("Current Consumption");
//        Add_Appliance = new JMenuItem("Add Appliance");
//        View_Power_Rating = new JMenuItem("View Power Rating");
         Trade_Permits = new JMenuItem("Trade Permits");
          Trade.add(Trade_Permits);
          Trade_Permits.addActionListener(this);
//        Trade.add(Consumption);
//        Trade.add(View_Power_Rating);
//        Consumption.add(Current_Consumption);
//        Consumption.add(Add_Appliance);
        
//        View_Power_Rating.addActionListener(this);
//        Add_Appliance.addActionListener(this);
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
//            Component src = (Component) e.getSource();
//            Window window = SwingUtilities.windowForComponent(src);
//            if(window instanceof JFrame){
//                JFrame currentFrame = (JFrame) window;
//                
//                currentFrame.dispose();
//            }
            frame.dispose();
            new Login_Startup().setVisible(true);
        }
        
        if(e.getSource() == UserInfo){
            frame.dispose();
            new About_Industrial_Consumer(user,pass).setVisible(true);
        }
        
        if(e.getSource() == Buy_Credits){
            new Industrial_Consumer_Buy_Credits(user ,pass).setVisible(true);
        }
        
        if(e.getSource() == Current_Credit){
            new Industrial_Consumer_Current_Credit(user,pass).setVisible(true);
        }

//        
//        if(e.getSource() == Consumption_Projection){
////            new Consumption_Projection().setVisible(true);
//        }
//        
//        if(e.getSource() == Credits_Consumed){
//            new CurrentConsumption().setVisible(true);
//        }
        
//        if(e.getSource() == Add_Appliance){
//            new AddAppliance().setVisible(true);
//        }
        
//        if(e.getSource() == View_Power_Rating){
//            new PowerRating().setVisible(true);
//        }
// >>>>>>> master
    
        if(e.getSource() == Trade_Permits){
            new Trade(user,pass).setVisible(true);
        }
//        if(e.getSource() == Current_Consumption){
//            new CurrentConsumption().setVisible(true);
//        }
        
        if(e.getSource() == New_Complaints){
            new Industrial_New_Complaint(user, pass).setVisible(true);
        }
        
        if(e.getSource() == View_Complaints){
            new IndustrialViewComplains(user, pass).setVisible(true);
        }
        
    }
    
}   
