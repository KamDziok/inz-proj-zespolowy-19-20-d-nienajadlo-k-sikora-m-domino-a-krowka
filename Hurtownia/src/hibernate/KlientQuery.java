/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import Utils.pdfCreator;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
    
    /**
     * 
     * @param login - user login
     * @param password - user password
     * @return all users with login and password equals to params.
     */

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
    
      /**
     * 
     * @param login - user login
     * @param password - user password
     * @return all users with login and password equals to params (one unique entity).
     */

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
    
    
    /**
     * 
     * @param imie - first name of new user
     * @param nazwisko - last name of new user
     * @param telefon - cell phone number
     * @param login - username
     * @param haslo - password
     * 
     * use this method to register new user.
     * 
     */


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
    
    /**
     * 
     * @param login - user login
     * @param password - new user password
     * 
     * Use this method to change user password.
     * 
     */
    

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
    
    /**
     * 
     * @param login - user name in db
     * @return unique client  entity from DB selected by login.
     */
    

    public Klient wyszukiwanie(String login) {
        Klient k = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Klient WHERE Login  = '" + login + "'";
        query = session.createQuery(hql);
        k = (Klient) query.uniqueResult();
        session.close();

        return k;
    }
    
    
    
    /*
        changeAddress() - client field is required to change address
    */

    public void changeAddress(int clientID, String country, String city, 
            String street, String buildingNr, String localNumber, String email) 
            throws Exception{
 
        session = HibernateUtil.getSessionFactory().openSession();
        
        String query = "UPDATE `adresy` SET";
        
        if(clientID == 0) {
            throw new Exception("Client cannot be empty!");
        }
        
        if(!query.equals("UPDATE `adresy` SET"))
            query+=",";
        
        if(country.length() > 0){
            query = query + " `Kraj` = '" + country + "'";
        }
            
        if(city.length() > 0){
        if(!query.equals("UPDATE `adresy` SET"))
            query+=",";
            query = query+" `Miasto` = '" + city + "'";
        }
        
        if(street.length() > 0){
        if(!query.equals("UPDATE `adresy` SET"))
            query+=",";
            query = query+" `Ulica` = '" + street + "'";
        }
        
        if(buildingNr.length() > 0){
        if(!query.equals("UPDATE `adresy` SET"))
            query+=",";
            query = query + " `NumerBudynku` = '" + buildingNr + "'";
        }
        
        if(localNumber.length() > 0){
        if(!query.equals("UPDATE `adresy` SET"))
            query+=",";
            query = query + " `NumerLokalu`= '" + localNumber + "'";
        }
        
        if(email.length() > 0){
        if(!query.equals("UPDATE `adresy` SET"))
            query+=",";
            query = query + " `email` = '"+email+"'";
        }
        
        query = query + " WHERE " + " `KlientID` = " + clientID;
        
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
        
        // QUERY TEMPLATE
        // UPDATE `adresy` SET `KlientID`=[value-1],`Kraj`=[value-2],
        // `Miasto`=[value-3],`Ulica`=[value-4],`NumerBudynku`=[value-5],
        // `NumerLokalu`=[value-6],`AdresID`=[value-7],`Email`=[value-8] WHERE 1
        
    }
     
    
    /**
     * 
     * @param ilosc - quantity of products in order
     * @param ProduktID - product identifier 
     * @param klientID - client identifier
     * @param towary - order prodcuts
     * @param date - order date
     * 
     * Use this method to order products.
     * 
     */
    
    
    public void zamowTowar(int ilosc, 
            int ProduktID , int klientID  , ArrayList towary , Date date){
        
        
    String data= new SimpleDateFormat("yyyy-MM-dd").format(date);
    
    String dataID= new SimpleDateFormat("HHmmssSSS").format(date);
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "INSERT INTO `zamowienie` (`ZamowienieID`, `KlientID`, "
            + "`StatusZaplaty`, `StatusTransportu`, `Data`)"
            + "VALUES ('"+dataID + "', '" + klientID +"', 'nie zapłacone', "
            + "'oczekujące', '"+data+"')";
    
         
             Produkty produkt;
            produkt = (Produkty)session.get(Produkty.class, ProduktID);
            float cena =  produkt.getCenaKupna();
            float koszt = cena*ilosc;
        
    


    String query2 = "INSERT INTO `towaryzamowienie` (`TowaryZamowienieID`, "
            + "`Ilosc`, `ProduktID`, `ZamowienieID`, `Koszt`) VALUES (NULL , '"

            +ilosc + "', '" + ProduktID +"', '" +dataID +"', '" + koszt +"')";

  try {
    session.getTransaction().begin();
      if (towary.size() == 0) 
    session.createSQLQuery(query).executeUpdate();
    session.createSQLQuery(query2).executeUpdate();
    session.getTransaction().commit();
    session.close();
}
catch (HibernateException error){
    session.getTransaction().rollback();
    session.close();
}
    
        towary.add("");
    }
    
    /**
     * 
     * @param zamowienieID - order identifier
     * @throws DocumentException default exception
     * @throws IOException default exception
     * 
     * Use this method to take invoice as pdf.
     * 
     */
    
   public void pobierzFakture(String zamowienieID) 
           throws DocumentException, IOException{
        
       
       Zamowienie z = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Zamowienie WHERE ZamowienieID  = " + zamowienieID + "";
        query = session.createQuery(hql);
        z = (Zamowienie) query.uniqueResult();
        session.close();

        
        Klient k = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql2 = "From Klient WHERE KlientID  = '" + z.getKlientID() + "'";
        query = session.createQuery(hql2);
        k = (Klient) query.uniqueResult();
        session.close();
        
        
        List<Towaryzamowienie> towary = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql3 = "From Towaryzamowienie WHERE ZamowienieID  = '" + 
                zamowienieID + "'";
        query = session.createQuery(hql3);
        towary = query.list();
        session.close();
       String[][] productss =  new String[towary.size()][3];
       
       
       
       
       
       System.out.println(towary.get(0));
       for(int i = 0; i < towary.size() ; i++){
           
           
           Produkty p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql4 = "From Produkty WHERE ProduktID  = '" + towary.get(i).
                getProduktID() + "'";
        query = session.createQuery(hql4);
        p = (Produkty) query.uniqueResult();
        session.close();
        
        
           productss[i][0] = p.getNazwa();
           productss[i][1] = String.valueOf(towary.get(i).getIlosc());
           productss[i][2] = String.valueOf(p.getCenaKupna());
       }
       
       
       //        INSTRUKCJA DO PDF 
       int vat = 23;
       String waluta = "PLN";
        pdfCreator pdf = new pdfCreator();
        pdf.createInvoice(zamowienieID,vat, waluta, k, productss);
//     
    }
   
   public void zatwierdzZamowienie(String ID){
    
        session = HibernateUtil.getSessionFactory().openSession();
        String query = "UPDATE `zamowienie` SET `StatusTransportu`='"
                +"w trakcie realizacji' WHERE `ZamowienieID` = " + ID;

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
   public void anulujZamowienie(String ID){
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "DELETE FROM `towaryzamowienie` WHERE `ZamowienieID` =  " + ID;
    String query2 = "DELETE FROM `zamowienie` WHERE `ZamowienieID` =  " + ID;

        try {
            session.getTransaction().begin();
            session.createSQLQuery(query).executeUpdate();
            session.createSQLQuery(query2).executeUpdate();
            session.getTransaction().commit();
            session.close();
}
        catch (HibernateException error){
        session.getTransaction().rollback();
        session.close();
        }
    }
   public void usunProdukt(int ID){
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "DELETE FROM `towaryzamowienie` WHERE `TowaryZamowienieID` =  " + ID;

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
   
   public void usunNieZapZam(String ID){
       
      List<Zamowienie> zamowienia =  new ZamowienieQuery().zamowieniaID(Integer.parseInt(ID));
      
      for(Zamowienie zamowienie : zamowienia){
          if(zamowienie.getStatusTransportu().equals("oczekujące")) {
              String query = "DELETE FROM `towaryzamowienie` WHERE `ZamowienieID` = " 
                      + zamowienie.getZamowienieId();
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
      }
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "DELETE FROM `zamowienie` WHERE `StatusTransportu` = 'oczekujące' AND `KlientID` = " + ID;

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
