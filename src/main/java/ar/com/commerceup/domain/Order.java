package ar.com.commerceup.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer internalid;
    @Column(unique = true)
    @NotBlank(message="El codigo de categoria no puede ser nulo/vacio.")
    @Size(max = 10, message="El codigo de categoria debe ser menor a 10 caracteres.")
    private String orderCode;
    @Size(max = 255, message="Se excedio del maximo de caracteres permitidos.")
    private String description;
    @Column(updatable=false)
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated;
    @UpdateTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateModified;
    @Column(updatable=false)
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSale;
    @Size(max = 50, message="Se excedio del maximo de caracteres permitidos.")
    private String salePlatform;
    
    @JoinColumn(name = "usuarioId", referencedColumnName = "internalid")
    @ManyToOne
    private User usuarioId;
    @JoinColumn(name = "orderDetailId", referencedColumnName = "internalid")
    @OneToOne
    private OrderDetail orderDetailId;
    @JoinColumn(name = "statusId", referencedColumnName = "internalid")
    @ManyToOne
    private Status statusId;
    
    
}
