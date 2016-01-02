package com.TMWProject.Controller;

import com.TMWProject.Entity.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import service.UsersFacadeREST;

/**
 *
 * @author Μάχη
 */
@Named(value = "userController")
@Stateless
public class UserController{

    @EJB
    private UsersFacadeREST usersFacadeREST;
    
    
    @PersistenceContext
    private EntityManager em;

    Users u = new Users();
    private String idUser;
    private String name;
    private String surname;
    private String email;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public UserController() {
      
          
    }

    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }


   
    public List<Users> usersList(){
       return this.usersFacadeREST.findAll();
    }

  
    public String add() {
        this.usersFacadeREST.create(this.u);
        this.u = new Users();

        return "AddUser?faces-redirect=true";
    }

    public void delete(Users u) {
        this.usersFacadeREST.remove(u);

    }

    public String edit(Users u) {
        this.u = u;
        return "editUser.xhtml?faces-redirect=true";
    }


    public String edit() {
        this.usersFacadeREST.edit(this.u);
        this.u = new Users();
        return "AddUser.xhtml";
    }
    
        
      public String backToUsers(){
         return "AddUser.xhtml?faces-redirect=true";
      }


}
