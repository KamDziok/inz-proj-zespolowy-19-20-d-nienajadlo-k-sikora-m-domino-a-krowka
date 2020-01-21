package Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author dawid
 */

public class pdfCreator {
    private static PathFinder appPath = new PathFinder();
    
    public static void createInvoice(String invoiceNumber, int VAT) throws FileNotFoundException, DocumentException, IOException{
        File fileHTML = new File(appPath.get() + "\\invoices\\invoice_nr." + invoiceNumber + ".pdf");
        
       
        
        String table = "<table>"
                    + "<tr> "
                        +"<th>Produkt</th>"
                        +"<th>Cena netto</th>"
                        +"<th>Stawka VAT</th>"
                        +"<th>Kwota VAT</th>"
                        +"<th>Cena brutto</th>"
                        +"<th>Suma VAT</th>"
                        +"<th>Cena razem</th>"
                    + "</tr>"
                + "</table>";
        
        for(String[] invoiceElement : products){
            table += "<table>"
                        + "<tr>"
                            + "<th>"
                                + invoiceElement[0]
                            + "</th>"
                            + "<th>"
                                + invoiceElement[2]
                            + "</th>"
                            + "<th>"
                                + VAT + "%"
                            + "</th>"
                            + "<th>"
                                + (Integer.parseInt(invoiceElement[2])/100)*VAT
                            + "</th>"
                        + "</tr>"
                    + "</table>";
        }
        
        try {
            String page = readHtml("header") + "<h1>Faktura nr."
                    +invoiceNumber+"</h1>\n"+ readHtml("br") + table +readHtml("footer");
            
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
