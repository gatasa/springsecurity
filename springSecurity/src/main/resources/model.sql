CREATE TABLE category (
   id serial PRIMARY KEY NOT NULL,
   name varchar(255) NOT NULL
);
CREATE TABLE user (
   id serial PRIMARY KEY NOT NULL,
   name varchar(255) NOT NULL,
   password varchar(255) NOT NULL,
   role int NOT NULL -- from category
);
CREATE TABLE board (
   id serial PRIMARY KEY NOT NULL,
   name varchar(255) NOT NULL,
   location varchar(255) NOT NULL,
   model varchar(255) NOT NULL,
   enabled bool DEFAULT TRUE
);
CREATE TABLE pin (
   id serial PRIMARY KEY NOT NULL,
   name varchar(255) NOT NULL,
   purpose int NOT NULL, -- from category
   pin int NOT NULL,
   timer int,
   formula varchar(255),
   unit int -- from category
);

INSERT INTO category (name) VALUES ('Admin');
INSERT INTO category (name) VALUES ('User');
INSERT INTO category (name) VALUES ('Input');
INSERT INTO category (name) VALUES ('Output');
INSERT INTO category (name) VALUES ('Cº');
