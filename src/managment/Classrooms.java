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


public class Classrooms extends javax.swing.JPanel {

  
    public Classrooms() {
        initComponents();
        refreshTable();
        updateClassroomId();
    }
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM classrooms");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("classroom_id"),
                    rs.getString("classroom_name"),
                    rs.getString("capacity"),
                    rs.getString("class_type"),
                });
            }
            System.out.println("Table refreshed successfully!");
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
            System.out.println("Error refreshing table: " + e.getMessage());
        }
    }
    
    private void updateClassroomId() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(classroom_id) FROM classrooms");
            if (rs.next()) {
                int classroom_id = rs.getInt(1) + 1;
                HallIdTxt.setText(String.valueOf(classroom_id));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchHallId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        HallNameTxt = new javax.swing.JTextField();
        HallReBtn = new javax.swing.JButton();
        HallSearchBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        HallIdTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        HallCapTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        HallTypeTxt = new javax.swing.JComboBox<>();
        HallAddBtn = new javax.swing.JButton();
        HallDltBtn = new javax.swing.JButton();
        HallUpBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(213, 213, 250));
        setPreferredSize(new java.awt.Dimension(1170, 670));

        jPanel1.setBackground(new java.awt.Color(213, 213, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(422, 632));

        jLabel1.setText("Class Room ID :");

        jLabel2.setText("Name");

        HallReBtn.setText("Reset Fields");
        HallReBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HallReBtnActionPerformed(evt);
            }
        });

        HallSearchBtn.setText("Search");
        HallSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HallSearchBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Class Room  ID :");

        HallIdTxt.setText("00");

        jLabel5.setText("Capacity");

        jLabel6.setText("Class Type");

        HallTypeTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smart Board", "Projector", "Whiteboard", "Auditorium" }));

        HallAddBtn.setText("Add");
        HallAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HallAddBtnActionPerformed(evt);
            }
        });

        HallDltBtn.setText("Delete");
        HallDltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HallDltBtnActionPerformed(evt);
            }
        });

        HallUpBtn.setText("Update");
        HallUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HallUpBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(HallNameTxt)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addComponent(HallIdTxt))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchHallId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HallReBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(HallSearchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(HallCapTxt)
                    .addComponent(HallTypeTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HallAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HallUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(HallDltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchHallId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HallSearchBtn))
                .addGap(18, 18, 18)
                .addComponent(HallReBtn)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(HallIdTxt))
                .addGap(72, 72, 72)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HallNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HallCapTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HallTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HallAddBtn)
                    .addComponent(HallDltBtn)
                    .addComponent(HallUpBtn))
                .addGap(61, 61, 61))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class ID", "Name", "Capacity", "Class Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(760, 760, 760)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void HallReBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HallReBtnActionPerformed
        searchHallId.setText("");
        HallNameTxt.setText("");
        HallCapTxt.setText("");
    }//GEN-LAST:event_HallReBtnActionPerformed

    private void HallAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HallAddBtnActionPerformed
        String classroom_id = HallIdTxt.getText();
        String classroom_name = HallNameTxt.getText();
        String capacity = HallCapTxt.getText();
        String class_type = (String) HallTypeTxt.getSelectedItem();

        if (classroom_name.isEmpty() || capacity.isEmpty() || class_type.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO classrooms (classroom_id, classroom_name, capacity, class_type) VALUES (?,?,?,?)");
            ps.setString(1, classroom_id);
            ps.setString(2, classroom_name);
            ps.setString(3, capacity);
            ps.setString(4, class_type);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully saved");

            refreshTable();
            updateClassroomId();

            searchHallId.setText("");
            HallNameTxt.setText("");
            HallCapTxt.setText("");
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Classroom already exists!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_HallAddBtnActionPerformed

    private void HallSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HallSearchBtnActionPerformed
        int checkid = 0;
        String id = searchHallId.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM classrooms WHERE classroom_id='" + id + "'");
            while (rs.next()) {
                checkid = 1;
                searchHallId.setEditable(false);
                HallNameTxt.setText(rs.getString("classroom_name"));
                HallCapTxt.setText(rs.getString("capacity"));
                HallTypeTxt.setSelectedItem(rs.getString("class_type"));
                
            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "Classroom ID does not Exist");
            }
            HallAddBtn.setVisible(false); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_HallSearchBtnActionPerformed

    private void HallUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HallUpBtnActionPerformed
        String classroom_id = HallIdTxt.getText();
        String classroom_name = HallNameTxt.getText();
        String capacity = HallCapTxt.getText();
        String class_type = (String) HallTypeTxt.getSelectedItem();

        if (classroom_name.isEmpty() || capacity.isEmpty() || class_type.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO classrooms (classroom_id, classroom_name, capacity, class_type) VALUES (?,?,?,?)");
            ps.setString(1, classroom_id);
            ps.setString(2, classroom_name);
            ps.setString(3, capacity);
            ps.setString(4, class_type);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully updated");

            refreshTable();
            updateClassroomId();

            searchHallId.setText("");
            HallNameTxt.setText("");
            HallCapTxt.setText("");
            HallAddBtn.setVisible(true); 
            searchHallId.setEditable(true); 
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Classroom already exists!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_HallUpBtnActionPerformed

    private void HallDltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HallDltBtnActionPerformed
       int a = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            String id = HallIdTxt.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM classrooms WHERE classroom_id='" + id + "'");
                JOptionPane.showMessageDialog(null, "Successfully Deleted");

                refreshTable();
                updateClassroomId();
                HallAddBtn.setVisible(true); 
                searchHallId.setEditable(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_HallDltBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HallAddBtn;
    private javax.swing.JTextField HallCapTxt;
    private javax.swing.JButton HallDltBtn;
    private javax.swing.JLabel HallIdTxt;
    private javax.swing.JTextField HallNameTxt;
    private javax.swing.JButton HallReBtn;
    private javax.swing.JButton HallSearchBtn;
    private javax.swing.JComboBox<String> HallTypeTxt;
    private javax.swing.JButton HallUpBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchHallId;
    // End of variables declaration//GEN-END:variables
}
