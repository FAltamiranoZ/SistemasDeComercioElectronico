/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsCat;

import entities.Category;
import facades.CategoryFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Polupero
 */
@WebService(serviceName = "WSCat")
public class WSCat {

    @EJB
    private CategoryFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    public int create(@WebParam(name = "entity") Category entity) {
        ejbRef.create(entity);
        int idNvoCustomer = entity.getId();
//el logger esta para farolear y que aparezca en el output del glassfishServer,
//se puede quitar sin problema.
        Logger.getLogger(WSCat.class.getName()).log(Level.SEVERE, "El id del nuevo cliente es {0}", entity.toString());
        return idNvoCustomer;
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Category entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Category entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Category find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Category> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Category> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
    @WebMethod(operationName = "findByName")
    public List<Category> findByName(@WebParam(name = "nombre") String nombre) {
        return ejbRef.findByName(nombre);
    }
    
}
