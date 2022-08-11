CREATE SEQUENCE drink_id_seq START WITH 1;
ALTER TABLE drinks ALTER COLUMN id SET DEFAULT nextval('drink_id_seq');