# --- !Ups

create table names (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_name primary key (id))
;
create table feed (
  id                        bigint not null,
  title                     varchar(255),
  article                   text,
  constraint pk_feed primary key (id)
);

create sequence name_seq;
create sequence feed_seq;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists names;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists name_seq;

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists feed;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists feed_seq;
