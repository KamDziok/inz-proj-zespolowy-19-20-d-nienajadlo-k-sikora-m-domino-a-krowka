/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Date;

/**
 *
 * @author adamk
 */
public class WyplatyPracownik {
    
    
    public Integer wyplataId;
     public String pracownikName;
     public Date data;
     public float kwota;


    public WyplatyPracownik(String pracownik, Date data, float kwota , int id) {
       this.pracownikName = pracownik;
       this.data = data;
       this.kwota = kwota;
       this.wyplataId = id;
    }

    public Integer getWyplataId() {
        return wyplataId;
    }

    public void setWyplataId(Integer wyplataId) {
        this.wyplataId = wyplataId;
    }

    public String getPracownikName() {
        return pracownikName;
    }

    public void setPracownikName(String pracownikName) {
        this.pracownikName = pracownikName;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }
    
    
    
}
