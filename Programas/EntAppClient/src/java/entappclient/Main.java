/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entappclient;

import ejb.NewSessionBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author Polupero
 */
public class Main {

    @EJB
    private static NewSessionBeanRemote newSessionBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.err.println(newSessionBean.businessMethod());
        System.err.println(newSessionBean.suma(2, 5));
        System.out.println(newSessionBean.metodoPrintPrueba());
    }
    
}
