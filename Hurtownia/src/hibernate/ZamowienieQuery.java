/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Date;
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
    
    
      public Date getOrderDate(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Zamowienie where ZamowienieId = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Zamowienie> zamow = query.list();
        session.close();
        int i = 0;
        Date date = zamow.get(0).getData();
        return date;
    }
    
    
    public List<Zamowienie> zamowieniaIDBezOczekujace(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Zamowienie where KlientId = '" + id 
                + "' AND StatusTransportu != 'oczekujące'";
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
    
    public List<Zamowienie> zamowienaPrzedWyslaniem(){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Zamowienie where StatusTransportu = 'oczekujące' OR StatusTransportu = 'w trakcie realizacji'";
        Query query = session.createQuery(hql);
        List <Zamowienie> zamow = query.list();
        session.close();
        return zamow;
    
}
    
    public List<Zamowienie> wszystkieZamowienia(){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Zamowienie";
        Query query = session.createQuery(hql);
        List <Zamowienie> zamow = query.list();
        session.close();
        return zamow;
    
}
      public void changeStatus(int id, String statusZ) {
        session = HibernateUtil.getSessionFactory().openSession();
      
       try{
        
            session.beginTransaction();
           Zamowienie zamowienia = (Zamowienie)session.get(Zamowienie.class, id);
           zamowienia.setStatusZaplaty(statusZ);
            //zamowienia.setStatusTransportu(statusT);
           
          session.getTransaction().commit();
           

      } catch(Exception sqlException) {
           if(null != session.getTransaction()) {
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
    

