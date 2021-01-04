/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nnextpojo;

import wsprod.Product;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import wscust.Customer;


/**
 *
 * @author rggh
 */
public class NnextPojo 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        XMLGregorianCalendar fecha = null;
        boolean primero            = true;
        wsprod.Product prod        = new wsprod.Product();
        wsprod.Category cat        = new wsprod.Category();
        
        System.out.println("Son " + count_Product() + " productos");
        System.out.println("--------------Product.findAll() ----------------------------");
        java.util.List<wsprod.Product> lisprod = findAll_Product();
        for(wsprod.Product p:lisprod)
        {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getDescription() + " " +
                    p.getPrice() + " " + p.getLastUpdate() + " Cat:" +
                    p.getCategoryId().getId() + " " + p.getCategoryId().getName());
            if(primero)
            {
              //cat   = p.getCategoryId(); // se obtiene la categoría
              cat.setId(p.getCategoryId().getId());
              cat.setName(p.getCategoryId().getName());
              fecha = p.getLastUpdate();
              primero = false;
            }
        }
        int id = 1;
        System.out.println("-------------------------- id = " + id + " --------------------------");
        System.out.println("El producto con id " + id + " es:");
        wsprod.Product p = find_Product(id);
        System.out.println(p.getId() + " " + p.getName() + " " + p.getDescription() + " " +
                    p.getPrice() + " " + p.getLastUpdate() + " Cat:" +
                    p.getCategoryId().getId() + " " + p.getCategoryId().getName());
        String strByName = "chocolate cookies";
        System.out.println("------------------ name = " + strByName + " ------------------------");
        
        java.util.List<wsprod.Product> prodsName = findByName(strByName);
        prodsName.forEach((pr) -> {
            System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getDescription() + " " +
                    pr.getPrice() + " " + pr.getLastUpdate() + " Cat:" +
                    pr.getCategoryId().getId() + " " + pr.getCategoryId().getName());
        });
           
        prod.setCategoryId(cat);
        prod.setId(0);
        prod.setName("Producto nuevisimo");
        prod.setDescription("Descripcion del producto fase 3");
        prod.setPrice(new BigDecimal(55.0));
        
        XMLGregorianCalendar xmlFecha = null;
        try {
            xmlFecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(NnextPojo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        prod.setLastUpdate(  xmlFecha);
                
        create_Product(prod);
     
        // --------------------------------- Customer --------------------------------  
        wscust.Customer cust = new wscust.Customer();
     
        cust.setCcNumber("ccNumber");
        cust.setCityRegion("MT");
        cust.setEmail("rgamboa@itam.mx");
        cust.setAddress("Rio Hondo 1");
        cust.setPhone("5556284061");
        cust.setName("Rafael Gregorio");
       
        long lngIdCustomer = create_customer(cust);
        System.out.println("==================================================");
        System.out.println("El nuevo cliente tiene clave:" + lngIdCustomer);
        System.out.println("==================================================");
        System.out.println("---------------- Customer.findAll() ----------------------------");
        java.util.List<wscust.Customer> liscust = findAll_Customers();
        for(wscust.Customer c:liscust)
        {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getAddress() + " " +
                    c.getCcNumber() + " " + c.getCityRegion() + " " + c.getEmail() + " " + c.getPhone());
        }
        
        // Se trae el´cliente recién creado para crearle un pedido
        wscust.Customer clte = find_Customer(lngIdCustomer);
        wspedidoheader.Customer phclte = new wspedidoheader.Customer();
        phclte.setAddress(clte.getAddress());
        phclte.setCcNumber(clte.getCcNumber());
        phclte.setCityRegion(clte.getCityRegion());
        phclte.setEmail(clte.getEmail());
        phclte.setId(clte.getId());
        phclte.setName(clte.getName());
        phclte.setPhone(clte.getPhone());
        
        wsPedidoItems.Customer itclte = new wsPedidoItems.Customer();
        itclte.setAddress(clte.getAddress());
        itclte.setCcNumber(clte.getCcNumber());
        itclte.setCityRegion(clte.getCityRegion());
        itclte.setEmail(clte.getEmail());
        itclte.setId(clte.getId());
        itclte.setName(clte.getName());
        itclte.setPhone(clte.getPhone());
        // 
        // Se crea el encabezado del pedido
        //
        wspedidoheader.CustomerOrder oh = new wspedidoheader.CustomerOrder();
        oh.setCustomerId(phclte);
        oh.setAmount(new BigDecimal(100.75));
        oh.setConfirmationNumber(10);
        oh.setDateCreated(xmlFecha);
        
        long lngIdPedidoHeader = create_pedidoHeader(oh);
        
        System.out.println(".........................................");
        System.out.println("Al header le corresponde el no. de pedido " + lngIdPedidoHeader);
        System.out.println(".........................................");
        //
        // se crea el objeto wspedidoitem.customer_order para dar de alta los items
        //
        wsPedidoItems.CustomerOrder itco = new wsPedidoItems.CustomerOrder();
        
        itco.setAmount(oh.getAmount());
        itco.setConfirmationNumber(oh.getConfirmationNumber());
        itco.setCustomerId(itclte);
        itco.setDateCreated(fecha);
        itco.setId((int)lngIdPedidoHeader);
        //
        // dando de alta los items
        //
        //
        // se forma la lista con el "catalogo" de productos en formato items
        //
        java.util.List<wsPedidoItems.Product> lisItProd = new java.util.ArrayList<>();
        wsPedidoItems.Product itp;
        wsPedidoItems.Category itcat;
        for(wsprod.Product pr:lisprod)
        {
            itcat = new wsPedidoItems.Category();
            itcat.setId(pr.getCategoryId().getId());
            itcat.setName(pr.getCategoryId().getName());
            
            itp = new wsPedidoItems.Product();
            itp.setCategoryId(itcat);
            itp.setDescription(pr.getDescription());
            itp.setId(pr.getId());
            itp.setLastUpdate(pr.getLastUpdate());
            itp.setName(pr.getName());
            itp.setPrice(pr.getPrice());
            
            lisItProd.add(itp);
        }
        
        wsPedidoItems.OrderedProductPK oppkv; 
       
        wsPedidoItems.OrderedProduct item;
        for ( int k = 0; k <=5; k++)
        {
          oppkv = new wsPedidoItems.OrderedProductPK();
          oppkv.setCustomerOrderId((int)lngIdPedidoHeader);
          oppkv.setProductId(lisItProd.get(k).getId());  
          item = new wsPedidoItems.OrderedProduct();
          item.setOrderedProductPK(oppkv);
          item.setQuantity((short)5);
          item.setCustomerOrder(itco);
          item.setProduct(lisItProd.get(k));
          create_PedidoItem(item);
        }
        
        java.util.List<wspedidoheader.CustomerOrder> listaPedidos = findAll_CustomerOrder();
        java.util.List<wsPedidoItems.OrderedProduct> listaItems   = findAll_OrderedProduct();
        
        System.out.println("========= Pedidos =========");
        for(wspedidoheader.CustomerOrder co:listaPedidos )
        {
            System.out.println("pedido no. " + co.getId() + " del Clte No." + co.getCustomerId().getName() + " " + co.getDateCreated() + " por " + co.getAmount());
        }
        
        System.out.println("=========== items ===========");
        for(wsPedidoItems.OrderedProduct pit: listaItems)
        {
            System.out.println("item: Pedido No. " + pit.getCustomerOrder().getId() + " " + pit.getProduct().getDescription() + " cant. " + pit.getQuantity());
        }
       
    }

    private static int count_Product() {
        wsprod.NewWebService_Service service = new wsprod.NewWebService_Service();
        wsprod.NewWebService port = service.getNewWebServicePort();
        return port.count();
    }

    private static void create_Product(wsprod.Product entity) {
        wsprod.NewWebService_Service service = new wsprod.NewWebService_Service();
        wsprod.NewWebService port = service.getNewWebServicePort();
        port.create(entity);
    }

    private static Product find_Product(java.lang.Object id) {
        wsprod.NewWebService_Service service = new wsprod.NewWebService_Service();
        wsprod.NewWebService port = service.getNewWebServicePort();
        return port.find(id);
    }

    private static java.util.List<wsprod.Product> findAll_Product() {
        wsprod.NewWebService_Service service = new wsprod.NewWebService_Service();
        wsprod.NewWebService port = service.getNewWebServicePort();
        return port.findAll();
    }

    private static java.util.List<wsprod.Product> findByName(java.lang.String nombre) {
        wsprod.NewWebService_Service service = new wsprod.NewWebService_Service();
        wsprod.NewWebService port = service.getNewWebServicePort();
        return port.findByName(nombre);
    }

    private static long create_customer(wscust.Customer entity) {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.create(entity);
    }

    private static java.util.List<wscust.Customer> findAll_Customers() {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.findAll();
    }

    private static void create_PedidoHeader(wspedidoheader.CustomerOrder entity) {
        wspedidoheader.WSPedidoHeader_Service service = new wspedidoheader.WSPedidoHeader_Service();
        wspedidoheader.WSPedidoHeader port = service.getWSPedidoHeaderPort();
        port.create(entity);
    }

    private static void create_PedidoItems(wsPedidoItems.OrderedProduct entity) {
        wsPedidoItems.WSPedidoItems_Service service = new wsPedidoItems.WSPedidoItems_Service();
        wsPedidoItems.WSPedidoItems port = service.getWSPedidoItemsPort();
        port.create(entity);
    }

    private static long create_pedidoHeader(wspedidoheader.CustomerOrder entity) {
        wspedidoheader.WSPedidoHeader_Service service = new wspedidoheader.WSPedidoHeader_Service();
        wspedidoheader.WSPedidoHeader port = service.getWSPedidoHeaderPort();
        return port.create(entity);
    }

    private static void create_PedidoItem(wsPedidoItems.OrderedProduct entity) {
        wsPedidoItems.WSPedidoItems_Service service = new wsPedidoItems.WSPedidoItems_Service();
        wsPedidoItems.WSPedidoItems port = service.getWSPedidoItemsPort();
        port.create(entity);
    }

    private static Customer find_Customer(long id) {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.find(id);
    }

    private static java.util.List<wspedidoheader.CustomerOrder> findAll_CustomerOrder() {
        wspedidoheader.WSPedidoHeader_Service service = new wspedidoheader.WSPedidoHeader_Service();
        wspedidoheader.WSPedidoHeader port = service.getWSPedidoHeaderPort();
        return port.findAll();
    }

    private static java.util.List<wsPedidoItems.OrderedProduct> findAll_OrderedProduct() {
        wsPedidoItems.WSPedidoItems_Service service = new wsPedidoItems.WSPedidoItems_Service();
        wsPedidoItems.WSPedidoItems port = service.getWSPedidoItemsPort();
        return port.findAll();
    }

    
}
