create sequence specialization_seq;
create table specialization (
	id bigint primary key not null default nextval('specialization_seq'),
	description varchar(255)
);

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
	"specializationId" bigint default null references specialization(id),
	"profileImageFilename" varchar(255) default null,

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
	"dateOfBirth" timestamp default null,
	"lastLogin" timestamp default null,
	"cardCode" varchar(255) default null
);

create sequence article_seq;
create table article (
	id bigint primary key not null default nextval('article_seq'),
	title varchar(255),
	authorId bigint not null references hybrid(id),
	ingress varchar(255),
	text text,
	datemade timestamp default now(),
	imagepath varchar(255) default null
);
alter table article add "previousArticle" bigint default null references article(id);

create sequence event_seq;
create table event (
	"id" bigint primary key not null default nextval('event_seq'),
	"articleId" bigint not null references article(id),

	"location" varchar(255),
	"graduationLimits" varchar(10),
	"isBedpres" boolean default false,
	"isBinding" boolean default false,
	"genderAllowed" char default 'A',
	"maxParticipants" int default 50,
	"maxWaiting" int default 50,

	"signUpStart" timestamp,
	"secondSignUp" timestamp,
	"signUpDeadline" timestamp,
	"eventHappens" timestamp,
	"eventStops" timestamp
);
alter table event add "previousEvent" bigint default null references event(id);

create sequence comment_seq;
create table comment (
	id bigint primary key not null default nextval('comment_seq'),
	comment text,
	author bigint not null references hybrid(id),
	"createdDate" timestamp default now()
);

create table visible (
	"articleId" bigint primary key default null references article(id),
	sorting timestamp
);
