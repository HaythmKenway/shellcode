DROP DATABASE IF EXISTS shellcode;
DROP ROLE IF EXISTS shellcodemaster;
CREATE ROLE shellcodemaster WITH PASSWORD 'password';
CREATE DATABASE shellcode WITH OWNER=shellcodemaster;

\connect shellcode

CREATE SEQUENCE user_seq START 1;


ALTER DEFAULT PRIVILEGES GRANT ALL ON TABLES TO shellcodemaster;
ALTER DEFAULT PRIVILEGES GRANT ALL ON SEQUENCES TO shellcodemaster;

CREATE TABLE users(
user_id integer PRIMARY KEY NOT NULL DEFAULT nextval('user_seq'),
name varchar(50) NOT NULL,
email varchar(50) NOT NULL,
phone varchar(10) NOT NULL,
password varchar(150) NOT NULL
);


