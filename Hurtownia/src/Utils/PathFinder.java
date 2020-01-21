package Utils;
import java.io.IOException;
/**
 *
 * @author dawid
 */
public class PathFinder {
    public static String get(){
        try{
            String path = new java.io.File(".").getCanonicalPath();
            return path;
        }
        catch(IOException e){
            System.err.println("Can't find a path of application!");
            return null;
        }
    }
}

