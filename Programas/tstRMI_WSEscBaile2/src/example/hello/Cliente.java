/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//================================================================
// Código del Cliente:
//================================================================
package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long lngQuienSoy;
        long sumDeltaT, sumDeltaT2, dtMin = 0, dtMax = 0;
        long lngCuantosMilisFaltan;

        String host = (args.length < 1) ? null : args[0];
        long i, n, t0, t1, dt, tiempoEspera;
        boolean response, flag;
        
        //Porque solo se va a eliminar el del prefijo, no se quitó el for ni
        //se eliminó el parámetro que recibe la cantidad de solicitudes por
        //cuestiones de tiempo y para poder seguir el mismo formato en caso de
        //querer invocarlo usando un bat. debido a que se quiere eliminar con
        //varios clientes o algo por el estilo.
        n = 1;

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            IServDisparo servDisparo = (IServDisparo) registry.lookup("ServidorDeDisparo");
            lngQuienSoy = servDisparo.quienSoy();
            lngCuantosMilisFaltan = servDisparo.deltaTEnMilis();
            System.out.println("Cliente " + lngQuienSoy + " faltan " + lngCuantosMilisFaltan + " milisegundos");
            sumDeltaT = 0;
            sumDeltaT2 = 0;
            //Yo saqué aquí el service para no crearlo cada que llamo al 
            //webService.
            wsescbaile.NewWebService_Service service = new wsescbaile.NewWebService_Service();
            Thread.currentThread().sleep(lngCuantosMilisFaltan);

            String cveAlumno, nomAlumno, apPatAlumno, apMatAlumno;
            String strSufAlumno;
            //Aquí se declaran las cadenas de textos para el número de cliente
            //y para el número de solicitud.
            String quienSoyTexto = "";
            cveAlumno = "E_";
            nomAlumno = "nomAl_";
            apPatAlumno = "apPatAl_";
            apMatAlumno = "apMatAl_";

            for (i = 0; i < n; i++) {
                t0 = System.currentTimeMillis();
                //Esta serie de ifs es para poder rellenar con ceros a la
                //izquierda el servidor
                if (lngQuienSoy < 10) {
                    quienSoyTexto = "00" + lngQuienSoy;
                }
                if (lngQuienSoy >= 10 && lngQuienSoy < 100) {
                    quienSoyTexto = "0" + lngQuienSoy;
                }
                if (lngQuienSoy >= 100) {
                    quienSoyTexto = "" + lngQuienSoy;
                }
                strSufAlumno = "" + quienSoyTexto + "_" + args[2];
                response = borraAlumno(cveAlumno + strSufAlumno, nomAlumno + strSufAlumno, apPatAlumno + strSufAlumno, apMatAlumno + strSufAlumno, service);
                t1 = System.currentTimeMillis();
                dt = t1 - t0;
                sumDeltaT += dt;
                sumDeltaT2 += dt * dt;
                if (i == 0) {
                    dtMin = dt;
                    dtMax = dt;
                } else {
                    if (dt < dtMin) {
                        dtMin = dt;
                    }
                    if (dt > dtMax) {
                        dtMax = dt;
                    }
                }
                System.out.println("Clte " + lngQuienSoy + ": " + response);
            }
            servDisparo.acumula(sumDeltaT, sumDeltaT2, n, dtMax, dtMin);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static boolean altaAlumno(java.lang.String cveAlumno, java.lang.String nombreAlumno, java.lang.String apPaternoAlumno, java.lang.String apMaternoAlumno, wsescbaile.NewWebService_Service service) {
        wsescbaile.NewWebService port = service.getNewWebServicePort();
        return port.altaAlumno(cveAlumno, nombreAlumno, apPaternoAlumno, apMaternoAlumno);
    }

    private static Boolean modificaAlumno(java.lang.String cveAlumnoV, java.lang.String nombreAlumnoV, java.lang.String apPaternoAlumnoV, java.lang.String apMaternoAlumnoV, java.lang.String cveAlumnoN, java.lang.String nombreAlumnoN, java.lang.String apPaternoAlumnoN, java.lang.String apMaternoAlumnoN, wsescbaile.NewWebService_Service service) {
        wsescbaile.NewWebService port = service.getNewWebServicePort();
        return port.modificaAlumno(cveAlumnoV, nombreAlumnoV, apPaternoAlumnoV, apMaternoAlumnoV, cveAlumnoN, nombreAlumnoN, apPaternoAlumnoN, apMaternoAlumnoN);
    }

    private static Boolean borraAlumno(java.lang.String cveAlumno, java.lang.String nombreAlumno, java.lang.String apPaternoAlumno, java.lang.String apMaternoAlumno, wsescbaile.NewWebService_Service service) {
        wsescbaile.NewWebService port = service.getNewWebServicePort();
        return port.borraAlumno(cveAlumno, nombreAlumno, apPaternoAlumno, apMaternoAlumno);
    }

}
//================================================================

