-- liquibase formatted sql
-- changeset sombriks:changeset_2022_08_20_22_36_29-carga_inicial.sql

insert into setores (id, nome)
values (1, 'Administrativo'),
       (2, 'Vendas'),
       (3, 'Estoque');
insert into pastas (id, setores_id, nome)
values (1, 1, 'Prioritário'),
       (2, 1, 'Fiscal'),
       (3, 2, 'Prioritário'),
       (4, 2, 'Pós venda'),
       (5, 3, 'Prioritário'),
       (6, 3, 'Entradas'),
       (7, 3, 'Saídas');
insert into estados_documento (id, nome)
values (1, 'novo'),
       (2, 'transferido')

-- rollback delete from estados_documento;
-- rollback delete from pastas;
-- rollback delete from setores;
