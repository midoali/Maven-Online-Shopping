package com.iti.dtos;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fatma
 */
public class Customer {

    private int id;
    private String name;
    private Date birthday;
    private String password;
    private String job;
    private String email;
    private int credit;
    private int phone;
    private String address;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Customer() {
    }

    public Customer(String name, Date birthday, String password, String job, String email, int credit, int phone, String address) {
        this.name = name;
        this.birthday = birthday;
        this.password = password;
        this.job = job;
        this.email = email;
        this.credit = credit;
        this.phone = phone;
        this.address = address;
    }

    public Customer(int id, String name, Date birthday, String password, String job, String email, int credit, int phone, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.password = password;
        this.job = job;
        this.email = email;
        this.credit = credit;
        this.phone = phone;
        this.address = address;
    }

    public Customer(int id, String name, Date birthday, String job, String email, int credit, int phone, String address) {
        this.name = name;
        this.birthday = birthday;
        this.job = job;
        this.email = email;
        this.credit = credit;
        this.phone = phone;
        this.address = address;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date Birthday) {
        this.birthday = Birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + ", password=" + password + ", job=" + job + ", email=" + email + ", credit=" + credit + ", phone=" + phone + ", address=" + address + '}';
    }

}
