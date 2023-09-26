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
@Table(name = "includes"/*, catalog = "CREDENTIALS3", schema = ""*/)
@NamedQueries({
    @NamedQuery(name = "Includes.findAll", query = "SELECT i FROM Includes i")/*,
    @NamedQuery(name = "Actor.findByAName", query = "SELECT a FROM Actor a WHERE a.aName = :aName"),
    @NamedQuery(name = "Actor.findByAOscar", query = "SELECT a FROM Actor a WHERE a.aOscar = :aOscar")*/})
public class Includes implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "cName", nullable = false)
    private String _aName;
    @Id
    @NotNull
    @Column(name = "dCode")
    private Integer _dCode;

    public String getAName() {
        return _aName;
    }

    public void setAName(String _aName) {
        this._aName = _aName;
    }

    public Integer getDCode() {
        return _dCode;
    }

    public void setDCode(Integer _dCode) {
        this._dCode = _dCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this._dCode);
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
        final Includes other = (Includes) obj;
        return Objects.equals(this._dCode, other._dCode);
    }

    @Override
    public String toString() {
        return "Includes{" + "_dCode=" + _dCode + '}';
    }

    
}
