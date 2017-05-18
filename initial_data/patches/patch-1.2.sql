update moh_area set moh_area="Other" where id=14;

update form_544 set moh_area_id=14 where moh_area_id=15;
update form_544 set moh_area_id=14 where moh_area_id=16;

delete from moh_area where id=15;
delete from moh_area where id=16;