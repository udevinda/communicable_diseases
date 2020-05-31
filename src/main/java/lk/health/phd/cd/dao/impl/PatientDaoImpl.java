package lk.health.phd.cd.dao.impl;

import lk.health.phd.cd.dao.PatientDao;
import lk.health.phd.cd.dto.PatientFilterDto;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.Patient;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("patientDao")
public class PatientDaoImpl extends UniversalDaoImpl<Patient> implements PatientDao {

    public Patient getPatientById(final Long inId){
        Session session = getCurrentSession();

        return (Patient) session.createCriteria(Patient.class).add(Restrictions.eq("id", inId)).uniqueResult();
    }

    @Override
    public Patient getPatientByPatientId(String inPatientId){
        Session session = getCurrentSession();

        return (Patient) session.createCriteria(Patient.class).add(Restrictions.eq("patientId", inPatientId))
                .uniqueResult();
    }

    @Override
    public List<Patient> searchPatientBySearchFields(PatientFilterDto inPatientFilterDto, Integer inOffset, Integer inLimit) {
        Session session = getCurrentSession();

        Criteria criteria = session.createCriteria(Patient.class);

        if (inPatientFilterDto.getPatientId() != null && !(inPatientFilterDto.getPatientId().isEmpty())) {
            criteria.add(Restrictions.eq("patientId", inPatientFilterDto.getPatientId()));
        }
        if (inPatientFilterDto.getNic() != null && !(inPatientFilterDto.getNic().isEmpty())) {
            criteria.add(Restrictions.eq("nic", inPatientFilterDto.getNic()));
        }
        if (inPatientFilterDto.getName() != null && !(inPatientFilterDto.getName().isEmpty())) {
            criteria.add(Restrictions.eq("name", inPatientFilterDto.getName()));
        }
        if (inPatientFilterDto.getContactNo() != null && !(inPatientFilterDto.getContactNo().isEmpty())) {
            criteria.add(Restrictions.eq("contactNo", inPatientFilterDto.getContactNo()));
        }
        if (inPatientFilterDto.getSex() != null) {
            criteria.add(Restrictions.eq("sex", inPatientFilterDto.getSex()));
        }
        if (inPatientFilterDto.getStatus() != null) {
            criteria.add(Restrictions.eq("status", inPatientFilterDto.getStatus()));
        }
        if (inPatientFilterDto.getDateOfRegisteredFrom() != null) {
            criteria.add(Restrictions.ge("registeredDate", inPatientFilterDto.getDateOfRegisteredFrom()));
        }
        if (inPatientFilterDto.getDateOfRegisteredTo() != null) {
            criteria.add(Restrictions.le("registeredDate", inPatientFilterDto.getDateOfRegisteredTo()));
        }

        criteria.setMaxResults(inLimit);
        criteria.setFirstResult(inOffset);

        return criteria.list();
    }

    @Override
    public Long searchCountPatientBySearchFields(PatientFilterDto inPatientFilterDto) {
        Session session = getCurrentSession();

        Criteria criteria = session.createCriteria(Patient.class);

        if (inPatientFilterDto.getPatientId() != null) {
            criteria.add(Restrictions.eq("patientId", inPatientFilterDto.getPatientId()));
        }
        if (inPatientFilterDto.getNic() != null) {
            criteria.add(Restrictions.eq("nic", inPatientFilterDto.getNic()));
        }
        if (inPatientFilterDto.getName() != null && !(inPatientFilterDto.getName().isEmpty())) {
            criteria.add(Restrictions.eq("name", inPatientFilterDto.getName()));
        }
        if (inPatientFilterDto.getContactNo() != null && !(inPatientFilterDto.getContactNo().isEmpty())) {
            criteria.add(Restrictions.eq("contactNo", inPatientFilterDto.getContactNo()));
        }
        if (inPatientFilterDto.getSex() != null) {
            criteria.add(Restrictions.eq("sex", inPatientFilterDto.getSex()));
        }
        if (inPatientFilterDto.getStatus() != null) {
            criteria.add(Restrictions.eq("status", inPatientFilterDto.getStatus()));
        }
        if (inPatientFilterDto.getDateOfRegisteredFrom() != null) {
            criteria.add(Restrictions.ge("registeredDate", inPatientFilterDto.getDateOfRegisteredFrom()));
        }
        if (inPatientFilterDto.getDateOfRegisteredTo() != null) {
            criteria.add(Restrictions.le("registeredDate", inPatientFilterDto.getDateOfRegisteredTo()));
        }

        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

}
