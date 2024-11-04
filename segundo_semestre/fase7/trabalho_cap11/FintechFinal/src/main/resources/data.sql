DROP TABLE t_usuario CASCADE CONSTRAINTS;
DROP SEQUENCE seq_usuario;

DROP TABLE t_usuario_info CASCADE CONSTRAINTS;

DROP TABLE t_operacao CASCADE CONSTRAINTS;
DROP SEQUENCE seq_operacao;

DROP TABLE t_investimento CASCADE CONSTRAINTS;
DROP SEQUENCE seq_investimento;

DROP TABLE t_noticia CASCADE CONSTRAINTS;
DROP SEQUENCE seq_noticia;

-- INVESTIMENTO
CREATE SEQUENCE seq_investimento START WITH 1 INCREMENT BY 1;

CREATE TABLE t_investimento (
    id_investimento   NUMBER(8) NOT NULL,
    id_usuario        NUMBER(8) NOT NULL,
    nm_investimento   VARCHAR2(20) NOT NULL,
    desc_investimento VARCHAR2(100) NOT NULL,
    dt_inicio         DATE NOT NULL,
    dt_termino        DATE,
    valor_inicial     NUMBER(8, 2) NOT NULL,
    percent_mensal    NUMBER(3) NOT NULL
);

ALTER TABLE t_investimento ADD CONSTRAINT t_investimento_pk PRIMARY KEY ( id_investimento );

-- NOTICIA
CREATE SEQUENCE seq_noticia START WITH 1 INCREMENT BY 1;

CREATE TABLE t_noticia (
    id_noticia    NUMBER(8) NOT NULL,
    id_usuario    NUMBER(8) NOT NULL,
    dt_publicacao DATE NOT NULL,
    titulo        VARCHAR2(50) NOT NULL,
    texto         CLOB NOT NULL,
    resumo        VARCHAR2(50) NOT NULL,
    imagem        VARCHAR2(40) NOT NULL,
    imagem_alt    VARCHAR2(40) NOT NULL
);

ALTER TABLE t_noticia ADD CONSTRAINT t_noticia_pk PRIMARY KEY ( id_noticia );

-- OPERACAO
CREATE SEQUENCE seq_operacao START WITH 1 INCREMENT BY 1;

CREATE TABLE t_operacao (
    id_operacao   NUMBER(8) NOT NULL,
    id_usuario    NUMBER(8) NOT NULL,
    nm_operacao   VARCHAR2(30) NOT NULL,
    desc_operacao VARCHAR2(100) NOT NULL,
    tipo_operacao CHAR(1) NOT NULL,
    dt_registro   DATE NOT NULL,
    dt_operacao   DATE NOT NULL,
    valor         NUMBER(8, 2) NOT NULL
);

COMMENT ON COLUMN t_operacao.tipo_operacao IS
    'D-Despesa/R-Receita';

ALTER TABLE t_operacao ADD CONSTRAINT t_operacao_pk PRIMARY KEY ( id_operacao );

-- USUARIO
CREATE SEQUENCE seq_usuario START WITH 1 INCREMENT BY 1;

CREATE TABLE t_usuario (
    id_usuario    NUMBER(8) NOT NULL,
    nome          VARCHAR2(30) NOT NULL,
    sobrenome     VARCHAR2(30) NOT NULL,
    dt_nascimento DATE NOT NULL,
    email         VARCHAR2(50) NOT NULL,
    nm_usuario    VARCHAR2(20) NOT NULL,
    senha         VARCHAR2(100) NOT NULL,
    cargo         VARCHAR2(5) NOT NULL
);

COMMENT ON COLUMN t_usuario.cargo IS
    '''ADMIN'' ou ''USER''';

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_email_un UNIQUE ( email );

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_nm_usuario_un UNIQUE ( nm_usuario );

-- USUARIO INFO
CREATE TABLE t_usuario_info (
    id_usuario       NUMBER(8) NOT NULL,
    dt_registro      DATE NOT NULL,
    email_verificado CHAR(1) NOT NULL,
    enviar_novidades CHAR(1) NOT NULL,
    pronomes         VARCHAR2(20),
    apelido          VARCHAR2(20)
);

COMMENT ON COLUMN t_usuario_info.email_verificado IS
    'Y-Sim/N-Nao';

COMMENT ON COLUMN t_usuario_info.enviar_novidades IS
    'Y-Sim/N-Nao';

ALTER TABLE t_usuario_info ADD CONSTRAINT t_usuario_info_pk PRIMARY KEY ( id_usuario );

-- CONSTRAINTS
ALTER TABLE t_investimento
    ADD CONSTRAINT t_investimento_t_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_noticia
    ADD CONSTRAINT t_noticia_t_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_operacao
    ADD CONSTRAINT t_operacao_t_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_usuario_info
    ADD CONSTRAINT t_usuario_info_t_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES t_usuario ( id_usuario )
            ON DELETE CASCADE;