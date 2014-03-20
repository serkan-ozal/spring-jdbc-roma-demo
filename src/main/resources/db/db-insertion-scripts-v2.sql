INSERT INTO USER (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, ENABLED, GENDER, LANGUAGE, OCCUPATION, EDUCATION, BLOOD_TYPE, MARITAL_STATUS, RELIGION, BIRTH_DATE, PHONE_NUMBER) VALUES ('user', 'password',  'Serkan', 'OZAL', 1, 1, 1, 300, 'MASTER', 1, 'SINGLE', 'MUSLIM', '1986-09-15', '+901234567890');

INSERT INTO ROLE (NAME) VALUES('Admin');

INSERT INTO USER_ROLE (SELECT usr.ID, r.ID FROM USER usr, ROLE r where r.name ='Admin');

INSERT INTO PERMISSION (NAME) VALUES('GET_PERM');
INSERT INTO PERMISSION (NAME) VALUES('LIST_PERM');
INSERT INTO PERMISSION (NAME) VALUES('UPDATE_PERM');
INSERT INTO PERMISSION (NAME) VALUES('DELETE_PERM');

INSERT INTO ROLE_PERMISSION (SELECT r.ID, perm.ID FROM PERMISSION perm, "ROLE" r WHERE r.name ='Admin');

COMMIT;
