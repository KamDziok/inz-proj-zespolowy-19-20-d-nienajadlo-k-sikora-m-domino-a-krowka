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
import org.hibernate.Transaction;

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
        String hql = "from Klient where login = '" + login + "'"
                + " and password = '" + password + "'";
        query = session.createQuery(hql);
        k = (Klient) query.uniqueResult();
        session.close();
        if (k != null) {
            return true;
        }
        return false;
    }

    public Klient selectByLoginandPassword(String login, String password) {
        Klient k = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Klient where login = '" + login + "' "
                + "and password = "
                + "'" + password + "'";
        query = session.createQuery(hql);
        k = (Klient) query.uniqueResult();
        session.close();
        return k;
    }


    public void rejestracja(String imie, String nazwisko, long telefon,
            String login, String haslo) {

        session = HibernateUtil.getSessionFactory().openSession();
        String query = "INSERT INTO `klient` (`Imie`, `Nazwisko`, `Telefon`,"
                + "`login`, `password`) VALUES ('" + imie + "', '"
                + nazwisko + "', " + "'" + telefon + "', '" + login + "', '"
                + haslo + "')";
        try {
            session.getTransaction().begin();
            session.createSQLQuery(query).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException error) {
            session.getTransaction().rollback();
            session.close();
        }

    }

    public void changePassword(String login, String password) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Klient klient = new KlientQuery().wyszukiwanie(login);
            klient.setPassword(password);
            session.update(klient);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Klient wyszukiwanie(String login) {
        Klient k = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Klient WHERE Login  = '" + login + "'";
        query = session.createQuery(hql);
        k = (Klient) query.uniqueResult();
        session.close();

        return k;
    }

    public void changeAddress(Klient client, String country, String city, 
            String street, String buildingNr, String localNumber, String email) throws Exception{
        
        if(client == null) {
            throw new Exception("Client cannot be empty!");
        }
        
        try{
            if(country.length() > 0){
               
            }
        } catch(HibernateException error){
            
        }
        
        // QUERY TEMPLATE
        // UPDATE `adresy` SET `KlientID`=[value-1],`Kraj`=[value-2],`Miasto`=[value-3],`Ulica`=[value-4],`NumerBudynku`=[value-5],`NumerLokalu`=[value-6],`AdresID`=[value-7],`Email`=[value-8] WHERE 1
        
        
    }
    
}
