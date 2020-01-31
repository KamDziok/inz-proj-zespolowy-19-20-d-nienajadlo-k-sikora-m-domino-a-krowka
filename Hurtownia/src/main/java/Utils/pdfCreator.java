package Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import hurtownia.hibernate.Adresy;
import hurtownia.hibernate.AdresyQuery;
import hurtownia.hibernate.Klient;
import hurtownia.hibernate.ZamowienieQuery;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dawid
 * class pdfCreator is class to crate invoices for project
 */



public class pdfCreator {
    private static PathFinder appPath = new PathFinder();
    private static DecimalFormat df = new DecimalFormat("#.##");
    static Date dateToInvoice = new Date();
    static Calendar calendarToInvoice = Calendar.getInstance();
    static String initDay = calendarToInvoice.get(Calendar.DAY_OF_MONTH) < 10 ? "0"+calendarToInvoice.get(Calendar.DAY_OF_MONTH) : ""+calendarToInvoice.get(Calendar.DAY_OF_MONTH);
    static String initMonth = calendarToInvoice.get(Calendar.MONTH)+1 < 10 ? ""+calendarToInvoice.get(Calendar.MONTH)+1 : ""+calendarToInvoice.get(Calendar.MONTH)+1;
    static String initYear = ""+calendarToInvoice.get(Calendar.YEAR);
    
    
     /**
     *
     * ready method to creating invoices for project in pdf format
     * with dynamicly VAT calculation
     * 
     * @param invoiceNumber - it's a invoice number on ready pdf document
     * @param currency - currency on invoice
     * @param k - instance of kKlient class
     * @param VAT - VAT % in invoice - dynamicly calculated before generating pdf
     * @param products[][] two-dimensional array of products in invoice 
     * @throws FileNotFoundException default exception
     * @throws DocumentException default exception
     * @throws IOException default exception
     */
    
    public static void createInvoice(String invoiceNumber, int VAT, String currency, Klient k, String[][] products) throws FileNotFoundException, DocumentException, IOException, ParseException{
        File fileHTML = new File(appPath.get() + "\\invoices\\invoice_nr" + invoiceNumber + ".pdf");
        AdresyQuery aq = new AdresyQuery();
        Adresy a = aq.wyswietlAdres(k.getKlientId());
        ZamowienieQuery zamowienie = new ZamowienieQuery();
        Date dateOfOrder = zamowienie.getOrderDate(Integer.parseInt(invoiceNumber));
        Calendar finishCalendar = Calendar.getInstance();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        finishCalendar.setTime(formatDate.parse(dateOfOrder.toString()));
        finishCalendar.add(Calendar.DAY_OF_MONTH, 14);
        String finishDateAsString = formatDate.format(finishCalendar.getTime()); 
        
        Date dateToday = new Date();
        String dateTodayString = formatDate.format(dateToday);
        
        String table = readHtml("br")
                + "<p>Wystawiono dla:</p>"
                +"<p>Imie i nazwisko: "+k.getImie()+" "+k.getNazwisko()+"</p>"
                +"<p>Adres: "+a.getMiasto()+" "+a.getUlica()+" "+a.getNumerBudynku()+"</p>"
                +"<p>Email: "+a.getEmail()+"</p>"
                +"<p>Tel. :"+k.getTelefon()+"</p>"
                + "<p>Data zamówienia: "+ dateOfOrder +"</p>"
                + "<p>Wystawiono dnia: "+dateTodayString+"</p>"
                +readHtml("br")+readHtml("br");

        
        calendarToInvoice.setTime(dateToInvoice);
        calendarToInvoice.add(Calendar.DATE, 14);
        dateToInvoice = calendarToInvoice.getTime();
        String day = calendarToInvoice.get(Calendar.DAY_OF_MONTH)+1 < 10 ? "0"+calendarToInvoice.get(Calendar.DAY_OF_MONTH) : ""+calendarToInvoice.get(Calendar.DAY_OF_MONTH);
        String month = calendarToInvoice.get(Calendar.MONTH)+1 < 10 ? "0"+(calendarToInvoice.get(Calendar.MONTH)+1) : ""+(calendarToInvoice.get(Calendar.MONTH)+1);
        String year = ""+calendarToInvoice.get(Calendar.YEAR);
        
        Double totalPrice = 0.00;
        
         table += "<table>"
                    + "<tr> "
                        +"<th>Produkt</th>"
                        +"<th>Ilosc</th>"
                        +"<th>VAT "+VAT+"%</th>"
                        +"<th>Cena netto</th>"
                        +"<th>Cena brutto</th>"
                        +"<th>Suma</th>"
                    + "</tr>"
                + "</table>"
                + readHtml("line");
        
        for(String[] invoiceElement : products){
            
            Double singleVAT = (Double.parseDouble(invoiceElement[2])/100)*VAT;
            Double summaryVAT = singleVAT * Integer.parseInt(invoiceElement[1]);
            Double nettoPrice = Double.parseDouble(invoiceElement[2]);
            Double bruttoPrice = nettoPrice + singleVAT;
            Double summaryPrice = Double.parseDouble(invoiceElement[1]) * bruttoPrice;
            
            totalPrice += summaryPrice;
            
            table += "<table>"
                        +"<tr>"
                            +"<th>"
                                +invoiceElement[0]
                            +"</th>"
                            +"<th>"
                                +invoiceElement[1]
                            +"</th>"
                            +"<th>"
                                +df.format(singleVAT)
                            +"</th>"    
                             +"<th>"
                                +df.format(nettoPrice)
                            +"</th>"    
                            +"<th>"
                                +df.format(bruttoPrice)
                            +"</th>"  
                           +"<th>"
                                +df.format(summaryPrice)
                            +"</th>"  
                        +"</tr>"
                    + "</table>";
        }
        
  
        
        table += readHtml("line")
                + "<table>"
                + "<tr>"
                + "<th>"
                + "</th>"
                + "<th>"
                   + "Sztuk"
                + "</th>"
                + "<th>"
                   + currency
                + "</th>"
                 + "<th>"
                   + currency
                + "</th>"
                 + "<th>"
                   + currency
                + "</th>"
                 + "<th>"
                   + currency
                + "</th>"
                + "</tr>"
                + "</table>" 
                + readHtml("br")
                + readHtml("br")
                + "<h4>W sumie do zapłaty: "+df.format(totalPrice)+" "+currency+"</h4>"
                + readHtml("br")
                + "<h4>"
                    + "Termin platnosci: 14 dni, uplywa: "
                    +finishDateAsString
                +"</h4>"
                + readHtml("br") 
                + readHtml("br")
                + readHtml("br")
                + "<p>Wygenerowano automatycznie przez system hurtowni.</p>";
        
        try {
            String page = readHtml("header") + "<h1>Faktura nr."
                    +invoiceNumber+"</h1>\n"+ readHtml("br") + readHtml("br")
                   + table +readHtml("footer");
            
            try (OutputStream file = new FileOutputStream(fileHTML)) {
                Document document = new Document();
                PdfWriter.getInstance(document, file);
                document.open();
                HTMLWorker htmlWorker = new HTMLWorker(document);
                htmlWorker.parse(new StringReader(page));
                document.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    public static String readHtml(String path) throws FileNotFoundException, IOException{
        String contents = new String(Files.readAllBytes(
                Paths.get(appPath.get()+"\\src\\Utils\\html_templates\\"+ path+".html")));

        return contents;
    }
}
