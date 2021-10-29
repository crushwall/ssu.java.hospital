package model;

import model.enums.Specialization;

import java.util.Date;

public class Doctor extends User{
    private Date employmentDate;
    private String education;
    private Specialization specialization;
    private Date startWorkingTime;
    private Date endWorkingTime;

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

    public Date getStartWorkingTime() {
        return startWorkingTime;
    }

    public void setStartWorkingTime(Date startWorkingTime) {
        this.startWorkingTime = startWorkingTime;
    }

    public Date getEndWorkingTime() {
        return endWorkingTime;
    }

    public void setEndWorkingTime(Date endWorkingTime) {
        this.endWorkingTime = endWorkingTime;
    }
}
