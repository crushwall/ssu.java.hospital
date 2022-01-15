package com.hospital.model;

import com.hospital.model.enums.HumanSex;

import java.util.Date;

public class Human{
    private String firstName;
    private String lastName;
    private HumanSex sex;
    private Date birthday;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HumanSex getSex() { return sex; }

    public void setSex(HumanSex sex) { this.sex = sex; }
}
