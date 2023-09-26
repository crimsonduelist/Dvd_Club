/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import javax.persistence.Column;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author WiZ14
 */
@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @NotNull
    @Column(name = "mNo", nullable = false)
    private int _mNo;

    @NotNull
    @Size(min = 10, max = 10)
    @Column(name = "mPhoneNo", nullable = false, length = 10)
    private Integer _mPhoneNo;

//    public Phone() {
//    }

//    public Phone(int mNo, String mPhoneNo) {
//        this._mNo = mNo;
//        this._mPhoneNo = mPhoneNo;
//    }

    public int getMNo() {
        return _mNo;
    }

    public void setMNo(int mNo) {
        this._mNo = mNo;
    }

    public Integer getMPhoneNo() {
        return _mPhoneNo;
    }

    public void setMPhoneNo(Integer mPhoneNo) {
        this._mPhoneNo = mPhoneNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) _mNo;
        hash += (_mPhoneNo != null ? _mPhoneNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if (this._mNo != other._mNo) {
            return false;
        }
        if ((this._mPhoneNo == null && other._mPhoneNo != null) || (this._mPhoneNo != null && !this._mPhoneNo.equals(other._mPhoneNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nameit3.entities.Phone[ mNo=" + _mNo + ", mPhoneNo=" + _mPhoneNo + " ]";
    }
    
}
