# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  article_id                bigint auto_increment not null,
  title                     varchar(255),
  ingress                   varchar(255),
  text                      text,
  author_ID                 bigint,
  image_path                varchar(255),
  date_made                 timestamp not null,
  constraint pk_article primary key (article_id))
;

create table bedrift (
  bedrift_id                bigint auto_increment not null,
  bedrift_name              varchar(255),
  active                    boolean,
  webpage                   varchar(255),
  responsible_ID            bigint,
  priority                  integer,
  date_made                 timestamp not null,
  when_updated              timestamp not null,
  constraint pk_bedrift primary key (bedrift_id))
;

create table comment (
  comment_id                bigint auto_increment not null,
  comment                   varchar(255),
  author_ID                 bigint,
  article_article_id        bigint,
  created_date              timestamp not null,
  constraint pk_comment primary key (comment_id))
;

create table contact (
  contact_id                bigint auto_increment not null,
  contact                   varchar(255),
  telephone                 varchar(255),
  email                     varchar(255),
  other                     text,
  bedrift_bedrift_id        bigint,
  date_made                 timestamp not null,
  when_updated              timestamp not null,
  constraint pk_contact primary key (contact_id))
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
  bedpres                   boolean,
  binding                   boolean,
  gender_allowed            varchar(255),
  max_participants          integer,
  max_participants_waiting  integer,
  sign_up_start             timestamp,
  second_sign_up            timestamp,
  sign_up_deadline          timestamp,
  event_happens             timestamp,
  event_stops               timestamp,
  constraint pk_event primary key (event_id))
;

create table note (
  note_id                   bigint auto_increment not null,
  note                      text,
  bedrift_bedrift_id        bigint,
  date_made                 timestamp not null,
  when_updated              timestamp not null,
  constraint pk_note primary key (note_id))
;

create table renders (
  article_reference_article_id bigint,
  event_reference_event_id  bigint)
;

create table USER (
  ID                        bigint auto_increment not null,
  username                  varchar(255),
  FIRST_NAME                varchar(256) default 'Fornavn' not null,
  LAST_NAME                 varchar(256) default 'Etternavn' not null,
  MIDDLE_NAME               varchar(255),
  EMAIL                     varchar(255),
  WEBSITE_URL               varchar(255),
  PHONE                     varchar(255),
  TITLE                     varchar(255),
  GRADUATION_YEAR           integer,
  SPECIALIZATION            varchar(29),
  PROFILE_IMAGE_FILE_NAME   varchar(255),
  STUDENT                   boolean default false,
  BEDKOM                    boolean default false,
  ARRKOM                    boolean default false,
  VEVKOM                    boolean default false,
  ADMIN                     boolean default false,
  ROOT                      boolean default false,
  GENDER                    char(1) default ' ',
  ENROLLED                  timestamp,
  DATE_OF_BIRTH             timestamp,
  block4from_this_event_event_id bigint,
  LAST_LOGIN                timestamp,
  PROFILE_IMAGE_POS         double,
  constraint ck_USER_SPECIALIZATION check (SPECIALIZATION in ('NONE','GEOMATIKK','KONSTRUKSJON','MARIN','MASKIN','PETROLIUM','PRODUKSJONSLEDELSE')),
  constraint uq_USER_1 unique (USERNAME),
  constraint pk_USER primary key (ID))
;

create table user_event_joined (
  user_id                   bigint not null,
  event_id                  bigint not null)
;


create table event_USER (
  event_event_id                 bigint not null,
  USER_ID                        bigint not null,
  constraint pk_event_USER primary key (event_event_id, USER_ID))
;
create sequence user_event_joined_seq;

alter table article add constraint fk_article_author_1 foreign key (author_ID) references USER (ID) on delete restrict on update restrict;
create index ix_article_author_1 on article (author_ID);
alter table bedrift add constraint fk_bedrift_responsible_2 foreign key (responsible_ID) references USER (ID) on delete restrict on update restrict;
create index ix_bedrift_responsible_2 on bedrift (responsible_ID);
alter table comment add constraint fk_comment_author_3 foreign key (author_ID) references USER (ID) on delete restrict on update restrict;
create index ix_comment_author_3 on comment (author_ID);
alter table comment add constraint fk_comment_article_4 foreign key (article_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_comment_article_4 on comment (article_article_id);
alter table contact add constraint fk_contact_bedrift_5 foreign key (bedrift_bedrift_id) references bedrift (bedrift_id) on delete restrict on update restrict;
create index ix_contact_bedrift_5 on contact (bedrift_bedrift_id);
alter table event add constraint fk_event_articleRef_6 foreign key (article_ref_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_event_articleRef_6 on event (article_ref_article_id);
alter table note add constraint fk_note_bedrift_7 foreign key (bedrift_bedrift_id) references bedrift (bedrift_id) on delete restrict on update restrict;
create index ix_note_bedrift_7 on note (bedrift_bedrift_id);
alter table renders add constraint fk_renders_articleReference_8 foreign key (article_reference_article_id) references article (article_id) on delete restrict on update restrict;
create index ix_renders_articleReference_8 on renders (article_reference_article_id);
alter table renders add constraint fk_renders_eventReference_9 foreign key (event_reference_event_id) references event (event_id) on delete restrict on update restrict;
create index ix_renders_eventReference_9 on renders (event_reference_event_id);
alter table USER add constraint fk_USER_block4FromThisEvent_10 foreign key (block4from_this_event_event_id) references event (event_id) on delete restrict on update restrict;
create index ix_USER_block4FromThisEvent_10 on USER (block4from_this_event_event_id);



alter table event_USER add constraint fk_event_USER_event_01 foreign key (event_event_id) references event (event_id) on delete restrict on update restrict;

alter table event_USER add constraint fk_event_USER_USER_02 foreign key (USER_ID) references USER (ID) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists bedrift;

drop table if exists comment;

drop table if exists contact;

drop table if exists event;

drop table if exists event_USER;

drop table if exists note;

drop table if exists renders;

drop table if exists USER;

drop table if exists user_event_joined;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_event_joined_seq;

