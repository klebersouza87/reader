package com.devtech.challenge.model;

public class Client {

    private int id;
    private String CNPJ;
    private String name;
    private String businessArea;

    public Client(int id, String CNPJ, String name, String businessArea) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.name = name;
        this.businessArea = businessArea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }
}
