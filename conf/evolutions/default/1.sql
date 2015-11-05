# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  article_id                bigint auto_increment not null,
  title                     varchar(255),
  ingress                   varchar(255),
  text                      text,
  previous_edit_article_id  bigint,
  author_id                 bigint,
  image_path                varchar(255),
  date_made                 datetime not null,
  constraint pk_article primary key (article_id))
;

create table bedrift (
  bedrift_id                bigint auto_increment not null,
  bedrift_name              varchar(255),
  active                    tinyint(1) default 0,
  webpage                   varchar(255),
  responsible_id            bigint,
  priority                  integer,
  date_made                 datetime not null,
  when_updated              datetime not null,
  constraint pk_bedrift primary key (bedrift_id))
;

create table comment (
  comment_id                bigint auto_increment not null,
  comment                   varchar(255),
  author_id                 bigint,
  article_article_id        bigint,
  created_date              datetime not null,
  constraint pk_comment primary key (comment_id))
;

create table contact (
  contact_id                bigint auto_increment not null,
  contact                   varchar(255),
  telephone                 varchar(255),
  email                     varchar(255),
  other                     text,
  bedrift_bedrift_id        bigint,
  date_made                 datetime not null,
  when_updated              datetime not null,
  constraint pk_contact primary key (contact_id))
;

create table event (
  event_id                  bigint auto_increment not null,
  article_ref_article_id    bigint,
  previous_edit_event_id    bigint,
  location                  varchar(255),
  first_upper_graduation_limit integer,
  first_lower_graduation_limit integer,
  second_upper_graduation_limit integer,
  second_lower_graduation_limit integer,
  first_year_allowed        tinyint(1) default 0,
  second_year_allowed       tinyint(1) default 0,
  third_year_allowed        tinyint(1) default 0,
  fourth_year_allowed       tinyint(1) default 0,
  fifth_year_allowed        tinyint(1) default 0,
  first_year_allowed_after_second_signup tinyint(1) default 0,
  second_year_allowed_after_second_signup tinyint(1) default 0,
  third_year_allowed_after_second_signup tinyint(1) default 0,
  fourth_year_allowed_after_second_signup tinyint(1) default 0,
  fifth_year_allowed_after_second_signup tinyint(1) default 0,
  bedpres                   tinyint(1) default 0,
  binding                   tinyint(1) default 0,
  gender_allowed            varchar(255),
  max_participants          integer,
  max_participants_waiting  integer,
  sign_up_start             datetime,
  second_sign_up            datetime,
  sign_up_deadline          datetime,
  event_happens             datetime,
  event_stops               datetime,
  constraint pk_event primary key (event_id))
;

create table note (
  note_id                   bigint auto_increment not null,
  note                      text,
  bedrift_bedrift_id        bigint,
  date_made                 datetime not null,
  when_updated              datetime not null,
  constraint pk_note primary key (note_id))
;

create table renders (
  render_id                 bigint auto_increment not null,
  article_reference_article_id bigint,
  event_reference_event_id  bigint,
  constraint pk_renders primary key (render_id))
;

create table user (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  first_name                varchar(256) default 'Fornavn' not null,
  last_name                 varchar(256) default 'Etternavn' not null,
  middle_name               varchar(255),
  email                     varchar(255),
  website_url               varchar(255),
  phone                     varchar(255),
  title                     varchar(255),
  graduation_year           integer,
  specialization            varchar(29),
  profile_image_file_name   varchar(255),
  student                   boolean default false,
  styret                    boolean default false,
  bedkom                    boolean default false,
  arrkom                    boolean default false,
  vevkom                    boolean default false,
  jentekom                  boolean default false,
  redaksjonen               boolean default false,
  admin                     boolean default false,
  root                      boolean default false,
  gender                    char(1) default 'U',
  enrolled                  datetime,
  date_of_birth             datetime,
  block4from_this_event_event_id bigint,
  last_login                datetime,
  profile_image_pos         double,
  constraint ck_user_specialization check (specialization in ('NONE','GEOMATIKK','KONSTRUKSJON','MARIN','MASKIN','PETROLIUM','PRODUKSJONSLEDELSE')),
  constraint uq_user_1 unique (username),
  constraint pk_user primary key (id))
;

create table user_event_joined (
  user_id                   bigint not null,
  event_id                  bigint not null)
;


create table event_user (
  event_event_id                 bigint not null,
  user_id                        bigint not null,
  constraint pk_event_user primary key (event_event_id, user_id))
;
alter table article add constraint fk_article_previousEdit_1 foreign key (previous_edit_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_article_previousEdit_1 on article (previous_edit_article_id);
alter table article add constraint fk_article_author_2 foreign key (author_id) references user (id) on delete restrict on update restrict;
create index ix_article_author_2 on article (author_id);
alter table bedrift add constraint fk_bedrift_responsible_3 foreign key (responsible_id) references user (id) on delete restrict on update restrict;
create index ix_bedrift_responsible_3 on bedrift (responsible_id);
alter table comment add constraint fk_comment_author_4 foreign key (author_id) references user (id) on delete restrict on update restrict;
create index ix_comment_author_4 on comment (author_id);
alter table comment add constraint fk_comment_article_5 foreign key (article_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_comment_article_5 on comment (article_article_id);
alter table contact add constraint fk_contact_bedrift_6 foreign key (bedrift_bedrift_id) references bedrift (bedrift_id) on delete restrict on update restrict;
create index ix_contact_bedrift_6 on contact (bedrift_bedrift_id);
alter table event add constraint fk_event_articleRef_7 foreign key (article_ref_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_event_articleRef_7 on event (article_ref_article_id);
alter table event add constraint fk_event_previousEdit_8 foreign key (previous_edit_event_id) references event (event_id) on delete restrict on update restrict;
create index ix_event_previousEdit_8 on event (previous_edit_event_id);
alter table note add constraint fk_note_bedrift_9 foreign key (bedrift_bedrift_id) references bedrift (bedrift_id) on delete restrict on update restrict;
create index ix_note_bedrift_9 on note (bedrift_bedrift_id);
alter table renders add constraint fk_renders_articleReference_10 foreign key (article_reference_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_renders_articleReference_10 on renders (article_reference_article_id);
alter table renders add constraint fk_renders_eventReference_11 foreign key (event_reference_event_id) references event (event_id) on delete restrict on update restrict;
create index ix_renders_eventReference_11 on renders (event_reference_event_id);
alter table user add constraint fk_user_block4FromThisEvent_12 foreign key (block4from_this_event_event_id) references event (event_id) on delete restrict on update restrict;
create index ix_user_block4FromThisEvent_12 on user (block4from_this_event_event_id);



alter table event_user add constraint fk_event_user_event_01 foreign key (event_event_id) references event (event_id) on delete restrict on update restrict;

alter table event_user add constraint fk_event_user_user_02 foreign key (user_id) references user (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table article;

drop table bedrift;

drop table comment;

drop table contact;

drop table event;

drop table event_user;

drop table note;

drop table renders;

drop table user;

drop table user_event_joined;

SET FOREIGN_KEY_CHECKS=1;

