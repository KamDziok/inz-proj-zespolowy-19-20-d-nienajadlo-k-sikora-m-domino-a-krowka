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

/**
 *
 * @author monika
 */
public class MagazynQuery {
    
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    /**
     * 
     * @param id - products identifier
     * @return all products from database selected by id
     */
    
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
     
     
     /**
      * use this method to get all avaiable stores from DB
      * 
      * @return all avaiables stores from database 
      */
     
      public List<Magazyn> MagazynSelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Magazyn.class);
        List<Magazyn> magazyn = criteria.list();
        session.close();
        return magazyn;
    }
      
      public void zmianaIlosci (int id, int ilosc){
          session = HibernateUtil.getSessionFactory().openSession();
      
            String query = "UPDATE `magazyn` SET";
            
            if(!query.equals("UPDATE `magazyn` SET"))
            query+=",";
            
             if(ilosc > 0){
        if(!query.equals("UPDATE `magazyn` SET"))
            query+=",";
         
           Magazyn magazyn;
            magazyn = (Magazyn)session.get(Magazyn.class, id);
         
             int iloscS = magazyn.getIlosc();
             int iloscZ = iloscS - ilosc;
        
            
            query = query+" `Ilosc` = '" + iloscZ + "'";
            
        }
             
             query = query + " WHERE `ProduktId` = " + id;
              try {
            session.getTransaction().begin();
            session.createSQLQuery(query).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException error){
            session.getTransaction().rollback();
            session.close();
        }
      }
      
}
