/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tstwsprodpojo;

import java.math.BigDecimal;
import javax.xml.datatype.XMLGregorianCalendar;
import wscust.Customer;
import wsordprod.OrderedProduct;
import wsprod.Product;

/**
 *
 * @author Polupero
 */
public class TstWSProdPojo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XMLGregorianCalendar fecha = null;
        //Los ws no tienen mayúsculas porque son paquetes importados 
        //autogenerados en este proyecto, y se quitan las mayúsculas 
        //automaticamente
        wsprod.Category cat = new wsprod.Category();

        //Solo cuenta el número de productos
        System.out.println("Son " + count_Product() + " productos");

        //Enlista los productos
        System.out.println("--------------Product.findAll() ----------------------------");
        java.util.List<wsprod.Product> lisprod = findAll_Product();
        boolean first = false;
        for (wsprod.Product p : lisprod) {
            //Como CATEGORY_ID es Foregign key, no puedo solamente llamar a 
            //p.getCategoryId(), ya que va a hacer referencia a la categoría 
            //correspondiente, debeo de asumir que estoy en la tabla categoría 
            //y usar su función correspondiente: p.getCategoryId().getId().
            System.out.println("Producto: " + p.getId() + " " + p.getName() + " " + p.getDescription() + " " + p.getPrice() + " " + p.getLastUpdate() + " Categoría: " + p.getCategoryId().getId() + " " + p.getCategoryId().getName());

            //Este extra lo hicimos para cachar un category para después, nada que ver con el método original
            if(!first){
                cat.setId(p.getCategoryId().getId());
                cat.setName(p.getCategoryId().getName());
                fecha = p.getLastUpdate();
                first = true;
            }
        }
        //Halla un producto por Id.
        int id = 1;
        System.out.println("-------------------------- id = " + id + " --------------------------");
        System.out.println("El producto con id " + id + " es:");
        wsprod.Product p = find_Product(id);
        System.out.println(p.getId() + " " + p.getName() + " " + p.getDescription() + " "
                + p.getPrice() + " " + p.getLastUpdate() + " Cat:"
                + p.getCategoryId().getId() + " " + p.getCategoryId().getName());

        //Halla un producto por nombre
        String strByName = "chocolate cookies";
        System.out.println("------------------ name = " + strByName + " ------------------------");

        java.util.List<wsprod.Product> prodsName = findByName_Product(strByName);
        prodsName.forEach((pr) -> {
            System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getDescription() + " "
                    + pr.getPrice() + " " + pr.getLastUpdate() + " Cat:"
                    + pr.getCategoryId().getId() + " " + pr.getCategoryId().getName());
        });

        //Creamos aquí un producto
        wsprod.Product prod = new wsprod.Product();
        prod.setCategoryId(cat);
        prod.setName("Nombre");
        prod.setDescription("Descripcion");
        prod.setPrice(new BigDecimal(25.0));
        prod.setLastUpdate(fecha);
        create_Product(prod);//No aparece en la lista si no hasta la próxima ejecución, porque el find esta arriba

        //Creamos aquí un cliente
        wscust.Customer cust = new wscust.Customer();
        cust.setCcNumber("ccNumber");
        cust.setCityRegion("MT");
        cust.setEmail("rgamboa@itam.mx");
        cust.setAddress("Rio Hondo 1");
        cust.setPhone("5556284061");
        cust.setName("Rafael Gregorio");
        //create_1(cust); //Tiene el nombre create_1 porque ya existía el create del wsProd, al ya existir entonces lo importa como
        //create_1, entonces, yo cambié el nombre del método a create_Customer (no hay problema).
        int lngIdCustomer = create_Customer(cust); //Lo mismo que el de arriba, pero este guarda el id del creado
        System.out.println("==================================================");
        System.out.println("El nuevo cliente tiene clave:" + lngIdCustomer);
        System.out.println("==================================================");
        System.out.println("---------------- Customer.findAll() ----------------------------");
        java.util.List<wscust.Customer> liscust = findAll_Customer();
        for (wscust.Customer c : liscust) {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getAddress() + " "
                    + c.getCcNumber() + " " + c.getCityRegion() + " " + c.getEmail() + " " + c.getPhone());
        }


        //Dar de alta un pedido. Debe de darse de alta el customer order y el 
        //ordered product; sin embargo el customer order incluye al cliente 
        //porque necesitamos el customer_id; y el ordered product, necesita el 
        //customer order id y el product id
        //Le vamos a crear un pedido al cliente que acabamos de crear.
        //Proceso del customer order
        
        //Es necesario volver a crear el cliente en lugar de nomas usar el cust 
        //de arriba porque el cust de arriba no tiene el setID, y por lo tanto, 
        //no esta completo y no funcionaría al pasarlo como objeto (porque no
        //sería el mismo que al que hace referencia); además: (leer lo de abajo)
        wscust.Customer clte = find_Customer(lngIdCustomer);
        //Normalmente uno pensaría en que se debe de poner wscust.Customer, pero
        //debido a que voy a crear abajo un customerOrder, necesito que el
        //customer sea del mismo paquete, si no, no funciona.
        //Solo puedo llamar de esta manera a cosas que esten relacionadas; es
        //decir, no puedo hacer custOrd.Prod o .cat, porque no tienen nada que 
        //ver, y por lo tanto, no estan disponibles.
        wscustord.Customer clteCustOrd = new wscustord.Customer();
        clteCustOrd.setAddress(clte.getAddress());
        clteCustOrd.setCcNumber(clte.getCcNumber());
        clteCustOrd.setCityRegion(clte.getCityRegion());
        clteCustOrd.setEmail(clte.getEmail());
        clteCustOrd.setId(clte.getId());
        clteCustOrd.setName(clte.getName());
        clteCustOrd.setPhone(clte.getPhone());        
        
        //Crear el Customer Order:
  
        wscustord.CustomerOrder oh = new wscustord.CustomerOrder();
        oh.setCustomerId(clteCustOrd);
        oh.setAmount(new BigDecimal(100.75));
        oh.setConfirmationNumber(10);
        oh.setDateCreated(fecha);

        int lngIdPedidoHeader = create_CustomerOrder(oh);

        System.out.println(".........................................");
        System.out.println("Al header le corresponde el no. de pedido " + lngIdPedidoHeader);
        System.out.println(".........................................");

        //Proceso del orderedProduct
        
        //CustomerOrder con ID
        wsordprod.CustomerOrder itco = new wsordprod.CustomerOrder();

        wsordprod.Customer clteOrdProd = new wsordprod.Customer();
        clteOrdProd.setAddress(clte.getAddress());
        clteOrdProd.setCcNumber(clte.getCcNumber());
        clteOrdProd.setCityRegion(clte.getCityRegion());
        clteOrdProd.setEmail(clte.getEmail());
        clteOrdProd.setId(clte.getId());
        clteOrdProd.setName(clte.getName());
        clteOrdProd.setPhone(clte.getPhone());
        
        itco.setAmount(oh.getAmount());
        itco.setConfirmationNumber(oh.getConfirmationNumber());
        itco.setCustomerId(clteOrdProd);
        itco.setDateCreated(fecha);
        itco.setId((int) lngIdPedidoHeader);

        //Lista de productos, el category dentro es para crear el product de 
        //dentro, haremos que en nuestra lista esten todos los productos.
        java.util.List<wsordprod.Product> lisItProd = new java.util.ArrayList<>();
        wsordprod.Product itp;
        wsordprod.Category itcat;
        for (wsprod.Product pr : lisprod) { //es el lisprod del inicio de 
            //findAll() de productos.
            itcat = new wsordprod.Category();
            itcat.setId(pr.getCategoryId().getId());
            itcat.setName(pr.getCategoryId().getName());

            itp = new wsordprod.Product();
            itp.setCategoryId(itcat);
            itp.setDescription(pr.getDescription());
            itp.setId(pr.getId());
            itp.setLastUpdate(pr.getLastUpdate());
            itp.setName(pr.getName());
            itp.setPrice(pr.getPrice());

            lisItProd.add(itp);
        }
        
//Cuando tienes una tabla con 2 ForeignKeys, entonces se crea una entidad extra,
//en este caso de llama OrderedProductPK (PrimaryKey); esta entidad es diferente
//en cuanto a que al guardar las llaves, no lo hará como las demás recibiendo
//toda la entidad, si no que solo recibirá el ID, ya que para el son como 
//primaryKeys.

        //OrderedProductPK
        wsordprod.OrderedProductPK oppkv;
        //OrderedProductPK no es un tabla y existe como parte de OrderedProduct, 
        //Por lo que no tiene su webService y sale de su padre
        
        //OrderedProduct
        wsordprod.OrderedProduct item;
        for (int k = 0; k <= 5; k++) { //Solo vamos a pedir los primeros 6 productos
            oppkv = new wsordprod.OrderedProductPK();
            oppkv.setCustomerOrderId((int) lngIdPedidoHeader);
            oppkv.setProductId(lisItProd.get(k).getId());
            item = new wsordprod.OrderedProduct();
            item.setOrderedProductPK(oppkv);
            item.setQuantity((short) 5);
            item.setCustomerOrder(itco);
            item.setProduct(lisItProd.get(k));
            create_OrderedProduct(item);
        }

        //Para enlistar nadamas
        java.util.List<wscustord.CustomerOrder> listaPedidos = findAll_CustomerOrder();
        java.util.List<wsordprod.OrderedProduct> listaItems = findAll_OrderedProduct();
        System.out.println("========= Pedidos =========");
        for (wscustord.CustomerOrder co : listaPedidos) {
            System.out.println("pedido no. " + co.getId() + " del Clte No." + co.getCustomerId().getName() + " " + co.getDateCreated() + " por " + co.getAmount());
        }
        System.out.println("=========== items ===========");
        for (wsordprod.OrderedProduct pit : listaItems) {
            System.out.println("item: Pedido No. " + pit.getCustomerOrder().getId() + " " + pit.getProduct().getDescription() + " cant. " + pit.getQuantity());
        }

    }

    private static java.util.List<wsprod.Product> findAll_Product() {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.findAll();
    }

    private static int count_Product() {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.count();
    }

    private static Product find_Product(java.lang.Object id) {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.find(id);
    }

    private static java.util.List<wsprod.Product> findByName_Product(java.lang.String nombre) {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        return port.findByName(nombre);
    }

    private static void create_Product(wsprod.Product entity) {
        wsprod.WSProd_Service service = new wsprod.WSProd_Service();
        wsprod.WSProd port = service.getWSProdPort();
        port.create(entity);
    }

    private static int create_Customer(wscust.Customer entity) {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.create(entity);
    }

    private static java.util.List<wscust.Customer> findAll_Customer() {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.findAll();
    }

    private static Customer find_Customer(java.lang.Object id) {
        wscust.WSCustomer_Service service = new wscust.WSCustomer_Service();
        wscust.WSCustomer port = service.getWSCustomerPort();
        return port.find(id);
    }

    private static int create_CustomerOrder(wscustord.CustomerOrder entity) {
        wscustord.WSCustomerOrder_Service service = new wscustord.WSCustomerOrder_Service();
        wscustord.WSCustomerOrder port = service.getWSCustomerOrderPort();
        return port.create(entity);
    }

    private static void create_OrderedProduct(wsordprod.OrderedProduct entity) {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        port.create(entity);
    }

    private static java.util.List<wscustord.CustomerOrder> findAll_CustomerOrder() {
        wscustord.WSCustomerOrder_Service service = new wscustord.WSCustomerOrder_Service();
        wscustord.WSCustomerOrder port = service.getWSCustomerOrderPort();
        return port.findAll();
    }

    private static java.util.List<wsordprod.OrderedProduct> findAll_OrderedProduct() {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        return port.findAll();
    }

    private static OrderedProduct find_OrderedProduct(java.lang.Object id) {
        wsordprod.WSOrderedProduct_Service service = new wsordprod.WSOrderedProduct_Service();
        wsordprod.WSOrderedProduct port = service.getWSOrderedProductPort();
        return port.find(id);
    }
    
    

}
