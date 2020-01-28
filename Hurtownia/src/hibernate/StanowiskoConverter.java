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
public class StanowiskoConverter  extends StringConverter<Pracownik> {

    @Override
    public String toString(Pracownik pracownik) {
        return pracownik == null ? null: pracownik.getStanowisko();
    }

    @Override
    public Pracownik fromString(String string) {
       return null;
    }
    
}
