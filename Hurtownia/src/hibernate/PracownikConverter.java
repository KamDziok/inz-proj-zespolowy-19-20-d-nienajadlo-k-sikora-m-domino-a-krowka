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
public class PracownikConverter extends StringConverter<Pracownik> {

    /**
     * 
     * @param pracownik - Pracownik class instance to convert
     * @return converted pracownik instance to string 
     * 
     */
    
    @Override
    public String toString(Pracownik pracownik) {
        return pracownik == null? null :  pracownik.getImie() + " " 
                + pracownik.getNazwisko();
    }

    @Override
    public Pracownik fromString(String string) {
       
        return null;
    
    
}
}
