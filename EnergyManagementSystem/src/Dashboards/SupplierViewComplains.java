/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboards;
import LoginPages.Industrial_Consumer_Current_Credit;
import java.awt.Dimension;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 * 
 * @author RISHABH
 */
public class SupplierViewComplains extends javax.swing.JFrame {
    
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

    public SupplierViewComplains(String Username, String Password) { // Changed the constructor argument from the default case.
        initComponents();
//        setJMenuBar(new Household_Consumer_Menu_Bar().Consumer_MenuBar());
    
        this.user = Username;
        this.pass = Password;
        
        setJMenuBar(new SupplierMenuBar().supplierMenuBar(user, pass, this));

        
        try{
                Class.forName(DB_DRV);
                con = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
                System.out.printf("Connected to Database! \n");
                Statement stmnt = con.createStatement();
                // mysql query to run
                String sql1 = "select * from Supplier where Supplier_ID = '"+user+"' and password = '"+pass+"'";
                ResultSet rs1 = stmnt.executeQuery(sql1);
//                rs1.next();
//                System.out.println(rs1.getString(1));

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
                    String Supplier_Id = rs1.getString(1);
                    System.out.println("Consumer ID is: " + String.valueOf(Supplier_Id));
                    String sql2 = "SELECT * FROM complain WHERE Supplier_Id = '"+Supplier_Id+"'";
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
                        System.out.println("Akshay Error1 testing");
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
        jLabel1 = new javax.swing.JLabel();
        btnResolve = new javax.swing.JButton();
        txtComplainId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(722, 350));

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

        jLabel1.setText("Resolve Complain:");

        btnResolve.setText("Resolve");
        btnResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolveActionPerformed(evt);
            }
        });

        txtComplainId.setText("<Complain_ID>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtComplainId, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnResolve)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnResolve)
                    .addComponent(txtComplainId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnResolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolveActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName(DB_DRV);
                con = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
                System.out.printf("Connected to Database! \n");
                
                Statement stmnt = con.createStatement();
                Statement stmnt1 = con.createStatement();
                Statement stmnt2 = con.createStatement();
                Statement stmnt3 = con.createStatement();
                String sql = "select * from Supplier where Supplier_ID = '" + user + "' and password = '" + pass + "'";
                ResultSet rs2 = stmnt.executeQuery(sql);
                
                String complaint_ID=txtComplainId.getText();
                
                String sql2 = "{CALL delete_complaint(?, ?, ?)}";
                CallableStatement stmt = con.prepareCall(sql2);
                // Set the parameters
                stmt.setString(1, user);
                stmt.setString(2, complaint_ID);
                stmt.registerOutParameter(3, 12); // Assuming @result is a VARCHAR output parameter
                stmt.registerOutParameter(3, Types.INTEGER); // Assuming @result is an OUT parameter

                // Execute the stored procedure
                stmt.execute();
                String result = stmt.getString(3);
                // Retrieve the result
                int num = Integer.parseInt(result);
            if (num == 1) {
                System.out.println(result);
                System.out.println(num);
                System.out.println("Akshay 1");
                String message = "Complain Resolved";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.OK_OPTION);
                dispose();
                new SupplierViewComplains(user,pass).setVisible(true);
//                new Industrial_Consumer_Current_Credit(user, pass).setVisible(true);

            } else {
                System.out.println(result);
                System.out.println(num);

                System.out.println("Akshay 2");
                String message = "Complain couldn't be resolved";
                JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);

            }           
                
                
        }
       catch (Exception e) {
                    e.printStackTrace();
                }
    }//GEN-LAST:event_btnResolveActionPerformed

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
            java.util.logging.Logger.getLogger(SupplierViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierViewComplains.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierViewComplains(user, pass).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResolve;
    private javax.swing.JTable householdViewComplainsTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtComplainId;
    // End of variables declaration//GEN-END:variables
}
