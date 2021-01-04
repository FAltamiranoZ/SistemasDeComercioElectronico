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

        //Este parámetro recibe la cantidad de solicitudes deseadas
        if (args[1] != null) {
            n = Integer.parseInt(args[1]);
        } else {
            n = 200;
        }

        //Este parámetro recibe el tiempo de espera del cliente, de no haberse
        //especificado se asignan 250 milisegundos
        if (args[2] != null) {
            tiempoEspera = Integer.parseInt(args[2]);
        } else {
            tiempoEspera = 250;
        }

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
            String quienSoyTexto = "", queNumeroSoy = "";
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
                //Esta serie de ifs es para poder rellenar con ceros a la
                //izquierda el número de cliente.
                if (i < 10) {
                    queNumeroSoy = "000" + i;
                }
                if (i >= 10 && i < 100) {
                    queNumeroSoy = "00" + i;
                }
                if (i >= 100 && i < 1000) {
                    queNumeroSoy = "0" + i;
                }
                if (i >= 1000) {
                    queNumeroSoy = "" + i;
                }

                strSufAlumno = "" + quienSoyTexto + "_" + queNumeroSoy;
                //Aquí se crean o se borran alumnos según se desee
                response = altaAlumno(cveAlumno + strSufAlumno, nomAlumno + strSufAlumno, apPatAlumno + strSufAlumno, apMatAlumno + strSufAlumno, service);
                //response = borraAlumno(cveAlumno + strSufAlumno, nomAlumno + strSufAlumno, apPatAlumno + strSufAlumno, apMatAlumno + strSufAlumno, service);
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
                //Este es el sleep entre transacciones.
                Thread.sleep(tiempoEspera);
//                Thread.sleep(250);
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

