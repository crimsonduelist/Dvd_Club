/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author WiZ14
 */
@Stateless
public class CategoryService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public CategoryService() {
        System.out.println("ctor CategoryService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Category create(Category entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Category read(Object id) {
        return getEntityManager().find(Category.class, id);
    }

    public Category update(Category entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Category entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Category save(Category entity) throws NoSuchFieldException {
        if (entity.getClass().getDeclaredField("cName").getAnnotation(Column.class).length() < 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Category> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Category.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Category entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
