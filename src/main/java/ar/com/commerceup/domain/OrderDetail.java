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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MR ROBOT
 */
@Entity
@Table(name = "orderDetail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer internalid;
    @OneToMany(mappedBy = "orderDetailId")
    private List<Order> order1List;

    public OrderDetail() {
    }

    public OrderDetail(Integer internalid) {
        this.internalid = internalid;
    }

    public Integer getInternalid() {
        return internalid;
    }

    public void setInternalid(Integer internalid) {
        this.internalid = internalid;
    }

    @XmlTransient
    public List<Order> getOrder1List() {
        return order1List;
    }

    public void setOrder1List(List<Order> order1List) {
        this.order1List = order1List;
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
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.internalid == null && other.internalid != null) || (this.internalid != null && !this.internalid.equals(other.internalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.commerceup.domain.OrderDetail[ internalid=" + internalid + " ]";
    }
    
}
