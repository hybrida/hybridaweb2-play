# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  title                     varchar(255),
  content                   varchar(255),
  posted                    timestamp)
;

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table example_ebean_entity (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_example_ebean_entity primary key (id))
;

create table feed (
  id                        bigint not null,
  title                     varchar(255),
  image_title               varchar(255),
  article                   text,
  ingress                   varchar(255),
  constraint pk_feed primary key (id))
;

create table feed_form (
  image_title               varchar(255),
  ingress                   varchar(255),
  title                     varchar(255),
  article                   varchar(255))
;

create table lol_name (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_lol_name primary key (id))
;

create table USER (
  id                        bigint not null,
  username                  varchar(255),
  l_name                    varchar(255),
  f_name                    varchar(255),
  student                   boolean,
  admin                     boolean,
  bedkom                    boolean,
  email                     varchar(255),
  last_login                timestamp,
  constraint uq_USER_1 unique (id,username),
  constraint pk_USER primary key (id))
;

create sequence company_seq;

create sequence example_ebean_entity_seq;

create sequence feed_seq;

create sequence lol_name_seq;

create sequence USER_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists company;

drop table if exists example_ebean_entity;

drop table if exists feed;

drop table if exists feed_form;

drop table if exists lol_name;

drop table if exists USER;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists example_ebean_entity_seq;

drop sequence if exists feed_seq;

drop sequence if exists lol_name_seq;

drop sequence if exists USER_seq;

