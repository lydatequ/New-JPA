/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lyda
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findByScode", query = "SELECT s FROM Sales s WHERE s.scode = :scode")
    , @NamedQuery(name = "Sales.findByPcode", query = "SELECT s FROM Sales s WHERE s.pcode = :pcode")
    , @NamedQuery(name = "Sales.findBySdate", query = "SELECT s FROM Sales s WHERE s.sdate = :sdate")
    , @NamedQuery(name = "Sales.findByQuant", query = "SELECT s FROM Sales s WHERE s.quant = :quant")
    , @NamedQuery(name = "Sales.findByCost", query = "SELECT s FROM Sales s WHERE s.cost = :cost")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Scode")
    private Integer scode;
    @Column(name = "pcode")
    private Integer pcode;
    @Column(name = "Sdate")
    @Temporal(TemporalType.DATE)
    private Date sdate;
    @Column(name = "Quant")
    private Integer quant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cost")
    private BigDecimal cost;
    @JoinColumn(name = "Ccode", referencedColumnName = "Ccode")
    @ManyToOne(optional = false)
    private Customers ccode;
    @JoinColumn(name = "Smcode", referencedColumnName = "Scode")
    @ManyToOne(optional = false)
    private Salesmen smcode;

    public Sales() {
    }

    public Sales(Integer scode) {
        this.scode = scode;
    }

    public Integer getScode() {
        return scode;
    }

    public void setScode(Integer scode) {
        this.scode = scode;
    }

    public Integer getPcode() {
        return pcode;
    }

    public void setPcode(Integer pcode) {
        this.pcode = pcode;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Customers getCcode() {
        return ccode;
    }

    public void setCcode(Customers ccode) {
        this.ccode = ccode;
    }

    public Salesmen getSmcode() {
        return smcode;
    }

    public void setSmcode(Salesmen smcode) {
        this.smcode = smcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scode != null ? scode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.scode == null && other.scode != null) || (this.scode != null && !this.scode.equals(other.scode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sales[ scode=" + scode + " ]";
    }
    
}
