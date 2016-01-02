package com.TMWProject.Entity;

import com.TMWProject.Entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-01-02T21:52:41")
@StaticMetamodel(Assignments.class)
public class Assignments_ { 

    public static volatile SingularAttribute<Assignments, Integer> assId;
    public static volatile SingularAttribute<Assignments, String> projectName;
    public static volatile SingularAttribute<Assignments, String> priority;
    public static volatile SingularAttribute<Assignments, String> type;
    public static volatile SingularAttribute<Assignments, Users> username;

}