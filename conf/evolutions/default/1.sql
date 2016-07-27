# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  title                         varchar(255) not null,
  content                       varchar(255),
  constraint pk_article primary key (title)
);

create table egg (
  id                            bigint not null,
  name                          varchar(255),
  distance                      bigint,
  constraint pk_egg primary key (id)
);
create sequence egg_seq;

create table move (
  id                            integer not null,
  name                          varchar(255),
  move_type                     varchar(255),
  power                         integer,
  critical_hit_rate             integer,
  cooldown                      integer,
  energy_inc                    integer,
  constraint pk_move primary key (id)
);
create sequence move_seq;

create table pokemon (
  id                            integer not null,
  name                          varchar(255),
  type1                         varchar(255),
  type2                         varchar(255),
  hp                            integer,
  attack                        integer,
  defence                       integer,
  capture_rate                  integer,
  escape_rate                   integer,
  max_cp                        integer,
  move_interval                 integer,
  attack_interval               integer,
  evolve_candy                  integer,
  distance                      integer,
  constraint pk_pokemon primary key (id)
);
create sequence pokemon_seq;


# --- !Downs

drop table if exists article;

drop table if exists egg;
drop sequence if exists egg_seq;

drop table if exists move;
drop sequence if exists move_seq;

drop table if exists pokemon;
drop sequence if exists pokemon_seq;

