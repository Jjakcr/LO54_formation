/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.repository;

import fr.utbm.formation.core.entity.Client;
import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.tools.HibernateUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jean- Jacques
 */
public class ClientDAO {

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;

    public boolean addClient(Client cl) {

        if (!this.isAlreadySubscribed(cl)) {
            try {

                tx = session.beginTransaction();
                session.save(cl);
                tx.commit();

            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                    e.printStackTrace();
                }
            } finally {
                session.close();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlreadySubscribed(Client cl) {
        String adCl = cl.getEmail();
        int idSCl = cl.getCourseSession().getIdSession();
        Criteria crit = session.createCriteria(Client.class);
        crit.createAlias("courseSession", "CrsS");
        crit.add(Restrictions.and(Restrictions.eq("email", adCl), (Restrictions.eq("CrsS.idSession", idSCl))));
        List<Client> result = crit.list();
        return !result.isEmpty();
    }

    public List getFormation(String email) {
        List<CourseSession> result = new LinkedList();
        Criteria crit = session.createCriteria(Client.class);
        //crit.setMaxResults(10); partie de la mise en place des bouton next et prev 
        crit.add(Restrictions.eq("email", email));
        List<Client> preresult = crit.list();
        for (Iterator iterator = preresult.iterator(); iterator.hasNext();) {
            Client cl = (Client) iterator.next();

            result.add(cl.getCourseSession());
        }

        return result;

    }

}
