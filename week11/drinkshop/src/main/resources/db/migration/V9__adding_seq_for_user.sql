CREATE SEQUENCE user_id_seq START WITH 1;
ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('user_id_seq');