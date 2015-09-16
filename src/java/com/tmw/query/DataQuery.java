/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmw.query;


import com.tmw.login.entity.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Μάχη
 */
public class DataQuery {
    
    private final  EntityManager em;
    private final  EntityManagerFactory emf;

    public DataQuery() {
        emf= Persistence.createEntityManagerFactory("TMWProjectPU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
    }

    
    public  boolean loginControl(String username, String password){
        try {
            Login l = em.createNamedQuery("login.control", Login.class).setParameter("username", username).setParameter("password", password).getSingleResult();
            if (l !=null){
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
            
        }
    }
   
    
    
    
    
    
    
}
