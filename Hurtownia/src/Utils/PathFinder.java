package Utils;
import java.io.IOException;
/**
 *
 * @author dawid
 */

/**
 * Returns canonical path of project
 *  Use PathFinder.get() to get path
 */
public class PathFinder {
    // this method returns path to Hurtownia main directory
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

