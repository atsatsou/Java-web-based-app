/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmw.domain.Projects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Μάχη
 */
@Entity
@Table(name = "Projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p"),
    @NamedQuery(name = "Projects.findById", query = "SELECT p FROM Projects p WHERE p.id = :id"),
    @NamedQuery(name = "Projects.findByName", query = "SELECT p FROM Projects p WHERE p.name = :name"),
    @NamedQuery(name = "Projects.findByType", query = "SELECT p FROM Projects p WHERE p.type = :type"),
    @NamedQuery(name = "Projects.findByStatus", query = "SELECT p FROM Projects p WHERE p.status = :status"),
    @NamedQuery(name = "Projects.findByStartDate", query = "SELECT p FROM Projects p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Projects.findByEndDate", query = "SELECT p FROM Projects p WHERE p.endDate = :endDate")})
public class Projects implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Status")
    private String status;
    @Column(name = "Start_Date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "End_Date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Projects() {
    }

    public Projects(Integer id) {
        this.id = id;
    }

    public Projects(Integer id, String name, String type, String status, Date endDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tmw.domain.Projects.Projects[ id=" + id + " ]";
    }
    
}
