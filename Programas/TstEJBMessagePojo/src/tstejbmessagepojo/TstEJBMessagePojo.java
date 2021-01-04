/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstejbmessagepojo;

import wsmessageclient.Message;

/**
 *
 * @author Polupero
 */
public class TstEJBMessagePojo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //find por id
        int id = 1;
        Message msg = find(id);
        System.out.println("msg: " + msg.getId() + " -> " + msg.getMessage());
        
        //find all
        java.util.List<wsmessageclient.Message> listmsgs = findAll();
        //Esto simplemente es un for que se refactorizo automaticamente con NetBeans
//for(Message m:listmsgs)
//            System.out.println("msg: " + msg.getId() + " -> " + msg.getMessage());
        listmsgs.forEach((_item) -> {
            System.out.println("mensaje: " + _item.getId() + " -> " + _item.getMessage());
        });
        
        //editaMensaje, en este caso edita el primer mensaje porque al principio
        //del main hicimos que msg = find(1), podemos cambiarlo al hacer otro
        //find primero
//        System.out.println("------------------------");
//        msg.setMessage("Este es un mensaje editado");
//        edit(msg); //Esto edita el mensaje, pero no se aprecia a menos que cambie
//        //el setMessage para probarlo.
//        msg = find(id);
//        System.out.println("msg: " + msg.getId() + " -> " + msg.getMessage());
        
        //Crea mensaje desde una entidad (msg en este caso)
//    msg = new Message();
//    msg.setMessage("Mensaje desde WsClientPojo");
//    create(msg); //Agrega un mensaje a la BD
    
        //Crea mensaje desde un String
//    boolean blnCreaMensaje = creaMensaje("Mensaje creado desde el Pojo");
//        if (blnCreaMensaje)
//            System.out.println("Se ha creado el mensaje");
//        else
//            System.out.println("Llamar a los bomberos!!!");
    }

    private static Message find(int id) {
        wsmessageclient.WSMensajes_Service service = new wsmessageclient.WSMensajes_Service();
        wsmessageclient.WSMensajes port = service.getWSMensajesPort();
        return port.find(id);
    }

    private static java.util.List<wsmessageclient.Message> findAll() {
        wsmessageclient.WSMensajes_Service service = new wsmessageclient.WSMensajes_Service();
        wsmessageclient.WSMensajes port = service.getWSMensajesPort();
        return port.findAll();
    }

    private static void create(wsmessageclient.Message entity) {
        wsmessageclient.WSMensajes_Service service = new wsmessageclient.WSMensajes_Service();
        wsmessageclient.WSMensajes port = service.getWSMensajesPort();
        port.create(entity);
    }

    private static void edit(wsmessageclient.Message entity) {
        wsmessageclient.WSMensajes_Service service = new wsmessageclient.WSMensajes_Service();
        wsmessageclient.WSMensajes port = service.getWSMensajesPort();
        port.edit(entity);
    }

    private static boolean creaMensaje(java.lang.String strMensaje) {
        wsmessageclient.WSMensajes_Service service = new wsmessageclient.WSMensajes_Service();
        wsmessageclient.WSMensajes port = service.getWSMensajesPort();
        return port.creaMensaje(strMensaje);
    }
    
    
}
