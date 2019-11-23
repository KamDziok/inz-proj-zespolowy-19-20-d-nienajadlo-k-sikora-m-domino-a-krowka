package hibernate;
// Generated 2019-11-22 23:46:43 by Hibernate Tools 4.3.1



/**
 * Klient generated by hbm2java
 */
public class Klient  implements java.io.Serializable {


     private Integer klientId;
     private Adresy adresy;
     private Uzytkownicy uzytkownicy;
     private String imie;
     private String nazwisko;
     private long telefon;

    public Klient() {
    }

    public Klient(Adresy adresy, Uzytkownicy uzytkownicy, String imie, String nazwisko, long telefon) {
       this.adresy = adresy;
       this.uzytkownicy = uzytkownicy;
       this.imie = imie;
       this.nazwisko = nazwisko;
       this.telefon = telefon;
    }
   
    public Integer getKlientId() {
        return this.klientId;
    }
    
    public void setKlientId(Integer klientId) {
        this.klientId = klientId;
    }
    public Adresy getAdresy() {
        return this.adresy;
    }
    
    public void setAdresy(Adresy adresy) {
        this.adresy = adresy;
    }
    public Uzytkownicy getUzytkownicy() {
        return this.uzytkownicy;
    }
    
    public void setUzytkownicy(Uzytkownicy uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
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
    public long getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(long telefon) {
        this.telefon = telefon;
    }




}


