-- ============================================================================
-- DVD Club: Authentication Database Schema
-- ============================================================================
-- Creates the dvdclub_auth_db database and tables for Apache Shiro
-- user authentication and role management.
-- ============================================================================

CREATE DATABASE IF NOT EXISTS dvdclub_auth_db;
USE dvdclub_auth_db;

DROP TABLE IF EXISTS ROLES2, USERS2;

CREATE TABLE USERS2 (
    USERID      INT AUTO_INCREMENT,
    USERNAME    VARCHAR(256),
    PASS        VARCHAR(256),
    PRIMARY KEY (USERID)
);

CREATE TABLE ROLES2 (
    ID      INT AUTO_INCREMENT,
    ROLES   ENUM('ADMIN', 'USER'),
    USERID  INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (USERID) REFERENCES USERS2(USERID)
);
