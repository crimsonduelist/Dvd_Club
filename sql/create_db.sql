-- ============================================================================
-- DVD Club: Main Database Schema
-- ============================================================================
-- Creates the dvdclub_db database and all tables for the DVD Club
-- application (DVDs, members, loans, actors, categories).
-- ============================================================================

CREATE DATABASE IF NOT EXISTS dvdclub_db;
USE dvdclub_db;

DROP TABLE IF EXISTS includes, playsin, borrow, phone, dvd, member, actor, category;

CREATE TABLE member (
    mNo         INT AUTO_INCREMENT,
    mLastName   VARCHAR(20) NOT NULL,
    mFirstName  VARCHAR(15) NOT NULL,
    mAddress    VARCHAR(30),
    mRegDate    DATE NOT NULL,
    mDvdCount   INT,
    PRIMARY KEY (mNo),
    CHECK (mDvdCount >= 0)
);

CREATE TABLE dvd (
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

CREATE TABLE category (
    cName       VARCHAR(30),
    cDvdCount   INT,
    PRIMARY KEY (cName),
    CHECK (cDvdCount >= 0)
);

CREATE TABLE actor (
    aName   VARCHAR(30),
    aOscar  INT,
    PRIMARY KEY (aName),
    CHECK (aOscar >= 0)
);

CREATE TABLE phone (
    mNo        INT,
    mPhoneNo   VARCHAR(10),
    PRIMARY KEY (mNo, mPhoneNo),
    FOREIGN KEY (mNo) REFERENCES member(mNo)
);

CREATE TABLE borrow (
    mNo     INT,
    dCode   INT,
    outDate DATE,
    inDate  DATE,
    PRIMARY KEY (outDate),
    FOREIGN KEY (mNo) REFERENCES member(mNo),
    FOREIGN KEY (dCode) REFERENCES dvd(dCode)
);

CREATE TABLE playsin (
    aName   VARCHAR(30),
    dCode   INT,
    roleNo  INT,
    PRIMARY KEY (aName, dCode),
    FOREIGN KEY (aName) REFERENCES actor(aName),
    FOREIGN KEY (dCode) REFERENCES dvd(dCode)
);

CREATE TABLE includes (
    cName   VARCHAR(15),
    dCode   INT,
    PRIMARY KEY (cName, dCode),
    FOREIGN KEY (cName) REFERENCES category(cName),
    FOREIGN KEY (dCode) REFERENCES dvd(dCode)
);
