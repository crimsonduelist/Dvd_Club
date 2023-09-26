/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Dvd;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author WiZ14
 */
@Stateless
public class DvdService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public DvdService() {
        System.out.println("ctor DvdService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Dvd create(Dvd entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Dvd read(Object id) {
        return getEntityManager().find(Dvd.class, id);
    }

    public Dvd update(Dvd entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Dvd entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Dvd save(Dvd entity) {
        if (entity.getDCode() < 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Dvd> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Dvd.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Dvd entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
