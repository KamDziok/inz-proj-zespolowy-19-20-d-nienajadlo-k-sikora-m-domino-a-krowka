package hibernate;
// Generated 2019-11-22 23:46:43 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Uzytkownicy generated by hbm2java
 */
public class Uzytkownicy  implements java.io.Serializable {


     private String login;
     private String haslo;
     private Set klients = new HashSet(0);
     private Set pracowniks = new HashSet(0);

    public Uzytkownicy() {
    }

	
    public Uzytkownicy(String login, String haslo) {
        this.login = login;
        this.haslo = haslo;
    }
    public Uzytkownicy(String login, String haslo, Set klients, Set pracowniks) {
       this.login = login;
       this.haslo = haslo;
       this.klients = klients;
       this.pracowniks = pracowniks;
    }
   
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getHaslo() {
        return this.haslo;
    }
    
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public Set getKlients() {
        return this.klients;
    }
    
    public void setKlients(Set klients) {
        this.klients = klients;
    }
    public Set getPracowniks() {
        return this.pracowniks;
    }
    
    public void setPracowniks(Set pracowniks) {
        this.pracowniks = pracowniks;
    }




}


