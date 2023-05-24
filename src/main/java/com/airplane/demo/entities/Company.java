package com.airplane.demo.entities;

import javafx.beans.property.SimpleStringProperty;

public class Company {
    private SimpleStringProperty idCompany;
    private SimpleStringProperty code;
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty password;

    public Company(String code, String name, String email, String password) {
        this.code = new SimpleStringProperty(code);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public String getIdCompany() {
        return idCompany.get();
    }

    public SimpleStringProperty idCompanyProperty() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany.set(idCompany);
    }

    public String getCode() {
        return code.get();
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
