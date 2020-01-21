package Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import hibernate.Klient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dawid
 */

// do not try to read this code for your personal safety

// HOW TO USE?
// pdfCreator.createInvoice(String numerZamówienia, int stawkaVAT, Klient k, String[][] produkty w zamówieniu)
// pozdrawiam

public class pdfCreator {
    private static PathFinder appPath = new PathFinder();
    private static DecimalFormat df = new DecimalFormat("#.##");
    static Date dateToInvoice = new Date();
    static Calendar calendarToInvoice = Calendar.getInstance();
    static String initDay = calendarToInvoice.get(Calendar.DAY_OF_MONTH) < 10 ? "0"+calendarToInvoice.get(Calendar.DAY_OF_MONTH) : ""+calendarToInvoice.get(Calendar.DAY_OF_MONTH);
    static String initMonth = calendarToInvoice.get(Calendar.MONTH)+1 < 10 ? ""+calendarToInvoice.get(Calendar.MONTH)+1 : ""+calendarToInvoice.get(Calendar.MONTH)+1;
    static String initYear = ""+calendarToInvoice.get(Calendar.YEAR);
    
    public static void createInvoice(String invoiceNumber, int VAT, String currency, Klient k, String[][] products) throws FileNotFoundException, DocumentException, IOException{
        File fileHTML = new File(appPath.get() + "\\invoices\\invoice_nr." + invoiceNumber + ".pdf");
        
        String table = readHtml("br")
                + "<p>Wystawiono dla:</p>"
                +"<p>"+k.getImie()+" "+k.getNazwisko()+"</p>"
                + "<p>Dnia "+initDay+"."+initMonth+"."+initYear+"r.</p>"+readHtml("br")+readHtml("br");

        
        calendarToInvoice.setTime(dateToInvoice);
        calendarToInvoice.add(Calendar.DATE, 14);
        dateToInvoice = calendarToInvoice.getTime();
        String day = calendarToInvoice.get(Calendar.DAY_OF_MONTH)+1 < 10 ? "0"+calendarToInvoice.get(Calendar.DAY_OF_MONTH) : ""+calendarToInvoice.get(Calendar.DAY_OF_MONTH)+1;
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
                    + "Termin platnosci: 14 dni, upływa: "
                    +day
                    + "."
                    + month
                    + "."
                    +year
                +"r.</h4>"
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
