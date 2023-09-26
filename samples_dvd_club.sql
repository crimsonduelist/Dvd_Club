

insert into Member ( mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount )
values (100,'NIKOY','NIKOS','TZAVARA 12',('01/03/08'),NULL);

insert into Member ( mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount )
values (101,'PETROY','PETROS','RIGA 23',('15/02/09'),NULL);

insert into Member ( mNo, mLastName, mFirstName, mAddress, mRegDate, mDvdCount )
values (102,'FWTIOY','FWTIS','KANARH 20',('17/03/09'),NULL);




insert into Dvd (dCode, dTitle, dDirector, dvdLendCost, dAcquisitionCost,  
dCategoryCount, dLendTimes )
values (10001, 'scarface', 'Brian De Palma', 1.5, 20, 2, 2);


insert into Dvd ( dCode, dTitle, dDirector, dvdLendCost, 
dAcquisitionCost,  dCategoryCount, dLendTimes )
values (10002, 'Instinct', 'Jon Turtelaub', 1.5, 22, 2, 2);


insert into Dvd ( dCode, dTitle, dDirector, dvdLendCost, 
dAcquisitionCost,  dCategoryCount, dLendTimes )
values (10003, 'Scent of woman', 'Martin Brest', 1.7, 21, 1, 1);





insert into Category ( cName, cDvdCount)
values ('crime',1);

insert into Category ( cName, cDvdCount)
values ('drama',3);

insert into Category ( cName, cDvdCount)
values ('thriller',1);




insert into Actor ( aName,aOscar )
values ('Al Pacino',NULL);

insert into Actor ( aName,aOscar )
values ('Michelle Pfeiffer',NULL);

insert into Actor ( aName,aOscar )
values ('Anthony Hopkins',NULL);

insert into Actor ( aName,aOscar )
values ('Cuba Gooding',NULL);

insert into Actor ( aName,aOscar )
values ('Chris O ''Donnell',NULL);





insert into Phone( mNo, mPhoneNo )
values(100,'6944100001');

insert into Phone( mNo, mPhoneNo )
values(100,'6944100002');

insert into Phone( mNo, mPhoneNo )
values(101,'6944100003');

insert into Phone( mNo, mPhoneNo )
values(102,'6944100004');




insert into Borrow (mNo,dCode, outDate, inDate )
values(100,10002,('02/03/08 13:30:25'), 
				 ('03/03/08 20:22:19'));

insert into Borrow (mNo,dCode, outDate, inDate )
values(100,10001,('15/08/09 14:22:12'), 
				 NULL);

insert into Borrow (mNo,dCode, outDate, inDate )
values(101,10002,('10/07/09 10:23:01'), 
				 ('12/07/09 21:25:04'));

insert into Borrow (mNo,dCode, outDate, inDate )
values(101,10001,('13/08/09 09:13:14'), 
				 ('14/08/09 11:59:08'));

insert into Borrow (mNo,dCode, outDate, inDate )
values(102,10003,('17/08/09 12:58:02'), 
				 ('25/08/09 20:00:00'));


				 
	
	 
insert into PlaysIn ( aName, dCode, roleNo )
values('Al Pacino',10001,1);

insert into PlaysIn ( aName, dCode, roleNo )
values('Michelle Pfeiffer',10001,2);

insert into PlaysIn ( aName, dCode, roleNo )
values('Anthony Hopkins',10002,1);

insert into PlaysIn ( aName, dCode, roleNo )
values('Cuba Gooding',10002,1);

insert into PlaysIn ( aName, dCode, roleNo )
values('Al Pacino',10003,1);

insert into PlaysIn ( aName, dCode, roleNo )
values('Chris O ''Donnell',10003,1);




insert into Includes ( cName, dCode )
values('crime',10001);

insert into Includes ( cName, dCode )
values('drama',10001);

insert into Includes ( cName, dCode )
values('drama',10002);

insert into Includes ( cName, dCode )
values('thriller',10002);

insert into Includes ( cName, dCode )
values('drama',10003);


