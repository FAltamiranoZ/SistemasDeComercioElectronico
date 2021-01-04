
package wsprod;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSProd", targetNamespace = "http://wsProd/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSProd {


    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "remove", targetNamespace = "http://wsProd/", className = "wsprod.Remove")
    @Action(input = "http://wsProd/WSProd/remove")
    public void remove(
        @WebParam(name = "entity", targetNamespace = "")
        Product entity);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://wsProd/", className = "wsprod.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://wsProd/", className = "wsprod.CountResponse")
    @Action(input = "http://wsProd/WSProd/countRequest", output = "http://wsProd/WSProd/countResponse")
    public int count();

    /**
     * 
     * @param id
     * @return
     *     returns wsprod.Product
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "find", targetNamespace = "http://wsProd/", className = "wsprod.Find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://wsProd/", className = "wsprod.FindResponse")
    @Action(input = "http://wsProd/WSProd/findRequest", output = "http://wsProd/WSProd/findResponse")
    public Product find(
        @WebParam(name = "id", targetNamespace = "")
        Object id);

    /**
     * 
     * @param entity
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "create", targetNamespace = "http://wsProd/", className = "wsprod.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://wsProd/", className = "wsprod.CreateResponse")
    @Action(input = "http://wsProd/WSProd/createRequest", output = "http://wsProd/WSProd/createResponse")
    public int create(
        @WebParam(name = "entity", targetNamespace = "")
        Product entity);

    /**
     * 
     * @param nombre
     * @return
     *     returns java.util.List<wsprod.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByName", targetNamespace = "http://wsProd/", className = "wsprod.FindByName")
    @ResponseWrapper(localName = "findByNameResponse", targetNamespace = "http://wsProd/", className = "wsprod.FindByNameResponse")
    @Action(input = "http://wsProd/WSProd/findByNameRequest", output = "http://wsProd/WSProd/findByNameResponse")
    public List<Product> findByName(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre);

    /**
     * 
     * @return
     *     returns java.util.List<wsprod.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://wsProd/", className = "wsprod.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://wsProd/", className = "wsprod.FindAllResponse")
    @Action(input = "http://wsProd/WSProd/findAllRequest", output = "http://wsProd/WSProd/findAllResponse")
    public List<Product> findAll();

    /**
     * 
     * @return
     *     returns java.util.List<wsprod.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "catalogo", targetNamespace = "http://wsProd/", className = "wsprod.Catalogo")
    @ResponseWrapper(localName = "catalogoResponse", targetNamespace = "http://wsProd/", className = "wsprod.CatalogoResponse")
    @Action(input = "http://wsProd/WSProd/catalogoRequest", output = "http://wsProd/WSProd/catalogoResponse")
    public List<Product> catalogo();

    /**
     * 
     * @param nombre
     * @return
     *     returns java.util.List<wsprod.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findLikeName", targetNamespace = "http://wsProd/", className = "wsprod.FindLikeName")
    @ResponseWrapper(localName = "findLikeNameResponse", targetNamespace = "http://wsProd/", className = "wsprod.FindLikeNameResponse")
    @Action(input = "http://wsProd/WSProd/findLikeNameRequest", output = "http://wsProd/WSProd/findLikeNameResponse")
    public List<Product> findLikeName(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre);

    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "edit", targetNamespace = "http://wsProd/", className = "wsprod.Edit")
    @Action(input = "http://wsProd/WSProd/edit")
    public void edit(
        @WebParam(name = "entity", targetNamespace = "")
        Product entity);

    /**
     * 
     * @param range
     * @return
     *     returns java.util.List<wsprod.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findRange", targetNamespace = "http://wsProd/", className = "wsprod.FindRange")
    @ResponseWrapper(localName = "findRangeResponse", targetNamespace = "http://wsProd/", className = "wsprod.FindRangeResponse")
    @Action(input = "http://wsProd/WSProd/findRangeRequest", output = "http://wsProd/WSProd/findRangeResponse")
    public List<Product> findRange(
        @WebParam(name = "range", targetNamespace = "")
        List<Integer> range);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "precioPromPorCatId", targetNamespace = "http://wsProd/", className = "wsprod.PrecioPromPorCatId")
    @ResponseWrapper(localName = "precioPromPorCatIdResponse", targetNamespace = "http://wsProd/", className = "wsprod.PrecioPromPorCatIdResponse")
    @Action(input = "http://wsProd/WSProd/precioPromPorCatIdRequest", output = "http://wsProd/WSProd/precioPromPorCatIdResponse")
    public String precioPromPorCatId();

}