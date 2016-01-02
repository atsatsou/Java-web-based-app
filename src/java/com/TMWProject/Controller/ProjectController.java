package com.TMWProject.Controller;

import com.TMWProject.Entity.Projects;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import service.ProjectsFacadeREST;

/**
 *
 * @author Μάχη
 */
@Named(value = "projectController")
@Stateless
public class ProjectController {

    @EJB
    private ProjectsFacadeREST projectsFacadeREST;

    Projects p = new Projects();

    private Integer projectId;
    private String projectName;
    private String type;
    private Date startdate;
    private Date enddate;

    public Projects getP() {
        return p;
    }

    public void setP(Projects p) {
        this.p = p;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    
   
    public ProjectController() {
    }

    /**
     *
     * @return
     */
  public List<Projects> projectList(){
     return this.projectsFacadeREST.findAll();
  }

    public String add() {
        this.projectsFacadeREST.create(this.p);
        this.p = new Projects();

        return "AddProject?faces-redirect=true";
    }

    public void delete(Projects p) {
        this.projectsFacadeREST.remove(p);

    }

    public String edit(Projects p) {
        this.p = p;
        return "edit.xhtml?faces-redirect=true";
    }


    public String edit() {
        this.projectsFacadeREST.edit(this.p);
        this.p = new Projects();
        return "AddProject?faces-redirect=true";
    }

}
