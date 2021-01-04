/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajson;

import java.time.*;
import org.json.JSONObject;
/**
 *
 * @author Rafael
 */
public class ClsPersona
{
       // Bean ClsPersona
       String nombre = null;
       String apPat  = null;
       String apMat  = null;
       java.time.LocalDate  fechaNac = null;
       
    public ClsPersona(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public java.time.LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac( java.time.LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
       
   
       @Override
    public String toString()
    {
        return this.getClass().getName() + ":" + 
               "\nNombre:             " + this.getNombre() +
               "\nApellido Paterno:   " + this.getApPat() + 
               "\nApellido Materno:   " + this.getApMat() +
               "\nFecha de Nacimiento:" + this.getFechaNac();
    }
       
    public static void main( String args[])
    {
        ClsPersona per = new ClsPersona();
        per.setNombre("Rafael Gregorio");
        per.setApPat("Gamboa");
        per.setApMat("Hirales");
        per.setFechaNac(java.time.LocalDate.of(1955, Month.MARCH, 25));
        
        System.out.println(per);
        System.out.println("\n");
 
        JSONObject json = new JSONObject(per);        
        String cadJson = json.toString();
        System.out.println("json:\n" + json);
        
        JSONObject otrojson = new JSONObject(cadJson);
        
        ClsPersona otraper = new ClsPersona();
        otraper.setNombre(otrojson.getString("nombre"));
        otraper.setApPat(otrojson.getString("apPat"));
        otraper.setApMat(otrojson.getString("apMat"));
        String strFechaNac = (String) otrojson.get("fechaNac");        
        java.time.LocalDate fechaNac = java.time.LocalDate.parse(strFechaNac);
        System.out.println("strFecha:\n" + strFechaNac);
        System.out.println("fechaNac:\n" + fechaNac);
        
        otraper.setFechaNac(fechaNac);
        System.out.println("---------------------------");
        System.out.println("otraper:\n"+otraper);
        System.out.println("---------------------------");
                
    }
    
    
       
}
