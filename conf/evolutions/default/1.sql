# --- First database schema

# --- !Ups

create table article (
  title                     varchar(255),
  content                   varchar(255))
;

create table egg (
  id                        bigint not null,
  name                      varchar(255),
  distance                  bigint,
  primary key(id))
;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;


