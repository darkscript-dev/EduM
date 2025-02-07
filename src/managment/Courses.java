/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package managment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.ConnectionProvider;
import java.sql.*;


public class Courses extends javax.swing.JPanel {

    
    public Courses() {
        initComponents();
        refreshTable();
        updateCourseId();
    }
    
    private void refreshTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("course_id"),
                    rs.getString("course_name"),
                    rs.getString("type"),
                    rs.getString("duration"),
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void updateCourseId(){
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(course_id) FROM courses");
            if (rs.next()) {
                int course_id = rs.getInt(1) + 1;
                CsIdTxt.setText(String.valueOf(course_id));
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
        jLabel1 = new javax.swing.JLabel();
        CsIdTxt = new javax.swing.JLabel();
        CsReBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CsDurationTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CsTypeTxt = new javax.swing.JComboBox<>();
        CsAddBtn = new javax.swing.JButton();
        CsDltBtn = new javax.swing.JButton();
        CsUpBtn = new javax.swing.JButton();
        CsNameTxt = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        searchCsId = new javax.swing.JTextField();
        CsSearchBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(213, 213, 250));
        setPreferredSize(new java.awt.Dimension(1170, 670));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course id", "Name", "Type", "Duration"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(213, 213, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(422, 632));

        jLabel1.setText("Course id :");

        CsIdTxt.setText("00");

        CsReBtn.setText("Reset Fields");
        CsReBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsReBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        jLabel4.setText("Duration");

        jLabel5.setText("Type");

        CsTypeTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Time", "Part Time" }));

        CsAddBtn.setText("Add");
        CsAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsAddBtnActionPerformed(evt);
            }
        });

        CsDltBtn.setText("Delete");
        CsDltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsDltBtnActionPerformed(evt);
            }
        });

        CsUpBtn.setText("Update");
        CsUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsUpBtnActionPerformed(evt);
            }
        });

        CsNameTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DSE24", "DBIS24", "HNDSE24", "DSE25", "DBIS25", "HNDSE25" }));

        jLabel2.setText("Course id :");

        CsSearchBtn.setText("Search");
        CsSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CsAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(CsUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(CsDltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CsTypeTxt, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CsDurationTxt)
                            .addComponent(CsNameTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(CsIdTxt))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(searchCsId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CsSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CsReBtn))))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchCsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CsSearchBtn))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CsIdTxt)
                    .addComponent(CsReBtn))
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CsNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CsDurationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CsTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CsAddBtn)
                    .addComponent(CsDltBtn)
                    .addComponent(CsUpBtn))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CsReBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsReBtnActionPerformed
        searchCsId.setText("");
        CsDurationTxt.setText("");
    }//GEN-LAST:event_CsReBtnActionPerformed

    private void CsAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsAddBtnActionPerformed
        String course_id=CsIdTxt.getText();
        String course_name=(String)CsNameTxt.getSelectedItem();
        String type=(String)CsTypeTxt.getSelectedItem();
        String duration=CsDurationTxt.getText();
        
        if (course_id.isEmpty() || course_name.isEmpty() || type.isEmpty() || duration.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO courses (course_id, course_name, type, duration) VALUES (?,?,?,?)");
            ps.setString(1, course_id);
            ps.setString(2, course_name);
            ps.setString(3, type);
            ps.setString(4, duration);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully saved");

            refreshTable();
            updateCourseId();

            searchCsId.setText("");
            CsDurationTxt.setText("");
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Course already exists!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_CsAddBtnActionPerformed

    private void CsSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsSearchBtnActionPerformed
         int checkid = 0;
        String id = searchCsId.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses WHERE course_id='" + id + "'");
            while (rs.next()) {
                checkid = 1;
                searchCsId.setEditable(false);
                CsNameTxt.setSelectedItem(rs.getString("course_name"));
                CsTypeTxt.setSelectedItem(rs.getString("type"));
                CsDurationTxt.setText(rs.getString("duration"));
            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "Course ID does not Exist");
            }
            CsAddBtn.setVisible(false); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_CsSearchBtnActionPerformed

    private void CsUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsUpBtnActionPerformed
        String course_id=CsIdTxt.getText();
        String course_name=(String)CsNameTxt.getSelectedItem();
        String type=(String)CsTypeTxt.getSelectedItem();
        String duration=CsDurationTxt.getText();;

        if (course_name.isEmpty() || type.isEmpty() || duration.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE courses SET course_name=?, type=?, duration=? WHERE course_id=?");
            ps.setString(1, course_id);
            ps.setString(2, course_name);
            ps.setString(3, type);
            ps.setString(4, duration);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully updated");

            refreshTable();
            updateCourseId();

            searchCsId.setText("");
            CsDurationTxt.setText("");
            CsAddBtn.setVisible(true); 
            searchCsId.setEditable(true);
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Course already exists!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_CsUpBtnActionPerformed

    private void CsDltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsDltBtnActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            String id = CsIdTxt.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM courses WHERE course_id='" + id + "'");
                JOptionPane.showMessageDialog(null, "Successfully Deleted");

                refreshTable();
                updateCourseId();
                CsAddBtn.setVisible(true); 
                searchCsId.setEditable(true); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_CsDltBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CsAddBtn;
    private javax.swing.JButton CsDltBtn;
    private javax.swing.JTextField CsDurationTxt;
    private javax.swing.JLabel CsIdTxt;
    private javax.swing.JComboBox<String> CsNameTxt;
    private javax.swing.JButton CsReBtn;
    private javax.swing.JButton CsSearchBtn;
    private javax.swing.JComboBox<String> CsTypeTxt;
    private javax.swing.JButton CsUpBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchCsId;
    // End of variables declaration//GEN-END:variables
}
