/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsProd;

import entities.Product;
import facades.ProductFacade;
import java.util.ArrayList;
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
@WebService(serviceName = "WSProd")
public class WSProd {

    @EJB
    private ProductFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    public int create(@WebParam(name = "entity") Product entity) {
        ejbRef.create(entity);
        int idNvoCustomer = entity.getId();
        Logger.getLogger(WSProd.class.getName()).log(Level.SEVERE, "El id del nuevo cliente es {0}", entity.toString());
        return idNvoCustomer;
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Product entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Product entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Product find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Product> findAll() {
        Product q;
        List<Product> lista = ejbRef.findAll();
        List<Product> otraLista = new ArrayList<>();
        for (Product p : lista) {
            q = new Product();
            q.setId(p.getId());
            q.setName(p.getName());
            q.setDescription(p.getDescription());
            q.setPrice(p.getPrice());
            q.setLastUpdate(p.getLastUpdate());
            q.setCategoryId(p.getCategoryId());
            otraLista.add(q);
        }
        return otraLista;
    }
    
    @WebMethod(operationName = "catalogo")
    public List<Product> catalogo() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Product> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
        @WebMethod(operationName = "findByName")
    public List<Product> findByName(@WebParam(name = "nombre") String nombre) {
        return ejbRef.findByName(nombre);
    }

    @WebMethod(operationName = "findLikeName")
    public List<Product> findLikeName(@WebParam(name = "nombre") String nombre) {
        return ejbRef.findLikeName(nombre);
    }

    @WebMethod(operationName = "precioPromPorCatId")
    public String precioPromPorCatId() {
        return ejbRef.precioPromPorCatId();
    }
    
}
