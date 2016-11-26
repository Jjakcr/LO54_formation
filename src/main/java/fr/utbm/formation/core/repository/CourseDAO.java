/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.repository;

import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.tools.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jean- Jacques
 */
public class CourseDAO {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;

    public void addCourse(Course c) {

        try {

            tx = session.beginTransaction();
            session.save(c);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        System.out.print("Formation Crée");
    }
    
    public boolean isExist(String crit){
       String hql = "FROM Course where CODE='"+crit+"'";
        Query query = session.createQuery(hql); //methode HQL
        List result= query.list();
        return !result.isEmpty();
    }

    public void searchCourse(String filtre) {

        try {
            tx = session.beginTransaction();
            String hql = "FROM Course where TITLE LIKE '%" + filtre + "%'";
            Query query = session.createQuery(hql); //methode HQL
            List result = query.list();
            for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                Course c = (Course) iterator.next();
                System.out.print("Code: " + c.getCode());
                System.out.print("Title :" + c.getTitle());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }

    }

    public void getAllCourse() {
          try {
            tx = session.beginTransaction();
            String hql = "FROM Course";
            Query query = session.createQuery(hql); //methode HQL
            List result = query.list();
           
            tx.commit();
            //return result; 
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        
    }


}
