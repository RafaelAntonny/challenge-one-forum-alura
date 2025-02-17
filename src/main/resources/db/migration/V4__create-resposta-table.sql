create table respostas (

    id bigint not null auto_increment,
    mensagem varchar(2500) not null,
    topico_id bigint not null,
    data_criacao date not null,
    autor_id bigint not null,
    solucao tinyint not null,

    primary key(id),
    constraint fk_respostas_topico_id foreign key(topico_id) references topicos(id) on delete cascade,
    constraint fk_respostas_usuario_id foreign key(autor_id) references usuarios(id) on delete cascade
);