package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;
    @LogMethodCall
    @MeasureExecutionTime
    @RequestMapping(method = RequestMethod.GET,value = "/all")
        public List<Employee> getAll(){
        return service.getList();
    }

    @LogMethodCall
    @MeasureExecutionTime
    @RequestMapping(method = RequestMethod.POST,value = "/new")
        public String newUser(@RequestBody Employee employee){
        return service.addEmp(employee);
    }

    @LogMethodCall
    @MeasureExecutionTime
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete")
        public String deleteUserByID(@RequestParam(value = "id",required = false) Integer id){
        if(id!=null){
            return service.deleteEmpByID(id);
        }else return "Please provide Employee ID";

    }

    @LogMethodCall
    @MeasureExecutionTime
    @RequestMapping(method = RequestMethod.PUT,value = "/update")
        public String updateInfo(@RequestBody Employee employee){
            return service.updateInfo(employee);
    }
    @LogMethodCall
    @MeasureExecutionTime
    @RequestMapping(method = RequestMethod.GET,params = "id",value = "/getinfo")
        public String getInfo(@RequestParam(value = "id",required = false) Integer id){
        if(id!=null){
            return service.getInfo(id).toString();
        }else return "Please provide Employee ID";

    }
}

