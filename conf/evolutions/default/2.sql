# --- !Ups

create table names (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_name primary key (id))
;

create sequence name_seq;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists names;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists name_seq;
