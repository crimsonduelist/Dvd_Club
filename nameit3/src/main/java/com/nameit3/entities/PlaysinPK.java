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
public class PlaysinPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "aName", nullable = false, length = 30)
    private String aName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dCode", nullable = false)
    private int dCode;

    public PlaysinPK() {
    }

    public PlaysinPK(String aName, int dCode) {
        this.aName = aName;
        this.dCode = dCode;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public int getDCode() {
        return dCode;
    }

    public void setDCode(int dCode) {
        this.dCode = dCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aName != null ? aName.hashCode() : 0);
        hash += (int) dCode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaysinPK)) {
            return false;
        }
        PlaysinPK other = (PlaysinPK) object;
        if ((this.aName == null && other.aName != null) || (this.aName != null && !this.aName.equals(other.aName))) {
            return false;
        }
        if (this.dCode != other.dCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nameit3.entities.PlaysinPK[ aName=" + aName + ", dCode=" + dCode + " ]";
    }
    
}
