package com.gn.app.dto.administrativeTask.GnProfile;

import com.gn.app.dto.BaseDTO;

/**
 * Created by hp on 1/31/2019.
 */
public class GnProfileDTO extends BaseDTO{

    private Integer id;
    private String gnId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String officeAddress;
    private String phoneNumber;
    private String appointmentDate;
    private String dateOfDutyAssumed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGnId() {
        return gnId;
    }

    public void setGnId(String gnId) {
        this.gnId = gnId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDateOfDutyAssumed() {
        return dateOfDutyAssumed;
    }

    public void setDateOfDutyAssumed(String dateOfDutyAssumed) {
        this.dateOfDutyAssumed = dateOfDutyAssumed;
    }
}
