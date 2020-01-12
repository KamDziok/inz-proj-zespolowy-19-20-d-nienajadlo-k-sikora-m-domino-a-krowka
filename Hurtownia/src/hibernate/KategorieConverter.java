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
public class KategorieConverter extends StringConverter<Kategorie>  {

    @Override
    public String toString(Kategorie kat) {
        return kat == null? null : kat.getNazwa();
    }

    @Override
    public Kategorie fromString(String string) {
        return null;
    }
    
}
