# --- !Ups
INSERT INTO PUBLIC.USER(USERNAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, EMAIL, WEBSITE_URL, PHONE, PROFILE_IMAGE_FILE_NAME, ADMIN, ROOT, GENDER, LAST_LOGIN) VALUES('ivarhk', 'Ivar', STRINGDECODE('Kr\u00e5b\u00f8l'), NULL, NULL, NULL, NULL, NULL, FALSE, FALSE, STRINGDECODE('\u0000'), NULL);
INSERT INTO PUBLIC.USER(USERNAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, EMAIL, WEBSITE_URL, PHONE, PROFILE_IMAGE_FILE_NAME, ADMIN, ROOT, GENDER, LAST_LOGIN) VALUES('hybrid', 'Administrator', 'Etternavn', NULL, NULL, NULL, NULL, NULL, TRUE, TRUE, STRINGDECODE('\u0000'), NULL);

# --- !Downs
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE PUBLIC.USER;
SET FOREIGN_KEY_CHECKS = 1;