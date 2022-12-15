DROP TABLE IF EXISTS clients, statuses, client_status, accounts;

-- CREATE TABLES

CREATE TABLE IF NOT EXISTS clients (
                                       id serial
                                       CONSTRAINT clients_pk PRIMARY KEY
                                       UNIQUE NOT NULL,
                                       name varchar (20),
    email varchar (255)UNIQUE NOT NULL,
    phone bigint UNIQUE NOT NULL,
    about text
    );

CREATE TABLE IF NOT EXISTS statuses (
                                        id serial
                                        CONSTRAINT statuses_pk PRIMARY KEY
                                        UNIQUE NOT NULL,
                                        alias varchar (15) UNIQUE NOT NULL,
    description text NOT NULL
    );

CREATE TABLE IF NOT EXISTS client_status (
                                             client_id int NOT NULL,
                                             status_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
                                        id serial UNIQUE NOT NULL,
                                        client_id int NOT NULL,
                                        number varchar (20) UNIQUE NOT NULL,
    value float NOT NULL
    );

-- FILL FIELDS

INSERT INTO clients (name, email, phone, about) VALUES ('Alexander', 'alex@gmail.com', '380951111111 ', 'Good man');
INSERT INTO clients (name, email, phone, about) VALUES ('Hellen','helen@ukr.net', '380974212392', NULL);
INSERT INTO clients (name, email, phone, about) VALUES ('Sergio',' serg@ukr.netm', '380675267512', 'Forever Student Student Student Student Student ');
INSERT INTO clients (name, email, phone, about) VALUES ('Vasya', 'vasya@gmail.com', '380978534567', 'coolman');
INSERT INTO clients (name, email, phone, about) VALUES ('Galya', 'galya@ukr.net', '380673339233', 'Часто носить воду');
INSERT INTO clients (name, email, phone, about) VALUES ('Bob',' bob@mail.ua', '380968408638', '');
INSERT INTO clients (name, email, phone, about) VALUES ('Nabob Navorotonich', 'nabob@gmail.com', '380958089090', 'Rich man');
INSERT INTO clients (name, email, phone, about) VALUES ('Bobik', 'bobik@ukr.net', '380968568843', 'Собачка');
INSERT INTO clients (name, email, phone, about) VALUES ('Jerry', 'jerry@mail.ua', '380985558439', 'mouose, authentic, not for PC');
INSERT INTO clients (name, email, phone, about) VALUES ('Tom', 'tom@gmail.com', '380994644423', 'maw');

INSERT INTO statuses (alias, description) VALUES ('STANDARD', 'limited rights');
INSERT INTO statuses (alias, description) VALUES ('PREMIUM', 'wide rights');
INSERT INTO statuses (alias, description) VALUES ('VIP', 'full rights');

INSERT INTO client_status (client_id, status_id) VALUES ('1', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('1', '2');
INSERT INTO client_status (client_id, status_id) VALUES ('1', '3');
INSERT INTO client_status (client_id, status_id) VALUES ('2', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('3', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('1', '2');
INSERT INTO client_status (client_id, status_id) VALUES ('4', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('5', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('5', '2');
INSERT INTO client_status (client_id, status_id) VALUES ('6', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('7', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('8', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('8', '2');
INSERT INTO client_status (client_id, status_id) VALUES ('8', '3');
INSERT INTO client_status (client_id, status_id) VALUES ('9', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('9', '2');
INSERT INTO client_status (client_id, status_id) VALUES ('9', '3');
INSERT INTO client_status (client_id, status_id) VALUES ('10', '1');
INSERT INTO client_status (client_id, status_id) VALUES ('10', '2');
INSERT INTO client_status (client_id, status_id) VALUES ('10', '3');

INSERT INTO accounts (client_id, number, value) VALUES ('1', 'w334332', '99999999.99');
INSERT INTO accounts (client_id, number, value) VALUES ('1', 'y38742', '737282.00');
INSERT INTO accounts (client_id, number, value) VALUES ('1', 's8ew9w', '10000000.00');
INSERT INTO accounts (client_id, number, value) VALUES ('2', 'fhf8372', '34327.00');
INSERT INTO accounts (client_id, number, value) VALUES ('2', 'de3222311', '323523523.22');
INSERT INTO accounts (client_id, number, value) VALUES ('3', 'o24212451', '3463.99');
INSERT INTO accounts (client_id, number, value) VALUES ('3', 'q2341412', '371171.99');
INSERT INTO accounts (client_id, number, value) VALUES ('4', 'g2321525412541', '11.99');
INSERT INTO accounts (client_id, number, value) VALUES ('5', 'l12132241221', '16141.99');
INSERT INTO accounts (client_id, number, value) VALUES ('6', 'd82784121', '434677.99');
INSERT INTO accounts (client_id, number, value) VALUES ('7', 'k25412512', '7777777.21');
INSERT INTO accounts (client_id, number, value) VALUES ('7', 'a2412175145', '999999.99');
INSERT INTO accounts (client_id, number, value) VALUES ('7', 'f72845719', '4351671777.00');
INSERT INTO accounts (client_id, number, value) VALUES ('8', 'i242141', '234.56');
INSERT INTO accounts (client_id, number, value) VALUES ('8', 'v93521', '64378.48');
INSERT INTO accounts (client_id, number, value) VALUES ('9', 'f21541251', '99993222195.61');
INSERT INTO accounts (client_id, number, value) VALUES ('9', 'd23521', '10000.43');
INSERT INTO accounts (client_id, number, value) VALUES ('10', 'v2352562', '12314.14');
INSERT INTO accounts (client_id, number, value) VALUES ('10', 'a213523', '15236777.52');
INSERT INTO accounts (client_id, number, value) VALUES ('10', 'g2345252', '902525.12');

-- REQUESTS

SELECT * FROM clients WHERE phone='380958089090';

SELECT alias, description FROM statuses;

SELECT number FROM accounts WHERE value > 1000.0;

SELECT name FROM clients;

SELECT * FROM clients WHERE length(name)>7;

SELECT name, phone, about FROM clients WHERE ((name IS NOT NULL) AND length(name) > 0) AND phone > 380951111111 AND ((about IS NOT NULL) AND length(about) > 0);

SELECT * FROM clients WHERE email LIKE 'alex%';

SELECT * FROM clients ORDER BY phone DESC;

SELECT * FROM clients AS c
                  INNER JOIN  accounts AS a ON a.id = c.id;

SELECT c.name, c.email, c.phone, s.alias FROM clients AS c
                                                  INNER JOIN client_status AS cs ON c.id = cs.client_id
                                                  INNER JOIN  statuses AS s ON s.id = cs.status_id

