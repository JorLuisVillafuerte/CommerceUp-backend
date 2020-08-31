/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author villa
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer internalid;
    private String statusType;
    @OneToMany(mappedBy = "statusId")
    private List<Category> categoryList;
    @OneToMany(mappedBy = "statusId")
    private List<Product> productList;

    public Status() {
    }

    public Status(Integer internalid) {
        this.internalid = internalid;
    }

    public Integer getInternalid() {
        return internalid;
    }

    public void setInternalid(Integer internalid) {
        this.internalid = internalid;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (internalid != null ? internalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.internalid == null && other.internalid != null) || (this.internalid != null && !this.internalid.equals(other.internalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.commerceup.domain.Status[ internalid=" + internalid + " ]";
    }
    
}
