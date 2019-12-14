/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

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
        String hql = "from Pracownik where login = '" + login + 
                "' and password = '" + password + "'";
        query = session.createQuery(hql);
        p = (Pracownik) query.uniqueResult();
        session.close();
        if (p != null) {
            return true;
        }
        return false;
    }
    
    public Pracownik selectByLoginandPassword(String login, String password){
        Pracownik p = null;
        session = HibernateUtil.getSessionFactory().openSession();
         String hql = "from Pracownik where login = '" + login + "' "
                 + "and password = '" + password + "'";
        query = session.createQuery(hql);
        p = (Pracownik) query.uniqueResult();
        session.close();
        return p;
    }
 
      
      
       public List <Pracownik> PracownikSelectAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(Pracownik.class);
        List <Pracownik> p = criteria.list();
        session.close();
        return p;
    }
        
        
        
}
