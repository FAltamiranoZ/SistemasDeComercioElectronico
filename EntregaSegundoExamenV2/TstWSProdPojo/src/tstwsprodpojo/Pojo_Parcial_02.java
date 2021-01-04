/*                       SISTEMAS DE COMERCIO ELECTRÓNICO
 *                      semestre agosto - diciembre de 2020
 *                            Segundo Examen Parcial
 *                         Martes 10 de noviembre de 2020
 *                               duración: 2:00 hrs
 * Instrucciones:
 * Usted debe 
 *  1) habilitar los ejercicios del Ejer 1) al Ejer 4);
 *  2) programar lo necesario para implementar los ejercicios Ejer 5) y Ejer 6).
 * NOTA: Al inicio del main() debe asignar su clave única y su nombre en las 
 *       variables al efecto.
 * Cada una de las partes a trabajar tiene un inicio cometado con
 *  /* inicio comentario M)
 *    y termina con
 *  fin comentario M) */
 // solamente debe anular el comentario cerrando o abriendo el mismo, no lo borre
 /*
 * Igualmente aparecen comentadas las UTILERIAS, solo que ahí por obviedad
 * no tiene leyendas.
 *
 * Al finalizar su examen usted debe enviar un .zip, .rar o .7z con:
 * a) El proyecto del sitio web con las entidades, beans de sesión
 *    correspondientes;
 * b) El proyecto de su implementación de este pojo;
 * c) La salida del pojo en un archivo de texto;
 * d) La salida del log del glassfish PARA UNA EJECUCIÓN hasta donde haya
 *    logrado la implementación.
 * Tiene hasta las 13:10 hrs para subirlo a CANVAS
 *
 * RECOMENDACIONES:
 * i)   Revise detenidamente los acopladores listados mas abajo;
 * ii)  Revise las utilerías al final de este pojo;
 * iii) Su Clave Única y Nombre son importantes ya que con ellos se definen
 *      las entidades con que trabaja el sistema.
 * iv)  Inicialice la base de datos;
 * v)   Defina a None el Validation Strategy del persistence.xml;
 * vi)  Asimismo, en el persitence.xml agregue la definición del logging.level a "FINEST":
 *
 * un ejemplo del persistence.xml:
 *
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
  <persistence-unit name="Parcial_02_202003PU" transaction-type="JTA">
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <jta-data-source>java:app/affablebean</jta-data-source>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <validation-mode>NONE</validation-mode>
    <properties>
      <property name="eclipselink.logging.level" value="FINEST"/>
    </properties>
  </persistence-unit>
</persistence>
 *
 */
package tstwsprodpojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import wscat.Category;
import wscust.Customer;
import wscustord.CustomerOrder;
import wsordprod.OrderedProduct;
import wsordprod.OrderedProductPK;
import wsprod.Product;

/**
 *
 * @author Rafael
 */
public class Pojo_Parcial_02 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       /*
        ACOPLADORES DE PAQUETES DE LOS CLIENTES DE Web Service a los BEANS de Sesión:
        wscat       CategoryFacade
        wscust      CustomerFacade
        wscustord   CustomerOrderFacade
        wsordprod   OrderedProductFacade
        wsprod      ProductFacade
        
        Las utilerías (Ver después del código del main del pojo) tienen implementadas
        las funcionalidades (XYZ es cada bean de entidad)
            count_XYZ
            create_XYZ      NOTA: el create regresa int
            findAll_XYZ
            find_XYZ
       */
        
       //
       // Nota: en lo que sigue, CU es su Clave Única
       //
       String strCU = "163314";
       // Primer Nombre de Pila, primer apellido, segundo apellido (3 cadenas)
       String strNombre[] = {"Jose Francisco","Altamirano","Zevallos"};
       double dblCU = Double.parseDouble(strCU);
       
       XMLGregorianCalendar xmlFecha = null;
       try 
       {
          xmlFecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
       } 
       catch (DatatypeConfigurationException ex) 
       {
           System.out.println("Error al crear xmlFecha:" + ex);
           System.exit(1);
       }

       System.out.println("SCE: Segundo examen parcial de " + strCU + " " +
                           strNombre[0] + " " + strNombre[1] + " " + strNombre[2]);
       System.out.println("----------------------------------------------------");
       System.out.println("          " + xmlFecha.toString());
       System.out.println("----------------------------------------------------");
       //
       // Ejer 1) Crear una nueva categoría de nombre Limpieza CU
       //
       
/* inicia cometario 1)*/
       
       int cat_id; 
       wscat.Category catnew = new wscat.Category();
       catnew.setName("Limpieza " + strCU);
       cat_id = create_Category(catnew);
       catnew.setId(cat_id);
       System.out.println("Se ha dado de alta la categoría " + catnew.getId() + " ... " + catnew.getName());
       List<wscat.Category> liscat = findAll_Category();
       System.out.println("Lista de Categorías:" + ( liscat.isEmpty() ? " Lista sin elementos":"" ));
       for(wscat.Category cat:liscat)
            System.out.println("Categoría:" + cat.getId() + "->" + cat.getName());
       
/*fin comentario 1) */
       
       // 
       // Ejer 2) Crear tres productos con tal categoría
       //         con precio unitario cada uno de los dígitos no cero de su clave única,
       //         empezando por la derecha
       //         con nombres 
       //                   Prod_PRIMER_NOMBRE_DE_PILA
       //                   Prod_PRIMER_APELLIDO
       //                   Prod_SEGUNDO_APELLIDO
       //         y descripciones
       //                   descripcion PRIMER_NOMBRE_DE_PILA
       //                   descripcion PRIMER_APELLIDO
       //                   descripcion SEGUNDO_APELLIDO
       
/* inicia comentario 2)*/
       
             
       // precios unitarios de los productos
       int NUMPRODS = 3;
       List<wsprod.Product> listaProdsNuevos = new ArrayList<>();
      
       double dblPrecioUnitario;
       double dblcu = dblCU;
       String nombreProdNuevos[] = strNombre;
       
       wsprod.Product prd;
       wsprod.Category catProd = new wsprod.Category();
       catProd.setId(catnew.getId());
       catProd.setName(catnew.getName());
        
       int i = 0; 
       while(i < NUMPRODS) 
       { 
           dblPrecioUnitario = 0.0;
           while(dblPrecioUnitario == 0.0 )
           {
               dblPrecioUnitario = dblcu - 10.0 * Math.floor(dblcu/10.0);
               dblcu = Math.floor(dblcu/10.0);
           }
           
           prd = new wsprod.Product();
           prd.setCategoryId(catProd);
           prd.setDescription("descripcion " + nombreProdNuevos[i]);
           prd.setLastUpdate(xmlFecha);
           prd.setName("Prod_" + nombreProdNuevos[i]);
           prd.setPrice(new BigDecimal(dblPrecioUnitario));
           listaProdsNuevos.add(prd);
           i++;
       }
       // Dando de alta los productos
       int idProd;
       for(wsprod.Product pr:listaProdsNuevos)
       {
           idProd = create_Product(pr);
           pr.setId(idProd);
       }
       // revisando la lista de productos
       List<wsprod.Product> lisprod = findAll_Product();
       System.out.println("Lista de Productos:" + ( lisprod.isEmpty() ? " Lista sin elementos":"" ));
       for(wsprod.Product p:lisprod)
            System.out.println("Producto:" + p.getId() + " " + p.getName() + " " + p.getDescription() +
                    " cat:" + p.getCategoryId().getId() + " " + p.getCategoryId().getName());
       
/*fin comentario 2)*/
       
       //
       // Ejer 3) Crear un nuevo cliente con su nombre y apellidos
       //
       
/* inicia comentario 3)*/
       
       wscust.Customer custnew = new wscust.Customer();
       custnew.setAddress("Rio Hondo 1");
       custnew.setCcNumber(strCU);
       custnew.setCityRegion("MX");
       custnew.setEmail("rgamboa@itam.mx"); // poner su correo del itam
       custnew.setName(strNombre[0] + " " + strNombre[1] + " " + strNombre[2]);
       custnew.setPhone("5556284000"); // conmutador del itam, no cambiar
       
       int idCustNew = create_Customer(custnew);
       custnew.setId(idCustNew);
       System.out.println("Se ha dado de alta el clte:" + custnew.getId() + " " +
                            custnew.getName() + " " + custnew.getAddress() + " " +
                            custnew.getCcNumber() + " " + custnew.getCityRegion() + " " +
                            custnew.getPhone() + " " + custnew.getEmail());
        
       // obteniendo el listado de los clientes:
       List<wscust.Customer> liscust = findAll_Customer();
       System.out.println("Lista de Clientes:" + ( liscust.isEmpty() ? " Lista sin elementos":"" ));
       for( wscust.Customer cust: liscust )
            System.out.println("Clte:" + cust.getId() + " " +
                            cust.getName() + " " + cust.getAddress() + " " +
                            cust.getCcNumber() + " " + cust.getCityRegion() + " " +
                            cust.getPhone() + " " + cust.getEmail());
       
/*fin comentario 3) */
       
       // Ejer 4) Crear dos pedidos con los tres productos dados de alta de
       //         la nueva categoría, con 5 unidades de cada uno, 
       //         el segundo con 10 unidades. 
       //
       
/* inicia comentario 4.0)*/
       
       // convirtiendo el Cliente custnew a wscustord
       wscustord.Customer custco = new wscustord.Customer();
       custco.setId(custnew.getId());
       custco.setAddress(custnew.getAddress());
       custco.setCcNumber(custnew.getCcNumber());
       custco.setCityRegion(custnew.getCityRegion());
       custco.setEmail(custnew.getEmail());
       custco.setName(custnew.getName());
       custco.setPhone(custnew.getPhone());
       
       // cambiando la categoría catnew a wsordprod
       
       wsordprod.Category catParaItems = new wsordprod.Category();
       catParaItems.setId(catnew.getId());
       catParaItems.setName(catnew.getName());
       
       // convirtiendo los productos a wsprodord
       List<wsordprod.Product> lisProdParaItems = new ArrayList<>();
       wsordprod.Product prodParaItems;
       for(wsprod.Product pr:listaProdsNuevos)
       {
          prodParaItems = new wsordprod.Product();
          prodParaItems.setCategoryId(catParaItems);
          prodParaItems.setDescription(pr.getDescription());
          prodParaItems.setId(pr.getId());
          prodParaItems.setLastUpdate(pr.getLastUpdate());
          prodParaItems.setName(pr.getName());
          prodParaItems.setPrice(pr.getPrice());
          lisProdParaItems.add(prodParaItems);
       }
       
       //
       //   4.1) Definir los items en una lista y obtener el total
       //
       //  NOTA: SE IDENTIFICAN CON 0 y 1 (para que coincidan con los índices 
       //        de los arreglos y posiciones en las listas) 
       //
         
/*fin comentario 4.0) */
       
/* inicia comentario 4.1)*/
       
       List<List<wsordprod.OrderedProduct>> lisLisItems = new ArrayList<>();
       // listas de items para ambos pedidos
       List<wsordprod.OrderedProduct> lisItemsCO0 = new ArrayList<>();
       List<wsordprod.OrderedProduct> lisItemsCO1 = new ArrayList<>();
       double sm0 = 0.0, sm1 = 0.0;
       wsordprod.OrderedProduct op0,op1;
       for( wsordprod.Product prop: lisProdParaItems)
       {
           op0 = new wsordprod.OrderedProduct();
           op0.setProduct(prop);
           op0.setQuantity((short)5.0);
           sm0 += op0.getQuantity() * prop.getPrice().doubleValue();
           lisItemsCO0.add(op0);
           
           op1 = new wsordprod.OrderedProduct();
           op1.setProduct(prop);
           op1.setQuantity((short)10.0);
           sm1 += op1.getQuantity() * prop.getPrice().doubleValue();
           lisItemsCO1.add(op1);
       }
       lisLisItems.add(lisItemsCO0);
       lisLisItems.add(lisItemsCO1);
       //
       //   4.2) Dar de alta los encabezados (CustomerOrder)
       //
       
/*fin comentario 4.1) */
       
/* inicia comentario 4.2)*/
       
       // primer encabezado
       wscustord.CustomerOrder co0 = new wscustord.CustomerOrder();
       co0.setAmount(new BigDecimal(sm0));
       co0.setConfirmationNumber(1);
       co0.setCustomerId(custco);
       co0.setDateCreated(xmlFecha);
       int intNumPedido0 = create_CustomerOrder(co0); // alta del primer encabezado
       co0.setId(intNumPedido0);
       
       // segundo encabezado
       wscustord.CustomerOrder co1 = new wscustord.CustomerOrder();
       co1.setAmount(new BigDecimal(sm1));
       co1.setConfirmationNumber(2);
       co1.setCustomerId(custco);
       co1.setDateCreated(xmlFecha);
       int intNumPedido1 = create_CustomerOrder(co1); // alta del segundo encabezado
       co1.setId(intNumPedido1);
       
       // y el custco a wsordprod.Customer
       wsordprod.Customer custcoop = new wsordprod.Customer();
       custcoop.setAddress(custco.getAddress());
       custcoop.setCcNumber(custco.getCcNumber());
       custcoop.setCityRegion(custco.getCityRegion());
       custcoop.setEmail(custco.getEmail());
       custcoop.setId(custco.getId());
       custcoop.setName(custco.getName());
       custcoop.setPhone(custco.getPhone());
       
       // convierto los co0 y co1 a wsordprod       
       
       wsordprod.CustomerOrder arr_coop[] = new wsordprod.CustomerOrder[2];
       arr_coop[0] = new wsordprod.CustomerOrder();
       arr_coop[1] = new wsordprod.CustomerOrder();
       
       arr_coop[0].setAmount(co0.getAmount());
       arr_coop[0].setConfirmationNumber(co0.getConfirmationNumber());
       arr_coop[0].setCustomerId(custcoop);
       arr_coop[0].setDateCreated(co0.getDateCreated());
       arr_coop[0].setId(co0.getId());
       
       arr_coop[1].setAmount(co1.getAmount());
       arr_coop[1].setConfirmationNumber(co1.getConfirmationNumber());
       arr_coop[1].setCustomerId(custcoop);
       arr_coop[1].setDateCreated(co1.getDateCreated());
       arr_coop[1].setId(co1.getId());
       
/*fin comentario 4.2) */

       // 
       //   4.3) Dar de alta los items de cada pedido 
       //
       
/* inicio comentario 4.3)*/
       
       // antes se actualiza el customerorder id de cada item
       List<wsordprod.OrderedProduct> lisop;
       wsordprod.OrderedProductPK oppkv; 
       for( i = 0; i<=1;i++)
       {
           lisop = lisLisItems.get(i);
           for(wsordprod.OrderedProduct item:lisop)
           {
               item.setCustomerOrder(arr_coop[i]);
               oppkv = new wsordprod.OrderedProductPK();
               oppkv.setCustomerOrderId(arr_coop[i].getId());
               oppkv.setProductId(item.getProduct().getId());
               item.setOrderedProductPK(oppkv);
               create_OrderedProduct(item);
           }  
       }
       // Obtener la lista de los encabezados (CustomerOrder)
       List<wscustord.CustomerOrder> lisco = findAll_CustomerOrder();
       System.out.println("Lista de Encabezados de Pedidos:" + ( lisco.isEmpty() ? " Lista sin elementos":"" ));
       for(wscustord.CustomerOrder co : lisco)
            System.out.println("CustomerOrder:" +
                                " Id:" + co.getId() + 
                                " Fecha:"     + co.getDateCreated() +
                                " Clte:"     + co.getCustomerId().getId() +
                                " "          + co.getCustomerId().getName() +
                                " Num. conf:" + co.getConfirmationNumber() +
                                " Monto:"    + co.getAmount());
       
       
       
       // Obtener la lista de los items (OrderedProducts)
       List<wsordprod.OrderedProduct> lisitems = findAll_OrderedProduct();
       System.out.println("Lista de Items de Pedidos:" + ( lisitems.isEmpty() ? " Lista sin elementos":"" ));
       //int numPedido;
       //wsordprod.CustomerOrder itmco;
       for(wsordprod.OrderedProduct itm : lisitems)
       {
            //itmco = itm.getCustomerOrder();
            //numPedido = itmco.getId().intValue();
            System.out.println("CustomerOrder:" +
                                " No.Pedido:"   + itm.getCustomerOrder().getId().intValue() + 
                                " Producto:"    + itm.getProduct().getId() +
                                " "             + itm.getProduct().getName() +
                                " Cantidad:"     + itm.getQuantity());
       }
       
/*fin comentario 4.3) */

       // 
       // Ejer 5)  Obtener cada encabezado con sus items.
       //      

        System.out.println(encabezado_OrderedProduct());
       
       //
       // Ejer 6) Obtener el monto total de los pedidos (Amount de CustomerOrder)
       //
       
        System.out.println("El monto total de los pedidos es: " + suma_CustomerOrder());
        
       //
       // ======================  FIN del main() ===========================
       //     
    }
    //-----------------------------------------------------------------------
    // -------------------------- UTILERIAS ---------------------------------
    //-----------------------------------------------------------------------
    // =======================================================================
    //   WSCategory
    // =======================================================================

    private static int count_Category() {
        wscat.WSCat_Service service = new wscat.WSCat_Service();
        wscat.WSCat port = service.getWSCatPort();
        return port.count();
    }
    private static int create_Category(wscat.Category entity) {
        wscat.WSCat_Service service = new wscat.WSCat_Service();
        wscat.WSCat port = service.getWSCatPort();
        return port.create(entity);
    }
    private static Category find_Category(int id) {
        wscat.WSCat_Service service = new wscat.WSCat_Service();
        wscat.WSCat port = service.getWSCatPort();
        return port.find(id);
    }
    private static java.util.List<wscat.Category> findAll_Category() {
        wscat.WSCat_Service service = new wscat.WSCat_Service();
        wscat.WSCat port = service.getWSCatPort();
        return port.findAll();
    }
    
    // =======================================================================
    //   WSProduct
    // =======================================================================

    private static int count_Product() {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.count();
    }
    private static int create_Product(wsprod.Product entity) {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.create(entity);
    }
    private static Product find_Product(int id) {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.find(id);
    }
    private static java.util.List<wsprod.Product> findAll_Product() {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.findAll();
    }
    private static String precioPromPorCatId() {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.precioPromPorCatId();
    }

    // =======================================================================
    //   WSCustomer
    // =======================================================================

    private static int count_Customer() {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.count();
    }
    private static int create_Customer(wscust.Customer entity) {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.create(entity);
    }
    private static Customer find_Customer(int id) {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.find(id);
    }
    private static java.util.List<wscust.Customer> findAll_Customer() {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.findAll();
    }

    // =======================================================================
    //   WSCustomerOrder
    // =======================================================================

    private static int count_CustomerOrder() {
        wscustord.WSCustomerOrder_Service service = new wscustord.WSCustomerOrder_Service();
        wscustord.WSCustomerOrder port = service.getWSCustomerOrderPort();
        return port.count();
    }
    private static int create_CustomerOrder(wscustord.CustomerOrder entity) {
        wscustord.WSCustomerOrder_Service service = new wscustord.WSCustomerOrder_Service();
        wscustord.WSCustomerOrder port = service.getWSCustomerOrderPort();
        return port.create(entity);
    }
    private static CustomerOrder find_CustomerOrder(int id) {
        wscustord.WSCustomerOrder_Service service = new wscustord.WSCustomerOrder_Service();
        wscustord.WSCustomerOrder port = service.getWSCustomerOrderPort();
        return port.find(id);
    }
    private static java.util.List<wscustord.CustomerOrder> findAll_CustomerOrder() {
        wscustord.WSCustomerOrder_Service service = new wscustord.WSCustomerOrder_Service();
        wscustord.WSCustomerOrder port = service.getWSCustomerOrderPort();
        return port.findAll();
    }
    private static String suma_CustomerOrder() {
        wscustord.WSCustomerOrder_Service service = new wscustord.WSCustomerOrder_Service();
        wscustord.WSCustomerOrder port = service.getWSCustomerOrderPort();
        return port.suma();
    }
    

    // =======================================================================
    //   WSOrderedProduct
    // =======================================================================

    private static int count_OrderedProduct() {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        return port.count();
    }
    private static OrderedProduct create_OrderedProduct(wsordprod.OrderedProduct entity) {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        return port.create(entity);
    }
    private static OrderedProduct find_OrderedProduct(java.lang.Object id) {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        return port.find(id);
    }
    private static java.util.List<wsordprod.OrderedProduct> findAll_OrderedProduct() {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        return port.findAll();
    }
    private static String encabezado_OrderedProduct() {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        return port.encabezado();
    }

    // =======================================================================
}
