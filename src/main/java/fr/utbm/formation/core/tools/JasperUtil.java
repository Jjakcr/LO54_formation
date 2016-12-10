/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.tools;

import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jean- Jacques
 */
public class JasperUtil {
DefaultTableModel tableModel;
    public JasperUtil() {
        JasperPrint jasperPrint = null;
        TableModelData();
        try {
            String x=JasperCompileManager.compileReportToFile("reports/Liste des formations.jrxml");
            jasperPrint = JasperFillManager.fillReport(x, new HashMap(),new JRTableModelDataSource(tableModel));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.viewReport(jasperPrint,false);
           
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "report/simple_report.pdf");
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }
        private void TableModelData() {
        String[] columnNames = {"CODE", "TITLE"};
        String[][] data = {
            {"111", "G Conger"},
            {"222", "A Date"},
            {"333", "R Linz"},
            {"444", "V Sethi"},
            
        };
        tableModel = new DefaultTableModel(data, columnNames);
    }
}




