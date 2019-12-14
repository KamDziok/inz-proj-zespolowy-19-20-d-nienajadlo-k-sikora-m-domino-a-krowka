package hibernate;
// Generated 2019-12-10 21:47:49 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pracownik generated by hbm2java
 */
public class Pracownik  implements java.io.Serializable {


     private Integer pracownikId;
     private String imie;
     private String nazwisko;
     private float placa;
     private String stanowisko;
     private String login;
     private String password;
     private Set wyplaties = new HashSet(0);

    public Pracownik() {
    }

	
    public Pracownik(String imie, String nazwisko, float placa, 
            String stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.stanowisko = stanowisko;
    }
    public Pracownik(String imie, String nazwisko, float placa, 
            String stanowisko, String login, String password, Set wyplaties) {
       this.imie = imie;
       this.nazwisko = nazwisko;
       this.placa = placa;
       this.stanowisko = stanowisko;
       this.login = login;
       this.password = password;
       this.wyplaties = wyplaties;
    }
   
    public Integer getPracownikId() {
        return this.pracownikId;
    }
    
    public void setPracownikId(Integer pracownikId) {
        this.pracownikId = pracownikId;
    }
    public String getImie() {
        return this.imie;
    }
    
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return this.nazwisko;
    }
    
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public float getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(float placa) {
        this.placa = placa;
    }
    public String getStanowisko() {
        return this.stanowisko;
    }
    
    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getWyplaties() {
        return this.wyplaties;
    }
    
    public void setWyplaties(Set wyplaties) {
        this.wyplaties = wyplaties;
    }




}


