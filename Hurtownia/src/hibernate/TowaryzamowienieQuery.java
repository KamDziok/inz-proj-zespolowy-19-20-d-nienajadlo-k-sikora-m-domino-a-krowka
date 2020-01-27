/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Monika
 */
public class TowaryzamowienieQuery {
    
     public List<Towaryzamowienie> zamowieniaID(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Towaryzamowienie where ZamowienieId = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Towaryzamowienie> zamow = query.list();
        session.close();
        int i = 0;
        for(Towaryzamowienie tz: zamow){
            if(tz.getZamowienieID() != id){
                zamow.remove(i);
                i--;
            }
            i++;
        }
        return zamow;
    
}
    
}
