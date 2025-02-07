package managment;

import com.sun.jdi.connect.spi.Connection;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import project.ConnectionProvider;
import java.sql.*;
import javax.swing.JComboBox;
import managment.Classrooms;
import managment.Courses;
import managment.Results;
import managment.Students;
import managment.Teachers;
import managment.login;

public class main extends javax.swing.JFrame {

    CardLayout cardLayout1;
    
    
    public main() {
        initComponents();
        refreshTable();
        updateScheduleId();
        populateComboBoxes();
        refreshDashboardCounts();
        
        pageNameTxt.setText("EduM / Dashboard");
        
        cardLayout1 = new CardLayout();
        cardPanel.setLayout(cardLayout1);
        
        Students students = new Students();
        cardPanel.add(students, "Students");
        
        Teachers teachers = new Teachers();
        cardPanel.add(teachers, "Teacher");
        
        Courses courses = new Courses();
        cardPanel.add(courses, "Courses");
        
        Results results = new Results();
        cardPanel.add(results, "Results");
        
        Classrooms classrooms = new Classrooms();
        cardPanel.add(classrooms, "Classroom");
        
        cardPanel.add(dashbPanel, "Dashboard");
        cardLayout1.show(cardPanel, "Dashboard");
    }
    
    private void refreshDashboardCounts() {
    try (java.sql.Connection con = ConnectionProvider.getCon();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM Students")) {
        
        // Get total student count
        try (PreparedStatement psStudents = con.prepareStatement("SELECT COUNT(*) FROM Students");
             ResultSet rsStudents = psStudents.executeQuery()) {
            if (rsStudents.next()) {
                studentCountTxt.setText(String.valueOf(rsStudents.getInt(1)));
            } else {
                studentCountTxt.setText("0"); // Handle case where no students are found
            }
        }

        // Get total teacher count
        try (PreparedStatement psTeachers = con.prepareStatement("SELECT COUNT(*) FROM Teachers");
             ResultSet rsTeachers = psTeachers.executeQuery()) {
            if (rsTeachers.next()) {
                StaffCountTxt.setText(String.valueOf(rsTeachers.getInt(1)));
            } else {
                StaffCountTxt.setText("0");
            }
        }

        // Get total course count
        try (PreparedStatement psCourses = con.prepareStatement("SELECT COUNT(*) FROM Courses");
             ResultSet rsCourses = psCourses.executeQuery()) {
            if (rsCourses.next()) {
                courseCountTxt.setText(String.valueOf(rsCourses.getInt(1)));
            } else {
                courseCountTxt.setText("0");
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error refreshing dashboard counts: " + e.getMessage());
        e.printStackTrace();
    }
}
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing table data

        try (java.sql.Connection con = ConnectionProvider.getCon();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM Schedules")) { // Original query

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("schedule_id"),
                getTeacherName(rs.getInt("teacher_id")), // Call method directly
                getCourseName(rs.getInt("course_id")),   // Call method directly
                getClassroomName(rs.getInt("classroom_id")) // Call method directly
            });
        }
        System.out.println("Table refreshed successfully!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error refreshing table: " + e.getMessage());
        e.printStackTrace();
    }
    }
    
    private String getTeacherName(int teacherId) { // No Connection parameter
    try (java.sql.Connection con = ConnectionProvider.getCon(); // Get connection here
         PreparedStatement ps = con.prepareStatement("SELECT name FROM Teachers WHERE teacher_id = ?")) {
        ps.setInt(1, teacherId);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("name");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
    return ""; // Return empty string if not found
    }
    
    private String getCourseName(int courseId) { // No Connection parameter
    try (java.sql.Connection con = ConnectionProvider.getCon();
         PreparedStatement ps = con.prepareStatement("SELECT course_name FROM Courses WHERE course_id = ?")) {
        ps.setInt(1, courseId);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("course_name");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "";
    }
    
    private String getClassroomName(int classroomId) { // No Connection parameter
    try (java.sql.Connection con = ConnectionProvider.getCon();
         PreparedStatement ps = con.prepareStatement("SELECT classroom_name FROM Classrooms WHERE classroom_id = ?")) {
        ps.setInt(1, classroomId);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("classroom_name");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "";
    }
    
    
    private void updateScheduleId() {
        try {
            java.sql.Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT MAX(schedule_id) FROM Schedules");
            if (rs.next()) {
                int schedule_id = rs.getInt(1) + 1;
                SchIdTxt.setText(String.valueOf(schedule_id));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void populateComboBoxes() {
        try {
            java.sql.Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();

            // Populate Teachers ComboBox
            ResultSet rsTeachers = st.executeQuery("SELECT name FROM Teachers");
            while (rsTeachers.next()) {
                TchComboBox.addItem(rsTeachers.getString("name"));
            }

            // Populate Courses ComboBox
            ResultSet rsCourses = st.executeQuery("SELECT course_name FROM Courses");
            while (rsCourses.next()) {
                CsComboBox.addItem(rsCourses.getString("course_name"));
            }

            // Populate Classrooms ComboBox
            ResultSet rsClassrooms = st.executeQuery("SELECT classroom_name FROM Classrooms");
            while (rsClassrooms.next()) {
                hallComboBox.addItem(rsClassrooms.getString("classroom_name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        dashbPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TchComboBox = new javax.swing.JComboBox<>();
        CsComboBox = new javax.swing.JComboBox<>();
        hallComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        SchAddBtn = new javax.swing.JButton();
        SchUpBtn = new javax.swing.JButton();
        SchDltBtn = new javax.swing.JButton();
        SchIDTxt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SeachSchIdTxt = new javax.swing.JTextField();
        SchSearchBtn = new javax.swing.JButton();
        SchReBtn = new javax.swing.JButton();
        SchIdTxt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        studentCountTxt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        StaffCountTxt = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        courseCountTxt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameTag = new javax.swing.JLabel();
        pageNameTxt = new javax.swing.JLabel();
        navBarPanel = new javax.swing.JPanel();
        logoLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        stdntBtn = new javax.swing.JLabel();
        tchrBtn = new javax.swing.JLabel();
        dashBtn = new javax.swing.JLabel();
        coursBtn = new javax.swing.JLabel();
        resltBtn = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        clsBtn = new javax.swing.JLabel();
        navBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1450, 676));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(224, 224, 255));
        mainPanel.setLayout(null);

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close 1.png"))); // NOI18N
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        mainPanel.add(closeBtn);
        closeBtn.setBounds(1136, 0, 34, 31);

        cardPanel.setBackground(new java.awt.Color(204, 255, 204));
        cardPanel.setLayout(new java.awt.CardLayout());

        dashbPanel.setBackground(new java.awt.Color(204, 255, 255));
        dashbPanel.setLayout(null);

        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule_id", "Teacher", "Course", "Class"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 800, 430);

        dashbPanel.add(jPanel1);
        jPanel1.setBounds(30, 210, 800, 430);

        jLabel2.setText("Class");
        dashbPanel.add(jLabel2);
        jLabel2.setBounds(860, 480, 120, 16);

        jLabel3.setText("Teacher");
        dashbPanel.add(jLabel3);
        jLabel3.setBounds(860, 330, 110, 16);

        jLabel4.setText("Course");
        dashbPanel.add(jLabel4);
        jLabel4.setBounds(860, 400, 110, 16);

        dashbPanel.add(TchComboBox);
        TchComboBox.setBounds(860, 350, 290, 22);

        dashbPanel.add(CsComboBox);
        CsComboBox.setBounds(860, 420, 290, 22);

        hallComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        dashbPanel.add(hallComboBox);
        hallComboBox.setBounds(860, 500, 290, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setText("Today Schedule");
        dashbPanel.add(jLabel5);
        jLabel5.setBounds(30, 170, 190, 26);

        SchAddBtn.setText("Add");
        SchAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchAddBtnActionPerformed(evt);
            }
        });
        dashbPanel.add(SchAddBtn);
        SchAddBtn.setBounds(860, 590, 75, 23);

        SchUpBtn.setText("Update");
        SchUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchUpBtnActionPerformed(evt);
            }
        });
        dashbPanel.add(SchUpBtn);
        SchUpBtn.setBounds(970, 590, 75, 23);

        SchDltBtn.setText("Detele");
        SchDltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchDltBtnActionPerformed(evt);
            }
        });
        dashbPanel.add(SchDltBtn);
        SchDltBtn.setBounds(1070, 590, 75, 23);
        dashbPanel.add(SchIDTxt);
        SchIDTxt.setBounds(880, 280, 0, 0);

        jLabel7.setText("Schedule ID :");
        dashbPanel.add(jLabel7);
        jLabel7.setBounds(860, 220, 90, 20);
        dashbPanel.add(SeachSchIdTxt);
        SeachSchIdTxt.setBounds(960, 220, 30, 22);

        SchSearchBtn.setText("Search");
        SchSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchSearchBtnActionPerformed(evt);
            }
        });
        dashbPanel.add(SchSearchBtn);
        SchSearchBtn.setBounds(1040, 220, 110, 23);

        SchReBtn.setText("Reset Fields");
        SchReBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SchReBtnActionPerformed(evt);
            }
        });
        dashbPanel.add(SchReBtn);
        SchReBtn.setBounds(1040, 260, 110, 23);

        SchIdTxt.setText("00");
        dashbPanel.add(SchIdTxt);
        SchIdTxt.setBounds(860, 280, 12, 16);

        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student Count");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 10, 130, 26);

        studentCountTxt.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        studentCountTxt.setForeground(new java.awt.Color(255, 255, 255));
        studentCountTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentCountTxt.setText("00");
        jPanel2.add(studentCountTxt);
        studentCountTxt.setBounds(163, 36, 90, 60);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradiant 2.jpg"))); // NOI18N
        jPanel2.add(jLabel10);
        jLabel10.setBounds(-7, 1, 280, 110);

        dashbPanel.add(jPanel2);
        jPanel2.setBounds(30, 30, 270, 110);

        jPanel3.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Staff");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(10, 10, 130, 26);

        StaffCountTxt.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        StaffCountTxt.setForeground(new java.awt.Color(255, 255, 255));
        StaffCountTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StaffCountTxt.setText("00");
        jPanel3.add(StaffCountTxt);
        StaffCountTxt.setBounds(163, 36, 90, 60);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradiant 2.jpg"))); // NOI18N
        jPanel3.add(jLabel6);
        jLabel6.setBounds(-7, 1, 280, 110);

        dashbPanel.add(jPanel3);
        jPanel3.setBounds(470, 30, 270, 110);

        jPanel4.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Courses");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(10, 10, 130, 26);

        courseCountTxt.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        courseCountTxt.setForeground(new java.awt.Color(255, 255, 255));
        courseCountTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseCountTxt.setText("00");
        jPanel4.add(courseCountTxt);
        courseCountTxt.setBounds(163, 36, 90, 60);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradiant 2.jpg"))); // NOI18N
        jPanel4.add(jLabel8);
        jLabel8.setBounds(0, 0, 270, 110);

        dashbPanel.add(jPanel4);
        jPanel4.setBounds(870, 30, 270, 110);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradiant 3.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        dashbPanel.add(jLabel9);
        jLabel9.setBounds(-3, -4, 1180, 680);

        cardPanel.add(dashbPanel, "card2");

        mainPanel.add(cardPanel);
        cardPanel.setBounds(0, 30, 1170, 670);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username :");
        mainPanel.add(jLabel1);
        jLabel1.setBounds(980, 0, 80, 30);

        usernameTag.setBackground(new java.awt.Color(204, 204, 204));
        usernameTag.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usernameTag.setForeground(new java.awt.Color(102, 102, 102));
        usernameTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameTag.setText("Admin");
        mainPanel.add(usernameTag);
        usernameTag.setBounds(1060, 0, 60, 30);

        pageNameTxt.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        pageNameTxt.setForeground(new java.awt.Color(102, 102, 102));
        mainPanel.add(pageNameTxt);
        pageNameTxt.setBounds(10, 0, 470, 30);

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 0, 1170, 700));

        navBarPanel.setBackground(new java.awt.Color(255, 255, 255));
        navBarPanel.setLayout(null);

        logoLbl.setFont(new java.awt.Font("Imprint MT Shadow", 1, 60)); // NOI18N
        logoLbl.setForeground(new java.awt.Color(255, 255, 255));
        logoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLbl.setText("#");
        navBarPanel.add(logoLbl);
        logoLbl.setBounds(10, 20, 60, 50);

        nameLbl.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(255, 255, 255));
        nameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLbl.setText("EduM");
        navBarPanel.add(nameLbl);
        nameLbl.setBounds(0, 20, 260, 50);

        stdntBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        stdntBtn.setForeground(new java.awt.Color(255, 255, 255));
        stdntBtn.setText("Students");
        stdntBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stdntBtnMouseClicked(evt);
            }
        });
        navBarPanel.add(stdntBtn);
        stdntBtn.setBounds(30, 190, 230, 20);

        tchrBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tchrBtn.setForeground(new java.awt.Color(255, 255, 255));
        tchrBtn.setText("Teachers");
        tchrBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tchrBtnMouseClicked(evt);
            }
        });
        navBarPanel.add(tchrBtn);
        tchrBtn.setBounds(30, 230, 230, 20);

        dashBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        dashBtn.setForeground(new java.awt.Color(255, 255, 255));
        dashBtn.setText("Dashboard");
        dashBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashBtnMouseClicked(evt);
            }
        });
        navBarPanel.add(dashBtn);
        dashBtn.setBounds(30, 150, 230, 20);

        coursBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        coursBtn.setForeground(new java.awt.Color(255, 255, 255));
        coursBtn.setText("Courses");
        coursBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coursBtnMouseClicked(evt);
            }
        });
        navBarPanel.add(coursBtn);
        coursBtn.setBounds(30, 270, 230, 20);

        resltBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        resltBtn.setForeground(new java.awt.Color(255, 255, 255));
        resltBtn.setText("Results");
        resltBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resltBtnMouseClicked(evt);
            }
        });
        navBarPanel.add(resltBtn);
        resltBtn.setBounds(30, 310, 230, 20);

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 51, 51));
        logoutBtn.setText("Logout");
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });
        navBarPanel.add(logoutBtn);
        logoutBtn.setBounds(30, 660, 230, 20);

        clsBtn.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        clsBtn.setForeground(new java.awt.Color(255, 255, 255));
        clsBtn.setText("Class rooms");
        clsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clsBtnMouseClicked(evt);
            }
        });
        navBarPanel.add(clsBtn);
        clsBtn.setBounds(30, 350, 230, 20);

        navBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gradiant 1.jpg"))); // NOI18N
        navBarPanel.add(navBg);
        navBg.setBounds(0, 0, 264, 700);

        getContentPane().add(navBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int  a = JOptionPane.showConfirmDialog(null,"Do you really want to Exit","Select",JOptionPane.YES_NO_OPTION);
        if (a==0) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_closeBtnActionPerformed

    private void stdntBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stdntBtnMouseClicked
        cardLayout1.show(cardPanel, "Students");
        pageNameTxt.setText("EduM / Students");
        
    }//GEN-LAST:event_stdntBtnMouseClicked

    private void dashBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashBtnMouseClicked
        cardLayout1.show(cardPanel, "Dashboard");
        pageNameTxt.setText("EduM / Dashboard");
        refreshDashboardCounts();
    }//GEN-LAST:event_dashBtnMouseClicked

    private void tchrBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tchrBtnMouseClicked
        cardLayout1.show(cardPanel, "Teacher");
        pageNameTxt.setText("EduM / Teacher");
    }//GEN-LAST:event_tchrBtnMouseClicked

    private void coursBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursBtnMouseClicked
        cardLayout1.show(cardPanel, "Courses");
        pageNameTxt.setText("EduM / Courses");
    }//GEN-LAST:event_coursBtnMouseClicked

    private void resltBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resltBtnMouseClicked
        cardLayout1.show(cardPanel, "Results");
        pageNameTxt.setText("EduM / Results");
    }//GEN-LAST:event_resltBtnMouseClicked

    private void clsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsBtnMouseClicked
        cardLayout1.show(cardPanel, "Classroom");
        pageNameTxt.setText("EduM / Classroom");
    }//GEN-LAST:event_clsBtnMouseClicked

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        int  a = JOptionPane.showConfirmDialog(null,"Do you really want to Logout","Select",JOptionPane.YES_NO_OPTION);
        if (a==0) {
            setVisible(false);
            new login().setVisible(true);
        } 
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void SchSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchSearchBtnActionPerformed
        int checkid = 0;
        String id = SeachSchIdTxt.getText();
        try {
            java.sql.Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Schedules WHERE schedule_id='" + id + "'");
            while (rs.next()) {
                checkid = 1;
                SeachSchIdTxt.setEditable(false);

                // Fetch teacher, course, and classroom names
                PreparedStatement psTeacher = con.prepareStatement("SELECT name FROM Teachers WHERE teacher_id = ?");
                psTeacher.setInt(1, rs.getInt("teacher_id"));
                ResultSet rsTeacher = psTeacher.executeQuery();
                if (rsTeacher.next()) {
                    TchComboBox.setSelectedItem(rsTeacher.getString("name"));
                }

                PreparedStatement psCourse = con.prepareStatement("SELECT course_name FROM Courses WHERE course_id = ?");
                psCourse.setInt(1, rs.getInt("course_id"));
                ResultSet rsCourse = psCourse.executeQuery();
                if (rsCourse.next()) {
                    CsComboBox.setSelectedItem(rsCourse.getString("course_name"));
                }

                PreparedStatement psClassroom = con.prepareStatement("SELECT classroom_name FROM Classrooms WHERE classroom_id = ?");
                psClassroom.setInt(1, rs.getInt("classroom_id"));
                ResultSet rsClassroom = psClassroom.executeQuery();
                if (rsClassroom.next()) {
                    hallComboBox.setSelectedItem(rsClassroom.getString("classroom_name"));
                }
            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "Schedule ID does not Exist");
            }
            SchAddBtn.setVisible(false); // Hide the Add button
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_SchSearchBtnActionPerformed

    private void SchReBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchReBtnActionPerformed
        SeachSchIdTxt.setText("");
        TchComboBox.setSelectedIndex(0);
        CsComboBox.setSelectedIndex(0);
        hallComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_SchReBtnActionPerformed

    private void SchAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchAddBtnActionPerformed
        String schedule_id = SchIdTxt.getText();
        String teacher_name = (String) TchComboBox.getSelectedItem();
        String course_name = (String) CsComboBox.getSelectedItem();
        String classroom_name = (String) hallComboBox.getSelectedItem();

        if (teacher_name.isEmpty() || course_name.isEmpty() || classroom_name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }
        
        try {
            java.sql.Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            
            PreparedStatement psTeacher = con.prepareStatement("SELECT teacher_id FROM Teachers WHERE name = ?");
            psTeacher.setString(1, teacher_name);
            ResultSet rsTeacher = psTeacher.executeQuery();
            int teacher_id = rsTeacher.next() ? rsTeacher.getInt("teacher_id") : -1;

            // Get course_id from course_name
            PreparedStatement psCourse = con.prepareStatement("SELECT course_id FROM Courses WHERE course_name = ?");
            psCourse.setString(1, course_name);
            ResultSet rsCourse = psCourse.executeQuery();
            int course_id = rsCourse.next() ? rsCourse.getInt("course_id") : -1;

            // Get classroom_id from classroom_name
            PreparedStatement psClassroom = con.prepareStatement("SELECT classroom_id FROM Classrooms WHERE classroom_name = ?");
            psClassroom.setString(1, classroom_name);
            ResultSet rsClassroom = psClassroom.executeQuery();
            int classroom_id = rsClassroom.next() ? rsClassroom.getInt("classroom_id") : -1;

            // Insert into Schedules table
            PreparedStatement ps = con.prepareStatement("INSERT INTO Schedules (schedule_id, teacher_id, course_id, classroom_id) VALUES (?,?,?,?)");
            ps.setString(1, schedule_id);
            ps.setInt(2, teacher_id);
            ps.setInt(3, course_id);
            ps.setInt(4, classroom_id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully saved");

            refreshTable();
            updateScheduleId();

            SeachSchIdTxt.setText("");
            TchComboBox.setSelectedIndex(0);
            CsComboBox.setSelectedIndex(0);
            hallComboBox.setSelectedIndex(0);

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Schedule already exists!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_SchAddBtnActionPerformed

    private void SchUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchUpBtnActionPerformed
        String schedule_id = SchIdTxt.getText();
        String teacher_name = (String) TchComboBox.getSelectedItem();
        String course_name = (String) CsComboBox.getSelectedItem();
        String classroom_name = (String) hallComboBox.getSelectedItem();

        if (teacher_name.isEmpty() || course_name.isEmpty() || classroom_name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
        }

        try {
            java.sql.Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();

            // Get teacher_id from teacher_name
            PreparedStatement psTeacher = con.prepareStatement("SELECT teacher_id FROM Teachers WHERE name = ?");
            psTeacher.setString(1, teacher_name);
            ResultSet rsTeacher = psTeacher.executeQuery();
            int teacher_id = rsTeacher.next() ? rsTeacher.getInt("teacher_id") : -1;

            // Get course_id from course_name
            PreparedStatement psCourse = con.prepareStatement("SELECT course_id FROM Courses WHERE course_name = ?");
            psCourse.setString(1, course_name);
            ResultSet rsCourse = psCourse.executeQuery();
            int course_id = rsCourse.next() ? rsCourse.getInt("course_id") : -1;

            // Get classroom_id from classroom_name
            PreparedStatement psClassroom = con.prepareStatement("SELECT classroom_id FROM Classrooms WHERE classroom_name = ?");
            psClassroom.setString(1, classroom_name);
            ResultSet rsClassroom = psClassroom.executeQuery();
            int classroom_id = rsClassroom.next() ? rsClassroom.getInt("classroom_id") : -1;

            // Update the schedule
            PreparedStatement ps = con.prepareStatement("UPDATE Schedules SET teacher_id=?, course_id=?, classroom_id=? WHERE schedule_id=?");
            ps.setInt(1, teacher_id);
            ps.setInt(2, course_id);
            ps.setInt(3, classroom_id);
            ps.setString(4, schedule_id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully updated");

            refreshTable();
            updateScheduleId();

            SeachSchIdTxt.setText("");
            TchComboBox.setSelectedIndex(0);
            CsComboBox.setSelectedIndex(0);
            hallComboBox.setSelectedIndex(0);
            SchAddBtn.setVisible(true); // Show the Add button again
            SeachSchIdTxt.setEditable(true); // Make the search field editable again
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Schedule already exists!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_SchUpBtnActionPerformed

    private void SchDltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SchDltBtnActionPerformed
         int a = JOptionPane.showConfirmDialog(null, "Do you really want to Delete?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            String id = SchIdTxt.getText();
            try {
                java.sql.Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
                st.executeUpdate("DELETE FROM Schedules WHERE schedule_id='" + id + "'");
                JOptionPane.showMessageDialog(null, "Successfully Deleted");

                refreshTable();
                updateScheduleId();
                SchAddBtn.setVisible(true); // Show the Add button again
                SeachSchIdTxt.setEditable(true); // Make the search field editable again
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_SchDltBtnActionPerformed

  
    
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CsComboBox;
    private javax.swing.JButton SchAddBtn;
    private javax.swing.JButton SchDltBtn;
    private javax.swing.JLabel SchIDTxt;
    private javax.swing.JLabel SchIdTxt;
    private javax.swing.JButton SchReBtn;
    private javax.swing.JButton SchSearchBtn;
    private javax.swing.JButton SchUpBtn;
    private javax.swing.JTextField SeachSchIdTxt;
    private javax.swing.JLabel StaffCountTxt;
    private javax.swing.JComboBox<String> TchComboBox;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel clsBtn;
    private javax.swing.JLabel coursBtn;
    private javax.swing.JLabel courseCountTxt;
    private javax.swing.JLabel dashBtn;
    private javax.swing.JPanel dashbPanel;
    private javax.swing.JComboBox<String> hallComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logoLbl;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JPanel navBarPanel;
    private javax.swing.JLabel navBg;
    private javax.swing.JLabel pageNameTxt;
    private javax.swing.JLabel resltBtn;
    private javax.swing.JLabel stdntBtn;
    private javax.swing.JLabel studentCountTxt;
    private javax.swing.JLabel tchrBtn;
    private javax.swing.JLabel usernameTag;
    // End of variables declaration//GEN-END:variables
}
