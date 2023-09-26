CREATE DATABASE CREDENTIALS3;
USE CREDENTIALS3;

DROP TABLES IF EXISTS Includes ,PlaysIn ,BORROW ,PHONE,DVD,MEMBER,ACTOR,CATEGORY;
/* MEMBER */
create table Member ( mNo INT AUTO_INCREMENT, mLastName varchar(20) not null, 
mFirstName varchar(15) not null, mAddress varchar(30), 
mRegDate DATE not null, mDvdCount INT,
primary key (mNo),
check (mDvdCount >= 0) );
/* DVD */
create table Dvd ( dCode INT AUTO_INCREMENT, dTitle varchar(30) not null, dDirector varchar(35), 
	dvdLendCost INT not null, dAcquisitionCost INT not null,  
	dCategoryCount INT, dLendTimes INT,
	primary key (dcode),
	check (dvdLendCost >= 0),
	check (dAcquisitionCost >= 0),
	check (dCategoryCount >= 0),
	check (dLendTimes >= 0)	);
					
/* EACH DVD HAS A Category */
create table Category ( cName varchar(30), cDvdCount INT,
	primary key (cName),
	check (cDvdCount >= 0) );
					
/* EACH DVD HAS AN ACTOR*/					
create table Actor ( aName varchar(30), aOscar INT,
	 primary key (aName),
	 check (aOscar >= 0) );
				
/* EACH MEMBER HAS A PHONE */
create table Phone( mNo INT , mPhoneNo varchar(10),
	primary key (mNo,mPhoneNo),
	foreign key (mNo) references Member(mNo) );

/* EACH MEMBER CAN BORROW A DVD */			
create table Borrow ( mNo INT,dCode INT, outDate DATE, inDate DATE,
	primary key (outDate),
	foreign key (mNo) references Member(mNo),
	foreign key (dCode) references Dvd(dCode) );
			
/* EACH DVD HAS ACTORS THAT PLAYIN IT */
create table PlaysIn ( 	aName varchar(30) , dCode INT, roleNo INT,
	primary key (aName,dCode),
	foreign key (aName) references Actor(aName),
	foreign key (dCode) references Dvd(dCode) );


/* EACH DVD INLUDES A Category */	
create table Includes ( cName varchar(15), dCode INT,
	primary key (cName,dCode),
	foreign key (cName) references Category(cName),
	foreign key (dCode) references Dvd(dCode) );
