INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, GENDER) VALUES ('user', 'password',  'Serkan', 'OZAL', 1, 1);

INSERT INTO ROLE (NAME) VALUES('Member');
INSERT INTO ROLE (NAME) VALUES('Admin');

INSERT INTO USER_ROLE (SELECT usr.ID, r.ID FROM USER usr, ROLE r WHERE r.NAME = 'Member');
INSERT INTO USER_ROLE (SELECT usr.ID, r.ID FROM USER usr, ROLE r WHERE r.NAME = 'Admin');

INSERT INTO PERMISSION (NAME) VALUES('MEMBER_GET_PERM');
INSERT INTO PERMISSION (NAME) VALUES('MEMBER_LIST_PERM');
INSERT INTO PERMISSION (NAME) VALUES('MEMBER_UPDATE_PERM');
INSERT INTO PERMISSION (NAME) VALUES('MEMBER_DELETE_PERM');
INSERT INTO PERMISSION (NAME) VALUES('ADMIN_GET_PERM');
INSERT INTO PERMISSION (NAME) VALUES('ADMIN_LIST_PERM');
INSERT INTO PERMISSION (NAME) VALUES('ADMIN_UPDATE_PERM');
INSERT INTO PERMISSION (NAME) VALUES('ADMIN_DELETE_PERM');

INSERT INTO ROLE_PERMISSION (SELECT r.ID, p.ID FROM PERMISSION p, ROLE r WHERE p.NAME LIKE 'MEMBER_%' AND r.NAME = 'Member');
INSERT INTO ROLE_PERMISSION (SELECT r.ID, p.ID FROM PERMISSION p, ROLE r WHERE p.NAME LIKE 'ADMIN_%' AND r.NAME = 'Admin');

COMMIT;
