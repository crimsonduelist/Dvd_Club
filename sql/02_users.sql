-- ============================================================================
-- DVD Club: Users & Authentication Database
-- ============================================================================
-- Run this script to create the authentication database for Apache Shiro.
-- This is a separate database from the main DVD Club database.
--
-- Prerequisites:
--   - MySQL/MariaDB server
--   - 01_schema.sql should be run first (optional, but recommended order)
-- ============================================================================

-- ============================================================================
-- STEP 1: Create Database
-- ============================================================================

CREATE DATABASE CREDENTIALS2;
USE CREDENTIALS2;

-- ============================================================================
-- STEP 2: Create Tables
-- ============================================================================

DROP TABLES IF EXISTS USERS2, ROLES2;

-- Users table
-- Stores login credentials for the application
CREATE TABLE USERS2 (
    USERID      INT AUTO_INCREMENT,
    USERNAME    VARCHAR(256),
    PASS        VARCHAR(256),
    PRIMARY KEY (USERID)
);

-- Roles table
-- Links users to their roles (ADMIN or USER)
CREATE TABLE ROLES2 (
    ID      INT AUTO_INCREMENT,
    ROLES   ENUM('ADMIN', 'USER'),
    USERID  INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (USERID) REFERENCES USERS2(USERID)
);

-- ============================================================================
-- STEP 3: Sample Users (optional)
-- ============================================================================
-- Uncomment the lines below to add sample users for testing

/*
INSERT INTO USERS2(USERNAME, PASS) VALUES('USER2', 'PASS2');
INSERT INTO ROLES2(ROLES, USERID) VALUES('USER', 2);
INSERT INTO USERS2(USERNAME, PASS) VALUES('USER3', 'PASS3');
INSERT INTO ROLES2(ROLES, USERID) VALUES('USER', 4);
*/

-- Verify users were created
-- SELECT * FROM USERS2;
-- SELECT * FROM ROLES2;
