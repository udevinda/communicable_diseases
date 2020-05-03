package lk.health.phd.cd.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="patient")
public class Patient implements Serializable {
    private static final long serialVersionUID = 4865683373727394000L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "patient_id", nullable = false, unique = true)
    private String patientId;

    @Column(name = "nic", nullable = false, unique = true)
    private String nic;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "sex", nullable = false)
    private Enums.Sex sex;

    @Column(name = "status", nullable = false)
    private Enums.Status status;

    @Column(name = "registered_date", nullable = false)
    private LocalDate registeredDate;

    @Column(name = "last_updated_time", nullable = false)
    private LocalDateTime lastUpdatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
