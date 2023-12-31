CREATE DATABASE CREDENTIALS2;
USE CREDENTIALS2;

DROP TABLES IF EXISTS USERS2,ROLES2;
CREATE TABLE USERS2 (USERID int AUTO_INCREMENT,USERNAME varchar(256),PASS varchar(256),
PRIMARY KEY(userid) );
CREATE TABLE ROLES2 (ID INT AUTO_INCREMENT ,ROLES ENUM ('ADMIN','USER'),USERID INT,
PRIMARY KEY (ID), 
FOREIGN KEY(USERID) REFERENCES USERS2(USERID));

/*Sample users*/
INSERT INTO USERS2(USERNAME,PASS) VALUES("USER2","PASS2");
INSERT INTO ROLES2 (ROLES,USERID) VALUES ('USER',2);
INSERT INTO USERS2(USERNAME,PASS) VALUES("USER3","PASS3");
INSERT INTO ROLES2 (ROLES,USERID) VALUES ('USER',4);
/*Check that your users were created*/
SELECT* FROM USERS2;
SELECT* FROM ROLES2;