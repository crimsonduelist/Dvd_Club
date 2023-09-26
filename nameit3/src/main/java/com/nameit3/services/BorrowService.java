/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Borrow;
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
public class BorrowService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public BorrowService() {
        System.out.println("ctor BorrowService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Borrow create(Borrow entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Borrow read(Object id) {
        return getEntityManager().find(Borrow.class, id);
    }

    public Borrow update(Borrow entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Borrow entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Borrow save(Borrow entity) throws NoSuchFieldException {
        if (entity.getClass().getDeclaredField("outDate").getAnnotation(Column.class).length() > 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Borrow> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Borrow.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Borrow entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
