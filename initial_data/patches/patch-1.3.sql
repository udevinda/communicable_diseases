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
insert into disease(disease_name, shortcode) values('Leishmenaisis and Leprosy', 'LL');