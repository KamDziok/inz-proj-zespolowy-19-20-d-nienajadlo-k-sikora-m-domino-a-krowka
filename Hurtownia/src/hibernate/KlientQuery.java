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

    public void changeAddress(Klient client, String country, String city,
            String street, String buildingNumber, String localNumber,
            String email) {

        int clientId = client.getKlientId();

        // SQL operations and variables
        Klient clientAddress = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Klient where KlientID= '" + clientId;
        query = session.createQuery(hql);
        clientAddress = (Klient) query.uniqueResult();
        session.close();

        if (country.length() == 0) {
            String query = "UPDATE `adresy ` SET Kraj=" + country
                    + " WHERE AdresID = ";
        }

        System.out.println(clientAddress);

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

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "UPDATE Klient SET password = '" + password
                    + "' WHERE login = '" + login + "'";
            query = session.createQuery(hql);
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Klient wyszukiwanie(String login){
        Klient k = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Klient WHERE Login  = '"+ login+"'" ;
        query = session.createQuery(hql);
        k = (Klient)query.uniqueResult();
        session.close();
        
        return k;
    }

}
