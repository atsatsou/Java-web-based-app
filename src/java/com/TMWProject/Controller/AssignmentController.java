package com.TMWProject.Controller;

import com.TMWProject.Entity.Assignments;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import service.AssignmentsFacadeREST;

/**
 *
 * @author Μάχη
 */
@Named(value = "assignmentController")
@Stateless
public class AssignmentController{
    @EJB
    private AssignmentsFacadeREST assignmentsFacadeREST;
    
    @PersistenceContext
    private EntityManager em;

    Assignments asgn = new Assignments();

    public AssignmentController() {
      
          
    }

    public Assignments getAsgn() {
        return asgn;
    }

    public void setAsgn(Assignments asgn) {
        this.asgn = asgn;
    }

    public List<Assignments> assignmentsList(){
       return this.assignmentsFacadeREST.findAll();
    }

  
    public String add() {
        this.assignmentsFacadeREST.create(this.asgn);
        this.asgn = new Assignments();

        return "index?faces-redirect=true";
    }
    
    public void delete(Assignments asgn) {
        this.assignmentsFacadeREST.remove(asgn);

    }

  

}
