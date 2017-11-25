insert into institute(name, district_id) values("DGH-Matale", 16);

update form_544 set institute=1 where institute='DGH - MATALE';
update form_544 set institute=1 where institute='DGH- Matale';
update form_544 set institute=1 where institute='DGH-Matale';
update form_544 set institute=1 where institute='DGH Matale';
update form_544 set institute=1 where institute='District General Hospital - Matale';

alter table form_544 drop column institute_id;
alter table form_544 change `institute` `institute_id` bigint(20);

update form_544 set disease_id=6 where disease_id=26;
delete from disease where id=26 and disease_name='Dengue Fever';

update form_544 set disease_id=25 where disease_id=27;
delete from disease where id=27 and disease_name='Influenza H1N1';

insert into disease(disease_name, shortcode) values('Blood and Mucosa Diarrhoea', 'BMD');
insert into disease(disease_name, shortcode) values('Leishmenaisis', 'LM');
insert into disease(disease_name, shortcode) values('Leprosy', 'LP');

insert into ward(name, institute_id) values("03", 1);
insert into ward(name, institute_id) values("04", 1);
insert into ward(name, institute_id) values("06", 1);
insert into ward(name, institute_id) values("07", 1);
insert into ward(name, institute_id) values("08", 1);
insert into ward(name, institute_id) values("09", 1);
insert into ward(name, institute_id) values("CLINIK", 1);
insert into ward(name, institute_id) values("ICU", 1);

update form_544 set ward=1 where ward='03';
update form_544 set ward=2 where ward='04';
update form_544 set ward=3 where ward='06';
update form_544 set ward=4 where ward='07';
update form_544 set ward=5 where ward='08';
update form_544 set ward=6 where ward='09';
update form_544 set ward=3 where ward='6';
update form_544 set ward=6 where ward='9';
update form_544 set ward=7 where ward='CLINIK';
update form_544 set ward=8 where ward='ICU';


alter table form_544 drop column ward_id;
alter table form_544 change `ward` `ward_id` bigint(20);