package hibernate;
// Generated 2020-01-15 16:13:33 by Hibernate Tools 4.3.1



/**
 * Towaryzamowienie generated by hbm2java
 */
public class Towaryzamowienie  implements java.io.Serializable {


     private Integer towaryZamowienieId;
     private Produkty produkty;
     private Zamowienie zamowienie;
     private int ilosc;
     private float koszt;

    public Towaryzamowienie() {
    }

    public Towaryzamowienie(Produkty produkty, Zamowienie zamowienie, int ilosc, float koszt) {
       this.produkty = produkty;
       this.zamowienie = zamowienie;
       this.ilosc = ilosc;
       this.koszt = koszt;
    }
   
    public Integer getTowaryZamowienieId() {
        return this.towaryZamowienieId;
    }
    
    public void setTowaryZamowienieId(Integer towaryZamowienieId) {
        this.towaryZamowienieId = towaryZamowienieId;
    }
    public Produkty getProdukty() {
        return this.produkty;
    }
    
    public String getProduktName() {
        return this.produkty.getNazwa();
    }    
    
    public int getProduktID() {
        return this.produkty.getProduktId();
    }
    public float getProduktCost() {
        return this.produkty.getCenaKupna();
    }
    public void setProdukty(Produkty produkty) {
        this.produkty = produkty;
    }
    public Zamowienie getZamowienie() {
        return this.zamowienie;
    }
    
    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
    public int getIlosc() {
        return this.ilosc;
    }
    
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    public float getKoszt() {
        return this.koszt;
    }
    
    public void setKoszt(float koszt) {
        this.koszt = koszt;
    }
    
    
    

}


