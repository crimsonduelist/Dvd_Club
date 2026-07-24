-- ============================================================================
-- DVD Club: Sample Data
-- ============================================================================
-- Run this script AFTER 01_schema.sql to populate the database with
-- sample data for testing and development.
--
-- Prerequisites:
--   - 01_schema.sql must be run first
--   - Database CREDENTIALS3 must exist
-- ============================================================================

USE CREDENTIALS3;

-- ============================================================================
-- Members
-- ============================================================================

INSERT INTO Member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (100, 'NIKOY', 'NIKOS', 'TZAVARA 12', '01/03/08', NULL);

INSERT INTO Member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (101, 'PETROY', 'PETROS', 'RIGA 23', '15/02/09', NULL);

INSERT INTO Member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (102, 'FWTIOY', 'FWTIS', 'KANARH 20', '17/03/09', NULL);

-- ============================================================================
-- DVDs
-- ============================================================================

INSERT INTO Dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10001, 'scarface', 'Brian De Palma', 1.5, 20, 2, 2);

INSERT INTO Dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10002, 'Instinct', 'Jon Turtelaub', 1.5, 22, 2, 2);

INSERT INTO Dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10003, 'Scent of woman', 'Martin Brest', 1.7, 21, 1, 1);

-- ============================================================================
-- Categories
-- ============================================================================

INSERT INTO Category (cName, cDvdCount) VALUES ('crime', 1);
INSERT INTO Category (cName, cDvdCount) VALUES ('drama', 3);
INSERT INTO Category (cName, cDvdCount) VALUES ('thriller', 1);

-- ============================================================================
-- Actors
-- ============================================================================

INSERT INTO Actor (aName, aOscar) VALUES ('Al Pacino', NULL);
INSERT INTO Actor (aName, aOscar) VALUES ('Michelle Pfeiffer', NULL);
INSERT INTO Actor (aName, aOscar) VALUES ('Anthony Hopkins', NULL);
INSERT INTO Actor (aName, aOscar) VALUES ('Cuba Gooding', NULL);
INSERT INTO Actor (aName, aOscar) VALUES ('Chris O ''Donnell', NULL);

-- ============================================================================
-- Phone Numbers
-- ============================================================================

INSERT INTO Phone (mNo, mPhoneNo) VALUES (100, '6944100001');
INSERT INTO Phone (mNo, mPhoneNo) VALUES (100, '6944100002');
INSERT INTO Phone (mNo, mPhoneNo) VALUES (101, '6944100003');
INSERT INTO Phone (mNo, mPhoneNo) VALUES (102, '6944100004');

-- ============================================================================
-- Borrow/Loan Records
-- ============================================================================

INSERT INTO Borrow (mNo, dCode, outDate, inDate)
VALUES (100, 10002, '02/03/08 13:30:25', '03/03/08 20:22:19');

INSERT INTO Borrow (mNo, dCode, outDate, inDate)
VALUES (100, 10001, '15/08/09 14:22:12', NULL);

INSERT INTO Borrow (mNo, dCode, outDate, inDate)
VALUES (101, 10002, '10/07/09 10:23:01', '12/07/09 21:25:04');

INSERT INTO Borrow (mNo, dCode, outDate, inDate)
VALUES (101, 10001, '13/08/09 09:13:14', '14/08/09 11:59:08');

INSERT INTO Borrow (mNo, dCode, outDate, inDate)
VALUES (102, 10003, '17/08/09 12:58:02', '25/08/09 20:00:00');

-- ============================================================================
-- Actor-DVD Relationships (PlaysIn)
-- ============================================================================

INSERT INTO PlaysIn (aName, dCode, roleNo) VALUES ('Al Pacino', 10001, 1);
INSERT INTO PlaysIn (aName, dCode, roleNo) VALUES ('Michelle Pfeiffer', 10001, 2);
INSERT INTO PlaysIn (aName, dCode, roleNo) VALUES ('Anthony Hopkins', 10002, 1);
INSERT INTO PlaysIn (aName, dCode, roleNo) VALUES ('Cuba Gooding', 10002, 1);
INSERT INTO PlaysIn (aName, dCode, roleNo) VALUES ('Al Pacino', 10003, 1);
INSERT INTO PlaysIn (aName, dCode, roleNo) VALUES ('Chris O ''Donnell', 10003, 1);

-- ============================================================================
-- Category-DVD Relationships (Includes)
-- ============================================================================

INSERT INTO Includes (cName, dCode) VALUES ('crime', 10001);
INSERT INTO Includes (cName, dCode) VALUES ('drama', 10001);
INSERT INTO Includes (cName, dCode) VALUES ('drama', 10002);
INSERT INTO Includes (cName, dCode) VALUES ('thriller', 10002);
INSERT INTO Includes (cName, dCode) VALUES ('drama', 10003);
