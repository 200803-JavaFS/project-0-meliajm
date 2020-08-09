questions:
which methods should be static in models?
how are associations made in Java?
how to delete a User or Account in Java?
how does a user login?
do we need to unit test our setters and getters?


to do:
[] connect scanner to models -> create new User and new Accounts
[] associate User and Account

[x]add validation to accounts and users
[x]*over-withdraw
[x]*no negative numbers for amounts to be deposited, transferred, withdraw
[x]*no empty Strings for username or password, min char length of password


build menu (user interface)

build service layer
	-login
	-logout
	-models
		-User
			-methods (login, logout)
			-fields
		-Account
			-methods (deposit, withdraw, transfer, etc)
	--testing of User

	--testing of Account
	
user experience flow:
 1. welcome
 2. user type
 3. login for type 1
	 1. find or create account
	 2. get balance, transfer, withdraw, deposit
	 3. switch accounts
	 4. exit
	 
 4. login for type 2
 	1. employee can view all accounts
 	2. exit
 5. login for type 3
 	1. approve/deny accounts
 	2. withdraw, deposit, transfer from all accounts
 	3. cancel account
 	4. exit
 
 
ways to break
 1. null or empty fields 
 2. cannot over-withdraw
 3. cannot add negative numbers