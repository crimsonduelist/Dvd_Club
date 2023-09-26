/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Actor;
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
public class ActorService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public ActorService() {
        System.out.println("ctor ActorService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Actor create(Actor entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Actor read(Object id) {
        return getEntityManager().find(Actor.class, id);
    }

    public Actor update(Actor entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Actor entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Actor save(Actor entity) throws NoSuchFieldException {
        if ( entity.getClass().getDeclaredField("aName").getAnnotation(Column.class).length() < 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Actor> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Actor.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Actor entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
