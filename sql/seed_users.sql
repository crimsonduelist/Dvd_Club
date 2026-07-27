-- ============================================================================
-- DVD Club: Sample Users
-- ============================================================================
-- Creates default users for Shiro authentication.
-- Run after create_users.sql.
-- ============================================================================

USE dvdclub_auth_db;

INSERT INTO USERS2(USERNAME, PASS) VALUES('admin', 'admin');
INSERT INTO ROLES2(ROLES, USERID) VALUES('ADMIN', 1);

INSERT INTO USERS2(USERNAME, PASS) VALUES('user', 'user');
INSERT INTO ROLES2(ROLES, USERID) VALUES('USER', 2);
