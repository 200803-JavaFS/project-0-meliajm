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

DELETE FROM accounts WHERE account_id = 10;

DELETE FROM accounts WHERE account_id = 11;

DELETE FROM accounts WHERE account_id = 12;

DELETE FROM users WHERE user_id = 99;
-------------------------------------------

CREATE OR REPLACE FUNCTION trigger_set_time() RETURNS TRIGGER 
AS $$
BEGIN
	NEW.update_at = NOW();
	RETURN NEW; 
END;
$$ LANGUAGE plpgsql; 

ALTER TABLE accounts ADD COLUMN update_at TIMESTAMP;

CREATE TRIGGER set_time BEFORE UPDATE ON accounts FOR EACH ROW
EXECUTE PROCEDURE trigger_set_time();
	