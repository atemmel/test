package com.antonsSkafferi.rest.webservices.restfulwebservices.tables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fredriksellgren
 */
@Entity
@Table(name="workingschedule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class WorkingSchedule implements Serializable {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workingscheduleid", updatable = false, nullable = false)
    private int workingscheduleid;
    
    @Column(name = "date", updatable = false, nullable = false)
    private String date;
    
    @Column(name = "start", updatable = false, nullable = false)
    private String start;
    
    @Column(name = "end", updatable = false, nullable = false)
    private String end;
    
    public WorkingSchedule(){}
    
    
    /*public WorkingSchedule(int workingscheduleid, String date, String start, String end){
        
        this.workingscheduleid = workingscheduleid;
        this.date = date;
        this.start = start;
        this.end = end;
        
    }*/
    
    public WorkingSchedule(String date, String start, String end){
        
        this.date = date;
        this.start = start;
        this.end = end;
    }
    
    
    /**
     * @return the workingsceduleid
     */
    public int getWorkingscheduleid() {
        return workingscheduleid;
    }

    /**
     * @param workingsceduleid the workingsceduleid to set
     */
    public void setWorkingscheduleid(int workingsceduleid) {
        this.workingscheduleid = workingsceduleid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(String end) {
        this.end = end;
    }
    
    
    @Override
    public String toString(){
        return "WorkingScedule [workingSceduleid = " + getWorkingscheduleid() + ", date=" + getDate() + ", start=" + getStart() + ", end=" + getEnd() + "]";
    }
    
}
