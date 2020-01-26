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
 * @author adamk
 */
public class KierownikQuery {
     
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    /**
     * 
     * @param imie - first name of user
     * @param nazwisko - last name of user
     * @param placa - worker salary
     * @param stanowisko - worker position on company
     * 
     * Method for adding new worker to database
     * 
     */
    
    public void dodajPracownika(String imie , String nazwisko, 
            float placa,String stanowisko){
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "INSERT INTO `pracownik` (`Imie`, `Nazwisko`, `Placa`,"
            + " `PracownikID`, `Stanowisko`, `login`, `password`) "
            + "VALUES ('" + imie +"', '"+nazwisko+"', '"+placa+"',"
            + " NULL, '"+stanowisko+"', NULL, NULL)";
    
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
    
    /**
     * 
     * @param pracownikId - worder ID param
     * 
     * method created fot getting fired worker from company
     * 
     */
    
     public void zwolnijPracownika (Integer pracownikId){
        session = HibernateUtil.getSessionFactory().openSession();
         Transaction tx = null;
         
         try{
             tx = session.beginTransaction();
             Pracownik pracownik;
            pracownik = (Pracownik)session.get(Pracownik.class, pracownikId);
             session.delete(pracownik);
             tx.commit();   
         }catch(Exception e){
             if(tx != null) tx.rollback();
             e.printStackTrace();
         } finally{
             session.close();
         }
    }
     
     
     /**
      * 
      * @param Nazwa - name of new product
      * @param Cena - price of new product
      * @param Opis - description of new product
      * @param Kategoria - category of new product
      * 
      * use this method to add new product into database
      * 
      */
     
     
     // Kategoria musi być pobrana jako ID
     public void dodajProdukt(String Nazwa , float Cena, 
            String Opis , int Kategoria){
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "INSERT INTO `produkty` (`ProduktID`, `Nazwa`, `CenaKupna`, "
            + "`Opis`, `KategoriaID`) "
            + "VALUES (NULL, '" + Nazwa +"', '"+Cena+"', '"+Opis+"',"
            +Kategoria+")";
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
     
     /**
      * 
      * @param ilosc - quantity of product
      * @param Cena - procuct's price
      * @param ProduktID - product's identifier
      * 
      * use this method to add product into store
      * 
      */
     
     public void dodajProduktNaMagazyn(int ilosc , float Cena, 
            int ProduktID ){
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "INSERT INTO `magazyn` (`MagazynID`, `Ilosc`, "
            +"`CenaSprzedazy`, `ProduktID`, `HurtowniaID`)"
            + "VALUES (NULL, '" + ilosc +"', '"+Cena+"', '"+ProduktID+"', '1')";
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
