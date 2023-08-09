package com.example;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    int id;
    String name;
    String position;
    String email;

    public Employee() {

    }

    public Employee(int id, String name, String position, String email) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.email = email;
    }


    public boolean equals(int id){
        return this.getId() == id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
