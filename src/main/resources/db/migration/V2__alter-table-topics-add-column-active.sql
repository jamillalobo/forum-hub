alter table topics add active tinyint;
update topics set active = 1;
