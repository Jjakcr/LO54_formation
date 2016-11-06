/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.repository;

import fr.utbm.formation.core.entity.Location;
import fr.utbm.formation.core.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
