# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create sequence company_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

