package escdebaile;

/*
 * ClsGestorEscBaile.java
 */
/**
 *
 * @author RGGH
 */
public class ClsGestorEscBaile {

    ClsConexion conexion;
// ---------------------------------------------------------------------------    

    public ClsGestorEscBaile() {
        String strBD = "D:\\Universidad\\SistemasDeComercio\\Programas\\EscBaileWeb\\EscDeBaile";
        conexion = new ClsConexion(strBD);
    }
// ---------------------------------------------------------------------------        

    public boolean conectaBD(String strUsuario, String strContrasenha) {
        return conexion.conectate(strUsuario, strContrasenha);
    }
// ---------------------------------------------------------------------------        

    public boolean conectado() {
        return conexion.conectado();
    }
// --------------------------------------------------------------------------- 

    public void desconecta() {
        conexion.cierraCon();
    }
// --------------------------------------------------------------------------- 

    public java.sql.ResultSet obtenAlumnos() {
        return conexion.obtenRS("tblAlumnos");
    }
// ---------------------------------------------------------------------------

    public MiModelo obtenModeloAlumno(String clvAlumno) {
        java.sql.ResultSet rs = conexion.obtenRegSelect("Select * from tblAlumnos where clvAlumno='" + clvAlumno + "'");
        MiModelo elModelo = new MiModelo(rs);
        return elModelo;
    }
// ---------------------------------------------------------------------------

    public MiModelo obtenModeloAlumnos() {
        java.sql.ResultSet rs = conexion.obtenRegSelect("Select * from tblAlumnos");
        MiModelo elModelo = new MiModelo(rs);
        return elModelo;
    }
// ---------------------------------------------------------------------------

// ---------------------------------------------------------------------------
    public java.sql.ResultSet obtenProfesores() {
        return conexion.obtenRS("tblProfesores");
    }
// ---------------------------------------------------------------------------    

    public java.sql.ResultSet obtenBailes() {
        return conexion.obtenRS("tblBailes");
    }
// ---------------------------------------------------------------------------    

    public java.sql.ResultSet obtenNiveles() {
        return conexion.obtenRS("tblNiveles");
    }
// ---------------------------------------------------------------------------    

    public java.sql.ResultSet obtenGrupos() {
        return conexion.obtenRS("tblGrupos");
    }
// ---------------------------------------------------------------------------    

    public java.sql.ResultSet obtenAlumnosPorGrupo(String numGpo) {
        return null;
    }
// ---------------------------------------------------------------------------
//                           Obtener un solo campo
// ---------------------------------------------------------------------------

    public java.sql.ResultSet obtenCampoParaLista(String strTV, String strCampo) {
        String strSelect = "Select " + strCampo + " From " + strTV;
        return conexion.obtenRegSelect(strSelect);
    }
// ---------------------------------------------------------------------------    
//                            Altas de registros 
// ---------------------------------------------------------------------------

    public boolean altaAlumno(String arr_nomCampos[], String arr_datos[]) {
        int i, n;

        //Un arbol de campos es un arreglo de campos donde cada hoja de este arbol
        //(cada objeto del arreglo) contiene el nombre del campo y un objeto de 
        //tipo campo. El objeto de tipo campo a su vez contiene el nombre del 
        //campo, un espacio para el nuevo valor, el tipo del campo y su espacio 
        //para el valor antiguo. (fuck knows porque dos veces el nombre del
        //campo) En el caso de alta, el valor antiguo va vacío y viceversa en el
        //caso de baja, solo en modificados se llenan los 2
        //En este caso, el arbol de campos nos regresa el mismo número de hojas 
        //que de columnas hay en la base de datos, por lo que tendríamos un arbol 
        //con 4 hojas, [(clvAlumno, campo), (nombre, campo), (apPaterno, campo), 
        //(apMaterno, campo)] y cada campo se vería como: 
        //(clvAlumno, "", ClsCampoBD.TIPO_VARCHAR, ""), (nombre, "", 
        //ClsCampoBD.TIPO_VARCHAR, ""), (apPaterno, "", 
        //ClsCampoBD.TIPO_VARCHAR, ""), (apMaterno, "", 
        //ClsCampoBD.TIPO_VARCHAR, "")
        //Como esta es una estructura que salió de ClasCampoBD, el nombre de
        //atributo de cada cosa es: (nombre, valor, tipo, valwhere)
        java.util.TreeMap<String, ClsCampoBD> colCampos = conexion.obtenMapaCampos(conexion.obtenRS("tblAlumnos"));

        n = arr_nomCampos.length;

        //Se rellena el espacio del nuevo valor
        for (i = 0; i < n; i++) {
            ((ClsCampoBD) colCampos.get(arr_nomCampos[i])).valor = arr_datos[i];
            //colCampos.clvAlumno.valor = cve_al0 por ejemplo.
        }

        // se solicita al objeto conexión que inserte el registro y se espera el resultado
        return conexion.insertaReg("tblAlumnos", colCampos);
    }

    public boolean modificaAlumno2(String arr_nomCampos[], String arr_datosV[], String arr_datosN[]) {
        int i, n;

        java.util.TreeMap<String, ClsCampoBD> colCampos = conexion.obtenMapaCampos(conexion.obtenRS("tblAlumnos"));

        n = arr_nomCampos.length;

        for (i = 0; i < n; i++) {
            ((ClsCampoBD) colCampos.get(arr_nomCampos[i])).valor = arr_datosN[i];
            ((ClsCampoBD) colCampos.get(arr_nomCampos[i])).valWhere = arr_datosV[i];
        }

        return conexion.modificaReg("tblAlumnos", colCampos);
    }

    //Yo cree esta función que elimina alumnos al recibiar todos los datos de 
    //valor y valwhere
    public boolean borraAlumno(String arr_nomCampos[], String arr_datos[]) {
        int i, n;

        java.util.TreeMap<String, ClsCampoBD> colCampos = conexion.obtenMapaCampos(conexion.obtenRS("tblAlumnos"));

        n = arr_nomCampos.length;

        for (i = 0; i < n; i++) {
            ((ClsCampoBD) colCampos.get(arr_nomCampos[i])).valWhere = arr_datos[i];
        }

        return conexion.eliminaRegs("tblAlumnos", colCampos);
    }
// ---------------------------------------------------------------------------    

    //En la versión Web, el modificaAlumno no modifica la clave, por eso se 
    public boolean modificaAlumno(MiModelo mm) {
        int col, colCve = -1;
        String strCve = null;

        int numCampos = mm.getColumnCount();
        String[] strNomDatos = new String[numCampos];
        String[] strDatos = new String[numCampos];

        for (col = 0; col < numCampos; col++) {
            strNomDatos[col] = mm.getColumnName(col);
            strDatos[col] = (String) mm.getValueAt(0, col);
            System.out.println(col + " -> " + strNomDatos[col] + ":" + strDatos[col]);
            if (strNomDatos[col].toLowerCase().startsWith("clv")) {
                colCve = col;
                strCve = strDatos[col];
            }
        }
        java.util.TreeMap<String, ClsCampoBD> colCampos
                = conexion.obtenMapaCampos(conexion.obtenRegSelect("Select * from tblAlumnos where clvAlumno ='" + strCve + "';"));

        for (col = 0; col < numCampos; col++) {
            colCampos.get(strNomDatos[col]).valor = strDatos[col];
        }
        colCampos.get(strNomDatos[colCve]).valWhere = strCve;

        return conexion.modificaReg("tblAlumnos", colCampos);

    }

// ---------------------------------------------------------------------------    
    public boolean altaProfesor() {
        return true;
    }
// ---------------------------------------------------------------------------    

    public boolean altaBaile() {
        return true;
    }
// ---------------------------------------------------------------------------    

    public boolean altaNivel() {
        return true;
    }
// ---------------------------------------------------------------------------    

    public boolean altaGrupo() {
        return true;
    }
// ---------------------------------------------------------------------------    

    public boolean altaAlumnoEnGrupo(String numGpo, String clvAlumno) {
        return true;
    }
// ---------------------------------------------------------------------------    
// ---------------------------------------------------------------------------    
// ---------------------------------------------------------------------------    
// ---------------------------------------------------------------------------    

}
