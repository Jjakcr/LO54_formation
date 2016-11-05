/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.service;

import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.repository.CourseDAO;

/**
 *
 * @author Jean- Jacques
 */
public class ServiceFormation {
    
    public void filterFormation (int type, String filtre){
        /*  type 1: mot clé dans titre
            type 2: par date
            type 3: par lieux
        */
        switch (type){
            case 1:
               CourseDAO formation = new CourseDAO();
               formation.searchCourse(filtre);
            case 2:
                /*parser string en date         
                  CourseSessionDAO cs = new CourseSessionDAO();
                  cs.searchCourseSession(date);
                */
            case 3:
        }
        
       
    }
    
     
    public void registerCourse(Course f){
        CourseDAO formation = new CourseDAO();
        formation.addCourse(f);
        
    }
}
