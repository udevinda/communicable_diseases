package lk.health.phd.cd.services.impl;

import lk.health.phd.cd.dao.PatientDao;
import lk.health.phd.cd.models.Patient;
import lk.health.phd.cd.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDao patientDao;

    public Patient addPatient(final Patient patient) {
        Long id = patientDao.save(patient);
        Patient persistedPatient = patientDao.getPatientById(id);
        return persistedPatient;
    }
}
