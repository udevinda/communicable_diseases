package lk.health.phd.cd.services;

import lk.health.phd.cd.models.Patient;

public interface PatientService {
    Patient addPatient(final Patient patient);
    Patient findPatientbyId(final String patientId);
}
