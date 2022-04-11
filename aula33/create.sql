
    create table tb_jogador (
       id bigint not null auto_increment,
        altura double precision,
        nome varchar(255),
        peso double precision,
        posicao varchar(255),
        time_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table tb_time (
       id bigint not null auto_increment,
        cidade varchar(255),
        estado varchar(255),
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table tb_jogador 
       add constraint FK5mc2rilqsly2vyex88hcsawrs 
       foreign key (time_id) 
       references tb_time (id);
INSERT INTO tb_time (nome, cidade, estado) VALUES ("Time101", "boansa", "BsA");
