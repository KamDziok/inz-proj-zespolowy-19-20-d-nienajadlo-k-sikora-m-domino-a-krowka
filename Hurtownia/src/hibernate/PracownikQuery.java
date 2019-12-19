/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 *
 * @author monika
 */
public class PracownikQuery {

    Session session = null;
    Query query = null;
    Criteria criteria = null;

    public boolean selecyByLoginandPassword(String login, String password) {
        Pracownik p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Pracownik where login = '" + login
                + "' and password = '" + password + "'";
        query = session.createQuery(hql);
        p = (Pracownik) query.uniqueResult();
        session.close();
        if (p != null) {
            return true;
        }
        return false;
    }

    public Pracownik selectByLoginandPassword(String login, String password) {
        Pracownik p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Pracownik where login = '" + login + "' "
                + "and password = '" + password + "'";
        query = session.createQuery(hql);
        p = (Pracownik) query.uniqueResult();
        session.close();
        return p;
    }

    public Pracownik wyszukiwanie(String login) {
        Pracownik p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Pracownik WHERE Login  = '" + login + "'";
        query = session.createQuery(hql);
        p = (Pracownik) query.uniqueResult();
        session.close();

        return p;
    }

    public void changePassword(String login, String password) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Pracownik pracownik = new PracownikQuery().wyszukiwanie(login);
            pracownik.setPassword(password);
            session.update(pracownik);
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

    public List<Pracownik> PracownikSelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Pracownik.class);
        List<Pracownik> p = criteria.list();
        session.close();
        return p;
    }
    
    public void changeProductQuantity(int storageId, int quantity, 
            int productId, int wholesaleId) throws Exception{
            
        String query = "UPDATE `magazyn` SET ";
        
        query = query + "`Ilosc` = " + quantity;
        query = query + " WHERE `ProduktID` = " + productId;
        query = query + " AND `HurtowniaID` = " + wholesaleId;
        query = query + " AND `MagazynID` = " + storageId;
        
        session = HibernateUtil.getSessionFactory().openSession();

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
    
    public void addNewProduct(int productID, String productName, 
            double productPrice,String productDescription, int categoryID)
            throws Exception {
        
        Produkty lastProduct = null;
        
        session = HibernateUtil.getSessionFactory().openSession();
    
        String query = "INSERT INTO `produkty`(`ProduktID`, `Nazwa`, "
                + "`CenaKupna`, `Opis`, `KategoriaID`) VALUES ("+productID+""
                + ",'"+productName+"', "+productPrice+","
                + "'"+productDescription+"', "+categoryID+")";
          
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


