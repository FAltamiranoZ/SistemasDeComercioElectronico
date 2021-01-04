
package wscust;

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
@WebService(name = "WSCustomer", targetNamespace = "http://wsCust/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSCustomer {


    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "remove", targetNamespace = "http://wsCust/", className = "wscust.Remove")
    @Action(input = "http://wsCust/WSCustomer/remove")
    public void remove(
        @WebParam(name = "entity", targetNamespace = "")
        Customer entity);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://wsCust/", className = "wscust.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://wsCust/", className = "wscust.CountResponse")
    @Action(input = "http://wsCust/WSCustomer/countRequest", output = "http://wsCust/WSCustomer/countResponse")
    public int count();

    /**
     * 
     * @param id
     * @return
     *     returns wscust.Customer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "find", targetNamespace = "http://wsCust/", className = "wscust.Find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://wsCust/", className = "wscust.FindResponse")
    @Action(input = "http://wsCust/WSCustomer/findRequest", output = "http://wsCust/WSCustomer/findResponse")
    public Customer find(
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
    @RequestWrapper(localName = "create", targetNamespace = "http://wsCust/", className = "wscust.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://wsCust/", className = "wscust.CreateResponse")
    @Action(input = "http://wsCust/WSCustomer/createRequest", output = "http://wsCust/WSCustomer/createResponse")
    public int create(
        @WebParam(name = "entity", targetNamespace = "")
        Customer entity);

    /**
     * 
     * @return
     *     returns java.util.List<wscust.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://wsCust/", className = "wscust.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://wsCust/", className = "wscust.FindAllResponse")
    @Action(input = "http://wsCust/WSCustomer/findAllRequest", output = "http://wsCust/WSCustomer/findAllResponse")
    public List<Customer> findAll();

    /**
     * 
     * @param range
     * @return
     *     returns java.util.List<wscust.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findRange", targetNamespace = "http://wsCust/", className = "wscust.FindRange")
    @ResponseWrapper(localName = "findRangeResponse", targetNamespace = "http://wsCust/", className = "wscust.FindRangeResponse")
    @Action(input = "http://wsCust/WSCustomer/findRangeRequest", output = "http://wsCust/WSCustomer/findRangeResponse")
    public List<Customer> findRange(
        @WebParam(name = "range", targetNamespace = "")
        List<Integer> range);

    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "edit", targetNamespace = "http://wsCust/", className = "wscust.Edit")
    @Action(input = "http://wsCust/WSCustomer/edit")
    public void edit(
        @WebParam(name = "entity", targetNamespace = "")
        Customer entity);

}
