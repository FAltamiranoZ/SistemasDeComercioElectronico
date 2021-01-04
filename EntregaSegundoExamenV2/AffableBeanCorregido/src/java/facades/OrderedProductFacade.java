/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.OrderedProduct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Polupero
 */
@Stateless
public class OrderedProductFacade extends AbstractFacade<OrderedProduct> {

    @PersistenceContext(unitName = "AffableBeanCorregidoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderedProductFacade() {
        super(OrderedProduct.class);
    }

    public String encabezado() {
        String strRes = "\n";
        em = getEntityManager();
        
        TypedQuery<Object> queryencabezado = em.createNamedQuery("OrderedProduct.encabezado", Object.class);
        java.util.List<Object> lista = queryencabezado.getResultList();
        
//        Query query = em.createQuery("SELECT co.ID, co.AMOUNT, co.DATE_CREATED, co.CONFIRMATION_NUMBER, p.ID, p.NAME, op.QUANTITY FROM PRODUCT p, ORDERED_PRODUCT op, CUSTOMER_ORDER co WHERE op.PRODUCT_ID = p.ID AND op.CUSTOMER_ORDER_ID = co.ID");
//        Query query = em.createQuery("SELECT co.id, co.amount, co.dateCreated, co.confirmationNumber, p.id, p.name, op.quantity FROM Product p, OrderedProduct op, CustomerOrder co WHERE op.product.id = p.id AND op.customerOrder.id = co.id");
        /*
        La versión comentada es como se escribiría en el SQL; sin embargo, no
        funciona de la misma manera en el proyecto por varias razones:
        La primera es que para referirnos a las tablas, vamos a tener que 
        utilizar el nombre de las entidades del proyecto. En lugar de 
        PRODUCT, usamos Product
        La segunda es que para referirnos a las columnas, vamos a tener que 
        utilizar el nombre que le asignamos dentro de la entidad a cada 
        columna. En lugar de op.PRODUCT_ID, usamos op.product
        La tercera es que, debido a que le asignamos una variable a cada nombre
        de columna, tenemos que fijarnos de que tipo la asignamos; por ejemplo,
        la variable product en OrderedProduct, no es un int como en la base
        de datos, es un objeto Product, por lo que debemos de llamar 
        op.product.id
        */
//        java.util.List<Object> lista = query.getResultList();
        String temp = "";
        for (Object obj : lista) {
            Object[] x = (Object[]) obj;
            if(!x[0].toString().equals(temp)){
                temp = x[0].toString();
                strRes += "Encabezado: " + x[0].toString() + "\n" + "Customer ID: " + x[1].toString() + " Cantidad: " + x[2].toString() + " Fecha de creación: " + x[3].toString() + " Número de confirmación: " + "\n";
            }
            strRes += "ID del producto: " + x[4].toString() + " Nombre del producto: " + x[5].toString() + " Cantidad del producto: " + x[6].toString() + " " + "\n";
        }

        return strRes;
    }

}
