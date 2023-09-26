/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author WiZ14
 */
@Entity
@Table(name = "actor"/*, catalog = "CREDENTIALS3", schema = ""*/)
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a")/*,
    @NamedQuery(name = "Actor.findByAName", query = "SELECT a FROM Actor a WHERE a.aName = :aName"),
    @NamedQuery(name = "Actor.findByAOscar", query = "SELECT a FROM Actor a WHERE a.aOscar = :aOscar")*/})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "aName", nullable = false)
    private String aName;
    @Column(name = "aOscar")
    private Integer aOscar;
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    //JoinColumn(name = "")
    private Collection<Playsin> playsinCollection;

    public Actor() {
    }

    public Actor(String aName) {
        this.aName = aName;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public Integer getAOscar() {
        return aOscar;
    }

    public void setAOscar(Integer aOscar) {
        this.aOscar = aOscar;
    }

    public Collection<Playsin> getPlaysinCollection() {
        return playsinCollection;
    }

    public void setPlaysinCollection(Collection<Playsin> playsinCollection) {
        this.playsinCollection = playsinCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aName != null ? aName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.aName == null && other.aName != null) || (this.aName != null && !this.aName.equals(other.aName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nameit3.entities.Actor[ aName=" + aName + " ]";
    }
    
}
