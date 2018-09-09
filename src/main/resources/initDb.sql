DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS book;
DROP SEQUENCE IF EXISTS glob_seq_stud;
DROP SEQUENCE IF EXISTS glob_seq_book;

CREATE SEQUENCE glob_seq_stud
  START 100;
CREATE SEQUENCE glob_seq_book
  START 500;

CREATE TABLE student (
  id           INTEGER PRIMARY KEY NOT NULL DEFAULT nextval('glob_seq_stud'),
  name         VARCHAR(30)         NOT NULL,
  age          INTEGER             NOT NULL,
  admin        BOOLEAN,
  created_date TIMESTAMP           NOT NULL
);

CREATE TABLE book (
  id      INTEGER PRIMARY KEY  NOT NULL DEFAULT nextval('glob_seq_book'),
  user_id INTEGER              NOT NULL,
  author  VARCHAR(30)          NOT NULL,
  title   VARCHAR(100)         NOT NULL,
  FOREIGN KEY (user_id) REFERENCES student (id) ON DELETE CASCADE
);