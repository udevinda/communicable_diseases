package lk.health.phd.cd.dto;

import lk.health.phd.cd.models.Enums;

import java.sql.Date;

public class PatientFilterDto {
    private String patientId;
    private String nic;
    private String name;
    private String contactNo;
    private Enums.Sex sex;
    private Enums.Status status;
    private Date dateOfRegisteredFrom;
    private Date dateOfRegisteredTo;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Enums.Sex getSex() {
        return sex;
    }

    public void setSex(Enums.Sex sex) {
        this.sex = sex;
    }

    public Enums.Status getStatus() {
        return status;
    }

    public void setStatus(Enums.Status status) {
        this.status = status;
    }

    public Date getDateOfRegisteredFrom() {
        return dateOfRegisteredFrom;
    }

    public void setDateOfRegisteredFrom(Date dateOfRegisteredFrom) {
        this.dateOfRegisteredFrom = dateOfRegisteredFrom;
    }

    public Date getDateOfRegisteredTo() {
        return dateOfRegisteredTo;
    }

    public void setDateOfRegisteredTo(Date dateOfRegisteredTo) {
        this.dateOfRegisteredTo = dateOfRegisteredTo;
    }
}
