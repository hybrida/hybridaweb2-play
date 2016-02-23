drop database hybrida;
create database hybrida;
use hybrida;

create table specialization (
	id    int not null,
	title varchar(255),

	primary key(id)
);

insert into specialization values (0, "None");
insert into specialization values (1, "Geomatikk");
insert into specialization values (2, "Konstruksjonsteknikk");
insert into specialization values (3, "Marin teknikk");
insert into specialization values (4, "Produktutvikling og materialer");
insert into specialization values (5, "Petroleumsfag");
insert into specialization values (6, "Produksjonsledelse");
insert into specialization values (7, "Varme- og strømningsteknikk");

create table user (
	id             bigint auto_increment not null,
	username       varchar(255) not null,
	firstName      varchar(255) default null,
	middleName     varchar(255) default null,
	lastName       varchar(255) default null,
	email          varchar(255) default null,
	websiteUrl     varchar(255) default null,
	phone          varchar(255) default null,
	title          varchar(255) default null,
	graduationYear int default null,
	spez int default null,
	profileImageFileName varchar(255) default null,

	primary key(id),
	foreign key (spez) references specialization(id)
);

create table userPropertyNames (
	id int not null,
	title varchar(255),

	primary key(id)
);

insert into userPropertyNames values (0, 'Student');
insert into userPropertyNames values (1, 'Styret');
insert into userPropertyNames values (2, 'Bedkom');
insert into userPropertyNames values (3, 'Arrkom');
insert into userPropertyNames values (4, 'Vevkom');
insert into userPropertyNames values (5, 'Jentekom');
insert into userPropertyNames values (6, 'Redaksjonen');
insert into userPropertyNames values (7, 'Admin');

create table userProperties (
	propId int not null,
	userId bigint not null,

	constraint oneProperty unique (propId, userId)
);

create table article (
	id           bigint auto_increment not null,
	previousEdit bigint default null,
	authorId     bigint not null,
	dateMade     timestamp not null default current_timestamp,
	imagePath    varchar(255),
	title        varchar(255),
	ingress      varchar(255),
	text         text,

	primary key(id),
	foreign key (authorId) references user(id),
	foreign key (previousEdit) references article(id)
);
