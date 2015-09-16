package com.projects.model;

import java.util.Date;

/**
 * Ορίσματα Πεδίων απο Βάση
 *
 * @author Μάχη
 */
public class Projects {

    private int Id;
    private String Name;
    private String Type;
    private String Status;
    private Date Start_Date;
    private Date End_Date;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date Start_Date) {
        this.Start_Date = Start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(Date End_Date) {
        this.End_Date = End_Date;
    }

}
