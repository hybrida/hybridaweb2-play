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

create table event_entity (
  event_id                  bigint not null,
  event_description         varchar(255),
  event_time                timestamp,
  constraint pk_event_entity primary key (event_id))
;

create table event_model (
  id                        bigint not null,
  title                     varchar(255),
  image_title               varchar(255),
  article                   varchar(255),
  ingress                   varchar(255),
  antall                    integer,
  constraint pk_event_model primary key (id))
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

create table feed_entity (
  derp                      varchar(255))
;

create table feed_form (
  id                        integer not null,
  image_title               varchar(255),
  ingress                   varchar(255),
  title                     varchar(255),
  article                   varchar(255),
  constraint pk_feed_form primary key (id))
;

create table lol_name (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_lol_name primary key (id))
;

create table USER (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  first_name                varchar(256) default 'Fornavn',
  surname                   varchar(256) default 'Etternavn',
  middle_name               varchar(255),
  email                     varchar(255),
  altemail                  varchar(255),
  website_url               varchar(255),
  phone                     varchar(255),
  title                     varchar(255),
  profile_image_file_name   varchar(255),
  student                   boolean default false,
  bedkom                    boolean default false,
  admin                     boolean default false,
  root                      boolean default false,
  sex                       varchar(1) default ' ',
  enrolled                  timestamp,
  date_of_birth             timestamp,
  last_login                timestamp,
  constraint uq_USER_1 unique (username),
  constraint pk_USER primary key (id))
;

create sequence company_seq;

create sequence event_entity_seq;

create sequence event_model_seq;

create sequence example_ebean_entity_seq;

create sequence feed_seq;

create sequence feed_form_seq;

create sequence lol_name_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists company;

drop table if exists event_entity;

drop table if exists event_model;

drop table if exists example_ebean_entity;

drop table if exists feed;

drop table if exists feed_entity;

drop table if exists feed_form;

drop table if exists lol_name;

drop table if exists USER;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists event_entity_seq;

drop sequence if exists event_model_seq;

drop sequence if exists example_ebean_entity_seq;

drop sequence if exists feed_seq;

drop sequence if exists feed_form_seq;

drop sequence if exists lol_name_seq;

