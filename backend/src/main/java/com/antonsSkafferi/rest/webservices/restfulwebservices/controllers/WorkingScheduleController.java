/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.WorkingScheduleService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.WorkingSchedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredriksellgren
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WorkingScheduleController {
    
    @Autowired
    WorkingScheduleService service = WorkingScheduleService.getInstance();
    
    @RequestMapping(value = "/schedules")
    //Request GET
    private List<WorkingSchedule> getAllWorkingSchedule(){
       return service.getAllSchedules();
    }
    
    @RequestMapping(value = "/schedules/schedule/date", params="date")
    private List<WorkingSchedule> getScheduleByDate(@RequestParam String date){
        return service.scheduleByDate(date);
    }
    
    @PostMapping(value = "/post/schedules", params="schedule")
    private void saveSchedule(@RequestBody WorkingSchedule workingSchedule){
        service.saveOrUpdateSchedule(workingSchedule);
    }
    
    @DeleteMapping(value="/schedules/delete/schedule", params="id")
    private void deleteScedule(@RequestParam int id){

        service.deleteScheduleById(id);
    }


    @DeleteMapping("/schedules/delete/all")
    private void deleteAll(){
        service.deleteAll();
    }
    
    @RequestMapping(value= "/schedules/schedule/getid", params={"date", "start", "end"})
    private int getScheduleId(@RequestParam String date, String start, String end){
        
        return service.getScheduleIdByDateStartEnd(date, start, end);
    }
    
    @RequestMapping(value= "/schedules/schedule", params={"name","date"})
    private List<WorkingSchedule> getWorkScheduleByNameAndDate(@RequestParam String name, String date){
        return service.getWorkScheduleByNameAndDate(name, date);
    }
    
}
