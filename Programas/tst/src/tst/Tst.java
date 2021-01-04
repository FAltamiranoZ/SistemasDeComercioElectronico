/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tst;

/**
 *
 * @author Polupero
 */
public class Tst {

    /**
     * @param args the command line arguments
     * Para esta parte, lo que se hace es que se crea un new web service client, 
     * luego se usa literal el url de la pagina WSDL del cliente (en este caso 
     * el que hicimos en proyT01) y no se pone un paquete
     * Después, ponemos insert code, y escogemos call web service operation y 
     * vamos hasta abajo hasta encontrar el servicio (ahora si el puntito rojo) 
     * y lo escogemos.
     * Al hacer clean and build del tst, se abre una nueva ventan y hasta abajo
     * crea un jar, este lo podemos usar para trabajar desde el CMD
     * En las properties del tst, podemos ir a la parte de run y pasarle 
     * argumentos nosotros a manita para probarlo
     */
    public static void main(String[] args) {
        wssuma.MiWSsuma_Service service = new wssuma.MiWSsuma_Service();
        int numServicios = 0;
        if(numServicios == 0){
            numServicios = 20;
        }
        for (int i = 0; i < numServicios; i++) {
            System.out.println(suma(2,3, service));
        }
    }

    private static int suma(int a, int b, wssuma.MiWSsuma_Service service) {
        //wssuma.MiWSsuma_Service service = new wssuma.MiWSsuma_Service(); Esto 
        //no es lo mejor porque crea un nuevo objeto cada que se solicita, se
        //mejoró poniéndolo en el main y pasándolo como parámetro
        wssuma.MiWSsuma port = service.getMiWSsumaPort();
        return port.suma(a, b);
    }
    
}
