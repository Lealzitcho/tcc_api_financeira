CREATE TABLE cliente (
                         id serial,
                         categoria_saldo varchar(100),
                         descricao_saldo varchar(100),
                         data_recebimento varchar(100),
                         saldo_extra numeric,
                         CONSTRAINT cliente_pk PRIMARY KEY (id)
);

alter table cliente add column entrada boolean;