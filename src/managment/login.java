package managment;

import java.awt.Color;

public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
        errorLb.setVisible(false);
        userNtxt.setText("  Enter Username");
        userNtxt.setForeground(new Color(153, 153, 153));
        passWtxt.setText("  Enter Password");
        passWtxt.setForeground(new Color(153, 153, 153));
        passWtxt.setEchoChar((char) 0);
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNtxt = new javax.swing.JTextField();
        passWtxt = new javax.swing.JPasswordField();
        errorLb = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        loginBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(870, 480));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close 1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 30, 30));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EduM");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(2, 50, 310, 57);

        userNtxt.setOpaque(true);
        userNtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNtxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNtxtFocusLost(evt);
            }
        });
        jPanel1.add(userNtxt);
        userNtxt.setBounds(20, 180, 270, 42);

        passWtxt.setOpaque(true);
        passWtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passWtxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passWtxtFocusLost(evt);
            }
        });
        passWtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passWtxtActionPerformed(evt);
            }
        });
        jPanel1.add(passWtxt);
        passWtxt.setBounds(20, 240, 270, 42);

        errorLb.setForeground(new java.awt.Color(255, 255, 255));
        errorLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLb.setText("Incorrect Username or Password");
        jPanel1.add(errorLb);
        errorLb.setBounds(20, 300, 270, 16);

        jCheckBox1.setBackground(new java.awt.Color(204, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCheckBox1.setText("show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(180, 370, 110, 19);

        loginBtn.setBackground(new java.awt.Color(0, 0, 0));
        loginBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginBtn);
        loginBtn.setBounds(20, 400, 270, 42);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradiant 1.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 310, 480);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 480));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 560, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void userNtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNtxtFocusLost
        errorLb.setVisible(false);
        if (userNtxt.getText().equals("")) {
            userNtxt.setText("  Enter Username");
            userNtxt.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_userNtxtFocusLost

    private void passWtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passWtxtFocusGained
        errorLb.setVisible(false);
        if (passWtxt.getText().equals("  Enter Password")) {
            passWtxt.setEchoChar('*');
            passWtxt.setText("");
            passWtxt.setForeground(new Color(153, 153, 153));
        } else {
        }
    }//GEN-LAST:event_passWtxtFocusGained

    private void passWtxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passWtxtFocusLost
        errorLb.setVisible(false);
        if (passWtxt.getText().equals("")) {
            passWtxt.setEchoChar((char) 0);
            passWtxt.setText("  Enter Password");
            passWtxt.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_passWtxtFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            passWtxt.setEchoChar((char) 0);
        } else {
            passWtxt.setEchoChar('*');
        } 
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        if (userNtxt.getText().equals("admin") && passWtxt.getText().equals("admin")) {
            setVisible(false);
            new main().setVisible(true);

        } else {
            errorLb.setVisible(true);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void userNtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNtxtFocusGained
        errorLb.setVisible(false);
        if (userNtxt.getText().equals("  Enter Username")) {
            userNtxt.setText("");
            userNtxt.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_userNtxtFocusGained

    private void passWtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passWtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passWtxtActionPerformed

    
    
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLb;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passWtxt;
    private javax.swing.JTextField userNtxt;
    // End of variables declaration//GEN-END:variables
}
