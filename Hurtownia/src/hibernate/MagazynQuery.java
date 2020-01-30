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
 * @author monika
 */
public class MagazynQuery {
    
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    /**
     * 
     * @param id - products identifier
     * @return all products from database selected by id
     */
    
     public List<Magazyn> produktySelectAllOnID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Magazyn where ProduktID = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Magazyn> produkt = query.list();
        session.close();
        int i = 0;
        for(Magazyn m : produkt){
            if(m.getProdukty().getProduktId() != id){
                produkt.remove(i);
            }
            i++;
        }
        return produkt;
        
      
    }
     
     
     /**
      * use this method to get all avaiable stores from DB
      * 
      * @return all avaiables stores from database 
      */
     
      public List<Magazyn> MagazynSelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Magazyn.class);
        List<Magazyn> magazyn = criteria.list();
        session.close();
        return magazyn;
    }
      
  
      public void wyslijZamowienie (int id){
      
        TowaryzamowienieQuery tz = new TowaryzamowienieQuery();  
        List<Towaryzamowienie> tzTable = tz.zamowieniaID(String.valueOf(id));
        for (Towaryzamowienie towar : tzTable)
            executeUpdate("UPDATE `magazyn` SET `Ilosc`= `Ilosc` - "+
                    towar.getIlosc()+" WHERE `ProduktID` = " 
                    + towar.getProduktID());
        executeUpdate("UPDATE `zamowienie` SET `StatusTransportu` "
            +"='wysłano' WHERE `ZamowienieID` = " + id);
         
      }
      
      
      public int dostepneTowary(int id) {
          int avible = 0;
            List<Zamowienie> zamowienia = new ZamowienieQuery().zamowienaPrzedWyslaniem();
            TowaryzamowienieQuery towZamQ = new TowaryzamowienieQuery();
            for (Zamowienie zam : zamowienia) {
                List<Towaryzamowienie> towZam = towZamQ.zamowieniaID(String.valueOf(zam.getZamowienieId()));
                for (Towaryzamowienie towar : towZam) {
                    if (towar.getProduktID() == id) {
                        avible += towar.getIlosc();
                    }
                }
            }
            
           
                
          return getTowar(id) - avible;
      }
      
      
      public int getTowar(int id){
         session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Magazyn where ProduktID = '" + id + "'";
        Query query = session.createQuery(hql);
        Magazyn zamow = (Magazyn) query.uniqueResult();
        session.close();
          if(zamow == null )
              return 0;
        return zamow.getIlosc();
      }
      
      
      public void odbierzZwrot(int id){
          TowaryzamowienieQuery tz = new TowaryzamowienieQuery();  
          List<Towaryzamowienie> tzTable = tz.zamowieniaID(String.valueOf(id));
          for (Towaryzamowienie towar : tzTable) {
            executeUpdate("UPDATE `magazyn` SET `Ilosc`= `Ilosc` + "+
                    towar.getIlosc()+" WHERE `ProduktID` = " 
                    + towar.getProduktID());
            
        }
        
        executeUpdate("UPDATE `zamowienie` SET `StatusTransportu` "
            +"='anulowane' WHERE `ZamowienieID` = " + id);
        
      }
      
      
      
    public void executeUpdate(String query){
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
