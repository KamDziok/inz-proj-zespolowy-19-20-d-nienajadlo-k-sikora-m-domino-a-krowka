/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
}