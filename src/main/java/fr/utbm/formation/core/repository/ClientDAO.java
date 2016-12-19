/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.formation.core.repository;

import fr.utbm.formation.core.entity.Client;
import fr.utbm.formation.core.tools.HibernateUtil;
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

        if (!this.isAlreadyInscrit(cl)) {
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
        }
        else {
            return false;
        }
    }

    public boolean isAlreadyInscrit(Client cl) {
        String idCl = Integer.toString(cl.getIdClient());
        String idSCl = Integer.toString(cl.getCourseSession().getIdSession());
        Criteria crit = session.createCriteria(Client.class);
        crit.createAlias("coursesession", "CrsS");
        crit.add(Restrictions.eq("idClient", idCl));
        crit.add(Restrictions.eq("CrsS.idSession", idSCl));
        List result = crit.list();
        return !result.isEmpty();
    }

}
