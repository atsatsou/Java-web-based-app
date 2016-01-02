/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.TMWProject.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Μάχη
 */
@Entity
@Table(name = "assignments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignments.findAll", query = "SELECT a FROM Assignments a"),
    @NamedQuery(name = "Assignments.findByAssId", query = "SELECT a FROM Assignments a WHERE a.assId = :assId"),
    @NamedQuery(name = "Assignments.findByProjectName", query = "SELECT a FROM Assignments a WHERE a.projectName = :projectName"),
    @NamedQuery(name = "Assignments.findByPriority", query = "SELECT a FROM Assignments a WHERE a.priority = :priority"),
    @NamedQuery(name = "Assignments.findByType", query = "SELECT a FROM Assignments a WHERE a.type = :type")})
public class Assignments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ass_id")
    private Integer assId;
    @Size(max = 50)
    @Column(name = "project_name")
    private String projectName;
    @Size(max = 50)
    @Column(name = "priority")
    private String priority;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "username", referencedColumnName = "id_user")
    @ManyToOne
    private Users username;

    public Assignments() {
    }

    public Assignments(Integer assId) {
        this.assId = assId;
    }

    public Integer getAssId() {
        return assId;
    }

    public void setAssId(Integer assId) {
        this.assId = assId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assId != null ? assId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignments)) {
            return false;
        }
        Assignments other = (Assignments) object;
        if ((this.assId == null && other.assId != null) || (this.assId != null && !this.assId.equals(other.assId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   String.valueOf(username) ;
    }
    
}
