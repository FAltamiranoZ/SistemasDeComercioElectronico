/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;    

import javax.ejb.Stateless;

/**
 *
 * @author Polupero
 */
@Stateless
public class NewSessionBean implements NewSessionBeanRemote {

    @Override
    public String businessMethod() {
        return "Hola, este es el método getResult del NewSessionBean";
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Integer suma(int a, int b) {
        return a+b;
    }

    @Override
    public String metodoPrintPrueba() {
        return "Hola";
    }
}
