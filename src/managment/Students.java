/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package managment;
import project.ConnectionProvider;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Students extends javax.swing.JPanel {

    
    public Students() {
        initComponents();
        refreshTable();
        updateStudentId();
        
    }

    private void refreshTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("student_id"),
                    rs.getString("name"),
                    rs.getString("age"),
                    rs.getString("mobile_number"),
                    rs.getString("email"),
                    rs.getString("gender")
                });
                
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                jTable1.setRowSorter(sorter);
        
                sorter.setRowFilter(RowFilter.regexFilter(".+"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void updateStudentId(){
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(student_id) FROM students");
            if (rs.next()) {
                int student_id = rs.getInt(1) + 1;
                StIdTxt.setText(String.valueOf(student_id));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        stNameTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stAgeTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        stNumTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stMailTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stGenderTxt = new javax.swing.JComboBox<>();
        searchSTId = new javax.swing.JTextField();
        stSearchBtn = new javax.swing.JButton();
        stAddBtn = new javax.swing.JButton();
        stUpBtn = new javax.swing.JButton();
        stDltBtn = new javax.swing.JButton();
        stReBtn = new javax.swing.JButton();
        StIdTxt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1170, 670));
        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student id", "Name", "Age", "Mobile Number", "Email", "Gender"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(242, 242, 242));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 778, 670);

        jPanel1.setBackground(new java.awt.Color(213, 213, 250));
        jPanel1.setLayout(null);
        jPanel1.add(stNameTxt);
        stNameTxt.setBounds(26, 200, 365, 22);

        jLabel1.setText("Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(26, 178, 104, 16);

        jLabel2.setText("Age");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(26, 240, 104, 16);
        jPanel1.add(stAgeTxt);
        stAgeTxt.setBounds(26, 262, 365, 22);

        jLabel3.setText("Mobile Number");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(26, 302, 104, 16);
        jPanel1.add(stNumTxt);
        stNumTxt.setBounds(26, 324, 365, 22);

        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(26, 364, 104, 16);
        jPanel1.add(stMailTxt);
        stMailTxt.setBounds(26, 386, 365, 22);

        jLabel5.setText("Member ID :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(26, 125, 104, 16);

        jLabel7.setText("Gender");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(26, 426, 38, 16);

        stGenderTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "male", "female" }));
        jPanel1.add(stGenderTxt);
        stGenderTxt.setBounds(27, 448, 364, 22);
        jPanel1.add(searchSTId);
        searchSTId.setBounds(126, 40, 34, 22);

        stSearchBtn.setText("Search");
        stSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stSearchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(stSearchBtn);
        stSearchBtn.setBounds(300, 40, 91, 23);

        stAddBtn.setText("Add");
        stAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stAddBtnActionPerformed(evt);
            }
        });
        jPanel1.add(stAddBtn);
        stAddBtn.setBounds(26, 554, 100, 23);

        stUpBtn.setText("Update");
        stUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stUpBtnActionPerformed(evt);
            }
        });
        jPanel1.add(stUpBtn);
        stUpBtn.setBounds(160, 554, 100, 23);

        stDltBtn.setText("Delete");
        stDltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stDltBtnActionPerformed(evt);
            }
        });
        jPanel1.add(stDltBtn);
        stDltBtn.setBounds(291, 554, 100, 23);

        stReBtn.setText("Reset Fields");
        stReBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stReBtnActionPerformed(evt);
            }
        });
        jPanel1.add(stReBtn);
        stReBtn.setBounds(300, 81, 91, 23);

        StIdTxt.setText("00");
        jPanel1.add(StIdTxt);
        StIdTxt.setBounds(136, 125, 24, 16);

        jLabel8.setText("Search ID ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(26, 43, 102, 16);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradiant 3.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(-777, -8, 1190, 680);

        add(jPanel1);
        jPanel1.setBounds(774, 0, 410, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void stReBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stReBtnActionPerformed
        searchSTId.setText("");
        stNameTxt.setText("");
        stAgeTxt.setText("");
        stNumTxt.setText("");
        stMailTxt.setText("");
        searchSTId.setEditable(false);
    }//GEN-LAST:event_stReBtnActionPerformed

    private void stAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stAddBtnActionPerformed
        String student_id=StIdTxt.getText();
        String name=stNameTxt.getText();
        String age=stAgeTxt.getText();
        String mobile_number=stNumTxt.getText();
        String email=stMailTxt.getText();
        String gender=(String)stGenderTxt.getSelectedItem();
        
        if (name.isEmpty() || age.isEmpty() || mobile_number.isEmpty() || email.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }
        
        try {
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("INSERT INTO Students (student_id, name, age, mobile_number, email, gender) VALUES (?,?,?,?,?,?)");
            ps.setString(1, student_id);
            ps.setString(2, name);
            ps.setString(3, age);
            ps.setString(4, mobile_number);
            ps.setString(5, email);
            ps.setString(6, gender);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successluffy saved");
            
            refreshTable();
            updateStudentId();
            
            searchSTId.setText("");
            stNameTxt.setText("");
            stAgeTxt.setText("");
            stNumTxt.setText("");
            stMailTxt.setText("");
        } catch (SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "Email already exists!");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_stAddBtnActionPerformed

    private void stSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stSearchBtnActionPerformed
        int checkid=0;
        String id=searchSTId.getText();
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select *from Students where student_id='"+id+"'");
            while (rs.next()) {
                checkid=1;
                searchSTId.setEditable(false);
                stNameTxt.setText(rs.getString(2));
                stAgeTxt.setText(rs.getString(3));
                stNumTxt.setText(rs.getString(4));
                stMailTxt.setText(rs.getString(5));
            }
            if (checkid==0) {
                JOptionPane.showMessageDialog(null, "Student ID does not Exist");
            }
            stAddBtn.setVisible(false);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_stSearchBtnActionPerformed

    private void stUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stUpBtnActionPerformed
        String student_id=StIdTxt.getText();
        String name=stNameTxt.getText();
        String age=stAgeTxt.getText();
        String mobile_number=stNumTxt.getText();
        String email=stMailTxt.getText();
        String gender=(String)stGenderTxt.getSelectedItem();
        
        if (name.isEmpty() || age.isEmpty() || mobile_number.isEmpty() || email.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }
        
        try {
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("update students set name=?, age=?, mobile_number=?, email=?, gender=?, trade=? where student_id=?");
            ps.setString(1, student_id);
            ps.setString(2, name);
            ps.setString(3, age);
            ps.setString(4, mobile_number);
            ps.setString(5, email);
            ps.setString(6, gender);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successluffy saved");
            
            refreshTable();
            updateStudentId();
            
            searchSTId.setText("");
            stNameTxt.setText("");
            stAgeTxt.setText("");
            stNumTxt.setText("");
            stMailTxt.setText("");
            stAddBtn.setVisible(true);
            searchSTId.setText("");
            searchSTId.setEditable(true);
        } catch (SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "Email already exists!");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_stUpBtnActionPerformed

    private void stDltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stDltBtnActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Delete","Select",JOptionPane.YES_NO_OPTION);
        if (a==0) {
            String id=searchSTId.getText();
            try {
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                st.executeUpdate("Delete from Students where student_id='"+id+"'");
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                setVisible(false);
                
                refreshTable();
                updateStudentId();
                stAddBtn.setVisible(true);
                searchSTId.setText("");
                searchSTId.setEditable(true);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_stDltBtnActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StIdTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchSTId;
    private javax.swing.JButton stAddBtn;
    private javax.swing.JTextField stAgeTxt;
    private javax.swing.JButton stDltBtn;
    private javax.swing.JComboBox<String> stGenderTxt;
    private javax.swing.JTextField stMailTxt;
    private javax.swing.JTextField stNameTxt;
    private javax.swing.JTextField stNumTxt;
    private javax.swing.JButton stReBtn;
    private javax.swing.JButton stSearchBtn;
    private javax.swing.JButton stUpBtn;
    // End of variables declaration//GEN-END:variables
}
