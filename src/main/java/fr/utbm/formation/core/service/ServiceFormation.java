/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.service;

import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.entity.Location;
import fr.utbm.formation.core.repository.CourseDAO;
import fr.utbm.formation.core.repository.CourseSessionDAO;
import fr.utbm.formation.core.repository.LocationDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean- Jacques
 */
public class ServiceFormation {

    public void filterFormation(int type, String filtre) {
        /*  type 1: mot clé dans titre
            type 2: par date
            type 3: par lieux
         */
        switch (type) {
            case 1:
                CourseDAO formation = new CourseDAO();
                formation.searchCourse(filtre);
                break;
            case 2:
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date filterDate;
                try {
                    filterDate = formatter.parse(filtre);
                    CourseSessionDAO cs = new CourseSessionDAO();
                    cs.searchCourseSession(filterDate);
                } catch (ParseException ex) {
                    Logger.getLogger(ServiceFormation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case 3:
        }

    }

    public void registerCourse(Course f,CourseSession cs, Location loc) {
        CourseDAO formation = new CourseDAO();
        CourseSessionDAO csS = new CourseSessionDAO();
        LocationDAO lc = new LocationDAO();
        if (!formation.isExist(f.getCode())){
        formation.addCourse(f);
        }
        if(!loc.getCity().isEmpty() && !lc.isExist(loc.getId())){
           lc.addLocation(loc);
        }
        
        if(!cs.getCourseCode().isEmpty() && !csS.isExist(cs.getIdSession())){
           csS.addCourseSession(cs);
        }
        
    }
    
}
