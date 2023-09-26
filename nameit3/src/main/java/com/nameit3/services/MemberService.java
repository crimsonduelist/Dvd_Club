/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.services;

import com.nameit3.entities.Member;
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
public class MemberService {
    @PersistenceContext(unitName = "credentialsPU")
    private EntityManager _em;

    public MemberService() {
        System.out.println("ctor MemberService");
    }

    protected EntityManager getEntityManager() {
        return _em;
    }

    public Member create(Member entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public Member read(Object id) {
        return getEntityManager().find(Member.class, id);
    }

    public Member update(Member entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(Member entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Convenience method, to create or update automatically
     *
     * @param entity
     * @return
     */
    public Member save(Member entity) {
        if (entity.getMNo() < 0) {
            return create(entity);
        }
        return update(entity);
    }

    public List<Member> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Member.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public String checkState(Member entity){
        return entity + (_em.contains(entity) ? "attached" : "detached");
    }
}
