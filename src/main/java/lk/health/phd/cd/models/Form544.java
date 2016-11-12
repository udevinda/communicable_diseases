package lk.health.phd.cd.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "form_544")
public class Form544 implements Serializable {

	private static final long serialVersionUID = 5714134454387505650L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "nic", unique = true, nullable = false)
	private String nic;

	@Column(name = "institute", nullable = false)
	private String institute;

	@Column(name = "diesease", nullable = false)
	private String disease;

	@Column(name = "patient_name", nullable = false)
	private String patientName;

	@Column(name = "date_of_onset")
	private Date dateOfOnset;

	@Column(name = "peaditiric_patients_gurdian_name")
	private String peaditiricPatientsGurdianName;

	@Column(name = "date_of_admission", nullable = false)
	private Date dateOfAdmission;

	@Column(name = "bht_no", nullable = false)
	private Long bhtNo;

	@Column(name = "ward", nullable = false)
	private String ward;

	@Column(name = "age", nullable = false)
	private Integer age;

	// TODO convert to enum
	@Column(name = "sex", nullable = false)
	private String sex;

	@Column(name = "patient_home_address")
	private String patientHomeAddress;

	@Column(name = "patient_home_phone_no")
	private String patientsHomePhoneNo;

	@Column(name = "notifier_name", nullable = false)
	private String notifierName;

	@Column(name = "notifier_status", nullable = false)
	private String notifierStatus;

	@Column(name = "system_notified_date", nullable = false)
	private Date systemNotifiedDate;

}
