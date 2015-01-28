# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  id                        bigint not null,
  title                     varchar(255),
  ingress                   varchar(255),
  text                      varchar(255),
  author                    bigint,
  image_path                varchar(255),
  date_made                 timestamp not null,
  constraint pk_article primary key (id))
;

create table event (
  event_id                  bigint auto_increment not null,
  article_id                bigint,
  time_frame                integer,
  location                  varchar(255),
  first_upper_graduation_limit integer,
  first_lower_graduation_limit integer,
  second_upper_graduation_limit integer,
  second_lower_graduation_limit integer,
  sex_allowed               varchar(255),
  max_participants          integer,
  max_participants_waiting  integer,
  sign_up_deadline          timestamp,
  event_happens             timestamp,
  second_sign_up            timestamp,
  constraint pk_event primary key (event_id))
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
  id                        integer not null,
  image_title               varchar(255),
  ingress                   varchar(255),
  title                     varchar(255),
  article                   varchar(255),
  constraint pk_feed_form primary key (id))
;

create table renders (
  render                    bigint)
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

create sequence article_seq;

create sequence feed_seq;

create sequence feed_form_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists event;

drop table if exists feed;

drop table if exists feed_form;

drop table if exists renders;

drop table if exists USER;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists article_seq;

drop sequence if exists feed_seq;

drop sequence if exists feed_form_seq;

