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

create table pokemon (
  id                        bigint not null,
  name                      varchar(255),
  type1                     varchar(255),
  type2                     varchar(255),
  hp                        bigint,
  attack                    bigint,
  defence                   bigint,
  capture_rate              bigint,
  escape_rate               bigint,
  max_cp                    bigint,
  move_interval             bigint,
  attack_interval           bigint,
  evolve_candy              bigint,
  distance                  bigint,
  primary key(id))
;

create table move (
  id                        bigint not null,
  name                      varchar(255),
  move_type                 varchar(255),
  power                     bigint,
  critical_hit_rate         bigint,
  cooldown                  bigint,
  energy_inc                bigint,
  primary key(id))
;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists article;

drop table if exists egg;

drop table if exists pokemon;

drop table if exists move;


