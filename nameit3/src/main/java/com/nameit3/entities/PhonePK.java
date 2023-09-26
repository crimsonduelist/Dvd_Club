/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author WiZ14
 */
@Embeddable
public class PhonePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "mNo", nullable = false)
    private int mNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mPhoneNo", nullable = false, length = 10)
    private String mPhoneNo;

    public PhonePK() {
    }

    public PhonePK(int mNo, String mPhoneNo) {
        this.mNo = mNo;
        this.mPhoneNo = mPhoneNo;
    }

    public int getMNo() {
        return mNo;
    }

    public void setMNo(int mNo) {
        this.mNo = mNo;
    }

    public String getMPhoneNo() {
        return mPhoneNo;
    }

    public void setMPhoneNo(String mPhoneNo) {
        this.mPhoneNo = mPhoneNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mNo;
        hash += (mPhoneNo != null ? mPhoneNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhonePK)) {
            return false;
        }
        PhonePK other = (PhonePK) object;
        if (this.mNo != other.mNo) {
            return false;
        }
        if ((this.mPhoneNo == null && other.mPhoneNo != null) || (this.mPhoneNo != null && !this.mPhoneNo.equals(other.mPhoneNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nameit3.entities.PhonePK[ mNo=" + mNo + ", mPhoneNo=" + mPhoneNo + " ]";
    }
    
}
