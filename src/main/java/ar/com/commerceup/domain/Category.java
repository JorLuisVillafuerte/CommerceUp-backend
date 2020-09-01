/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer internalid;
    @Column(unique = true)
    private String categoryCode;
    private String name;
    private String description;
    private String targetType;
    private String seasonType;
    private String img;
    @Column(updatable=false)
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateModified;
    @JoinColumn(name = "statusId", referencedColumnName = "internalid")
    @ManyToOne
    private Status statusId;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryId", cascade = CascadeType.ALL)
    private List<Product> productList;

    
    public Category() {
    }

    public Category(Integer internalid) {
        this.internalid = internalid;
    }

    public Integer getInternalid() {
        return internalid;
    }

    public void setInternalid(Integer internalid) {
        this.internalid = internalid;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
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
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.internalid == null && other.internalid != null) || (this.internalid != null && !this.internalid.equals(other.internalid))) {
            return false;
        }
        return true;
    }

    public Category(String categoryCode, String name, String description, String targetType, String seasonType, String img, Date dateCreated, Date dateModified, Status statusId, List<Product> productList) {
        this.categoryCode = categoryCode;
        this.name = name;
        this.description = description;
        this.targetType = targetType;
        this.seasonType = seasonType;
        this.img = img;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.statusId = statusId;
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryCode=" + categoryCode + ", name=" + name + ", description=" + description + ", targetType=" + targetType + ", seasonType=" + seasonType + ", img=" + img + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + ", statusId=" + statusId + ", productList=" + productList + '}';
    }
    
    
    
}
