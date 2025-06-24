ALTER TABLE roles ALTER COLUMN id DROP DEFAULT;
ALTER TABLE roles ALTER COLUMN id TYPE BIGINT;
CREATE SEQUENCE IF NOT EXISTS roles_id_seq;
ALTER TABLE roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq');
ALTER SEQUENCE roles_id_seq OWNED BY roles.id;

ALTER TABLE languages ALTER COLUMN id DROP DEFAULT;
ALTER TABLE languages ALTER COLUMN id TYPE BIGINT;
CREATE SEQUENCE IF NOT EXISTS languages_id_seq;
ALTER TABLE languages ALTER COLUMN id SET DEFAULT nextval('languages_id_seq');
ALTER SEQUENCE languages_id_seq OWNED BY languages.id;

ALTER TABLE user_registration_logs ALTER COLUMN id DROP DEFAULT;
ALTER TABLE user_registration_logs ALTER COLUMN id TYPE BIGINT;
CREATE SEQUENCE IF NOT EXISTS user_registration_logs_id_seq;
ALTER TABLE user_registration_logs ALTER COLUMN id SET DEFAULT nextval('user_registration_logs_id_seq');
ALTER SEQUENCE user_registration_logs_id_seq OWNED BY user_registration_logs.id;

ALTER TABLE user_email_verifications ALTER COLUMN id DROP DEFAULT;
ALTER TABLE user_email_verifications ALTER COLUMN id TYPE BIGINT;
CREATE SEQUENCE IF NOT EXISTS user_email_verifications_id_seq;
ALTER TABLE user_email_verifications ALTER COLUMN id SET DEFAULT nextval('user_email_verifications_id_seq');
ALTER SEQUENCE user_email_verifications_id_seq OWNED BY user_email_verifications.id;
