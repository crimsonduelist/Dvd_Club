Simply build a Mysql db using the provided creates_dvd_club.sql and creates_users.sql (this is your users and 
roles for shiro)
And build the app itself which s in the nameit3.7z folder.
There s also a samples_dvd_club.sql so u have a handefull of inserts for each table to try, whether directly on the db 
or through the app! The sample inserts for the creates_users.sql are in that file itself
I ve omitted diagrams, business rules etc simply cuz it wasnt my focus. This was an attempt at building
an webapp that works, so I took a base I was familiar with -The dvd club 's ER-Diagram

It works on wildfly 26.1.0.Final. Just add a Mysql driver and your 2 db 's datasources -I ve named
them MYSQL_DS_CREDENTIALS3 and MYSQL_DS_CREDENTIALS2 for the dvd club db and users db accordingly. Feel free
to change them but remember to also change them in your persistence.xml along with your wildfly config(standalone-full.xml or
standalone.xml) and your shiro config(ini)


	There re a couple of bugs like when deleting the last row of a table, but are easy enough to fix. 
	Plus some things to add for proper implementation, like the non-admin user side of it. Or implement registration and
password hashing. 
	And add a (shiro)filter to disallow logged in users from heading back to login page for example -Note that 
the login function itself works properly, it will not allow them to relogin.
	In members and actors there s a small bug not letting tables load properly -Easy enough to fix
 
	The one thing I ll have to look at is the shiro filtering in the web.xml messing with jsf/primefaces look and feel
 on first page load which I ve handled for now with <tracking-mode>COOKIE</tracking-mode>
 
	There s no reason specifically I change between commandLinks and commandButtons, was just messing with them