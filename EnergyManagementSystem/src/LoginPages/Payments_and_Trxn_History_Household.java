/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package LoginPages;
import Dashboards.Household_Consumer_Menu_Bar;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author akshaypramodmalu
 */
public class Payments_and_Trxn_History_Household extends javax.swing.JFrame {

    String[] col = {"Sr. No.", "Payment ID", "Supplier ID", "No. of Credits"};
    static final String DB_URL = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/EMS");
    static final String DB_DRV = "com.mysql.cj.jdbc.Driver";
    static final String DB_USER = System.getenv().getOrDefault("DB_USER", "root");
    static final String DB_PASSWD = System.getenv().getOrDefault("DB_PASSWORD", "");

    static TreeSet<String> yearList = new TreeSet<>();
    static String[] monthList = {"January","February","March"," April","May","June","July","August","September","October","November","December"};
    static int monthCount[]= new int[13];
    Connection con;
    static String user;
    static String pass;
    long consumer_id;
    /**
     * Creates new form Payments_and_Trxn_History
     */
    public Payments_and_Trxn_History_Household(String Username,String Password) {
        initComponents();
        setJMenuBar(new Household_Consumer_Menu_Bar().Consumer_MenuBar(user,pass,this));
        try{    
                Payments_and_Trxn_History_Household.user=Username;
                Payments_and_Trxn_History_Household.pass=Password;
                Class.forName(DB_DRV);
                con = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
                System.out.printf("Connected to Database! \n");
                String sql1="SELECT * FROM Household_Consumer WHERE Name = '"+user+"'";
              
                Statement stmnt1=con.createStatement();
                Statement stmnt2=con.createStatement();
                Statement stmnt3 = con.createStatement();
                Statement stmnt4 = con.createStatement();
                ResultSet rs1=stmnt1.executeQuery(sql1);
                System.out.println("Akshay 1");    
                rs1.next();
                consumer_id = rs1.getLong(1);
//                String sql2="SELECT * FROM TRANSACTIONS WHERE Consumer_Id="+consumer_id+"";
                
                String sql3 = "SELECT DATE(Timestamp) AS Date FROM TRANSACTIONS WHERE consumer_id = "+consumer_id+"";
               
                ResultSet rs3 = stmnt3.executeQuery(sql3);
                
                while(rs3.next()){
                    System.out.println("Date Detected");
                    java.sql.Date date = rs3.getDate("Date");
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    System.out.println(date);
                    var month = cal.get(Calendar.MONTH);
                    var year = cal.get(Calendar.YEAR);
                    System .out.println("Month no. is "+ month +" Year no. is "+ year);
                    monthCount[month]++;
                    yearList.add(String.valueOf(year));
//                    String month = rs3.getString("MONTH");
//                    String year = rs3.getString("YEAR");
                }
//                for(int i=0; i<12;i++)
//                {
//                    if(monthCount[i]>0)
//                    {
//                        cmbFrom_Month.addItem(monthList[i]);
//                        cmbTo_Month.addItem(monthList[i]);
//                    }
//                }
//                
//                for (String year : yearList) {
//                    cmbFrom_Year.addItem(year);
//                    cmbTo_Year.addItem(year);
//                }
                
                
//                String from_month =  String.valueOf(cmbFrom_Month.getSelectedItem());
//                String to_month = String.valueOf(cmbTo_Month.getSelectedItem());
//                
//                String from_year = String.valueOf(cmbFrom_Year.getSelectedItem());
//                String to_year = String.valueOf(cmbTo_Year.getSelectedItem());
//                
//                String sql4 = "SELECT * FROM Transaction WHERE (Timestamp BETWEEN ("+from_month+" AND "+from_year+") AND ("+to_month+" AND "+to_year+")) AND (consumer_id = "+consumer_id+")";
//                
//                System.out.println("Akshay 2");    
//                
//                System.out.println(rs1.getString(1));
//                ResultSet rs2=stmnt2.executeQuery(sql4);
//                DefaultTableModel mdl = new DefaultTableModel();
//                mdl.setColumnIdentifiers(col);
//                tblPayments_and_Trxn.setModel(mdl);
//                int i=1;
//                while(rs2.next()){
//                System.out.println("Akshay testing error 1");    
//                System.out.println(rs2.getString(1));
//                String Payment_ID=String.valueOf(rs2.getInt(3));
//                String Supplier_ID=String.valueOf(rs2.getInt(4));
//                String No_Of_Credits=String.valueOf(rs2.getInt(5));
//                
//                String[] Payment_Row = {String.valueOf(i), Payment_ID, Supplier_ID, No_Of_Credits};
//                System.out.println(Payment_Row[0] +"&"+Payment_Row[1] +"&"+Payment_Row[2]+"&"+Payment_Row[3]);
//                mdl.addRow(Payment_Row);
//                i++;
//                }
                
            }
        catch(Exception e) {
            System.out.println("Akshay testing error 2");    

            System.out.println(e.getMessage());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayments_and_Trxn = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btn_Process_Query = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payments & Transaction History - Household Consumer");

        tblPayments_and_Trxn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPayments_and_Trxn);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Payments & Transaction History");

        btn_Process_Query.setText("Retrieve Data");
        btn_Process_Query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Process_QueryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(btn_Process_Query)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addComponent(btn_Process_Query)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Process_QueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Process_QueryActionPerformed
        // TODO add your handling code here:
        try
        {
            
            DefaultTableModel mdl = new DefaultTableModel();
            mdl.setColumnIdentifiers(col);
            tblPayments_and_Trxn.setModel(mdl);
            Statement stmnt = con.createStatement();
            Statement stmnt2 = con.createStatement();
//            String from_month_text = String.valueOf(cmbFrom_Month.getSelectedItem());
//            String to_month_text = String.valueOf(cmbTo_Month.getSelectedItem());
//            String from_year = String.valueOf(cmbFrom_Year.getSelectedItem());
//            String to_year = String.valueOf(cmbTo_Year.getSelectedItem());
//            int from_month =13, to_month=13;
//            for(int i=0; i<12; i++)
//            {
//                if(from_month_text.equals(monthList[i]))
//                    from_month = i+1;// jan is read as 0 even though it's number is 1
//                if(to_month_text.equals(monthList[i]))
//                    to_month = i+1;// jan is read as 0 even though it's number is 1
//            }
            String sql1 = "SELECT DATE(Timestamp) AS Date FROM TRANSACTIONS WHERE consumer_id = "+consumer_id+"";
            ResultSet rs1 = stmnt.executeQuery(sql1);
//            while(rs1.next())
//            {
//                java.sql.Date dat = rs1.getDate(1);
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(dat);
//                var year  = Calendar.YEAR;
//                var month = Calendar.MONTH;
//                System.out.println("Year: " + year + " Month: " + month);
//                String sql2 = "SELECT * FROM Transactions WHERE (MONTH("+Date+") BETWEEN ('" + from_month + "' AND '" + to_month + "') AND (YEAR("+Date+") BETWEEN " + from_year + " AND " + to_year + ")) AND (consumer_id = " + consumer_id + ")";
                var sql2 = "SELECT * FROM Transactions WHERE  (consumer_id = "+consumer_id+")";

                System.out.println("Akshay 2");
                ResultSet rs2 = stmnt2.executeQuery(sql2);
                int i = 1;
                while (rs2.next()) {
                    System.out.println("Akshay testing error 1");
                    System.out.println("Consumer ID" + rs2.getString(2));
                    String Payment_ID = String.valueOf(rs2.getLong(1));
                    String Supplier_ID = String.valueOf(rs2.getLong(4));
                    String No_Of_Credits = String.valueOf(rs2.getInt(5));
                    String[] Payment_Row = {String.valueOf(i), Payment_ID, Supplier_ID, No_Of_Credits};
                    System.out.println(Payment_Row[0] + "&" + Payment_Row[1] + "&" + Payment_Row[2] + "&" + Payment_Row[3]);
                    mdl.addRow(Payment_Row);
                    i++;
                }
                System.out.println("Out of the loop");
//            }
        }
        catch(Exception e) {
            System.out.println("Akshay testing error 2");    

            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_btn_Process_QueryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Payments_and_Trxn_History_Household.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payments_and_Trxn_History_Household.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payments_and_Trxn_History_Household.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payments_and_Trxn_History_Household.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payments_and_Trxn_History_Household(user,pass).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Process_Query;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPayments_and_Trxn;
    // End of variables declaration//GEN-END:variables
}
