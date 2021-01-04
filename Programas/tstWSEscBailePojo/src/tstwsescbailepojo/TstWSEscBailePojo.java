/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstwsescbailepojo;


/**
 *
 * @author Polupero
 */
public class TstWSEscBailePojo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        wsescbaile.NewWebService_Service service = new wsescbaile.NewWebService_Service();
        boolean blnRes;
        
//        int Nveces = 10;
//        long t0, t1, lngSumDeltaT;
//        double deltaTseg;
//        String cveAlumno, nomAlumno, apPatAlumno, apMatAlumno;
//        String strSufAlumno;
//        String strCadRes;
//        
//
//        cveAlumno = "cveAl_";
//        nomAlumno = "nomAl_";
//        apPatAlumno = "apPatAl_";
//        apMatAlumno = "apMatAl_";
//        lngSumDeltaT = 0;
//        
//        for (int i = 0; i < Nveces; i++) {
//            strSufAlumno = "" + i;
//            t0 = System.currentTimeMillis();
//            blnRes = altaAlumno(cveAlumno + strSufAlumno, nomAlumno + strSufAlumno, apPatAlumno + strSufAlumno, apMatAlumno + strSufAlumno);
//            t1 = System.currentTimeMillis();
//            lngSumDeltaT += t1 - t0;
//            deltaTseg = (t1 - t0) / 1000.0;
//            strCadRes = blnRes ? "Se ha realizado " : "No se pudo realizar" + " el alta del alumno clave " + cveAlumno + strSufAlumno;
//            System.out.println(strCadRes + " en " + deltaTseg + " seg.");
//        }
//        System.out.println("Eltiempo promedio de solicitud es: " + (lngSumDeltaT/1000.0)/Nveces);
        
        blnRes = modificaAlumno("cveAl_0", "nomAl_0", "apPatAl_0", "apMatAl_0", "cc", "nn", "aa", "aa", service);
        //blnRes = modificaAlumno("cc", "nn", "aa", "aa", "cveAl_0", "nomAl_0", "apPatAl_0", "apMatAl_0", service);
        System.out.println(blnRes);
    }

    private static boolean altaAlumno(java.lang.String cveAlumno, java.lang.String nombreAlumno, java.lang.String apPaternoAlumno, java.lang.String apMaternoAlumno, wsescbaile.NewWebService_Service service) {
        wsescbaile.NewWebService port = service.getNewWebServicePort();
        return port.altaAlumno(cveAlumno, nombreAlumno, apPaternoAlumno, apMaternoAlumno);
    }

    private static Boolean modificaAlumno(java.lang.String cveAlumnoV, java.lang.String nombreAlumnoV, java.lang.String apPaternoAlumnoV, java.lang.String apMaternoAlumnoV, java.lang.String cveAlumnoN, java.lang.String nombreAlumnoN, java.lang.String apPaternoAlumnoN, java.lang.String apMaternoAlumnoN, wsescbaile.NewWebService_Service service) {
        wsescbaile.NewWebService port = service.getNewWebServicePort();
        return port.modificaAlumno(cveAlumnoV, nombreAlumnoV, apPaternoAlumnoV, apMaternoAlumnoV, cveAlumnoN, nombreAlumnoN, apPaternoAlumnoN, apMaternoAlumnoN);
    }

}
