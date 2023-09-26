/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author WiZ14
 */
@Entity
@Table(name = "borrow"/*, catalog = "CREDENTIALS3", schema = ""*/)
@NamedQueries({
    @NamedQuery(name = "Borrow.findAll", query = "SELECT b FROM Borrow b")/*,
    @NamedQuery(name = "Borrow.findByOutDate", query = "SELECT b FROM Borrow b WHERE b.outDate = :outDate"),
    @NamedQuery(name = "Borrow.findByInDate", query = "SELECT b FROM Borrow b WHERE b.inDate = :inDate")*/})
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(name = "dCode", nullable = false)
    private Integer _dCode;
    @NotNull
    @Column(name = "mNo", nullable = false)
    private Integer _mNo;
    @Id
    @NotNull
//    @Basic
    @Column(name = "outDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date _outDate;
    @Column(name = "inDate")
//    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date _inDate;
//    @JoinColumn(name = "dCode", referencedColumnName = "dCode")
//    @ManyToOne

//    @JoinColumn(name = "mNo", referencedColumnName = "mNo")
//    @ManyToOne
//    @Id

    public Integer getDCode() {
        return _dCode;
    }

    public void setDCode(Integer _dCode) {
        this._dCode = _dCode;
    }

    public Integer getMNo() {
        return _mNo;
    }

    public void setMNo(Integer  mNo) {
        this._mNo =  mNo;
    }

    public java.util.Date getOutDate() {
        return _outDate;
    }

    public void setOutDate(java.util.Date  outDate) {
        this._outDate =  outDate;
    }

    public java.util.Date getInDate() {
        return _inDate;
    }

    public void setInDate(java.util.Date  inDate) {
        this._inDate =  inDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this._dCode);
        hash = 97 * hash + Objects.hashCode(this._mNo);
        hash = 97 * hash + Objects.hashCode(this._outDate);
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
        final Borrow other = (Borrow) obj;
        if (!Objects.equals(this._dCode, other._dCode)) {
            return false;
        }
        if (!Objects.equals(this._mNo, other._mNo)) {
            return false;
        }
        return Objects.equals(this._outDate, other._outDate);
    }

    @Override
    public String toString() {
        return "Borrow{" + "_dCode=" + _dCode + ", _mNo=" + _mNo + ", _outDate=" + _outDate + '}';
    }

}
