/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsmensajes;

import boundary.MessageFacade;
import entities.Message;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Polupero
 */
@WebService(serviceName = "WSMensajes")
public class WSMensajes {

    @EJB
    private MessageFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Message entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Message entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Message entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Message find(@WebParam(name = "id") int id) {
        return ejbRef.find(new Long(id));
    }

    @WebMethod(operationName = "findAll")
    public List<Message> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Message> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "creaMensaje")
    public boolean creaMensaje(@WebParam(name = "strMensaje") String strMensaje) {
        Message entity = new Message();
        entity.setMessage(strMensaje);
        ejbRef.create(entity);
        return true;
    }
    
}
