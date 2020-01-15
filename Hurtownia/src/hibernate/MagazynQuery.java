/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author monika
 */
public class MagazynQuery {
    
       Session session = null;
    Query query = null;
    Criteria criteria = null;
    
     public List<Magazyn> produktySelectAllOnID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Magazyn where ProduktID = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Magazyn> produkt = query.list();
        session.close();
        int i = 0;
        for(Magazyn m : produkt){
            if(m.getProdukty().getProduktId() != id){
                produkt.remove(i);
            }
            i++;
        }
        return produkt;
        
      
    }
     
     
      public List<Magazyn> MagazynSelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Magazyn.class);
        List<Magazyn> magazyn = criteria.list();
        session.close();
        return magazyn;
    }
    
}
