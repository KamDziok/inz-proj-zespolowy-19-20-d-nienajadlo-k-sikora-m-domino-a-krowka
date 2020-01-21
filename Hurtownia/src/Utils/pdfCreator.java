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
    private static PathFinder appPath = new PathFinder();
    
    public String readHtml(String path) throws FileNotFoundException, IOException{
        String contents = new String(Files.readAllBytes(
                Paths.get(appPath.get()+"\\src\\Utils\\html_templates\\"+ path+".html")));

        return contents;
    }
}
