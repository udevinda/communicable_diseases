package lk.health.phd.cd.services.impl;

import lk.health.phd.cd.dao.PatientDao;
import lk.health.phd.cd.models.Patient;
import lk.health.phd.cd.services.PatientService;
import lk.health.phd.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDao patientDao;

    public Patient addPatient(final Patient patient) {
        patient.setRegisteredDate(LocalDate.now());
        patient.setLastUpdatedTime(LocalDateTime.now());
        patient.setPatientId(Util.getUniqueId(patient.getNic()+patient.getRegisteredDate()));
        Long id = patientDao.save(patient);
        Patient persistedPatient = patientDao.getPatientById(id);
        return persistedPatient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Patient alreadyAvailablePatient = patientDao.getPatientByPatientId(patient.getPatientId());
        alreadyAvailablePatient.setNic(patient.getNic());
        alreadyAvailablePatient.setName(patient.getName());
        alreadyAvailablePatient.setAddress(patient.getAddress());
        alreadyAvailablePatient.setContactNo(patient.getContactNo());
        alreadyAvailablePatient.setSex(patient.getSex());
        alreadyAvailablePatient.setStatus(patient.getStatus());
        alreadyAvailablePatient.setLastUpdatedTime(LocalDateTime.now());

        Long id = patientDao.save(alreadyAvailablePatient);

        return patientDao.getPatientById(id);
    }

    @Override
    public Patient findPatientbyId(final String patientId){
        return patientDao.getPatientByPatientId(patientId);
    }
}
