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
public class SupplierMenuBar implements ActionListener {
    
    String user;
    String pass;
    JFrame frame;
    JMenuBar supplierMenu;
    JMenu User;
    JMenu Complain;
    
    JMenuItem About;
    JMenuItem Logout;
    JMenuItem View;
//    JMenuItem Resolve_Complain;
    
    public JMenuBar supplierMenuBar(String Username, String Password, JFrame frame){
        this.user = Username;
        this.pass = Password;
        this.frame = frame;
        supplierMenu = new JMenuBar();
        User = new JMenu("User");
        Complain = new JMenu("Complain");

        
        supplierMenu.add(User);
        supplierMenu.add(Complain);
        
        About = new JMenuItem("About");
        Logout = new JMenuItem("Logout");
        View =new JMenuItem("View or Resolve");
//        Resolve_Complain = new JMenuItem("Resolve Complain");
        
        User.add(About);
        User.add(Logout);
        Complain.add(View);
//        Complain.add(Resolve_Complain);
        
        About.addActionListener(this);
        Logout.addActionListener(this);
        View.addActionListener(this);
//        Resolve_Complain.addActionListener(this);
        
        return supplierMenu;
       
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Logout){
            this.frame.dispose();
            new Login_Startup().setVisible(true);
        }
        
        if(e.getSource() == About){
            frame.dispose();
            new About_Supplier(user, pass).setVisible(true);
        }
        
   
        
        if(e.getSource() == View){
            new SupplierViewComplains(user,pass).setVisible(true);
        }
        
//        if(e.getSource() == Resolve_Complain){
////            new ViewComplains().setVisible(true);
//        }
        
    }
    
}
