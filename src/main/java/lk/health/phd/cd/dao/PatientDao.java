package lk.health.phd.cd.dao;

import lk.health.phd.cd.models.Patient;

public interface PatientDao extends UniversalDao<Patient> {
    Patient getPatientById(final Long inPatientId);
}
