/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obtencontenidobd;

import escdebaile.ClsCampoBD;
import escdebaile.ClsConexion;
import java.sql.ResultSet;
import java.util.TreeMap;

/**
 *
 * @author rggh
 */
public class ObtenContenidoBD 
{

    /**
     * @param args the command line arguments
     */
   // ---------------------------------------------------------------------------    
    public static void main(String[] args)
    {
      int i,n;  
      String strTbls[];  
      ResultSet r = null;
      java.util.TreeMap<String,ClsCampoBD> colCampos = null;
        
      String strLocBD   = "D:\\Universidad\\SistemasDeComercio\\Programas\\obtenScriptDatosBD\\EscDeBaile";     
      
//Si hacemos run de este proyecto, automaticamente usa los args especificados
//en sus propiedades en la parte de run, pero si le damos run solamente a este
//archivo, entonces no corre con ningun argumento, el código de abajo sirve 
//para pasarle argumentos y probarlo sin correr todo.
//      args = new String[1];
//      args[0] = "tblAlumnos";
      
      n = args.length;
      if(n > 0 )
      {
        strTbls = new String[args.length];
        for( i = 0; i < n; i++)
            strTbls[i] = args[i];
        try
        { 
           ClsConexion c = new ClsConexion(strLocBD);
           c.conectate("rafa","rafa");
           if( c.conectado() )    
           {
             System.out.println("connect 'jdbc:derby://localhost:1527/ejemplo;user=app;password=app';\n");
             for( i = 0; i < n; i++)//Siempre se hacen primero todos los drop.
                   System.out.println("DROP TABLE " + strTbls[i] + ";");
               System.out.println();
             
             for( i = 0; i < n; i++)
             {
               String strTbl = strTbls[i];
               r = c.obtenRS(strTbl);
               colCampos = c.obtenMapaCampos(r);
               r = c.obtenRS(strTbl,colCampos );
               if( i > 0)
                     System.out.println("\n");    
               System.out.println(c.obtenCadenaInsertRS(strTbl,r));               
             }
             c.cierraCon();
             System.out.println("disconnect;");
           }
           else
           {
              System.out.println("No se pudo conectar..."); 
           }
        }
        catch( Exception e )
        {
          e.printStackTrace();
        }
    }
    else
    {
        System.out.println("No hay nombres de tablas para trabajar...");      
    }
  }
// ---------------------------------------------------------------------------       
}
