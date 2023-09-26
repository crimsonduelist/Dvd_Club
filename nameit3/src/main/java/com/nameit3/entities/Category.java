/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author WiZ14
 */
@Entity
@Table(name = "category"/*, catalog = "CREDENTIALS3", schema = ""*/)
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")/*,
    @NamedQuery(name = "Category.findByCName", query = "SELECT c FROM Category c WHERE c.cName = :cName"),
    @NamedQuery(name = "Category.findByCDvdCount", query = "SELECT c FROM Category c WHERE c.cDvdCount = :cDvdCount")*/})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cName", nullable = false, length = 30)
    private String _cName;
    @Column(name = "cDvdCount")
    private Integer _cDvdCount;
//    @JoinTable(name = "includes", joinColumns = {
//        @JoinColumn(name = "cName", referencedColumnName = "cName", nullable = false)}, inverseJoinColumns = {
//        @JoinColumn(name = "dCode", referencedColumnName = "dCode", nullable = false)})
//    @ManyToMany
//    private Collection<Dvd> dvdCollection;

//    public Category() {
//    }
//
//    public Category(String cName) {
//        this.cName = cName;
//    }

    public String getCName() {
        return _cName;
    }

    public void setCName(String cName) {
        this._cName = cName;
    }

    public Integer getCDvdCount() {
        return _cDvdCount;
    }

    public void setCDvdCount(Integer cDvdCount) {
        this._cDvdCount = cDvdCount;
    }

//    public Collection<Dvd> getDvdCollection() {
//        return dvdCollection;
//    }
//
//    public void setDvdCollection(Collection<Dvd> dvdCollection) {
//        this.dvdCollection = dvdCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this._cName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        return Objects.equals(this._cName, other._cName);
    }

    @Override
    public String toString() {
        return "Category{" + "_cName=" + _cName + '}';
    }


}
