CREATE TABLE countries(
		id int PRIMARY KEY, 
		name varchar(255) NOT NULL
    );
CREATE TABLE brands(
		id int PRIMARY KEY,
		name varchar(255) NOT NULL
    );
CREATE TABLE warehouses(
		id int PRIMARY KEY,
		address varchar(255)
    );
CREATE TABLE employees(
		id int PRIMARY KEY,
		first_name varchar(255) NOT NULL,
		last_name varchar(255) NOT NULL,
		date_of_birth date NOT NULL,
		salary_in_usd int
	);
CREATE TABLE phones(
		id int PRIMARY KEY,
		model varchar(255) NOT NULL,
		year_made int NOT NULL,
		price_in_usd int NOT NULL
    );
