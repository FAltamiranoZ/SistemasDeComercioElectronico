/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsEscBaile;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import escdebaile.ClsGestorEscBaile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    //Yo puse aquí al gestor para evitar que se creara cada 5 segundos
    ClsGestorEscBaile gestor = new ClsGestorEscBaile();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "altaAlumno")
    public boolean altaAlumno(@WebParam(name = "cveAlumno") String cveAlumno, @WebParam(name = "nombreAlumno") String nombreAlumno, @WebParam(name = "apPaternoAlumno") String apPaternoAlumno, @WebParam(name = "apMaternoAlumno") String apMaternoAlumno) {
        //
        // habilitar el alta de alumno
        //
        String arrStrNomCampos[] = {"clvAlumno", "apPaterno", "apMaterno", "nombre"};
        String arrStrValCampos[] = new String[4];

        boolean blnRes = false;

        boolean conectado = gestor.conectaBD("rafa", "rafa");

        if (conectado) {
            arrStrValCampos[0] = cveAlumno;
            arrStrValCampos[1] = apPaternoAlumno;
            arrStrValCampos[2] = apMaternoAlumno;
            arrStrValCampos[3] = nombreAlumno;

            blnRes = gestor.altaAlumno(arrStrNomCampos, arrStrValCampos);

        }

        return blnRes;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificaAlumno")
    public Boolean modificaAlumno(@WebParam(name = "cveAlumnoV") String cveAlumnoV, @WebParam(name = "nombreAlumnoV") String nombreAlumnoV, @WebParam(name = "apPaternoAlumnoV") String apPaternoAlumnoV, @WebParam(name = "apMaternoAlumnoV") String apMaternoAlumnoV, @WebParam(name = "cveAlumnoN") String cveAlumnoN, @WebParam(name = "nombreAlumnoN") String nombreAlumnoN, @WebParam(name = "apPaternoAlumnoN") String apPaternoAlumnoN, @WebParam(name = "apMaternoAlumnoN") String apMaternoAlumnoN) {

        String arrStrNomCampos[] = {"clvAlumno", "apPaterno", "apMaterno", "nombre"};
        String arrStrValCamposV[] = new String[4];
        String arrStrValCamposN[] = new String[4];

        boolean blnRes = false;
        boolean conectado = gestor.conectaBD("rafa", "rafa");

        if (conectado) {
            arrStrValCamposV[0] = cveAlumnoV;
            arrStrValCamposV[1] = apPaternoAlumnoV;
            arrStrValCamposV[2] = apMaternoAlumnoV;
            arrStrValCamposV[3] = nombreAlumnoV;

            arrStrValCamposN[0] = cveAlumnoN;
            arrStrValCamposN[1] = apPaternoAlumnoN;
            arrStrValCamposN[2] = apMaternoAlumnoN;
            arrStrValCamposN[3] = nombreAlumnoN;

            blnRes = gestor.modificaAlumno2(arrStrNomCampos, arrStrValCamposV, arrStrValCamposN);

        }

        return blnRes;
    }

    /**
     * Web service operation
     */
    //Este es el servicio que cree para borrar alumnos, el cual a su vez hace
    //referencia al método creado en el gestor.
    @WebMethod(operationName = "borraAlumno")
    public Boolean borraAlumno(@WebParam(name = "cveAlumno") String cveAlumno, @WebParam(name = "nombreAlumno") String nombreAlumno, @WebParam(name = "apPaternoAlumno") String apPaternoAlumno, @WebParam(name = "apMaternoAlumno") String apMaternoAlumno) {
        String arrStrNomCampos[] = {"clvAlumno", "apPaterno", "apMaterno", "nombre"};
        String arrStrValCampos[] = new String[4];

        boolean blnRes = false;

        boolean conectado = gestor.conectaBD("rafa", "rafa");

        if (conectado) {
            arrStrValCampos[0] = cveAlumno;
            arrStrValCampos[1] = apPaternoAlumno;
            arrStrValCampos[2] = apMaternoAlumno;
            arrStrValCampos[3] = nombreAlumno;

            blnRes = gestor.borraAlumno(arrStrNomCampos, arrStrValCampos);

        }

        return blnRes;
    }
}
