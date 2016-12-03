package lk.health.phd.cd.dao.impl;

import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.PatientContactDao;
import lk.health.phd.cd.models.PatientContact;

/**
 * 
 * @author admin
 *
 */

@Repository("patientContactDao")
public class PatientContactDaoImpl extends UniversalDaoImpl<PatientContact> implements PatientContactDao {

}
