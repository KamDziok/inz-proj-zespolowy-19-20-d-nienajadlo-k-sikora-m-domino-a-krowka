/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;
import Utils.PathFinder;
import Utils.Popup;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;
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
    
    public long dodajPracownika(String imie , String nazwisko, 
        float placa,String stanowisko) throws IOException{
        
        Date date = new Date();
        int workerId = (int) date.getTime();
        
        String filename = PathFinder.get()+"\\workerCodes\\"+imie+"_"+nazwisko+"_"+stanowisko+".txt";
        
        createWorkersCodesDirIfNotExist();
        
        try{
            PrintWriter writeCode = new PrintWriter(filename, "UTF-8");
            writeCode.println(workerId);
            writeCode.close();
        } catch(Exception e){
            Popup.show("Nie można zapisać pliku z kodem pracownika!");
        }
        
        session = HibernateUtil.getSessionFactory().openSession();
        String query = "INSERT INTO `pracownik` (`Imie`, `Nazwisko`, `Placa`,"
            + " `PracownikID`, `Stanowisko`, `login`, `password`) "
            + "VALUES ('" + imie +"', '"+nazwisko+"', '"+placa+"',"
            + "'"+workerId+"','"+stanowisko+"', NULL, NULL)";
    
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
            
            return workerId;
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
         
       session = HibernateUtil.getSessionFactory().openSession();
    
        String query = "DELETE FROM Pracownik WHERE pracownikId = "
                + pracownikId;
          
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
         
         
         Ksiegowosc ksiegowosc = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Ksiegowosc WHERE KsiegowoscID  = 1";
        query = session.createQuery(hql);
        ksiegowosc = (Ksiegowosc) query.uniqueResult();
        session.close();
    
        session = HibernateUtil.getSessionFactory().openSession();
        List<Magazyn> produkty = new MagazynQuery().MagazynSelectAll();
        boolean flag = true;
        for (Magazyn produkt : produkty){
            if(produkt.getProductId() == ProduktID)
                flag = false;
        }
        
        String query;
        if(flag)
            query = "INSERT INTO `magazyn` (`MagazynID`, `Ilosc`, "
            +"`CenaSprzedazy`, `ProduktID`, `HurtowniaID`)"
            + "VALUES (NULL, '" + ilosc +"', '"+Cena+"', '"+ProduktID+"', '1')";
        
        else{
            if(Cena == 0)
            query = "UPDATE `magazyn` SET `Ilosc`=`Ilosc` + "+ilosc+" WHERE `ProduktID` = " + ProduktID;
            else
                query = "UPDATE `magazyn` SET `Ilosc`=`Ilosc` + "+
                        ilosc+" , `CenaSprzedazy` = "+
                        Cena+" WHERE `ProduktID` = " + ProduktID;
        }
            
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
     
    public static void createWorkersCodesDirIfNotExist(){
        try{
            File directoryInvoices = new File(PathFinder.get() + "\\workerCodes");
            if(!directoryInvoices.exists()){
                directoryInvoices.mkdir();
            }
        }catch(Exception e){
            System.err.println("Cannot create invoices directory!");
        }
    }
     
     
    
   
}
