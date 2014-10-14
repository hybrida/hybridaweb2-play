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

create table user (
  id                        bigint not null,
  l_name                    varchar(255),
  f_name                    varchar(255),
  student                   boolean,
  admin                     boolean,
  bedkom                    boolean,
  last_login                timestamp,
  constraint pk_user primary key (id))
;

create sequence company_seq;

create sequence feed_seq;

create sequence lol_name_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists company;

drop table if exists feed;

drop table if exists feed_form;

drop table if exists lol_name;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists feed_seq;

drop sequence if exists lol_name_seq;

drop sequence if exists user_seq;

