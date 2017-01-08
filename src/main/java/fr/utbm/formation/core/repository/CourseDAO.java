/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.repository;

import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

    public boolean isExist(String crit) {
        String hql = "FROM Course where CODE='" + crit + "'";
        Query query = session.createQuery(hql); //methode HQL
        List result = query.list();
        return !result.isEmpty();
    }

    public List searchCourse(String filtre) {
        List<Course> result = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Course where lower(TITLE) LIKE lower('%" + filtre + "%')";
            Query query = session.createQuery(hql); //methode HQL
            result = query.list();
            tx.commit();
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

    public List searchCourseCS(String filtre) {
        Criteria crit = session.createCriteria(CourseSession.class);
        crit.createAlias("course", "Crs");
        crit.add(Restrictions.like("Crs.title", "%" + filtre + "%").ignoreCase());
        List<CourseSession> result = crit.list();
        return result;
    }

    public List getAllCourse() {

        List<Course> result = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Course";
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
