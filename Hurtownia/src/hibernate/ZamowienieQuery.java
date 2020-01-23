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
public class ZamowienieQuery {
    
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    
    public List<Zamowienie> zamowieniaID(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Zamowienie where KlientId = '" + id + "'";
        Query query = session.createQuery(hql);
        List <Zamowienie> zamow = query.list();
        session.close();
        int i = 0;
        for(Zamowienie z : zamow){
            if(z.getKlientID() != id){
                zamow.remove(i);
            }
            i++;
        }
        return zamow;
    
}
}
