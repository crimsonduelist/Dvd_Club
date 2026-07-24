-- ============================================================================
-- DVD Club: Database Schema
-- ============================================================================
-- Run this script to create the DVD Club database and tables.
-- This is the main application database for managing DVDs, members, and loans.
--
-- Prerequisites:
--   - MySQL/MariaDB server
--   - Run as root or user with CREATE DATABASE privileges
-- ============================================================================

-- ============================================================================
-- STEP 1: Create Database
-- ============================================================================

CREATE DATABASE CREDENTIALS3;
USE CREDENTIALS3;

-- ============================================================================
-- STEP 2: Create Tables
-- ============================================================================
-- Drop existing tables if they exist (for clean re-runs)

DROP TABLES IF EXISTS Includes, PlaysIn, BORROW, PHONE, DVD, MEMBER, ACTOR, CATEGORY;

-- Members table
-- Stores customer/member information
CREATE TABLE Member (
    mNo         INT AUTO_INCREMENT,
    mLastName   VARCHAR(20) NOT NULL,
    mFirstName  VARCHAR(15) NOT NULL,
    mAddress    VARCHAR(30),
    mRegDate    DATE NOT NULL,
    mDvdCount   INT,
    PRIMARY KEY (mNo),
    CHECK (mDvdCount >= 0)
);

-- DVDs table
-- Stores DVD catalog information
CREATE TABLE Dvd (
    dCode               INT AUTO_INCREMENT,
    dTitle              VARCHAR(30) NOT NULL,
    dDirector           VARCHAR(35),
    dvdLendCost         INT NOT NULL,
    dAcquisitionCost    INT NOT NULL,
    dCategoryCount      INT,
    dLendTimes          INT,
    PRIMARY KEY (dCode),
    CHECK (dvdLendCost >= 0),
    CHECK (dAcquisitionCost >= 0),
    CHECK (dCategoryCount >= 0),
    CHECK (dLendTimes >= 0)
);

-- Categories table
-- Each DVD belongs to one or more categories
CREATE TABLE Category (
    cName       VARCHAR(30),
    cDvdCount   INT,
    PRIMARY KEY (cName),
    CHECK (cDvdCount >= 0)
);

-- Actors table
-- Stores actor information
CREATE TABLE Actor (
    aName   VARCHAR(30),
    aOscar  INT,
    PRIMARY KEY (aName),
    CHECK (aOscar >= 0)
);

-- Phone numbers for members
-- Each member can have multiple phone numbers
CREATE TABLE Phone (
    mNo        INT,
    mPhoneNo   VARCHAR(10),
    PRIMARY KEY (mNo, mPhoneNo),
    FOREIGN KEY (mNo) REFERENCES Member(mNo)
);

-- Borrow/Loan records
-- Tracks which member borrowed which DVD and when
CREATE TABLE Borrow (
    mNo     INT,
    dCode   INT,
    outDate DATE,
    inDate  DATE,
    PRIMARY KEY (outDate),
    FOREIGN KEY (mNo) REFERENCES Member(mNo),
    FOREIGN KEY (dCode) REFERENCES Dvd(dCode)
);

-- PlaysIn junction table
-- Maps actors to DVDs they appear in (many-to-many)
CREATE TABLE PlaysIn (
    aName   VARCHAR(30),
    dCode   INT,
    roleNo  INT,
    PRIMARY KEY (aName, dCode),
    FOREIGN KEY (aName) REFERENCES Actor(aName),
    FOREIGN KEY (dCode) REFERENCES Dvd(dCode)
);

-- Includes junction table
-- Maps categories to DVDs (many-to-many)
CREATE TABLE Includes (
    cName   VARCHAR(15),
    dCode   INT,
    PRIMARY KEY (cName, dCode),
    FOREIGN KEY (cName) REFERENCES Category(cName),
    FOREIGN KEY (dCode) REFERENCES Dvd(dCode)
);
