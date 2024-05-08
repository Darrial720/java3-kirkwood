package edu.kirkwood.learnx.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class JobApplication {

    private int applicationID;
    private int job_id;
    private String firstName;

    private String lastName;
    private String email;
    private double desiredSalary;
    private LocalDate earliestStartDate;
    private Instant dateSubmitted;
    private String status;

    public JobApplication() {
    }

    public JobApplication(int applicationID, int job_id, String firstName, String lastName, String email, double desiredSalary, LocalDate earliestStartDate, Instant dateSubmitted, String status) {
        this.applicationID = applicationID;
        this.job_id = job_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.desiredSalary = desiredSalary;
        this.earliestStartDate = earliestStartDate;
        this.dateSubmitted = dateSubmitted;
        this.status = status;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public int getJob_id() {
        return job_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public double getDesiredSalary() {
        return desiredSalary;
    }

    public LocalDate getEarliestStartDate() {
        return earliestStartDate;
    }

    /*public Date getEarliestStartDate_toDate() {
        return Date.from(earliestStartDate);
    }*/

    public Instant getDateSubmitted() {
        return dateSubmitted;
    }

    public Date getDateSubmitted_toDate() {
        return Date.from(dateSubmitted);
    }

    public String getStatus() {
        return status;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesiredSalary(double desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public void setEarliestStartDate(LocalDate earliestStartDate) {
        this.earliestStartDate = earliestStartDate;
    }

    public void setDateSubmitted(Instant dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationID=" + applicationID +
                ", job_id=" + job_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", desiredSalary=" + desiredSalary +
                ", earliestStartDate=" + earliestStartDate +
                ", dateSubmitted=" + dateSubmitted +
                ", status='" + status + '\'' +
                '}';
    }
}
