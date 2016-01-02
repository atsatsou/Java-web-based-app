package com.TMWProject.Entity;

import com.TMWProject.Entity.Assignments;
import com.TMWProject.Entity.UserGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-01-02T21:52:41")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> idUser;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> surname;
    public static volatile CollectionAttribute<Users, UserGroup> userGroupCollection;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile CollectionAttribute<Users, Assignments> assignmentsCollection;
    public static volatile SingularAttribute<Users, String> email;

}