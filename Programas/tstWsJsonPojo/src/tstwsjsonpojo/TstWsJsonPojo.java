/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstwsjsonpojo;

import java.time.LocalDate;
import org.json.JSONObject;
import tstjson_00.ClsPersona;

/**
 *
 * @author Polupero
 */
public class TstWsJsonPojo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se recupera el strJsonPersona que esta creado por default en el
        //webService y se reconstruye en un objeto.
        String strJsonPer = obtenPersona(1L);
        System.out.println("strJsonPer: " + strJsonPer + "\n");
        JSONObject ojop = new JSONObject(strJsonPer);
        ClsPersona op = new ClsPersona();
        op.setNombre(ojop.getString("nombre"));
        op.setApPat(ojop.getString("apPat"));
        op.setApMat(ojop.getString("apMat"));
        String strFecha = ojop.getString("fechaNac");
        LocalDate fecha = LocalDate.parse(strFecha);
        op.setFechaNac(fecha);
        System.out.println("op: " + op + "\n");
    }

    //El idPersona no sirve de nada, Gamboa se lo puso por necedad.
    private static String obtenPersona(long idPersona) {
        wsjsonPersonaClte.WsJsonPersona_Service service = new wsjsonPersonaClte.WsJsonPersona_Service();
        wsjsonPersonaClte.WsJsonPersona port = service.getWsJsonPersonaPort();
        return port.obtenPersona(idPersona);
    }
    
}
