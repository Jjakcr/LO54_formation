/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.tools;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jean- Jacques
 */
public class JasperUtil {
DefaultTableModel tableModel;
    public JasperUtil(List list, OutputStream outStream) {
        JasperPrint jasperPrint = null;
        
        JRBeanCollectionDataSource myBean = new JRBeanCollectionDataSource(list,false);
        try {
            String x=JasperCompileManager.compileReportToFile("D:\\netbeanLO54\\Data\\NetBeansProjects\\lo54\\reports\\Liste des formations.jrxml");
            jasperPrint = JasperFillManager.fillReport(x, new HashMap(),myBean);
            //JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            //jasperViewer.setVisible(true);
            //JasperViewer.viewReport(jasperPrint);
            
           
          JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }
       
    
 
}




