insert into institute(name, district_id) values("DGH-Matale", 16);

update form_544 set institute=1 where institute='DGH - MATALE';
update form_544 set institute=1 where institute='DGH- Matale';
update form_544 set institute=1 where institute='DGH-Matale';
update form_544 set institute=1 where institute='DGH Matale';
update form_544 set institute=1 where institute='District General Hospital - Matale';

alter table form_544 drop column institute_id;
alter table form_544 change `institute` `institute_id` bigint(20);