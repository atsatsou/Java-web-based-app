package com.TMWProject.Entity;

import com.TMWProject.Entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-01-02T21:52:41")
@StaticMetamodel(UserGroup.class)
public class UserGroup_ { 

    public static volatile SingularAttribute<UserGroup, String> idGroup;
    public static volatile SingularAttribute<UserGroup, String> description;
    public static volatile CollectionAttribute<UserGroup, Users> usersCollection;

}