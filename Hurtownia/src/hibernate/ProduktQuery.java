/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
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

    
      public List<Produkty> ProduktySelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Produkty.class);
        List<Produkty> produkt = criteria.list();
        session.close();
        return produkt;
    }
      
       public List<Produkty> produktySelectAllOnID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Produkty where KategoriaId = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Produkty> produkty = query.list();
        session.close();
        int i = 0;
        for(Produkty p : produkty){
            if(p.getKategorie().getKategoriaId() != id){
                produkty.remove(i);
            }
            i++;
        }
        return produkty;
        
      
    }
     
}
