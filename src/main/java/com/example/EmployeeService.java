package com.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private List <Employee> employeeList = new ArrayList<Employee>();

    public List<Employee> getList(){

        return this.employeeList;
    }

    public String addEmp(Employee employee){
        //employeeList.add(employee);
        employeeList.add(employee);
        return "Successfully added " + employee.toString();
    }

    public String deleteEmpByID(int id){
        try {
            employeeList.remove(employeeList.stream().filter(employee -> employee.equals(id)).collect(Collectors.toList()).get(0));
            return "Deleted Employee with iD: "+id;
        }
        catch (Exception e){
            return "Can't find user with id: " + id;
        }

    }

    public String updateInfo(Employee employee){
        try {
            Employee emp = employeeList.stream().filter(e -> e.equals(employee.id)).collect(Collectors.toList()).get(0);
            emp.setEmail(employee.getEmail());
            emp.setName(employee.getName());
            emp.setPosition(employee.getPosition());
            return "Info updated successfully";
        }catch (Exception e){
            return "Can't find Employee with ID: " + employee.getId();
        }
    }

    public Employee getInfo(int id){
        try {
            return employeeList.stream().filter(e -> e.equals(id)).collect(Collectors.toList()).get(0);
        }catch (Exception e){
            return null;
        }

    }
}
