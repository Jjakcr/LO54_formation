/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.repository;

import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.tools.HibernateUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jean- Jacques
 */
public class CourseSessionDAO {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;

    public boolean isExist(int crit) {
        String hql = "FROM CourseSession where idSession="+crit;
        Query query = session.createQuery(hql); //methode HQL
        List result= query.list();
        return !result.isEmpty();
        
    }

    public void addCourseSession(CourseSession cs) {
        
        
        try {

            tx = session.beginTransaction();
            session.save(cs);
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

    public List searchCourseSession(Date filterDate) {
        //requète par critère
        
        Criteria crit = session.createCriteria(CourseSession.class);
        crit.setMaxResults(10);
        crit.add(Restrictions.eq("startDate", filterDate));
        List <CourseSession> result = crit.list();
        return result;

    }
    
    public List getAllCourseSession() {
        
            List <CourseSession> result = null;
          try {
            tx = session.beginTransaction();
            String hql = "FROM CourseSession";
            Query query = session.createQuery(hql); //methode HQL
            result = query.list();
        
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
        return result; 
    }
}
