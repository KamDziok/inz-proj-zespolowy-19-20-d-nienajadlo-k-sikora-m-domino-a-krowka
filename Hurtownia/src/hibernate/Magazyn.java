package hibernate;
// Generated 2019-11-22 23:46:43 by Hibernate Tools 4.3.1



/**
 * Magazyn generated by hbm2java
 */
public class Magazyn  implements java.io.Serializable {


     private Integer magazynId;
     private Hurtownia hurtownia;
     private Produkty produkty;
     private int ilosc;
     private float cenaSprzedazy;

    public Magazyn() {
    }

    public Magazyn(Hurtownia hurtownia, Produkty produkty, int ilosc, float cenaSprzedazy) {
       this.hurtownia = hurtownia;
       this.produkty = produkty;
       this.ilosc = ilosc;
       this.cenaSprzedazy = cenaSprzedazy;
    }
   
    public Integer getMagazynId() {
        return this.magazynId;
    }
    
    public void setMagazynId(Integer magazynId) {
        this.magazynId = magazynId;
    }
    public Hurtownia getHurtownia() {
        return this.hurtownia;
    }
    
    public void setHurtownia(Hurtownia hurtownia) {
        this.hurtownia = hurtownia;
    }
    public Produkty getProdukty() {
        return this.produkty;
    }
    
    public void setProdukty(Produkty produkty) {
        this.produkty = produkty;
    }
    public int getIlosc() {
        return this.ilosc;
    }
    
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    public float getCenaSprzedazy() {
        return this.cenaSprzedazy;
    }
    
    public void setCenaSprzedazy(float cenaSprzedazy) {
        this.cenaSprzedazy = cenaSprzedazy;
    }




}

