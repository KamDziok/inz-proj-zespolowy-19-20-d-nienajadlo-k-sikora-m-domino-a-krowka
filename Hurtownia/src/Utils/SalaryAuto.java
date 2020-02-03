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
    
    public static boolean autoAddSalary() throws Exception{
        Calendar actualCalendar = Calendar.getInstance();
        List<Pracownik> workers;
        int dayOfMonth = actualCalendar.get(Calendar.DAY_OF_MONTH);
        Date date = new Date();
        String dateAsString = date.toString();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String dateOfSalary = formatDate.format(date).toString();
        
        List<Wyplaty> salariesAll = salariesQuery.WyplatySelectAll();
        
        if(!salariesAll.isEmpty() && salariesAll.get(0).getData().getMonth()+1 == date.getMonth()+1){
            System.err.println("Dodałeś wypłaty ");
            return false;
        }
        
        if(dayOfMonth == 10){
            workers = workersQuery.PracownikSelectAll();
            for(Pracownik worker : workers){
                salariesQuery.dodajWyplate(dateOfSalary, worker.getPlaca(), worker.getPracownikId());
            }
        } else{
//            System.err.println("Nie można dodać wypłat pracowników!");
        }
        
        return true;
    }
}
