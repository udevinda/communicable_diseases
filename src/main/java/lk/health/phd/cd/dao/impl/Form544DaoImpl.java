package lk.health.phd.cd.dao.impl;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import lk.health.phd.cd.dao.Form544Dao;
import lk.health.phd.cd.dto.DiseaseVsPatientSummaryDto;
import lk.health.phd.cd.dto.Form544FilterDto;
import lk.health.phd.cd.dto.MonthVsPatientSummaryDto;
import lk.health.phd.cd.models.Disease;
import lk.health.phd.cd.models.Form544;
import lk.health.phd.cd.models.MohArea;
import lk.health.phd.util.Util;

/**
 * 
 * @author admin
 *
 */

@Repository("form544Dao")
public class Form544DaoImpl extends UniversalDaoImpl<Form544> implements Form544Dao {

	/**
	 * {@inheritDoc}
	 */
	public Form544 findForm544ById(final Long inForm544Id) {
		Session session = getCurrentSession();

		return (Form544) session.createCriteria(Form544.class).add(Restrictions.eq("id", inForm544Id)).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Form544> searchForm544BySearchFields(final Form544FilterDto inForm544FilterDto, final Integer inOffset,
			final Integer inLimit) {

		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class);

		if (inForm544FilterDto.getBhtNo() != null) {
			criteria.add(Restrictions.eq("bhtNo", inForm544FilterDto.getBhtNo()));
		}
		if (inForm544FilterDto.getInstitute() != null && !(inForm544FilterDto.getInstitute().isEmpty())) {
			criteria.add(Restrictions.eq("institute", inForm544FilterDto.getInstitute()));
		}
		if (inForm544FilterDto.getNotifierName() != null && !(inForm544FilterDto.getNotifierName().isEmpty())) {
			criteria.add(Restrictions.eq("notifierName", inForm544FilterDto.getNotifierName()));
		}
		if (inForm544FilterDto.getPatientName() != null && !(inForm544FilterDto.getPatientName().isEmpty())) {
			criteria.add(Restrictions.eq("patientName", inForm544FilterDto.getPatientName()));
		}
		if (inForm544FilterDto.getSerialNo() != null && !(inForm544FilterDto.getSerialNo().isEmpty())) {
			criteria.add(Restrictions.eq("serialNo", inForm544FilterDto.getSerialNo()));
		}
		if (inForm544FilterDto.getSex() != null) {
			criteria.add(Restrictions.eq("sex", inForm544FilterDto.getSex()));
		}
		if (inForm544FilterDto.getWard() != null && !(inForm544FilterDto.getWard().isEmpty())) {
			criteria.add(Restrictions.eq("ward", inForm544FilterDto.getWard()));
		}
		if (inForm544FilterDto.getDisease() != null) {
			criteria.add(Restrictions.eq("disease", inForm544FilterDto.getDisease()));
		}
		if (inForm544FilterDto.getAgeFrom() != null) {
			criteria.add(Restrictions.ge("age", inForm544FilterDto.getAgeFrom()));
		}
		if (inForm544FilterDto.getAgeTo() != null) {
			criteria.add(Restrictions.le("age", inForm544FilterDto.getAgeTo()));
		}
		if (inForm544FilterDto.getDateOfAdmissionFrom() != null) {
			criteria.add(Restrictions.ge("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionFrom()));
		}
		if (inForm544FilterDto.getDateOfAdmissionTo() != null) {
			criteria.add(Restrictions.le("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionTo()));
		}
		if (inForm544FilterDto.getDateOfOnsetFrom() != null) {
			criteria.add(Restrictions.ge("dateOfOnset", inForm544FilterDto.getDateOfOnsetFrom()));
		}
		if (inForm544FilterDto.getDateOfOnsetTo() != null) {
			criteria.add(Restrictions.le("dateOfOnset", inForm544FilterDto.getDateOfOnsetTo()));
		}
		if (inForm544FilterDto.getMohArea() != null) {
			criteria.add(Restrictions.eq("mohArea", inForm544FilterDto.getMohArea()));
		}
		if (inForm544FilterDto.getFromDateOfNotifyFromUnit() != null) {
			criteria.add(Restrictions.ge("notificationByUnitDate", inForm544FilterDto.getFromDateOfNotifyFromUnit()));
		}
		if (inForm544FilterDto.getToDateOfNotifyFromUnit() != null) {
			criteria.add(Restrictions.le("notificationByUnitDate", inForm544FilterDto.getToDateOfNotifyFromUnit()));
		}
		if (inForm544FilterDto.getFromDateOfNotifyToMoh() != null) {
			criteria.add(Restrictions.ge("notificationToMohDate", inForm544FilterDto.getFromDateOfNotifyToMoh()));
		}
		if (inForm544FilterDto.getToDateOfNotifyToMoh() != null) {
			criteria.add(Restrictions.le("notificationToMohDate", inForm544FilterDto.getToDateOfNotifyToMoh()));
		}

		criteria.setMaxResults(inLimit);
		criteria.setFirstResult(inOffset);

		return criteria.list();
	}

	/**
	 * {@inheritDoc}
	 */
	public Long searchCountForm544BySearchFields(Form544FilterDto inForm544FilterDto) {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class);

		if (inForm544FilterDto.getBhtNo() != null) {
			criteria.add(Restrictions.eq("bhtNo", inForm544FilterDto.getBhtNo()));
		}
		if (inForm544FilterDto.getInstitute() != null && !(inForm544FilterDto.getInstitute().isEmpty())) {
			criteria.add(Restrictions.eq("institute", inForm544FilterDto.getInstitute()));
		}
		if (inForm544FilterDto.getNotifierName() != null && !(inForm544FilterDto.getNotifierName().isEmpty())) {
			criteria.add(Restrictions.eq("notifierName", inForm544FilterDto.getNotifierName()));
		}
		if (inForm544FilterDto.getPatientName() != null && !(inForm544FilterDto.getPatientName().isEmpty())) {
			criteria.add(Restrictions.eq("patientName", inForm544FilterDto.getPatientName()));
		}
		if (inForm544FilterDto.getSerialNo() != null && !(inForm544FilterDto.getSerialNo().isEmpty())) {
			criteria.add(Restrictions.eq("serialNo", inForm544FilterDto.getSerialNo()));
		}
		if (inForm544FilterDto.getSex() != null) {
			criteria.add(Restrictions.eq("sex", inForm544FilterDto.getSex()));
		}
		if (inForm544FilterDto.getWard() != null && !(inForm544FilterDto.getWard().isEmpty())) {
			criteria.add(Restrictions.eq("ward", inForm544FilterDto.getWard()));
		}
		if (inForm544FilterDto.getDisease() != null) {
			criteria.add(Restrictions.eq("disease", inForm544FilterDto.getDisease()));
		}
		if (inForm544FilterDto.getAgeFrom() != null) {
			criteria.add(Restrictions.ge("age", inForm544FilterDto.getAgeFrom()));
		}
		if (inForm544FilterDto.getAgeTo() != null) {
			criteria.add(Restrictions.le("age", inForm544FilterDto.getAgeTo()));
		}
		if (inForm544FilterDto.getDateOfAdmissionFrom() != null) {
			criteria.add(Restrictions.ge("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionFrom()));
		}
		if (inForm544FilterDto.getDateOfAdmissionTo() != null) {
			criteria.add(Restrictions.le("dateOfAdmission", inForm544FilterDto.getDateOfAdmissionTo()));
		}
		if (inForm544FilterDto.getDateOfOnsetFrom() != null) {
			criteria.add(Restrictions.ge("dateOfOnset", inForm544FilterDto.getDateOfOnsetFrom()));
		}
		if (inForm544FilterDto.getDateOfOnsetTo() != null) {
			criteria.add(Restrictions.le("dateOfOnset", inForm544FilterDto.getDateOfOnsetTo()));
		}
		if (inForm544FilterDto.getMohArea() != null) {
			criteria.add(Restrictions.eq("mohArea", inForm544FilterDto.getMohArea()));
		}
		if (inForm544FilterDto.getFromDateOfNotifyFromUnit() != null) {
			criteria.add(Restrictions.ge("notificationByUnitDate", inForm544FilterDto.getFromDateOfNotifyFromUnit()));
		}
		if (inForm544FilterDto.getToDateOfNotifyFromUnit() != null) {
			criteria.add(Restrictions.le("notificationByUnitDate", inForm544FilterDto.getToDateOfNotifyFromUnit()));
		}
		if (inForm544FilterDto.getFromDateOfNotifyToMoh() != null) {
			criteria.add(Restrictions.ge("notificationToMohDate", inForm544FilterDto.getFromDateOfNotifyToMoh()));
		}
		if (inForm544FilterDto.getToDateOfNotifyToMoh() != null) {
			criteria.add(Restrictions.le("notificationToMohDate", inForm544FilterDto.getToDateOfNotifyToMoh()));
		}

		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public Long getForm544CountForCurrentMonth() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(Util.getSystemTime());

		String lowerDateLimit = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + 1;
		String upperDateLimit = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + 31;

		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class);

		try {
			criteria.add(Restrictions.ge("systemNotifiedDate", Util.parseDate(lowerDateLimit, "yyyy-MM-dd")));
			criteria.add(Restrictions.le("systemNotifiedDate", Util.parseDate(upperDateLimit, "yyyy-MM-dd")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public Long getForm544CountForCurrentYear() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(Util.getSystemTime());

		String lowerDateLimit = cal.get(Calendar.YEAR) + "-" + 1 + "-" + 1;
		String upperDateLimit = cal.get(Calendar.YEAR) + "-" + 12 + "-" + 31;

		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class);

		try {
			criteria.add(Restrictions.ge("systemNotifiedDate", Util.parseDate(lowerDateLimit, "yyyy-MM-dd")));
			criteria.add(Restrictions.le("systemNotifiedDate", Util.parseDate(upperDateLimit, "yyyy-MM-dd")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

	}

	/**
	 * {@inheritDoc}
	 */
	public List<DiseaseVsPatientSummaryDto> getEachDiseaseCountForGivenMohArea(final MohArea inMohArea,
			final String inLowerDateLimit, final String inUpperDateLimit) {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class, "form544");

		try {
			criteria.add(Restrictions.eq("mohArea", inMohArea));
			criteria.add(Restrictions.ge("systemNotifiedDate", Util.parseDate(inLowerDateLimit, "yyyy-MM-dd")));
			criteria.add(Restrictions.le("systemNotifiedDate", Util.parseDate(inUpperDateLimit, "yyyy-MM-dd")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		criteria.createAlias("form544.disease", "disease");

		return criteria
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("disease.diseaseName"), "diseaseName")
						.add(Projections.count("id"), "count"))
				.setResultTransformer(new AliasToBeanResultTransformer(DiseaseVsPatientSummaryDto.class)).list();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<DiseaseVsPatientSummaryDto> getEachDiseaseCountForGivenWard(final String inWard,
			final String inLowerDateLimit, final String inUpperDateLimit) {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class, "form544");

		try {
			criteria.add(Restrictions.eq("ward", inWard));
			criteria.add(Restrictions.ge("systemNotifiedDate", Util.parseDate(inLowerDateLimit, "yyyy-MM-dd")));
			criteria.add(Restrictions.le("systemNotifiedDate", Util.parseDate(inUpperDateLimit, "yyyy-MM-dd")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		criteria.createAlias("form544.disease", "disease");

		return criteria
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("disease.diseaseName"), "diseaseName")
						.add(Projections.count("id"), "count"))
				.setResultTransformer(new AliasToBeanResultTransformer(DiseaseVsPatientSummaryDto.class)).list();
	}

	/**
	 * {@inheritDoc}
	 */
	public List getWardsForAInstitute(final String inInstitute) {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class, "form544");
		criteria.add(Restrictions.eq("institute", inInstitute));

		return criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("ward"), "ward"))
				.setResultTransformer(Transformers.TO_LIST).list();
	}

	/**
	 * {@inheritDoc}
	 */
	public List getDistinctInstituteList() {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class, "form544");

		return criteria
				.setProjection(Projections.projectionList().add(Projections.groupProperty("institute"), "institute"))
				.setResultTransformer(Transformers.TO_LIST).list();
	}

	public List<MonthVsPatientSummaryDto> getDiseaseCountForEachMonth(final Disease inDisease, final MohArea inMohArea,
			final String inYear) {
		Session session = getCurrentSession();

		Criteria criteria = session.createCriteria(Form544.class, "form544");
		criteria.add(Restrictions.eq("mohArea", inMohArea));
		criteria.add(Restrictions.eq("disease", inDisease));
		criteria.add(Restrictions.sqlRestriction("year({alias}.date_of_admission)=?", inYear, StringType.INSTANCE));

		return criteria
				.setProjection(Projections.projectionList()
						.add(Projections.sqlGroupProjection("month({alias}.date_of_admission) as month",
								"month({alias}.date_of_admission)", new String[] { "month" },
								new Type[] { IntegerType.INSTANCE }), "month")
						.add(Projections.count("id"), "count"))
				.setResultTransformer(new AliasToBeanResultTransformer(MonthVsPatientSummaryDto.class)).list();
	}

}
