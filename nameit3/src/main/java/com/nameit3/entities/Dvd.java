/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nameit3.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
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
@Table(name = "dvd"/*, catalog = "CREDENTIALS3", schema = ""*/)
@NamedQueries({
    @NamedQuery(name = "Dvd.findAll", query = "SELECT d FROM Dvd d")/*,
    @NamedQuery(name = "Dvd.findByDCode", query = "SELECT d FROM Dvd d WHERE d.dCode = :dCode"),
    @NamedQuery(name = "Dvd.findByDTitle", query = "SELECT d FROM Dvd d WHERE d.dTitle = :dTitle"),
    @NamedQuery(name = "Dvd.findByDDirector", query = "SELECT d FROM Dvd d WHERE d.dDirector = :dDirector"),
    @NamedQuery(name = "Dvd.findByDvdLendCost", query = "SELECT d FROM Dvd d WHERE d.dvdLendCost = :dvdLendCost"),
    @NamedQuery(name = "Dvd.findByDAcquisitionCost", query = "SELECT d FROM Dvd d WHERE d.dAcquisitionCost = :dAcquisitionCost"),
    @NamedQuery(name = "Dvd.findByDCategoryCount", query = "SELECT d FROM Dvd d WHERE d.dCategoryCount = :dCategoryCount"),
    @NamedQuery(name = "Dvd.findByDLendTimes", query = "SELECT d FROM Dvd d WHERE d.dLendTimes = :dLendTimes")}*/
})
public class Dvd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dCode", nullable = false)
    private Integer dCode;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "dTitle", nullable = false, length = 30)
    private String dTitle;
    @Size(max = 35)
    @Column(name = "dDirector", length = 35)
    private String dDirector;
    @NotNull
    @Column(name = "dvdLendCost", nullable = false)
    private int dvdLendCost;
    @NotNull
    @Column(name = "dAcquisitionCost", nullable = false)
    private int dAcquisitionCost;
    @Column(name = "dCategoryCount")
    private Integer dCategoryCount;
    @Column(name = "dLendTimes")
    private Integer dLendTimes;
//    @ManyToMany(mappedBy = "dvdCollection")
//    private Collection<Category> categoryCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dvd")
//    private Collection<Playsin> playsinCollection;
//    @OneToMany(mappedBy = "dCode")
//    private Collection<Borrow> borrowCollection;

//    @OneToMany(fetch = FetchType.EAGER,
//          cascade = CascadeType.ALL, orphanRemoval = true)
//  @JoinColumn(name = "ctCategoryId", referencedColumnName = "catId")
//  @MapKey(name = "_language")
//  private Map<String, Actor> _actor = new HashMap<>();
//    public Dvd() {
//    }
//
//    public Dvd(Integer dCode) {
//        this.dCode = dCode;
//    }
//    public Dvd(Integer dCode, String dTitle, int dvdLendCost, int dAcquisitionCost) {
//        this.dCode = dCode;
//        this.dTitle = dTitle;
//        this.dvdLendCost = dvdLendCost;
//        this.dAcquisitionCost = dAcquisitionCost;
//    }
    public Integer getDCode() {
        return dCode;
    }

    public void setDCode(Integer dCode) {
        this.dCode = dCode;
    }

    public String getDTitle() {
        return dTitle;
    }

    public void setDTitle(String dTitle) {
        this.dTitle = dTitle;
    }

    public String getDDirector() {
        return dDirector;
    }

    public void setDDirector(String dDirector) {
        this.dDirector = dDirector;
    }

    public int getDvdLendCost() {
        return dvdLendCost;
    }

    public void setDvdLendCost(int dvdLendCost) {
        this.dvdLendCost = dvdLendCost;
    }

    public int getDAcquisitionCost() {
        return dAcquisitionCost;
    }

    public void setDAcquisitionCost(int dAcquisitionCost) {
        this.dAcquisitionCost = dAcquisitionCost;
    }

    public Integer getDCategoryCount() {
        return dCategoryCount;
    }

    public void setDCategoryCount(Integer dCategoryCount) {
        this.dCategoryCount = dCategoryCount;
    }

    public Integer getDLendTimes() {
        return dLendTimes;
    }

    public void setDLendTimes(Integer dLendTimes) {
        this.dLendTimes = dLendTimes;
    }

//    public Collection<Category> getCategoryCollection() {
//        return categoryCollection;
//    }
//
//    public void setCategoryCollection(Collection<Category> categoryCollection) {
//        this.categoryCollection = categoryCollection;
//    }
//
//    public Collection<Playsin> getPlaysinCollection() {
//        return playsinCollection;
//    }
//
//    public void setPlaysinCollection(Collection<Playsin> playsinCollection) {
//        this.playsinCollection = playsinCollection;
//    }
//
//    public Collection<Borrow> getBorrowCollection() {
//        return borrowCollection;
//    }
//
//    public void setBorrowCollection(Collection<Borrow> borrowCollection) {
//        this.borrowCollection = borrowCollection;
//    }
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (dCode != null ? dCode.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Dvd)) {
//            return false;
//        }
//        Dvd other = (Dvd) object;
//        if ((this.dCode == null && other.dCode != null) || (this.dCode != null && !this.dCode.equals(other.dCode))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.nameit3.entities.Dvd[ dCode=" + dCode + " ]";
//    }
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Dvd other = (Dvd) obj;
        return Objects.equals(this.dCode, other.dCode);
    }

    @Override
    public String toString() {
        return "Dvd{" + "dCode=" + dCode + '}';
    }
}
