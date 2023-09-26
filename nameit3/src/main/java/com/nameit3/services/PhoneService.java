/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Phone;
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

public class PhoneService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public PhoneService() {
        System.out.println("ctor PhoneService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Phone create(Phone entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Phone read(Object id) {
        return getEntityManager().find(Phone.class, id);
    }

    public Phone update(Phone entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Phone entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Phone save(Phone entity) {
        if (entity.getMNo()< 0 || entity.getMPhoneNo()< 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Phone> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Phone.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Phone entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
