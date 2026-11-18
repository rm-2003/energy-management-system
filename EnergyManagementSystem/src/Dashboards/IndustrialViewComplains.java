/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboards;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 * 
 * @author RISHABH
 */
public class IndustrialViewComplains extends javax.swing.JFrame {
    
    static String user;
    static String pass;
    
    static final String DB_URL = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/EMS");
    static final String DB_DRV = "com.mysql.cj.jdbc.Driver";
    static final String DB_USER = System.getenv().getOrDefault("DB_USER", "root");
    static final String DB_PASSWD = System.getenv().getOrDefault("DB_PASSWORD", "");
    
    Connection con;
//    PreparedStatement pst;
//    ResultSet rs;
    
//    String[][] comp = new String[100][3];
//    String [][] comp = {{"1233", "1245", "bad power"},{"1232432", "1245", "no elec"}};
    String[] col = {"Sr. No","Complaint ID", "Supplier ID","Description"};

    public IndustrialViewComplains(String Username, String Password) { // Changed the constructor argument from the default case.
        initComponents();
//        setJMenuBar(new Household_Consumer_Menu_Bar().Consumer_MenuBar());

        this.user = Username;
        this.pass = Password;
        
        setJMenuBar(new Household_Consumer_Menu_Bar().Consumer_MenuBar(user, pass, this));
        
        try{
                Class.forName(DB_DRV);
                con = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
                System.out.printf("Connected to Database! \n");
                Statement stmnt = con.createStatement();
                // mysql query to run
                String sql1 = "select * from INDUSTRIAL_CONSUMER where INDUSTRIAL_CONSUMER_ID = '"+user+"' and password = '"+pass+"'";
                ResultSet rs1 = stmnt.executeQuery(sql1);
//                rs1.next();
//                System.out.println("Akshay 2 ");
//                System.out.println(rs1.getString(1));
//                System.out.println(rs1.getString(2));
//                System.out.println(rs1.getString(3));
//                System.out.println(rs1.getString(4));
//                System.out.println(rs1.getString(5));
//                System.out.println(rs1.getString(6));
//                System.out.println(rs1.getString(7));
//                System.out.println(rs1.getString(8));
//                System.out.println(rs1.getString(9));
                if(rs1.next()){
                    String Consumer_ID = rs1.getString(1);
                    System.out.println("Consumer ID is: " + String.valueOf(Consumer_ID));
                    String sql2 = "SELECT * FROM complain WHERE Consumer_Id = '"+Consumer_ID+"'";
                    Statement stmnt1 = con.createStatement();
                    ResultSet rs2 = stmnt1.executeQuery(sql2);
                    DefaultTableModel mdl = new DefaultTableModel();
                    mdl.setColumnIdentifiers(col);
                    householdViewComplainsTbl.setModel(mdl);
                    jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//                    JTable table = new JTable(mdl);
//                    TableColumnModel column_model = table.getColumnModel();
//                    column_model.getColumn(4).setPreferredWidth(300);
                    int i =1;
                    while(rs2.next()){
//                        System.out.println("Rishabh Error1 testing");
                        String complaintID = String.valueOf(rs2.getInt(5));
//                        System.out.print(String.valueOf(monthNo)+" ");
                        String supplierID = String.valueOf(rs2.getInt(3));
//                        System.out.print(year+" ");
                        String desc= rs2.getString(6);
//                        System.out.println(units+" ");
                        String[] complainRow = {String.valueOf(i), complaintID,supplierID, desc};
                        System.out.println(complainRow[0] +"&"+complainRow[1] +"&"+complainRow[2]);
                        mdl.addRow(complainRow);
//                        ComplaintTable.repaint();
//                        JFrame f= this.frameInit();
                        i++;
//                        mdl.fireTableRowsInserted(0,100);
                    }
                    mdl.fireTableDataChanged();
                } else {
                    System.out.println("else");
//                    JOptionPane.showMessageDialog(this, "Username or Password wrong.");
//                    jtuser.setText("");
//                    jpassword.setText("");
                }
                
            }catch (Exception e){
                System.out.println(e.getMessage());
                
            }
//        ComplaintTable.repaint();

        //ComplaintsTable = new JTable(comp, col);
        
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
        householdViewComplainsTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Industrial Consumer - View Complains");

        householdViewComplainsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. no.", "Complaint ID", "Supplier ID", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        householdViewComplainsTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        householdViewComplainsTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(householdViewComplainsTbl);
        if (householdViewComplainsTbl.getColumnModel().getColumnCount() > 0) {
            householdViewComplainsTbl.getColumnModel().getColumn(0).setResizable(false);
            householdViewComplainsTbl.getColumnModel().getColumn(0).setPreferredWidth(20);
            householdViewComplainsTbl.getColumnModel().getColumn(1).setResizable(false);
            householdViewComplainsTbl.getColumnModel().getColumn(1).setPreferredWidth(50);
            householdViewComplainsTbl.getColumnModel().getColumn(2).setResizable(false);
            householdViewComplainsTbl.getColumnModel().getColumn(2).setPreferredWidth(50);
            householdViewComplainsTbl.getColumnModel().getColumn(3).setResizable(false);
            householdViewComplainsTbl.getColumnModel().getColumn(3).setPreferredWidth(300);
        }
        householdViewComplainsTbl.getAccessibleContext().setAccessibleParent(householdViewComplainsTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(IndustrialViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndustrialViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndustrialViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndustrialViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndustrialViewComplains(user, pass).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable householdViewComplainsTbl;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
