/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.Reklama;

/**
 *
 * @author monika
 */
public class ReklamaQuery {
    
      Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    
     public void addNewAdvert(int ProduktID, String tytul, 
            String opis, String grafika){
           // throws Exception {
        
        session = HibernateUtil.getSessionFactory().openSession();
        
         Date date = new Date();
    String data= new SimpleDateFormat("yyyy-MM-dd").format(date);
    
        String query = "INSERT INTO `reklama`(`ReklamaID`, `Tytul`, `Data`,"
                + " `Opis`, `Grafika`, `ProduktID`) VALUES (NULL , '"
            +tytul + "', '" + data +"', '" +opis +"', '" +grafika+"', '" + 
                ProduktID +"')";
          
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
     
        public void removeAdvert(int ReklamaID)
            throws Exception {
        
        Produkty lastProduct = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
    
        String query = "DELETE FROM `reklama` WHERE `reklama`.`ReklamaID` = "
                + ReklamaID;
          
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
        
         public List<Reklama> ReklamaSelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Reklama.class);
        List<Reklama> reklama = criteria.list();
        session.close();
        return reklama;
    }
         
        public Reklama wyszukiwanieID (int id) {
        Reklama r = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Reklama where ProduktId ='" + id + "'" ;
        query = session.createQuery(hql);
        r = (Reklama) query.uniqueResult();
        session.close();

        return r;
    }
               
        public Reklama wyszukiwanieIDR (int id) {
        Reklama r = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Reklama where ReklamaId ='" + id + "'" ;
        query = session.createQuery(hql);
        r = (Reklama) query.uniqueResult();
        session.close();

        return r;
    }
             public void changeAdvert(int id, String tytul, String opis) {
        session = HibernateUtil.getSessionFactory().openSession();
      
        try {
           session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Reklama reklam= (Reklama)session.get(Reklama.class, id);
            reklam.setTytul(tytul);
            reklam.setOpis(opis);
           
           session.getTransaction().commit();
           

        } catch(Exception sqlException) {
            if(null != session.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
    
}
             }
}