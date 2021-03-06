/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.service;

import fr.utbm.formation.core.entity.Client;
import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.entity.Location;
import fr.utbm.formation.core.repository.ClientDAO;
import fr.utbm.formation.core.repository.CourseDAO;
import fr.utbm.formation.core.repository.CourseSessionDAO;
import fr.utbm.formation.core.repository.LocationDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean- Jacques
 */
public class ServiceFormation {

    public List filterFormation(int type, String filtre) {
        /*  type 1: mot clé dans titre
            type 2: par date
            type 3: par lieux
         */
        List result = null;
        switch (type) {
            case 1:
                CourseDAO formation = new CourseDAO();
                result = formation.searchCourseCS(filtre);
                break;
            case 2:
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date filterDate;
                try {
                    filterDate = formatter.parse(filtre);
                    CourseSessionDAO cs = new CourseSessionDAO();
                    result = cs.searchCourseSession(filterDate);
                } catch (ParseException ex) {
                    Logger.getLogger(ServiceFormation.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case 3:
                LocationDAO loc = new LocationDAO();
                result = loc.searchLocation(filtre);
                break;
            default:
                result = this.getAllFormationSession();
                break;
        }
        return result;
    }

    public void registerCourse(Course f, Location loc) {
        CourseDAO formation = new CourseDAO();
        LocationDAO lc = new LocationDAO();
        if (!formation.isExist(f.getCode())) {
            formation.addCourse(f);
        }
        if (!loc.getCity().isEmpty() && !lc.isExist(loc.getId())) {
            lc.addLocation(loc);
        }
    }

    public void resgisterCourseSession(CourseSession csS) {
        CourseSessionDAO csSD = new CourseSessionDAO();
        csSD.addCourseSession(csS);
    }

    public List getAllFormation() {
        CourseDAO formation = new CourseDAO();
        //CourseSessionDAO csS = new CourseSessionDAO();
        //LocationDAO lc = new LocationDAO();
        return formation.getAllCourse();
    }

    /* 
    getAllFormationSession() = display all registered trainings
    from COURSE_SESSION table (hql : courssession)
     */
    public List getAllFormationSession() {
        CourseSessionDAO csS = new CourseSessionDAO();
        return csS.getAllCourseSession();
    }

    public List getAllFormationLoc() {
        LocationDAO loc = new LocationDAO();
        return loc.getAllLocation();
    }

    public boolean subscribe(String lastname, String firstname, String address, String phone, String email, String idSession) {
        Client cl = new Client(lastname, firstname, address, phone, email);
        CourseSessionDAO getCsS = new CourseSessionDAO();
        cl.setCourseSession(getCsS.getCourseSessionById(idSession));
        ClientDAO clD = new ClientDAO();
        return clD.addClient(cl);
    }

    public List getMyFormations(String email) {
        ClientDAO clD = new ClientDAO();
        return clD.getFormation(email);
    }
}
