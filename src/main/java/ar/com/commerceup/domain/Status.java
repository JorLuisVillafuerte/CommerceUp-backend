/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author villa
 */
@Entity
@Table(name="status")
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer internalid;
    private String statusType;

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

    public Status(String statusType) {
        this.statusType = statusType;
    }

    
   
    
}
