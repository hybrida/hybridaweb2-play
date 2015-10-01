# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  article_id                bigint auto_increment not null,
  title                     varchar(255),
  ingress                   varchar(255),
  text                      text,
  author_id                 bigint,
  image_path                varchar(255),
  date_made                 timestamp not null,
  constraint pk_article primary key (article_id))
;

create table comment (
  comment_id                bigint auto_increment not null,
  comment                   varchar(255),
  author_id                 bigint,
  article_article_id        bigint,
  created_date              timestamp not null,
  constraint pk_comment primary key (comment_id))
;

create table event (
  event_id                  bigint auto_increment not null,
  article_ref_article_id    bigint,
  location                  varchar(255),
  first_upper_graduation_limit integer,
  first_lower_graduation_limit integer,
  second_upper_graduation_limit integer,
  second_lower_graduation_limit integer,
  first_year_allowed        boolean,
  second_year_allowed       boolean,
  third_year_allowed        boolean,
  fourth_year_allowed       boolean,
  fifth_year_allowed        boolean,
  first_year_allowed_after_second_signup boolean,
  second_year_allowed_after_second_signup boolean,
  third_year_allowed_after_second_signup boolean,
  fourth_year_allowed_after_second_signup boolean,
  fifth_year_allowed_after_second_signup boolean,
  gender_allowed            varchar(255),
  max_participants          integer,
  max_participants_waiting  integer,
  sign_up_deadline          timestamp,
  second_sign_up            timestamp,
  event_happens             timestamp,
  event_stops               timestamp,
  constraint pk_event primary key (event_id))
;

create table renders (
  article_reference_article_id bigint,
  event_reference_event_id  bigint)
;

create table USER (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  first_name                varchar(256) default 'Fornavn',
  lastName                   varchar(256) default 'Etternavn',
  middle_name               varchar(255),
  email                     varchar(255),
  website_url               varchar(255),
  phone                     varchar(255),
  title                     varchar(255),
  profile_image_file_name   varchar(255),
  graduation_year           integer,
  student                   boolean default false,
  bedkom                    boolean default false,
  arrkom                    boolean default false,
  vevkom                    boolean default false,
  admin                     boolean default false,
  root                      boolean default false,
  gender                    char(1) default ' ',
  enrolled                  timestamp,
  date_of_birth             timestamp,
  last_login                timestamp,
  constraint uq_USER_1 unique (username),
  constraint pk_USER primary key (id))
;

create table user_event_joined (
  user_id                   bigint not null,
  event_id                  bigint not null)
;


create table event_USER (
  event_event_id                 bigint not null,
  USER_id                        bigint not null,
  constraint pk_event_USER primary key (event_event_id, USER_id))
;
create sequence user_event_joined_seq;

alter table article add constraint fk_article_author_1 foreign key (author_id) references USER (id) on delete restrict on update restrict;
create index ix_article_author_1 on article (author_id);
alter table comment add constraint fk_comment_author_2 foreign key (author_id) references USER (id) on delete restrict on update restrict;
create index ix_comment_author_2 on comment (author_id);
alter table comment add constraint fk_comment_article_3 foreign key (article_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_comment_article_3 on comment (article_article_id);
alter table event add constraint fk_event_articleRef_4 foreign key (article_ref_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_event_articleRef_4 on event (article_ref_article_id);
alter table renders add constraint fk_renders_articleReference_5 foreign key (article_reference_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_renders_articleReference_5 on renders (article_reference_article_id);
alter table renders add constraint fk_renders_eventReference_6 foreign key (event_reference_event_id) references event (event_id) on delete restrict on update restrict;
create index ix_renders_eventReference_6 on renders (event_reference_event_id);



alter table event_USER add constraint fk_event_USER_event_01 foreign key (event_event_id) references event (event_id) on delete restrict on update restrict;

alter table event_USER add constraint fk_event_USER_USER_02 foreign key (USER_id) references USER (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists comment;

drop table if exists event;

drop table if exists event_USER;

drop table if exists renders;

drop table if exists USER;

drop table if exists user_event_joined;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_event_joined_seq;

