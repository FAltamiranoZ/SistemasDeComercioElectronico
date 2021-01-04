/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Polupero
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> {

    @PersistenceContext(unitName = "AffableBeanCorregidoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
    public java.util.List<Category> findByName(String nombre) {
        em = getEntityManager();
        TypedQuery<Category> queryCatByName = em.createNamedQuery("Category.findByName", Category.class);
        queryCatByName.setParameter("name", nombre);
        java.util.List<Category> lista = queryCatByName.getResultList();
        return lista;
    }
    
}
