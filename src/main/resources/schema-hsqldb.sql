CREATE TABLE customers
(
	userID NUMBER(19) NOT NULL,
	firstName VARCHAR(100) NOT NULL,
	lastName VARCHAR(100) NOT NULL,
	email VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (userID)
);