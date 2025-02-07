/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package managment;
import project.ConnectionProvider;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project.Print;


public class Results extends javax.swing.JPanel {

    
    public Results() {
        initComponents();
        refreshTable();
        updateResultId();
    }

    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 

        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM results");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("result_id"),
                    rs.getString("student_id"),
                    rs.getString("course_name"),
                    rs.getString("marks")
                });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void updateResultId() {
        try {
        Connection con = ConnectionProvider.getCon();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed!");
            return;
        }

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(result_id) FROM results");
        if (rs.next()) {
            int result_id = rs.getInt(1) + 1;
            RsIdTxt.setText(String.valueOf(result_id));
            System.out.println("Updated result_id: " + result_id); 
        } else {
            
            RsIdTxt.setText("1");
            System.out.println("No rows found, starting with result_id: 1"); 
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        System.out.println("Error updating result_id: " + e.getMessage());
    }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchRsId = new javax.swing.JTextField();
        RsSearchBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        RsMarksTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        RsStNameTxt = new javax.swing.JTextField();
        RsAddBtn = new javax.swing.JButton();
        RsDltBtn = new javax.swing.JButton();
        RsUpBtn = new javax.swing.JButton();
        RsReBtn = new javax.swing.JButton();
        RsCsNameTxt = new javax.swing.JComboBox<>();
        RsIdTxt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(213, 213, 250));
        setPreferredSize(new java.awt.Dimension(1170, 670));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "result_id", "student_id", "course name", "marks"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(213, 213, 250));

        jLabel1.setText("Course");

        jLabel2.setText("Student ID :");

        RsSearchBtn.setText("Search");
        RsSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RsSearchBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Marks");

        jLabel4.setText("Name");

        RsAddBtn.setText("Add");
        RsAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RsAddBtnActionPerformed(evt);
            }
        });

        RsDltBtn.setText("Delete");
        RsDltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RsDltBtnActionPerformed(evt);
            }
        });

        RsUpBtn.setText("Update");
        RsUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RsUpBtnActionPerformed(evt);
            }
        });

        RsReBtn.setText("Reset Fields");
        RsReBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RsReBtnActionPerformed(evt);
            }
        });

        RsCsNameTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DSE24", "DBIS24", "HNDSE24", "DSE25", "DBIS25", "HNDSE25", " " }));

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("search student id before press print");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(RsIdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(35, 35, 35)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(RsMarksTxt)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(searchRsId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(RsReBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                    .addComponent(RsSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addComponent(RsStNameTxt)
                                    .addComponent(RsCsNameTxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(RsAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(RsUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(RsDltBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchRsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RsSearchBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RsReBtn)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(RsIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RsStNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RsCsNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RsMarksTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RsAddBtn)
                    .addComponent(RsDltBtn)
                    .addComponent(RsUpBtn))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RsReBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RsReBtnActionPerformed
        searchRsId.setText("");
        RsStNameTxt.setText("");
        RsMarksTxt.setText("");
        searchRsId.setEditable(true);
    }//GEN-LAST:event_RsReBtnActionPerformed

    private void RsAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RsAddBtnActionPerformed
        String result_id = RsIdTxt.getText();
        String student_id = searchRsId.getText();
        String course_name = (String) RsCsNameTxt.getSelectedItem().toString();
        String marks = RsMarksTxt.getText();

     if (student_id.isEmpty() || course_name.isEmpty() || marks.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill all fields!");
        return;
    }

    try {
        Connection con = ConnectionProvider.getCon();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed!");
            return;
        }

        PreparedStatement ps = con.prepareStatement("INSERT INTO results (result_id, student_id, course_name, marks) VALUES (?,?,?,?)");
        ps.setString(1, result_id);
        ps.setString(2, student_id);
        ps.setString(3, course_name);
        ps.setString(4, marks);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Successfully saved");
            System.out.println("Data inserted successfully!");

            
            refreshTable();
            updateResultId(); 
        } else {
            JOptionPane.showMessageDialog(null, "Failed to insert data!");
        }

        
        searchRsId.setText("");
        RsStNameTxt.setText("");
        RsMarksTxt.setText("");
        searchRsId.setEditable(true);
    } catch (SQLIntegrityConstraintViolationException e) {
        JOptionPane.showMessageDialog(null, "Result already exists!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        System.out.println("Error inserting data: " + e.getMessage());
    }
    }//GEN-LAST:event_RsAddBtnActionPerformed

    private void RsSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RsSearchBtnActionPerformed
         int checkid = 0;
        String id = searchRsId.getText();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students WHERE student_id='" + id + "'");
            while (rs.next()) {
                checkid = 1;
                searchRsId.setEditable(false);
                RsStNameTxt.setText(rs.getString("name"));
            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "Student ID does not Exist");
            }
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_RsSearchBtnActionPerformed

    private void RsUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RsUpBtnActionPerformed
        String result_id = RsIdTxt.getText();
        String student_id = searchRsId.getText();
        String course_name = (String) RsCsNameTxt.getSelectedItem().toString();
        String marks = RsMarksTxt.getText();

        if (student_id.isEmpty() || course_name.isEmpty() || marks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }

        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE results SET student_id=?, course_name=?, marks=? WHERE result_id=?");
            ps.setString(1, result_id);
            ps.setString(2, student_id);
            ps.setString(3, course_name);
            ps.setString(4, marks);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully updated");

            refreshTable();
            updateResultId();

            searchRsId.setText("");
            RsStNameTxt.setText("");
            RsMarksTxt.setText("");
            RsAddBtn.setVisible(true);
            searchRsId.setEditable(true); 
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Result already exists!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_RsUpBtnActionPerformed

    private void RsDltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RsDltBtnActionPerformed
       int a = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            String id = RsIdTxt.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM results WHERE result_id='" + id + "'");
                JOptionPane.showMessageDialog(null, "Successfully Deleted");

                refreshTable();
                updateResultId();
                RsAddBtn.setVisible(true);
                searchRsId.setEditable(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_RsDltBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        int studentID = Integer.parseInt(searchRsId.getText()); // Get student ID from text field

        Connection con = ConnectionProvider.getCon(); // Get your database connection

        if (con != null) {
            Print.printReport(studentID, con); // Call the printReport method
            con.close(); // Close the connection after report generation
        } else {
            // Handle the case where the connection is null (e.g., show an error message)
            JOptionPane.showMessageDialog(this, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Invalid Student ID. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error closing the database connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RsAddBtn;
    private javax.swing.JComboBox<String> RsCsNameTxt;
    private javax.swing.JButton RsDltBtn;
    private javax.swing.JLabel RsIdTxt;
    private javax.swing.JTextField RsMarksTxt;
    private javax.swing.JButton RsReBtn;
    private javax.swing.JButton RsSearchBtn;
    private javax.swing.JTextField RsStNameTxt;
    private javax.swing.JButton RsUpBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchRsId;
    // End of variables declaration//GEN-END:variables
}
