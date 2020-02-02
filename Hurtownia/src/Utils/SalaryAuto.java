package Utils;

import hibernate.Pracownik;
import hibernate.PracownikQuery;
import hibernate.Wyplaty;
import hibernate.WyplatyQuery;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dawid
 */
public class SalaryAuto {
    private static WyplatyQuery salariesQuery = new WyplatyQuery();
    public static PracownikQuery workersQuery = new PracownikQuery();
    
    public static boolean autoAddSalary(){
        Calendar actualCalendar = Calendar.getInstance();
        List<Pracownik> workers;
        int dayOfMonth = actualCalendar.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();
        String dateAsString = date.toString();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        
        if(dayOfMonth == 2){
            System.err.println("Jest 2");
            workers = workersQuery.PracownikSelectAll();
            for(Pracownik worker : workers){
                salariesQuery.dodajWyplate(dateAsString, worker.getPlaca(), worker.getPracownikId());
            }
        } else{
            System.err.println("Nie jest 2 bo jest " + dayOfMonth);
        }
        
        return true;
    }
}
