/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Playsin;
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
public class PlaysinService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public PlaysinService() {
        System.out.println("ctor PlaysinService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Playsin create(Playsin entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Playsin read(Object id) {
        return getEntityManager().find(Playsin.class, id);
    }

    public Playsin update(Playsin entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Playsin entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Playsin save(Playsin entity) throws NoSuchFieldException {
        if (entity.getDCode()< 0  && entity.getClass().getDeclaredField("aName").getAnnotation(Column.class).length() < 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Playsin> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Playsin.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Playsin entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
