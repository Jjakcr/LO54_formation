/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.repository;

import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.entity.Location;
import fr.utbm.formation.core.tools.HibernateUtil;
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
public class LocationDAO {
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;

    public void addLocation(Location lc) {

        try {

            tx = session.beginTransaction();
            session.save(lc);
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
    
     public boolean isExist(int crit){
        String hql = "FROM Location where ID="+crit;
        Query query = session.createQuery(hql); //methode HQL
        List result= query.list();
        return !result.isEmpty();
    }
     
    public List searchLocation( String loc){
        Criteria crit = session.createCriteria(CourseSession.class);
        crit.setMaxResults(10);
        crit.createAlias("location", "Loc");

        crit.add(Restrictions.eq("Loc.city", loc));
        List <CourseSession> result = crit.list();
        return result;
     }
}
