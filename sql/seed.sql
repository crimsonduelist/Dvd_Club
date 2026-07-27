-- ============================================================================
-- DVD Club: Sample Data
-- ============================================================================
-- Populates the dvdclub_db database with sample data for development
-- and testing. Run after create_db.sql.
-- ============================================================================

USE dvdclub_db;

-- ============================================================================
-- Members
-- ============================================================================

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (100, 'NIKOY', 'NIKOS', 'TZAVARA 12', '2008-03-01', 2);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (101, 'PETROY', 'PETROS', 'RIGA 23', '2009-02-15', 3);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (102, 'FWTIOY', 'FWTIS', 'KANARH 20', '2009-03-17', 1);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (103, 'PAPADOPOULOU', 'MARIA', 'ERMOU 5', '2010-06-10', 4);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (104, 'GEORGIOU', 'EKATERINI', 'STADIU 18', '2010-09-22', 2);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (105, 'KONSTANTINOU', 'GIANNIS', 'EIRHNHS 31', '2011-01-05', 1);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (106, 'PANAGIOTOU', 'ELENI', 'FILIKIS ETERIAS 7', '2011-04-14', 3);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (107, 'MIHALOPOULOU', 'SOFIA', 'VOULAGMENIS 22', '2012-08-03', 2);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (108, 'TSIPOURA', 'ANNA', 'PLATONOS 14', '2013-02-19', 1);

INSERT INTO member (mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount)
VALUES (109, 'VOULGARIS', 'DIMITRIOS', 'SOLWNOU 9', '2013-07-30', 0);

-- ============================================================================
-- DVDs
-- ============================================================================

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10001, 'Scarface', 'Brian De Palma', 2, 20, 2, 12);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10002, 'Instinct', 'Jon Turtelaub', 2, 22, 2, 8);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10003, 'Scent of Woman', 'Martin Brest', 3, 21, 1, 15);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10004, 'The Godfather', 'Francis Ford Coppola', 3, 25, 2, 20);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10005, 'Pulp Fiction', 'Quentin Tarantino', 2, 18, 3, 18);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10006, 'The Dark Knight', 'Christopher Nolan', 3, 24, 2, 22);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10007, 'Forrest Gump', 'Robert Zemeckis', 2, 19, 2, 16);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10008, 'The Matrix', 'The Wachowskis', 2, 20, 2, 14);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10009, 'Inception', 'Christopher Nolan', 3, 23, 2, 17);

INSERT INTO dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost, dCategoryCount, dLendTimes)
VALUES (10010, 'Gladiator', 'Ridley Scott', 2, 21, 2, 11);

-- ============================================================================
-- Categories
-- ============================================================================

INSERT INTO category (cName, cDvdCount) VALUES ('Crime', 3);
INSERT INTO category (cName, cDvdCount) VALUES ('Drama', 5);
INSERT INTO category (cName, cDvdCount) VALUES ('Thriller', 3);
INSERT INTO category (cName, cDvdCount) VALUES ('Action', 3);
INSERT INTO category (cName, cDvdCount) VALUES ('Sci-Fi', 2);
INSERT INTO category (cName, cDvdCount) VALUES ('Comedy', 1);

-- ============================================================================
-- Actors
-- ============================================================================

INSERT INTO actor (aName, aOscar) VALUES ('Al Pacino', 1);
INSERT INTO actor (aName, aOscar) VALUES ('Robert De Niro', 2);
INSERT INTO actor (aName, aOscar) VALUES ('Michelle Pfeiffer', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('Anthony Hopkins', 1);
INSERT INTO actor (aName, aOscar) VALUES ('Cuba Gooding Jr.', 1);
INSERT INTO actor (aName, aOscar) VALUES ('Tom Hanks', 2);
INSERT INTO actor (aName, aOscar) VALUES ('Keanu Reeves', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('Christian Bale', 1);
INSERT INTO actor (aName, aOscar) VALUES ('Heath Ledger', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('Russell Crowe', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('John Travolta', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('Samuel L. Jackson', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('Brad Pitt', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('Leonardo DiCaprio', NULL);
INSERT INTO actor (aName, aOscar) VALUES ('Joe Pesci', 1);

-- ============================================================================
-- Phone Numbers
-- ============================================================================

INSERT INTO phone (mNo, mPhoneNo) VALUES (100, '6944100001');
INSERT INTO phone (mNo, mPhoneNo) VALUES (100, '6944100002');
INSERT INTO phone (mNo, mPhoneNo) VALUES (101, '6944100003');
INSERT INTO phone (mNo, mPhoneNo) VALUES (102, '6944100004');
INSERT INTO phone (mNo, mPhoneNo) VALUES (103, '6944100005');
INSERT INTO phone (mNo, mPhoneNo) VALUES (103, '6944100006');
INSERT INTO phone (mNo, mPhoneNo) VALUES (104, '6944100007');
INSERT INTO phone (mNo, mPhoneNo) VALUES (105, '6944100008');
INSERT INTO phone (mNo, mPhoneNo) VALUES (106, '6944100009');
INSERT INTO phone (mNo, mPhoneNo) VALUES (106, '6944100010');
INSERT INTO phone (mNo, mPhoneNo) VALUES (107, '6944100011');
INSERT INTO phone (mNo, mPhoneNo) VALUES (108, '6944100012');

-- ============================================================================
-- Borrow/Loan Records
-- ============================================================================

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (100, 10002, '2008-03-02 13:30:25', '2008-03-03 20:22:19');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (100, 10001, '2009-08-15 14:22:12', NULL);

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (101, 10002, '2009-07-10 10:23:01', '2009-07-12 21:25:04');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (101, 10001, '2009-08-13 09:13:14', '2009-08-14 11:59:08');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (101, 10004, '2010-01-20 18:00:00', '2010-01-23 15:30:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (102, 10003, '2009-08-17 12:58:02', '2009-08-25 20:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (103, 10005, '2010-07-05 16:00:00', '2010-07-08 19:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (103, 10006, '2011-02-14 20:00:00', '2011-02-17 18:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (103, 10004, '2011-06-01 11:00:00', NULL);

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (104, 10007, '2011-03-10 14:30:00', '2011-03-13 12:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (105, 10008, '2011-05-22 17:00:00', '2011-05-25 16:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (106, 10009, '2012-01-08 19:30:00', '2012-01-11 20:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (106, 10005, '2012-04-15 13:00:00', '2012-04-18 14:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (107, 10010, '2013-01-05 10:00:00', '2013-01-08 11:00:00');

INSERT INTO borrow (mNo, dCode, outDate, inDate)
VALUES (108, 10003, '2013-06-20 15:00:00', NULL);

-- ============================================================================
-- Actor-DVD Relationships (PlaysIn)
-- ============================================================================

INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Al Pacino', 10001, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Michelle Pfeiffer', 10001, 2);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Robert De Niro', 10001, 3);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Anthony Hopkins', 10002, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Cuba Gooding Jr.', 10002, 2);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Al Pacino', 10003, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Robert De Niro', 10004, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Al Pacino', 10004, 2);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('John Travolta', 10005, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Samuel L. Jackson', 10005, 2);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Brad Pitt', 10005, 3);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Christian Bale', 10006, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Heath Ledger', 10006, 2);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Tom Hanks', 10007, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Keanu Reeves', 10008, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Leonardo DiCaprio', 10009, 1);
INSERT INTO playsin (aName, dCode, roleNo) VALUES ('Russell Crowe', 10010, 1);

-- ============================================================================
-- Category-DVD Relationships (Includes)
-- ============================================================================

INSERT INTO includes (cName, dCode) VALUES ('Crime', 10001);
INSERT INTO includes (cName, dCode) VALUES ('Drama', 10001);
INSERT INTO includes (cName, dCode) VALUES ('Drama', 10002);
INSERT INTO includes (cName, dCode) VALUES ('Thriller', 10002);
INSERT INTO includes (cName, dCode) VALUES ('Drama', 10003);
INSERT INTO includes (cName, dCode) VALUES ('Crime', 10004);
INSERT INTO includes (cName, dCode) VALUES ('Drama', 10004);
INSERT INTO includes (cName, dCode) VALUES ('Crime', 10005);
INSERT INTO includes (cName, dCode) VALUES ('Drama', 10005);
INSERT INTO includes (cName, dCode) VALUES ('Thriller', 10005);
INSERT INTO includes (cName, dCode) VALUES ('Action', 10006);
INSERT INTO includes (cName, dCode) VALUES ('Thriller', 10006);
INSERT INTO includes (cName, dCode) VALUES ('Drama', 10007);
INSERT INTO includes (cName, dCode) VALUES ('Comedy', 10007);
INSERT INTO includes (cName, dCode) VALUES ('Action', 10008);
INSERT INTO includes (cName, dCode) VALUES ('Sci-Fi', 10008);
INSERT INTO includes (cName, dCode) VALUES ('Action', 10009);
INSERT INTO includes (cName, dCode) VALUES ('Sci-Fi', 10009);
INSERT INTO includes (cName, dCode) VALUES ('Action', 10010);
INSERT INTO includes (cName, dCode) VALUES ('Drama', 10010);
