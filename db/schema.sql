create sequence user_seq;
create table hybrid (
	id bigint primary key not null default nextval('user_seq'),
	username varchar(255) not null,
	firstname varchar(255) default null,
	lastname varchar(255) default null,
	middlename varchar(255) default null,
	email varchar(255) default null,
	websiteUrl varchar(255) default null,
	phone varchar(255) default null,
	title varchar(255) default null,
	graduationyear int default null,
	specialization_id bigint default null,
	profileimagefilename varchar(255) default null,

	student boolean default false,
	styret boolean default false,
	bedkom boolean default false,
	arrkom boolean default false,
	vevkom boolean default false,
	jentekom boolean default false,
	redaksjon boolean default false,
	admin boolean default false,
	root boolean default false,

	gender char default 'U',

	enrolled timestamp default now(),
	dateofbirth timestamp default null,
	lastLogin timestamp default null
);

create sequence article_seq;
create table article (
	id bigint primary key not null default nextval('article_seq'),
	title varchar(255),
	ingress varchar(255),
	text text,
	datemade timestamp,
	imagepath varchar(255)
);
alter table article add previousArticle bigint default null references article(id);

create sequence event_seq;
create table event (
	id bigint primary key not null default nextval('event_seq'),
	article_id bigint not null references article(id),

	location varchar(255),
	graduationlimits varchar(10),
	bedpres boolean default false,
	binding boolean default false,
	genderAllowed char default 'A',
	maxParticipants int default 50,
	maxWaiting int default 50,

	signUpStart timestamp,
	secondSignUp timestamp,
	signUpDeadline timestamp,
	eventHappens timestamp,
	eventStops timestamp
);
alter table event add "previousEvent" bigint default null references event(id);

