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
public class ZamowienieQuery {
    
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    public List<Zamowienie> zamowieniaID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Zamowienie where KlientId = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Zamowienie> zamow = query.list();
        session.close();
        int i = 0;
        for(Zamowienie z : zamow){
            if(z.getKlientID() != id){
                zamow.remove(i);
            }
            i++;
        }
        return zamow;
    
}
      public void changeStatus(int id, String statusZ, String statusT) {
        session = HibernateUtil.getSessionFactory().openSession();
      
       
           session = HibernateUtil.getSessionFactory().openSession();
            String query = "UPDATE `zamowienie` SET";
            
            if(!query.equals("UPDATE `zamowienie` SET"))
            query+=",";
            
            if(statusZ.length() > 0) {
                query = query + " `StatusZaplaty` = '" + statusZ + "'";
            }
            
             if(statusT.length() > 0){
        if(!query.equals("UPDATE `zamowienie` SET"))
            query+=",";
            query = query+" `StatusTransportu` = '" + statusT + "'";
        }
             
             query = query + " WHERE " + " `ZamowienieId` = " + id;
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
        
           // session.beginTransaction();
            //Zamowienie zamowienia = (Zamowienie)session.get(Zamowienie.class, id);
            //zamowienia.setStatusZaplaty(statusZ);
            //zamowienia.setStatusTransportu(statusT);
           
           //session.getTransaction().commit();
           

      //  } catch(Exception sqlException) {
           // if(null != session.getTransaction()) {
            //    session.getTransaction().rollback();
         ///   }
          //  sqlException.printStackTrace();
     //   } finally {
           // if(session != null) {
             //   session.close();
           // }
    
}
             }
    

