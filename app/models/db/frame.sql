drop database hybrida;
create database hybrida;
use hybrida;

create table article (
	id           bigint auto_increment not null,
	previousEdit bigint default null,
	authorId     bigint not null,
	dateMade     timestamp not null default current_timestamp,
	imagePath    varchar(255),
	title        varchar(255),
	ingress      varchar(255),
	text         text,

	primary key(id)
);
