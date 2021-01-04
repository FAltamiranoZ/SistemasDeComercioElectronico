/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstjson_00;

import java.time.LocalDate;
import java.time.Month;
import org.json.JSONObject;

/**
 *
 * @author Polupero
 */
public class ClsPersona {
    
    String nombre;
    String apPat;
    String apMat;
    LocalDate fechaNac;
    
    public ClsPersona(){
    }
    
    public ClsPersona(String nombre, String apPat, String apMat, LocalDate fechaNac){
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.fechaNac = fechaNac;
    }

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

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Nombre de la clase: ");
        sb.append(this.getClass().getName());
        sb.append("\n Nombre: ");
        sb.append(this.getNombre());
        sb.append("\n Apellido paterno: ");
        sb.append(this.getApPat());
        sb.append("\n Apellido materno: ");
        sb.append(this.getApMat());
        sb.append("\n Fecha de nacimiento: ");
        sb.append(this.getFechaNac());
        
        return sb.toString();
    }

    
    
    public static void main(String args[]) {
        ClsPersona per = new ClsPersona("Rafael Gregorio", "Gamboa", "Hirales", LocalDate.of(1955, Month.MARCH, 25));
        //Print del toString()
        System.out.println("Persona: " + per +  "\n");
        
        //Print al pasar a la persona como objeto JSON
        JSONObject jsonObject = new JSONObject(per);
        String strJsonPer = jsonObject.toString();
        System.out.println("Persona en JSON: " + strJsonPer + "\n");
        
        //Print al pasar el toString de un objeto JSON como objeto JSON, la
        //ventaja de hacerlo de esta manera, es que puedes llamar atributos
        //específicos.
        JSONObject ojop = new JSONObject(strJsonPer);
        System.out.println("ojop: " + ojop.toString() + "\n");
        //Aquí llamamos un atributo específico
        System.out.println("ojop.getString(nombre): " + ojop.getString("nombre") + "\n");
        
        //Esto es solo para demostrar que recuperando los atributos específicos
        //no se pierde nada y podemos reconstruir el objeto original.
        ClsPersona op = new ClsPersona();
        op.setNombre(ojop.getString("nombre"));
        op.setApPat(ojop.getString("apPat"));
        op.setApMat(ojop.getString("apMat"));
        String strFecha = ojop.getString("fechaNac");
        LocalDate fecha = LocalDate.parse(strFecha);
        op.setFechaNac(fecha);
        System.out.println("op: " + op + "\n");
    }

}
