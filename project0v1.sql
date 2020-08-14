create table users (
	user_id SERIAL primary key,
	username VARCHAR(30),
	user_password VARCHAR(30),
	user_type INTEGER,
	first_name VARCHAR(30),
	last_name VARCHAR(30)
);

create table accounts (
	account_id SERIAL primary key,
	balance numeric(12, 2),
	status_of_account INTEGER,
	account_type VARCHAR(8),
	user_id_fk INTEGER references users(user_id)
);

insert into users  (username, user_password, user_type, first_name, last_name)
	values ('Captain', 'p', 1, 'El Capitain', 'Miller'),
	('Jimbo', 'p', 2, 'James','Peacock')
;

insert into accounts (balance, status_of_account, account_type, user_id_fk)
	values(0.00, 1, 'SAVINGS', 1),
	(100000.00, 2, 'CHECKING', 2),
	(0.56, 1, 'CHECKING', null);
;


	