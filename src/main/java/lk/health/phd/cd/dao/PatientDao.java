package lk.health.phd.cd.dao;

import lk.health.phd.cd.dto.Form544FilterDto;
import lk.health.phd.cd.dto.PatientFilterDto;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.Patient;

import java.util.List;

public interface PatientDao extends UniversalDao<Patient> {
    Patient getPatientById(final Long inId);
    Patient getPatientByPatientId(final String inPatientId);
    List<Patient> searchPatientBySearchFields(final PatientFilterDto inPatientFilterDto, final Integer inOffset,
                                              final Integer inLimit);

    Long searchCountPatientBySearchFields(final PatientFilterDto inPatientFilterDto);
}
