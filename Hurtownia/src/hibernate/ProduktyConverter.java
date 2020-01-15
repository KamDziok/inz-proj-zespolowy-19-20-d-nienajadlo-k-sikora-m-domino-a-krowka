/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import javafx.util.StringConverter;

/**
 *
 * @author monika
 */
public class ProduktyConverter extends StringConverter<Produkty>{

    @Override
    public String toString(Produkty produkty) {
       return produkty == null ? null: produkty.getNazwa();
    }

    @Override
    public Produkty fromString(String string) {
        return null;
    }
    
}
