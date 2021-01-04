/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Product;
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
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "AffableBeanCorregidoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public java.util.List<Product> findByName(String nombre) {
        em = getEntityManager();
        TypedQuery<Product> queryCatByName = em.createNamedQuery("Product.findByName", Product.class);
        queryCatByName.setParameter("name", nombre);
        java.util.List<Product> lista = queryCatByName.getResultList();
        return lista;
    }

    public java.util.List<Product> findLikeName(String nombre) {
        em = getEntityManager();
        TypedQuery<Product> queryProdLikeName = em.createNamedQuery("Product.findLikeName", Product.class);
        queryProdLikeName.setParameter("name", nombre);
        java.util.List<Product> lista = queryProdLikeName.getResultList();
        return lista;
    }

    public String precioPromPorCatId() {
        String strRes = "\n";
        em = getEntityManager();

        Query query = em.createQuery("SELECT p.categoryId, count(p.price), AVG(p.price) FROM Product p GROUP BY p.categoryId");
        System.err.println(query.getResultList());
        java.util.List<Object> lista = query.getResultList();

        entities.Category cat;

        for (Object obj : lista) {
            Object[] x = (Object[]) obj;

            cat = (entities.Category) x[0];

            strRes += cat.getId() + " " + cat.getName() + " tiene " + x[1].toString() + " ... Precio Promedio:" + x[2].toString() + '\n';
        }

        return strRes;
    }
    
}
