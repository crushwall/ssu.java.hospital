package com.hospital.model;

import com.hospital.model.enums.Specialization;

import java.sql.Time;
import java.util.Date;

public class Doctor extends User{
    private Date employmentDate;
    private String education;
    private Specialization specialization;
    private Time startWorkingTime;
    private Time endWorkingTime;

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Time getStartWorkingTime() {
        return startWorkingTime;
    }

    public void setStartWorkingTime(Time startWorkingTime) {
        this.startWorkingTime = startWorkingTime;
    }

    public Time getEndWorkingTime() {
        return endWorkingTime;
    }

    public void setEndWorkingTime(Time endWorkingTime) {
        this.endWorkingTime = endWorkingTime;
    }
}
