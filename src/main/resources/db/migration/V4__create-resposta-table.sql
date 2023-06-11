create table respostas (

    id bigint not null auto_increment,
    mensagem varchar(2500) not null,
    topico_id bigint not null,
    data_criacao date not null,
    usuario_id bigint not null,
    solucao tinyint not null,

    primary key(id),
    constraint fk_respostas_topico_id foreign key(topico_id) references topicos(id),
    constraint fk_respostas_usuario_id foreign key(usuario_id) references usuarios(id)
);