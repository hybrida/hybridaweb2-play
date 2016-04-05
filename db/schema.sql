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
