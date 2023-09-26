/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Includes;
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
public class IncludesService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public IncludesService() {
        System.out.println("ctor IncludesService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Includes create(Includes entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Includes read(Object id) {
        return getEntityManager().find(Includes.class, id);
    }

    public Includes update(Includes entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Includes entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Includes save(Includes entity) throws NoSuchFieldException {
        if (entity.getDCode()< 0 && entity.getClass().getDeclaredField("cName").getAnnotation(Column.class).length() < 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Includes> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Includes.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Includes entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
