/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package managment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.ConnectionProvider;

/**
 *
 * @author E-LINE
 */
public class Teachers extends javax.swing.JPanel {

    
    public Teachers() {
        initComponents();
        refreshTable();
        updateteacherId();
    }

    private void refreshTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM teachers");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("teacher_id"),
                    rs.getString("name"),
                    rs.getString("mobile_number"),
                    rs.getString("email"),
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void updateteacherId(){
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(teacher_id) FROM teachers");
            if (rs.next()) {
                int teacher_id = rs.getInt(1) + 1;
                TchIdTxt.setText(String.valueOf(teacher_id));
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
        TchseachBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        searchTchId = new javax.swing.JTextField();
        TchIdTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TchNameTxt = new javax.swing.JTextField();
        TchNumTxt = new javax.swing.JTextField();
        TchMailTxt = new javax.swing.JTextField();
        TchReBtn = new javax.swing.JButton();
        TchAddBtn = new javax.swing.JButton();
        TchUpBtn = new javax.swing.JButton();
        TchDltBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(213, 213, 250));
        setMinimumSize(new java.awt.Dimension(1170, 670));
        setPreferredSize(new java.awt.Dimension(1170, 670));
        setLayout(null);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 402));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher id", "name", "Mobile Number", "mail"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 780, 680);

        jPanel1.setBackground(new java.awt.Color(213, 213, 250));
        jPanel1.setMinimumSize(new java.awt.Dimension(410, 670));
        jPanel1.setPreferredSize(new java.awt.Dimension(422, 632));

        TchseachBtn.setText("Search");
        TchseachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TchseachBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Search ID ");

        TchIdTxt.setText("00");

        jLabel5.setText("Member ID :");

        jLabel6.setText("Name");

        jLabel7.setText("Mobile Number");

        jLabel8.setText("Email");

        TchReBtn.setText("Reset fields");
        TchReBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TchReBtnActionPerformed(evt);
            }
        });

        TchAddBtn.setText("Add");
        TchAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TchAddBtnActionPerformed(evt);
            }
        });

        TchUpBtn.setText("Update");
        TchUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TchUpBtnActionPerformed(evt);
            }
        });

        TchDltBtn.setText("Delete");
        TchDltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TchDltBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TchIdTxt)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(searchTchId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TchReBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(TchseachBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TchMailTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TchNameTxt)
                            .addComponent(TchNumTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TchAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(TchUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(TchDltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TchseachBtn))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TchReBtn)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TchIdTxt)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TchNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TchNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TchMailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TchAddBtn)
                    .addComponent(TchUpBtn)
                    .addComponent(TchDltBtn))
                .addGap(37, 37, 37))
        );

        add(jPanel1);
        jPanel1.setBounds(760, 0, 410, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void TchReBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TchReBtnActionPerformed
        searchTchId.setText("");
        TchNumTxt.setText("");
        TchNameTxt.setText("");
        TchMailTxt.setText("");
    }//GEN-LAST:event_TchReBtnActionPerformed

    private void TchAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TchAddBtnActionPerformed
        String teacher_id=TchIdTxt.getText();
        String name=TchNameTxt.getText();
        String mobile_number=TchNumTxt.getText();
        String email=TchMailTxt.getText();
        
        if (name.isEmpty() || mobile_number.isEmpty() || email.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }
        try {
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("INSERT INTO teachers (teacher_id, name, mobile_number, email) VALUES (?,?,?,?)");
            ps.setString(1, teacher_id);
            ps.setString(2, name);
            ps.setString(3, mobile_number);
            ps.setString(4, email);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successluffy saved");
            
            refreshTable();
            updateteacherId();
            
            searchTchId.setText("");
            TchNumTxt.setText("");
            TchNameTxt.setText("");
            TchMailTxt.setText("");
        
        } catch (SQLIntegrityConstraintViolationException e) {  
            JOptionPane.showMessageDialog(null, "Email already exists!");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TchAddBtnActionPerformed

    private void TchseachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TchseachBtnActionPerformed
        int checkid=0;
        String id=searchTchId.getText();
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select *from teachers where teacher_id='"+id+"'");
            while (rs.next()) {
                checkid=1;
                searchTchId.setEditable(false);
                TchIdTxt.setText(rs.getString("teacher_id"));
                TchNameTxt.setText(rs.getString(2));
                TchNumTxt.setText(rs.getString(3));
                TchMailTxt.setText(rs.getString(4));
            }
            if (checkid==0) {
                JOptionPane.showMessageDialog(null, "Teacher_id does not Exist");
            }
            TchAddBtn.setVisible(false);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_TchseachBtnActionPerformed

    private void TchUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TchUpBtnActionPerformed
        String teacher_id=searchTchId.getText();
        String name=TchNameTxt.getText();
        String mobile_number=TchNumTxt.getText();
        String email=TchMailTxt.getText();
        
        if (name.isEmpty() || mobile_number.isEmpty() || email.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }
        try {
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("UPDATE teachers SET name=?, mobile_number=?, email=? WHERE teacher_id=?");
            ps.setString(1, teacher_id);
            ps.setString(2, name);
            ps.setString(3, mobile_number);
            ps.setString(4, email);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successluffy saved");
            
            refreshTable();
            updateteacherId();
            
            searchTchId.setText("");
            TchNumTxt.setText("");
            TchNameTxt.setText("");
            TchMailTxt.setText("");
            TchAddBtn.setVisible(true);
            searchTchId.setText("");
            searchTchId.setEditable(true);
        } catch (SQLIntegrityConstraintViolationException e) {  
            JOptionPane.showMessageDialog(null, "Email already exists!");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_TchUpBtnActionPerformed

    private void TchDltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TchDltBtnActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "Do you really want to Delete","Select",JOptionPane.YES_NO_OPTION);
        if (a==0) {
            String id=searchTchId.getText();
            try {
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                st.executeUpdate("Delete from teachers where teacher_id='"+id+"'");
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                setVisible(false);
                
                refreshTable();
                updateteacherId();
                TchAddBtn.setVisible(true);
                searchTchId.setText("");
                searchTchId.setEditable(true);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_TchDltBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TchAddBtn;
    private javax.swing.JButton TchDltBtn;
    private javax.swing.JLabel TchIdTxt;
    private javax.swing.JTextField TchMailTxt;
    private javax.swing.JTextField TchNameTxt;
    private javax.swing.JTextField TchNumTxt;
    private javax.swing.JButton TchReBtn;
    private javax.swing.JButton TchUpBtn;
    private javax.swing.JButton TchseachBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchTchId;
    // End of variables declaration//GEN-END:variables
}
