package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author dawid
 */
public class pdfCreator {
    
    
    public static String readHtml(String path) throws FileNotFoundException, IOException{
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\dawid\\Documents\\NetBeansProjects\\pdfCreator\\src\\pdfcreator\\"+path)));
        return contents;
    }
}
