/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author monika
 */
public class KategorieQuery {
    
    Session session = null;
    Criteria criteria = null;
    
    /**
     * 
     * @return all categories of products from database 
     */
    
     public List<Kategorie> KategorieSelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Kategorie.class);
        List<Kategorie> kat = criteria.list();
        session.close();
        return kat;
    }
     
     public void nowaKategoria(String nazwa,String opis){
         String query= "INSERT INTO `kategorie` (`Nazwa`, `KategoriaID`,"
                 +" `Opis`) VALUES ('"+nazwa+"', NULL, '"+opis+"');";
     
     
     try {
         
                session = HibernateUtil.getSessionFactory().openSession();
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
