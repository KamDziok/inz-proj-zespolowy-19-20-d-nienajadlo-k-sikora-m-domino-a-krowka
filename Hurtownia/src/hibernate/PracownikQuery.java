package hibernate;

import Utils.Hash;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author monika
 */
public class PracownikQuery {

    Session session = null;
    Query query = null;
    Criteria criteria = null;

    public boolean selecyByLoginandPassword(String login, String password) {
        Session session = null;
        Pracownik p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        
        String hql = "from Pracownik where login = '" + login
                + "' and password = '" + Hash.password(password) + "'";
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
                + "and password = '" + Hash.password(password) + "'";
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
    
      public Pracownik wyszukiwanieID (int id) {
        Pracownik p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Pracownik WHERE PracownikID  = '" + id + "'" ;
        query = session.createQuery(hql);
        p = (Pracownik) query.uniqueResult();
        session.close();
        return p;
    }
    
    public Pracownik wyszukanieZatrudnienie (String nazwisko, String imie){
        Pracownik p = null;
        session = HibernateUtil.getSessionFactory().openSession();
          String hql = "from Pracownik  WHERE nazwisko  = '" + nazwisko + "'"+ 
                  "and imie = '" + imie + "'";
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
            pracownik.setPassword(Hash.password(password));
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
    
    public void dodanieDanych(String login, String password, int id){
            session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Pracownik pracownik = new PracownikQuery().wyszukiwanieID(id);
            pracownik.setLogin(login);
            pracownik.setPassword(Hash.password(password));
            session.update(pracownik);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.err.println("błąd id");
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
            int productId) throws Exception{
            
        String query = "UPDATE `magazyn` SET ";
        
        query = query + "`Ilosc` = " + quantity;
        query = query + " WHERE `ProduktID` = " + productId;
        query = query + " AND `HurtowniaID` =  1 ";
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
                + "`CenaKupna`, `Opis`, `KategoriaID`) VALUES (NULL"
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


