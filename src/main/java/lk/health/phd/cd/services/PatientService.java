package lk.health.phd.cd.services;

import lk.health.phd.cd.dto.PatientFilterDto;
import lk.health.phd.cd.models.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(final Patient patient);
    Patient updatePatient(final Patient patient);
    Patient findPatientbyId(final String patientId);
    List<Patient> searchPatientByFilterFields(final PatientFilterDto inPatientFilterDto, final Integer inOffset,
                                              final Integer inLimit);
    Long searchCountPatientByFilterFields(final PatientFilterDto inPatientFilterDto);
}
