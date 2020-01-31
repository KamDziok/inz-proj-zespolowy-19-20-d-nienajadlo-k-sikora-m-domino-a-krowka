/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtownia.hibernate;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

/**
 *
 * @author karol
 */
public class WyplatyQuery {
    
     Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    /**
     * 
     * @return all salars from database 
     */
    
    public List<Wyplaty> WyplatySelectAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Wyplaty.class);
        List<Wyplaty> w = criteria.list();
        session.close();
        return w;
    }
    
    /**
     * 
     * @param id - user id to get salary
     * @return salary selected by id
     */
    
     public List<Wyplaty> wyplatyID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Wyplaty where PracownikId = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Wyplaty> wyplaty = query.list();
        session.close();
        int i = 0;
        for(Wyplaty w : wyplaty){
            if(w.getPracownik().getPracownikId() != id){
                wyplaty.remove(i);
            }
            i++;
        }
        return wyplaty;
     
}
     
     /**
      * 
      * @param dataSql - date to salary update
      * @param kwotaSql - new salary in global currency
      * @param idPrac - pracownik identifier
      * 
      * use this method to add new salary for worker
      * 
      */
         public void dodajWyplate(Date dataSql , float kwotaSql, int idPrac){
    
        session = HibernateUtil.getSessionFactory().openSession();
    String query = "INSERT INTO `wyplaty` (`WyplataID`, `Data`, `Kwota`,"
            + " `PracownikID`) "
            + "VALUES (NULL, '"+dataSql+"', '"+kwotaSql+"',"
            + " '"+idPrac+"')";
    
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
       
  
    //INSERT INTO `wyplaty` (`WyplataID`, `Data`, `Kwota`, `PracownikID`) VALUES (NULL, '2020-01-21', '1299', '3');
    }
         
              public void dodajWyplate(final float kwota,final int idPrac){
          Session session = HibernateUtil.getSessionFactory().openSession();
          Transaction transaction = session.beginTransaction();
          session.doWork(new Work() {

              @Override
              public void execute(Connection conn) throws SQLException {
                  CallableStatement cs = conn.prepareCall("{call dodajWyplate(?,?)}");
                  cs.setFloat(1,kwota);
                  cs.setInt(2, idPrac);
                  cs.execute();
       
          
      } 
          });
           transaction.commit();
           session.close();
     }
    
     
}
