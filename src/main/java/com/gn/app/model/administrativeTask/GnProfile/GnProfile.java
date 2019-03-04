package com.gn.app.model.administrativeTask.GnProfile;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

/**
 * Created by hp on 1/31/2019.
 */
@Entity
@Table(name = "tbl_gn_profile")
public class GnProfile extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "gn_id")
    private String gnId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "office_address")
    private String officeAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "appointment_date")
    private String appointmentDate;

    @Column(name = "date_of_duty_assumed")
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
