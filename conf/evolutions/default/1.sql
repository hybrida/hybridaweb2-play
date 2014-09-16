# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table user (
  l_name                    varchar(255),
  f_name                    varchar(255),
  student                   boolean,
  admin                     boolean,
  bedkom                    boolean)
;

create sequence company_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

