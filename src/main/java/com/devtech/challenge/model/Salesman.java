package com.devtech.challenge.model;

public class Salesman {

    private int id;
    private String CPF;
    private String name;
    private double salary;

    public Salesman(int id, String CPF, String name, double salary) {
        this.id = id;
        this.CPF = CPF;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
