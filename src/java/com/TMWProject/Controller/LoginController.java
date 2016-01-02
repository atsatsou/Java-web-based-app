package com.TMWProject.Controller;

import com.TMWProject.Entity.UserGroup;
import com.TMWProject.Entity.Users;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import service.UserGroupFacadeREST;
import service.UsersFacadeREST;

/**
 *
 * @author Μάχη
 */
@Named(value = "loginController")
@Stateless
public class LoginController implements Serializable{
    @EJB
    private UserGroupFacadeREST userGroupFacadeREST;

    @EJB
    private UsersFacadeREST usersFacadeREST;
    

    @PersistenceContext
    private EntityManager em;

    private String idUser;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String idGroup;
    private Collection<UserGroup> userGroupCollection;
    private Boolean admin = Boolean.FALSE;
   
    private Users users = new Users();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
     
    public LoginController(String idUser, String password, String name, String surname, String email) {
        this.idUser = idUser;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
       
    }

    public LoginController() {
    }
    
   
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }
    
     public Collection<UserGroup> getUserGroupCollection() {
        return userGroupCollection;
    }

    public void setUserGroupCollection(Collection<UserGroup> userGroupCollection) {
        this.userGroupCollection = userGroupCollection;
    }
    
     public Boolean isAdmin() { return admin; }
     
   
    

    public String login() {
       Users user = getUser();
       userGroupCollection=(Collection <UserGroup>) user.getUserGroupCollection();  
       
        if (user != null && userGroupCollection.iterator().next().getIdGroup().matches("ADMIN")){
            name=user.getName();
            surname=user.getSurname();
            email=user.getEmail();
            admin = Boolean.TRUE;
            return "admin/index.xhtml";
           
        } else if(userGroupCollection.iterator().next().getIdGroup().matches("USERS")){
            name=user.getName();
            surname=user.getSurname();
            email=user.getEmail();
            admin = Boolean.FALSE;
            return "users/index.xhtml";
        
        }else
             return "SignIn.xhtm?faces-redirect=true";
    }

    private Users getUser() {
        try {
            Users user = (Users) em.createNamedQuery("Users.control").
                    setParameter("idUser", idUser)
                   .setParameter("password", password).getSingleResult();
            return user;
        } catch (NoResultException nre) {
            return null;
        }
    }
    
  
    public void Reset(){
        idUser=null;
        password=null;
    }
    
    
   

}
