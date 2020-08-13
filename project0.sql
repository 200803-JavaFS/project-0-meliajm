create table accounts (
	account_id SERIAL primary key,
	balance numeric(12, 2),
	status_of_account INTEGER,
	account_type VARCHAR(8)
);

create table users (
	user_id SERIAL primary key,
	username VARCHAR(30),
	user_password VARCHAR(30),
	user_type INTEGER,
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	account_id_fk INTEGER references accounts(account_id)
);