/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author WiZ14
 */
@Entity
@Table(name = "playsin"/*, catalog = "CREDENTIALS3", schema = ""*/)
@NamedQueries({
    @NamedQuery(name = "Playsin.findAll", query = "SELECT p FROM Playsin p")/*,
    @NamedQuery(name = "Playsin.findByAName", query = "SELECT p FROM Playsin p WHERE p.playsinPK.aName = :aName"),
    @NamedQuery(name = "Playsin.findByDCode", query = "SELECT p FROM Playsin p WHERE p.playsinPK.dCode = :dCode"),
    @NamedQuery(name = "Playsin.findByRoleNo", query = "SELECT p FROM Playsin p WHERE p.roleNo = :roleNo")*/})
public class Playsin implements Serializable {

    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected PlaysinPK playsinPK;
    @NotNull
    @Column(name = "roleNo")
    private Integer _roleNo;
    @Id
    @GeneratedValue()
    @Column(name = "dCode", nullable = false)
    private Integer _dCode;
    @NotNull
    @Column(name = "aName", nullable = false)
    private String _aName;
//    public Playsin() {
//    }
//
//    public Playsin(PlaysinPK playsinPK) {
//        this.playsinPK = playsinPK;
//    }

//    public Playsin(String aName, int dCode) {
//        this.playsinPK = new PlaysinPK(aName, dCode);
//    }

//    public PlaysinPK getPlaysinPK() {
//        return playsinPK;
//    }

//    public void setPlaysinPK(PlaysinPK playsinPK) {
//        this.playsinPK = playsinPK;
//    }

    public Integer getRoleNo() {
        return _roleNo;
    }

    public void setRoleNo(Integer _roleNo) {
        this._roleNo = _roleNo;
    }

    public Integer getDCode() {
        return _dCode;
    }

    public void setDCode(Integer _dCode) {
        this._dCode = _dCode;
    }

    public String getAName() {
        return _aName;
    }

    public void setAName(String aName) {
        this._aName = aName;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this._dCode);
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
        final Playsin other = (Playsin) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Playsin{" + "_dCode=" + _dCode + '}';
    }
    
}
