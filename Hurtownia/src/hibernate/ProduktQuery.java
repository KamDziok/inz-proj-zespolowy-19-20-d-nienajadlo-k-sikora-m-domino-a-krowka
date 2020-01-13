/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author monika
 */
public class ProduktQuery {
    
    Session session = null;
    Query query = null;
    Criteria criteria = null;

      public Produkty getProdukt( int ProduktID) {
        Produkty p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Produkty where ProduktID = '" + ProduktID + "'";
        query = session.createQuery(hql);
        p = (Produkty) query.uniqueResult();
        session.close();
        return p;
    }
}
