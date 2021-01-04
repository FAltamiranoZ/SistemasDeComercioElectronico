/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wssuma;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Polupero
 */
@WebService(serviceName = "miWSsuma")
public class miWSsuma {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * Para agregar esta parte, se va a insert code / Add Web service operation
     * Para probarlo, se abre la carpeta de Web services y sobre el servicio (no
     * el método, es decir, no los puntitos rojos, sobre la cosita con el mundo)
     * le das clic derecho y test web services
     * Ya probándolo, ahí puedo ver el SOAP response y request
     * Y dentro del test, al darle clic en el WSDL file se abre el resto de la 
     * info
     */
    @WebMethod(operationName = "suma")
    public int suma(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        return a + b;
    }
}
