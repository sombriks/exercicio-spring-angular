-- liquibase formatted sql
-- changeset sombriks:changeset_2022_08_20_20_12_45-versao_inicial.sql

create table setores
(
    id   integer             not null primary key auto_increment,
    nome varchar(255) unique not null
);

create table pastas
(
    id         integer      not null primary key auto_increment,
    setores_id integer      not null,
    nome       varchar(255) not null,
    constraint fk_pastas_setores_id foreign key (setores_id) references setores (id)
);

create table estados_documento
(
    id   integer             not null primary key auto_increment,
    nome varchar(255) unique not null
);

create table documentos
(
    id                   integer      not null primary key auto_increment,
    pastas_id            integer      not null,
    estados_documento_id integer      not null,
    titulo               varchar(255) not null,
    constraint fk_documentos_pastas_id foreign key (pastas_id) references pastas (id),
    constraint fk_documentos_estados_documento_id foreign key (estados_documento_id) references estados_documento (id)
);

create table historico_documentos
(
    id            integer      not null primary key auto_increment,
    documentos_id integer      not null,
    data          timestamp    not null default now(),
    mudanca       varchar(255) not null,
    constraint fk_historico_documentos_documentos_id foreign key (documentos_id) references documentos (id)
);

-- rollback drop table historico_documentos;
-- rollback drop table documentos;
-- rollback drop table estados_documento;
-- rollback drop table pastas;
-- rollback drop table setores;
