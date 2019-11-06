--Create tables
create table Opleiding
(
	onderwijsinstelling varchar(255) not null,
	opleidingsnaam varchar(255) not null,
	niveau varchar(50)
);

create table Bedrijf
(
	bedrijfsemail varchar(255) not null,
	wachtwoord varchar(50) not null,
	bedrijfsnaam varchar(255) not null,
	telefoon varchar(15),
	email_contactpersoon varchar(255) not null,
	telefoon_contactpersoon varchar(15)
);

create table Student
(
	student_email varchar(255) not null,
	wachtwoord varchar(50) not null,
	naam varchar(50) not null,
	telefoon varchar(15),
	leerjaar int4,
	opleiding_onderwijsinstelling varchar(255) not null,
	opleiding_opleidingsnaam varchar(255) not null
);

create table Docent
(
	docent_email varchar(255) not null,
	wachtwoord varchar(50) not null,
	naam varchar(255),
	telefoon varchar(15),
	opleiding_onderwijsinstelling varchar(255) not null,
	opleiding_opleidingsnaam varchar(255) not null
);

--TEST DATA

insert into Opleiding values ('Avans', 'AD Informatica', 'HBO');
insert into Opleiding values ('KW1C', 'Applicatieontwikkeling', 'MBO');

insert into Bedrijf values ('Bedrijf@bedrijf.nl', 'wachtwoord', 'Bedrijf', '0611111111', 'BedrijfHR@bedrijf.nl', '0611111110');

insert into Student values ('jklaas@student.avans.nl', 'wachtwoord', 'Jan Klaas', '0644444441', 1, 'Avans', 'AD Informatica');
insert into Student values ('mbogaart@student.avans.nl', 'wachtwoord', 'Maxim Bogaart', '0644444442', 1, 'Avans', 'AD Informatica');
insert into Student values ('gvanloveren@student.avans.nl', 'wachtwoord', 'Giano van Loveren', '0644444443', 2, 'Avans', 'AD Informatica');
insert into Student values ('kbron@student.avans.nl', 'wachtwoord', 'Kimo Bron', '0644444444', 2, 'Avans', 'AD Informatica');
insert into Student values ('lveldhoven@student.avans.nl', 'wachtwoord', 'Luite Veldhoven', '0644444445', 2, 'Avans', 'AD Informatica');
insert into Student values ('MScheeren@student.kw1c.nl', 'wachtwoord', 'Michel Scheeren', '0655555551', 1, 'KW1C', 'Applicatieontwikkeling');
insert into Student values ('IFischer@student.kw1c.nl', 'wachtwoord', 'Ismail Fischer', '0655555553', 1, 'KW1C', 'Applicatieontwikkeling');
insert into Student values ('RMetselaar@student.kw1c.nl', 'wachtwoord', 'Rainier Metselaar', '0655555553', 2, 'KW1C', 'Applicatieontwikkeling');
insert into Student values ('BWarringa@student.kw1c.nl', 'wachtwoord', 'Barrie Warringa', '0655555554', 3, 'KW1C', 'Applicatieontwikkeling');
insert into Student values ('CRidderhof@student.kw1c.nl', 'wachtwoord', 'Chris Ridderhof', '0655555555', 3, 'KW1C', 'Applicatieontwikkeling');

insert into Docent values ('BKatwijk@avans.nl', 'wachtwoord', 'Bregtje van Katwijk', '0699999999', 'Avans', 'AD Informatica');
insert into Docent values ('MDuijf@avans.nl', 'wachtwoord', 'Mazen Duijf', '0666666666', 'Avans', 'AD Informatica');
insert into Docent values ('IBoshoven@kw1c.nl', 'wachtwoord', 'Ilco Boshoven', '0677777777', 'KW1C', 'Applicatieontwikkeling');
insert into Docent values ('GSieders@kw1c.nl', 'wachtwoord', 'Gidon Sieders', '0688888888', 'KW1C', 'Applicatieontwikkeling');

--TEST DATA

--Set primary keys
alter table Opleiding
add constraint pk_onderwijsinstelling
primary key (onderwijsinstelling, opleidingsnaam);

alter table Bedrijf
add constraint pk_bedrijfsemail
primary key (bedrijfsemail);

alter table Student
add constraint pk_student_email
primary key (student_email);

alter table Docent
add constraint pk_docent_email
primary key (docent_email);

--drop primary keys
/*
drop constraint pk_onderwijsinstelling
drop constraint pk_bedrijfsemail
drop constraint pk_student_email
drop constraint pk_docent_email
*/

--set foreign keys
alter table Docent
add constraint fk_docent_opleiding
foreign key (opleiding_onderwijsinstelling, opleiding_opleidingsnaam)
references Opleiding(onderwijsinstelling, opleidingsnaam);

alter table Student
add constraint fk_student_opleiding
foreign key (opleiding_onderwijsinstelling, opleiding_opleidingsnaam)
references Opleiding(onderwijsinstelling, opleidingsnaam);

--drop foreign keys
/*
drop constraint fk_docent_opleiding_onderwijsinstelling
drop constraint fk_docent_opleiding_opleidingsnaam
drop constraint fk_student_opleiding_onderwijsinstelling
drop constraint fk_student_opleiding_opleiding_opleidingsnaam
*/