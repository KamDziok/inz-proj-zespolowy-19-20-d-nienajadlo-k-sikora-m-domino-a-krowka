/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author monika
 */
public class UzytkownicyQuery {

    Session session = null;
    Query query = null;
    Criteria criteria = null;

    public boolean selecyByLoginandPassword(String login, String password) {
        Uzytkownicy u = null;
        session = hibernate.HibernateUtil.getSessionFactory().openSession();
        String hql = "from Nauczyciele where login = '" + login + "' and haslo = '" + password + "'";
        query = session.createQuery(hql);
        u = (Uzytkownicy) query.uniqueResult();
        session.close();
        if (u != null) {
            return true;
        }
        return false;
    }

    public Uzytkownicy selectByLoginandPassword(String login, String password) {
        Uzytkownicy u = null;
        session = hibernate.HibernateUtil.getSessionFactory().openSession();
        String hql = "from Uzytkownicy where login = '" + login + "' and haslo = '" + password + "'";
        query = session.createQuery(hql);
        u = (Uzytkownicy) query.uniqueResult();
        session.close();
        return u;
    }

}
