/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Print {
   public static void printReport(int student_id, Connection con) {
        try {
            // Load the report from the reports folder (adjust the path if needed)
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(Print.class.getResourceAsStream("/reports/result.jasper"));

            if (jasperReport == null) {
                System.err.println("result.jasper file not found!");
                return;
            }

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("student_id", student_id);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);

            JasperViewer.viewReport(jasperPrint, false); // Don't close the app when report closes

        } catch (JRException ex) {
            ex.printStackTrace(); // Print the full exception details
        }
    }
}
