drop table if exists avengers;
-- 0 NORMAL FORM
create table avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	real_name VARCHAR(30),
	power_level INTEGER,
	home_base VARCHAR(30),
	hb_address VARCHAR(60)
);

insert into avengers  (superhero_name, superhero_power, real_name, power_level, home_base, hb_address)
	values ('Captain America', 'Super Strong Frisbee', 'Steve Rodgers', 20, 'Stark Tower', '123 Stark Ave New York NY 10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint Barton', 55, 'Stark Tower', '123 Stark Ave New York NY 10709');

-- first normal form

create table avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	power_level INTEGER,
	home_base VARCHAR(30),
	hb_st_addr VARCHAR(60),
	hb_city VARCHAR(30),
	hb_state VARCHAR(2),
	hb_zip VARCHAR(5)
);

insert into avengers  (superhero_name, superhero_power, first_name, last_name, power_level, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	values ('Captain America', 'Super Strong Frisbee', 'Steve', 'Rodgers', 20, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 55, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709');

alter table avengers add primary key (superhero_name, first_name, last_name);

-- second normal form
drop table if exists avengers;

create table avengers (
	superhero_id SERIAL primary key,
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	power_level INTEGER,
	home_base VARCHAR(30),
	hb_st_addr VARCHAR(60),
	hb_city VARCHAR(30),
	hb_state VARCHAR(2),
	hb_zip VARCHAR(5)
);

insert into avengers  (superhero_name, superhero_power, first_name, last_name, power_level, home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	values ('Captain America', 'Super Strong Frisbee', 'Steve', 'Rodgers', 20, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 55, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Captain America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 20, 'Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709')
;

-- third normal form no transitive dependencies

drop table if exists avengers;
drop table if exists homes cascade;

create table homes (
	home_base VARCHAR(30) primary key,
	hb_st_addr VARCHAR(60),
	hb_city VARCHAR(30),
	hb_state VARCHAR(2),
	hb_zip VARCHAR(5)
);

create table avengers (
	superhero_id SERIAL primary key,
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	power_level INTEGER,
	home_base_fk VARCHAR(30) references homes(home_base)
);



insert into homes (home_base, hb_st_addr, hb_city, hb_state, hb_zip)
	values('Stark Tower', '123 Stark Ave', 'New York', 'NY', '10709'),
	('Helicarrier', 'bottom of the potomac', 'Washington', 'DC', '00000'),
	('Shawarma Joint', 'Somewhere in Manhattan',  'New York', 'NY', '10709')

insert into avengers  (superhero_name, superhero_power, first_name, last_name, power_level, home_base_fk)
	values ('Captain America', 'Super Strong Frisbee', 'Steve', 'Rodgers', 20, 'Stark Tower'),
	('Hawkeye', 'plucky can-do attitude', 'Clint', 'Barton', 55, 'Helicarrier'),
	('Captain America', 'Super Strong Frisbee', 'Bucky', 'Barnes', 20, 'Stark Tower'),
	('Hulk', 'Changes size to be huge', 'Bruce', 'Banner', 104, null)
;

select * from avengers join homes on home_base = home_base_fk;












