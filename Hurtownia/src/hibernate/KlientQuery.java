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

/**
 *
 * @author monika
 */
public class KlientQuery {
    
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    public boolean selecyByLoginandPassword(String login, String password) {
        Klient k = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Klient where login = '" + login + "' and password = '" + password + "'";
        query = session.createQuery(hql);
        k = (Klient) query.uniqueResult();
        session.close();
        if (k != null) {
            return true;
        }
        return false;
    }
    
    public Klient selectByLoginandPassword(String login, String password){
        Klient k = null;
        session = HibernateUtil.getSessionFactory().openSession();
         String hql = "from Klient where login = '" + login + "' and password = '" + password + "'";
        query = session.createQuery(hql);
        k = (Klient) query.uniqueResult();
        session.close();
        return k;
    }
    
    public String changeAddress(Klient client, String address){
        
        
        
        return address;
    }
    
    public void rejestracja(String imie , String nazwisko, String telefon,String login,String haslo){
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "INSERT INTO `klient` (`Imie`, `Nazwisko`, `Telefon`,`AdresID` ,`login`, `password`) VALUES ('" + imie +"', '"+nazwisko+"', '"+telefon+"', NULL, '"+login+"', '" + haslo+"')";
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
