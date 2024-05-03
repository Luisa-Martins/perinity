create table departamentos (
  id serial primary key,
  nome varchar(255) not null
);

create table pessoas (
    id serial primary key,
    nome varchar(255) not null,
    departamento_id integer,
    constraint fk_departamento
                     foreign key (departamento_id)
                     references departamentos(id)
);

create table tarefas (
    id serial primary key,
    titulo varchar(255),
    descricao varchar(255),
    prazo date,
    departamento_id integer,
    duracao integer,
    pessoa_id integer,
    finalizado boolean not null default false,
    constraint fk_departamento
                     foreign key (departamento_id)
                     references departamentos(id),
    constraint fk_pessoa
                     foreign key (pessoa_id)
                     references pessoas(id)
);