/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import Utils.pdfCreator;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author adamk
 */
public class KsiegowoscQuery {
    Session session = null;
    Query query = null;
    Criteria criteria = null;
    
        /**
         * 
         * @param zamowienieID - order identifier
         * @throws DocumentException 
         * @throws IOException 
         * 
         * use this method to create invoice to order by order id
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
        String hql3 = "From Towaryzamowienie WHERE ZamowienieID  = '"
                + zamowienieID + "'";
        query = session.createQuery(hql3);
        towary = query.list();
        session.close();
       String[][] productss =  new String[towary.size()][3];
       
       
       
       System.out.println(towary.get(0));
       for(int i = 0; i < towary.size() ; i++){
           
           
           Produkty p = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql4 = "From Produkty WHERE ProduktID  = '" + towary.get(i)
                .getProduktID() + "'";
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
}
