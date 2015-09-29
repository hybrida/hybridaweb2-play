# --- !Ups
INSERT INTO PUBLIC.USER(ID, USERNAME, FIRST_NAME, SURNAME, MIDDLE_NAME, EMAIL, WEBSITE_URL, PHONE, TITLE, PROFILE_IMAGE_FILE_NAME, GRADUATION_YEAR, STUDENT, BEDKOM, ADMIN, ROOT, SEX, ENROLLED, DATE_OF_BIRTH, LAST_LOGIN) VALUES(1, 'hybrid', '', 'Administrator', NULL, NULL, NULL, NULL, NULL, 'mlg.jpg', 2018, TRUE, TRUE, TRUE, TRUE, STRINGDECODE('\u0000'), NULL, TIMESTAMP '2003-04-01 00:00:00.0', NULL);
INSERT INTO PUBLIC.USER(ID, USERNAME, FIRST_NAME, SURNAME, MIDDLE_NAME, EMAIL, WEBSITE_URL, PHONE, TITLE, PROFILE_IMAGE_FILE_NAME, GRADUATION_YEAR, STUDENT, BEDKOM, ADMIN, ROOT, SEX, ENROLLED, DATE_OF_BIRTH, LAST_LOGIN) VALUES(2, 'thormodm', '', 'Thormod', 'Myrvang', '', NULL, '', NULL, 'oppg1b.jpg', 0, TRUE, TRUE, TRUE, TRUE, 'm', NULL, TIMESTAMP '1994-03-23 02:00:00.0', TIMESTAMP '2015-09-29 18:35:25.973');
INSERT INTO PUBLIC.USER(ID, USERNAME, FIRST_NAME, SURNAME, MIDDLE_NAME, EMAIL, WEBSITE_URL, PHONE, TITLE, PROFILE_IMAGE_FILE_NAME, GRADUATION_YEAR, STUDENT, BEDKOM, ADMIN, ROOT, SEX, ENROLLED, DATE_OF_BIRTH, LAST_LOGIN) VALUES(3, 'kevinrs', '', 'Kevin', 'Stravers', NULL, NULL, NULL, NULL, NULL, 2018, TRUE, TRUE, TRUE, TRUE, STRINGDECODE('\u0000'), NULL, TIMESTAMP '1994-09-25 22:10:00.0', NULL);
INSERT INTO PUBLIC.USER(ID, USERNAME, FIRST_NAME, SURNAME, MIDDLE_NAME, EMAIL, WEBSITE_URL, PHONE, TITLE, PROFILE_IMAGE_FILE_NAME, GRADUATION_YEAR, STUDENT, BEDKOM, ADMIN, ROOT, SEX, ENROLLED, DATE_OF_BIRTH, LAST_LOGIN) VALUES(4, 'simennje', '', 'Simen', 'Jensen', NULL, NULL, NULL, NULL, NULL, 2019, TRUE, TRUE, TRUE, TRUE, STRINGDECODE('\u0000'), NULL, TIMESTAMP '1994-11-22 12:00:00.0', NULL);

# --- !Downs
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE PUBLIC.USER;
SET FOREIGN_KEY_CHECKS = 1;