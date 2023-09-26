/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author WiZ14
 */
@Entity
@Table(name = "member"/*, catalog = "CREDENTIALS3", schema = ""*/)
@NamedQueries({
    @NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m")/*,
    @NamedQuery(name = "Member.findByMNo", query = "SELECT m FROM Member m WHERE m._mNo = :mNo"),
    @NamedQuery(name = "Member.findByMLastName", query = "SELECT m FROM Member m WHERE m._mLastName = :mLastName"),
    @NamedQuery(name = "Member.findByMFirstName", query = "SELECT m FROM Member m WHERE m._mFirstName = :mFirstName"),
    @NamedQuery(name = "Member.findByMAddress", query = "SELECT m FROM Member m WHERE m._mAddress = :mAddress"),
    @NamedQuery(name = "Member.findByMRegDate", query = "SELECT m FROM Member m WHERE m._mRegDate = :mRegDate"),
    @NamedQuery(name = "Member.findByMDvdCount", query = "SELECT m FROM Member m WHERE m._mDvdCount = :mDvdCount")*/})
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mNo")
    private Integer _mNo=0;//will properly implement
    @Size(min = 1, max = 20)
    @Column(name = "mLastName", nullable = false, length = 20)
    private String _mLastName;
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "mFirstName", nullable = false, length = 15)
    private String _mFirstName;
    @Size(max = 30)
    @Column(name = "mAddress", length = 30)
    private String _mAddress;
    
    @NotNull
    @Column(name = "mRegDate", nullable = false)
    @Temporal(TemporalType.DATE)
//    @Basic
    private java.util.Date _mRegDate ;
    
    @Column(name = "mDvdCount")
    private Integer _mDvdCount;
//    @OneToMany(fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL, orphanRemoval = true )//mappedBy = "member"
//    @JoinColumn(name = "mno" ,referencedColumnName = "mno")
//    @MapKey(name = "_mPhoneNo")
//    private Map<String, Phone> _phones = new HashMap<>();
//
//    public Map<String, Phone> getPhones() {
//        return _phones;
//    }
//
//    public void setPhones(Map<String, Phone> _phones) {
//        this._phones = _phones;
//    }
    
    
//    @OneToMany(mappedBy = "mNo")
//    private Collection<Borrow> borrowCollection;

//    public Member() {
//    }

//    public Member(Integer mNo) {
//        this._mNo = mNo;
//    }

//    public Member(Integer mNo, String mLastName, String mFirstName, Date mRegDate) {
//        this._mNo = mNo;
//        this._mLastName = mLastName;
//        this._mFirstName = mFirstName;
//        this._mRegDate = mRegDate;
//    }

    public Integer getMNo() {
        return _mNo;
    }

    public void setMNo(Integer mNo) {
        this._mNo = mNo;
    }

    public String getMLastName() {
        return _mLastName;
    }

    public void setMLastName(String mLastName) {
        this._mLastName = mLastName;
    }

    public String getMFirstName() {
        return _mFirstName;
    }

    public void setMFirstName(String mFirstName) {
        this._mFirstName = mFirstName;
    }

    public String getMAddress() {
        return _mAddress;
    }

    public void setMAddress(String mAddress) {
        this._mAddress = mAddress;
    }

    //
    public java.util.Date getMRegDate() {
        return _mRegDate;
    }

    public void setMRegDate(java.util.Date _mRegDate) {
        this._mRegDate = _mRegDate;
    }
    //

    public Integer getMDvdCount() {
        return _mDvdCount;
    }

    public void setMDvdCount(Integer mDvdCount) {
        this._mDvdCount = mDvdCount;
    }

//    public Collection<Phone> getPhoneCollection() {
//        return phoneCollection;
//    }

//    public void setPhoneCollection(Collection<Phone> phoneCollection) {
//        this.phoneCollection = phoneCollection;
//    }

//    public Collection<Borrow> getBorrowCollection() {
//        return borrowCollection;
//    }

//    public void setBorrowCollection(Collection<Borrow> borrowCollection) {
//        this.borrowCollection = borrowCollection;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (_mNo != null ? _mNo.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Member)) {
//            return false;
//        }
//        Member other = (Member) object;
//        if ((this._mNo == null && other._mNo != null) || (this._mNo != null && !this._mNo.equals(other._mNo))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.nameit3.entities.Member[ mNo=" + _mNo + " ]";
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this._mNo);
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
        final Member other = (Member) obj;
        return Objects.equals(this._mNo, other._mNo);
    }

    @Override
    public String toString() {
        return "Member{" + "_mNo=" + _mNo + '}';
    }
    
}
