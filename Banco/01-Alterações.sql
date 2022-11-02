CREATE TABLE cliente (
                         id serial,
                         categoria_saldo varchar(100),
                         descricao_saldo varchar(100),
                         data_recebimento timestamp,
                         data_cadastro timestamp,
                         saldo_extra numeric,
                         entrada boolean,
                         CONSTRAINT cliente_pk PRIMARY KEY (id)
);