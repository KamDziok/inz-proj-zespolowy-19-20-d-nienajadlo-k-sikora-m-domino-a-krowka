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
 * @author adamk
 */
public class AdresyQuery {
    
    
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    public void dodajAdres(int klientID , String kraj, String miasto,String ulica, String numerBudynku,String numerLokalu,String email){
    
        session = HibernateUtil.getSessionFactory().openSession();
        String query;
        if (!numerLokalu.equals(""))    
            query = "INSERT INTO `adresy` (`KlientID`, `Kraj`, `Miasto`, `Ulica`, `NumerBudynku`, `NumerLokalu`, `AdresID`, `Email`) VALUES ('"+ klientID +"', '"+kraj+"', '"+miasto+"', '"+ulica+"', '"+numerBudynku+"', '"+numerLokalu+"', NULL, '"+email+"')";
        else   
            query = "INSERT INTO `adresy` (`KlientID`, `Kraj`, `Miasto`, `Ulica`, `NumerBudynku`, `AdresID`, `Email`) VALUES ('"+ klientID +"', '"+kraj+"', '"+miasto+"', '"+ulica+"', '"+numerBudynku+"', NULL, '"+email+"')";


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
