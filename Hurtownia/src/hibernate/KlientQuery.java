/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.Criteria;
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
    
    public void changeAddress(Klient client, String country, String city, String street, String buildingNumber, String localNumber, String email){
        
        int clientId = client.getKlientId();
        
        // SQL operations and variables
        
        Klient clientAddress = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Klient where KlientID= '" + clientId;
        query = session.createQuery(hql);
        clientAddress = (Klient) query.uniqueResult();
        session.close();
        
        if(country.length() == 0){
            String query = "UPDATE `adresy ` SET Kraj=" + country + " WHERE AdresID = ";
        }
        
        System.out.println(clientAddress);
        
    }
    
}
