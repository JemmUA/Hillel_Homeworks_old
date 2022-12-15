DROP TABLE IF EXISTS clients, statuses, client_status, accounts, clients_updated;

-- CREATE TABLES

CREATE TABLE IF NOT EXISTS clients (
	id serial 
	CONSTRAINT clients_pk PRIMARY KEY,
	name varchar (20),
	email varchar (255)UNIQUE NOT NULL,
	phone bigint UNIQUE NOT NULL,
	about text 
);

CREATE TABLE IF NOT EXISTS statuses (
	id serial 
	CONSTRAINT statuses_pk PRIMARY KEY,
	alias varchar (15) UNIQUE NOT NULL,
	description text NOT NULL
);

-- table without links (keys)
-- CREATE TABLE IF NOT EXISTS client_status (
	-- client_id int NOT NULL,
	-- status_id int NOT NULL

-- ensure cascading removal instead using trigger
-- CREATE TABLE IF NOT EXISTS client_status (
	-- client_id int NOT NULL REFERENCES clients ON DELETE CASCADE,
	-- status_id int NOT NULL REFERENCES statuses ON DELETE CASCADE
-- );

-- For task 3
-- protected from deleting with links
CREATE TABLE IF NOT EXISTS client_status (
	client_id int NOT NULL, CONSTRAINT client_fk
	FOREIGN KEY (client_id) REFERENCES clients(id),
	status_id int NOT NULL, CONSTRAINT status_fk
	FOREIGN KEY (status_id) REFERENCES statuses(id)
);

CREATE TABLE IF NOT EXISTS accounts (
	id serial UNIQUE NOT NULL,
	client_id int NOT NULL,
	number varchar (20) UNIQUE NOT NULL,
	value float NOT NULL
);

CREATE TABLE IF NOT EXISTS clients_updated (
	id serial 
	CONSTRAINT clients_updated_pk PRIMARY KEY,
	uuid varchar (36),
	name varchar (20),
	email varchar (255)UNIQUE NOT NULL,
	phone bigint UNIQUE NOT NULL,
	about text 
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
INSERT INTO clients (name, email, phone, about) VALUES ('Jerry', 'jerry@mail.ua', '380985558439', 'mouse, authentic, not for PC');
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

-- Function for TASK 1
CREATE OR REPLACE FUNCTION update_client_status() RETURNS TRIGGER AS $$
DECLARE
	cut_id int;
	cut_stat_id int;
BEGIN
	IF	TG_OP = 'INSERT' THEN
		cut_id = NEW.id;
		cut_stat_id = (SELECT id FROM statuses WHERE alias = 'STANDARD');
		INSERT INTO client_status(client_id, status_id) VALUES (cut_id, cut_stat_id);
		RETURN NEW;
		
-- There is nothing to update in table client_status when table clients is updating, excepting case when ID changes in table clients
-- So UPDATE table client_status is pointless. Just for example.
	ELSIF TG_OP = 'UPDATE' THEN
		cut_id = OLD.id;
		UPDATE client_status SET client_id = cut_id WHERE client_id = OLD.id;
		RETURN OLD;
		
	ELSIF TG_OP = 'DELETE' THEN
		cut_id = OLD.id;
		DELETE FROM client_status WHERE client_id = cut_id;
		RETURN OLD;
	END IF;
END;
$$ LANGUAGE plpgsql;

-- Trigger for TASK 2
CREATE TRIGGER client_trigger
AFTER INSERT OR UPDATE OR DELETE ON clients
FOR EACH ROW EXECUTE PROCEDURE update_client_status();


-- Requests to exemine trigger and functions
INSERT INTO clients (name, email, phone, about)
VALUES ('Bill', 'bill@gmail.com', '380961246534', 'man');

INSERT INTO clients (name, email, phone, about)
VALUES ('Billy', 'billy@gmail.com', '380961246535', 'boy');

UPDATE clients SET name='Scott', email='scott@gmail.com' where name='Billy';

SELECT * FROM clients;

SELECT * FROM client_status;

-- Imposible to performe deleting due to links. 
-- DELETE FROM clients WHERE name = 'Scott'


CREATE OR REPLACE FUNCTION clients_uuidPlus() RETURNS void AS $uuid$
DECLARE
uuid varchar;
pointer CURSOR FOR SELECT * FROM clients;

BEGIN
FOR row IN pointer LOOP
uuid = gen_random_uuid();
INSERT INTO clients_updated(id, uuid, name, email, phone, about)
VALUES (row.id, uuid, row.name, row.email, row.phone, row.about);

END LOOP;
END;

$uuid$ LANGUAGE plpgsql;

SELECT clients_uuidPlus();

SELECT * FROM clients_updated;
