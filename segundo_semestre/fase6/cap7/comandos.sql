-- Cadastro e alteração

-- Cadastro de dados usuário.
INSERT INTO T_USUARIO (
    ID_USUARIO,
    NOME,
    SOBRENOME,
    DT_NASCIMENTO,
    EMAIL,
    NM_USUARIO,
    SENHA
) VALUES (
    [ID USUÁRIO],
    '[NOME]',
    '[SOBRENOME]',
    TO_DATE('[DATA DE NASCIMENTO]', 'dd/mm/yyyy'),
    '[EMAIL]',
    '[NOME DE USUÁRIO]',
    '[SENHA CRIPTOGRAFADA]'
);

-- Cadastrar os dados para a conta do usuário.
INSERT INTO T_USUARIO_INFO (
    ID_USUARIO,
    DT_REGISTRO,
    EMAIL_VERIFICADO,
    ENVIAR_NOVIDADES,
    PRONOMES
) VALUES (
    [ID USUÁRIO],
    TO_DATE('[DATA DE REGISTRO]', 'dd/mm/yyyy'),
    '[EMAIL VERIFICADO]',
    '[ENVIAR NOVIDADES]',
    '[PRONOMES]'
);

-- Alterar todos os dados do usuário.
UPDATE T_USUARIO
SET
    NOME = '[NOVO NOME]',
    SOBRENOME = '[NOVO SOBRENOME]',
    DT_NASCIMENTO = TO_DATE(
        '[NOVA DATA DE NASCIMENTO]',
        'dd/mm/yyyy'
    ),
    EMAIL = '[NOVO EMAIL]',
    NM_USUARIO = '[NOVO NOME DE USUÁRIO]',
    SENHA = '[NOVA SENHA CRIPTOGRAFADA]'
WHERE
    ID_USUARIO = [ID USUÁRIO];

COMMIT;

-- Cadastrar as receitas do usuário.
INSERT INTO T_SERV_UNICO (
    ID_SERV_UNICO,
    ID_USUARIO,
    ID_CONTA_BANCARIA,
    NM_SERVICO,
    DESC_SERVICO,
    DT_REGISTRO_SERV DT_OPERACAO,
    VALOR_OPERACAO,
    A_PAGAR,
    A_RECEBER
) VALUES (
    [ID SERVICO UNICO],
    [ID USUÁRIO],
    [ID CONTA BANCÁRIA],
    '[NOME SERVICO ÚNICO]',
    '[DESCRIÇÃO SERVICO ÚNICO]',
    TO_DATE('[DATA REGISTRO DO SERVIÇO]', 'dd/mm/yyyy'),
    TO_DATE('[DATA DA OPERAÇÃO]', 'dd/mm/yyyy'),
    [VALOR DA OPERAÇÃO],
    '[A PAGAR]',
    '[A RECEBER]'
);

INSERT INTO T_SERV_RECORRENTE (
    ID_SERV_UNICO,
    ID_USUARIO,
    ID_CONTA_BANCARIA,
    NM_SERVICO,
    DESC_SERVICO,
    DT_REGISTRO_SERV,
    DT_LIMITE,
    FREQUENCIA,
    VALOR_OPERACAO,
    OPERACAO_EFETUADA,
    A_PAGAR,
    A_RECEBER
) VALUES (
    [ID SERVICO RECORRENTE],
    [ID USUÁRIO],
    [ID CONTA BANCÁRIA],
    '[NOME SERVIÇO RECORRENTE]',
    '[DESCRIÇÃO SERVIÇO RECORRENTE]',
    TO_DATE('[DATA REGISTRO DO SERVIÇO]', 'dd/mm/yyyy'),
    TO_DATE('[DATA DE LIMITE DO PAGAMENTO]', 'dd/mm/yyyy'),
    '[FREQUENCIA]',
    [VALOR DA OPERAÇÃO],
    '[OPERAÇÃO EFETUADA]',
    '[A PAGAR]',
    '[A RECEBER]'
);

-- Alterar todos os dados das receitas do usuario.
UPDATE T_SERV_UNICO
SET
    ID_SERV_UNICO = [NOVO ID SERVIÇO],
    ID_USUARIO = [NOVO ID USUARIO],
    ID_CONTA_BANCARIA = [NOVO ID CONTA],
    NM_SERVICO = '[NOVO NOME DO SERVIÇO]',
    DESC_SERVICO = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    DT_REGISTRO_SERV = TO_DATE(
        '[NOVA DATA DE REGISTRO DO SERVIÇO]',
        'dd/mm/yyyy'
    ),
    DT_OPERACAO = TO_DATE(
        '[NOVA DATA DA OPERAÇÃO BANCÁRIA]',
        'dd/mm/yyyy'
    ),
    VALOR_OPERACAO = [NOVO VALOR DA OPERAÇÃO],
    A_PAGAR = '[A PAGAR]',
    A_RECEBER = '[A RECEBER]',
WHERE
    ID_SERV_UNICO = [ID SERVIÇO];

COMMIT;

UPDATE T_SERV_RECORRENTE
SET
    ID_SERV_UNICO = [NOVO ID SERVIÇO],
    ID_USUARIO = [NOVO ID USUÁRIO],
    ID_CONTA_BANCARIA = [NOVO ID CONTA],
    NM_SERVICO = '[NOVO NOME DO SERVIÇO]',
    DESC_SERVICO = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    DT_REGISTRO_SERV = TO_DATE(
        '[NOVA DATA DE REGISTRO DO SERVIÇO]',
        'dd/mm/yyyy'
    ),
    DT_LIMITE = TO_DATE(
        '[NOVA DATA LIMITE]',
        'dd/mm/yyyy'
    ),
    FREQUENCIA = '[NOVA FREQUÊNCIA]',
    VALOR_OPERACAO = [NOVO VALOR OPERAÇÃO],
    OPERACAO_EFETUADA = '[OPERAÇÃO EFETUADA]',
    A_PAGAR = '[A PAGAR]',
    A_RECEBER = '[A RECEBER]'
WHERE
    ID_SERV_RECORRENTE = [ID SERVIÇO];

COMMIT;

-- Cadastrar as despesas do usuário.
INSERT INTO T_SERV_UNICO (
    ID_SERV_UNICO,
    ID_USUARIO,
    ID_CONTA_BANCARIA,
    NM_SERVICO,
    DESC_SERVICO,
    DT_REGISTRO_SERV,
    DT_OPERACAO,
    VALOR_OPERACAO,
    A_PAGAR,
    A_RECEBER
) VALUES (
    [ID SERVIÇO ÚNICO],
    [ID USUÁRIO],
    [ID CONTA BANCÁRIA],
    '[NOME DO SERVIÇO]',
    '[Jantar em restaurante japonês]',
    TO_DATE('[DATA DE REGISTRO SERVIÇO]', 'dd/mm/yyyy'),
    TO_DATE('[DATA DA OPERAÇÃO]', 'dd/mm/yyyy'),
    [VALOR OPERAÇÃO],
    '[A PAGAR]',
    '[A RECEBER]'
);

INSERT INTO T_SERV_RECORRENTE (
    ID_SERV_UNICO,
    ID_USUARIO,
    ID_CONTA_BANCARIA,
    NM_SERVICO,
    DESC_SERVICO,
    DT_REGISTRO_SERV,
    DT_LIMITE,
    FREQUENCIA,
    VALOR_OPERACAO,
    OPERACAO_EFETUADA,
    A_PAGAR,
    A_RECEBER
) VALUES (
    [ID SERVICO RECORRENTE],
    [ID USUÁRIO],
    [ID CONTA BANCÁRIA],
    '[NOME SERVIÇO RECORRENTE]',
    '[DESCRIÇÃO SERVIÇO RECORRENTE]',
    TO_DATE('[DATA REGISTRO DO SERVIÇO]', 'dd/mm/yyyy'),
    TO_DATE('[DATA DE LIMITE DO PAGAMENTO]', 'dd/mm/yyyy'),
    '[FREQUENCIA]',
    [VALOR DA OPERAÇÃO],
    '[OPERAÇÃO EFETUADA]',
    '[A PAGAR]',
    '[A RECEBER]'
);

-- Alterar todos os dados das despesas do usuário.
UPDATE T_SERV_UNICO
SET
    ID_SERV_UNICO = [NOVO ID SERVIÇO],
    ID_USUARIO = [NOVO ID USUARIO],
    ID_CONTA_BANCARIA = [NOVO ID CONTA],
    NM_SERVICO = '[NOVO NOME DO SERVIÇO]',
    DESC_SERVICO = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    DT_REGISTRO_SERV = TO_DATE(
        '[NOVA DATA DE REGISTRO DO SERVIÇO]',
        'dd/mm/yyyy'
    ),
    DT_OPERACAO = TO_DATE(
        '[NOVA DATA DA OPERAÇÃO BANCÁRIA]',
        'dd/mm/yyyy'
    ),
    VALOR_OPERACAO = [NOVO VALOR DA OPERAÇÃO],
    A_PAGAR = '[A PAGAR]',
    A_RECEBER = '[A RECEBER]',
WHERE
    ID_SERV_UNICO = [ID SERVIÇO];

COMMIT;

UPDATE T_SERV_RECORRENTE
SET
    ID_SERV_UNICO = [NOVO ID SERVIÇO],
    ID_USUARIO = [NOVO ID USUÁRIO],
    ID_CONTA_BANCARIA = [NOVO ID CONTA],
    NM_SERVICO = '[NOVO NOME DO SERVIÇO]',
    DESC_SERVICO = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    DT_REGISTRO_SERV = TO_DATE(
        '[NOVA DATA DE REGISTRO DO SERVIÇO]',
        'dd/mm/yyyy'
    ),
    DT_LIMITE = TO_DATE(
        '[NOVA DATA LIMITE]',
        'dd/mm/yyyy'
    ),
    FREQUENCIA = '[NOVA FREQUÊNCIA]',
    VALOR_OPERACAO = [NOVO VALOR OPERAÇÃO],
    OPERACAO_EFETUADA = '[OPERAÇÃO EFETUADA]',
    A_PAGAR = '[A PAGAR]',
    A_RECEBER = '[A RECEBER]'
WHERE
    ID_SERV_RECORRENTE = [ID SERVIÇO];

COMMIT;

-- Cadastrar os dados para investimentos.
INSERT INTO T_INVESTIMENTO (
    ID_INVESTIMENTO,
    ID_USUARIO,
    NM_INVESTIMENTO,
    DESC_INVESTIMENTO,
    DT_INICIO,
    VALOR_INICIAL,
    PERCENT_MENSAL
) VALUES (
    [ID INVESTIMENTO],
    [ID USUÁRIO],
    '[NOME DO INVESTIMENTO]',
    '[DESCRIÇÃO DO INVESTIMENTO]',
    TO_DATE('[DATA DE INÍCIO DO INVESTIMENTO]', 'dd/mm/yyyy'),
    [VALOR INICIAL],
    [PERCENTUAL MENSAL]
);

-- Alterar todos os dados para investimentos do usuario.
UPDATE T_INVESTIMENTO
SET
    ID_INVESTIMENTO = [NOVO ID INVESTIMENTO],
    ID_USUARIO = [NOVO ID USUÁRIO],
    NM_INVESTIMENTO = '[NOVO NOME DO INVESTIMENTO]',
    DESC_INVESTIMENTO = '[NOVA DESCRIÇÃO DO INVESTIMENTO]',
    DT_INICIO = TO_DATE(
        '[NOVA DATA DE INÍCIO DO INVESTIMENTO]',
        'dd/mm/yyyy'
    ),
    VALOR_INICIAL = [NOVO VALOR INICIAL],
    PERCENT_MENSAL = [PERCENTUAL MENSAL]
WHERE
    ID_INVESTIMENTO = [ID INVESTIMENTO];

COMMIT;

-- Consultas

-- Consultar os dados de um usuário (filtrar a partir do seu código).
SELECT
    NOME,
    SOBRENOME,
    DT_NASCIMENTO,
    EMAIL,
    NM_USUARIO
FROM
    T_USUARIO
WHERE
    ID_USUARIO = [ID USUÁRIO];

-- Consultar os dados de um único registro de despesa de um usuário (filtrar a
-- partir do código do usuário e do código da despesa).
SELECT
    *
FROM
    T_SERV_UNICO
WHERE
    ID_USUARIO = [ID USUÁRIO]
    AND ID_SERV_UNICO = [ID SERVIÇO ÚNICO];

-- Consultar os dados de todos os registros de despesas de um  usuário,
-- ordenando-os dos registros mais recentes para os mais antigos (filtrar a
-- partir do seu código).
SELECT
    *
FROM
    T_SERV_UNICO
WHERE
    ID_USUARIO = [ID USUÁRIO]
ORDER BY
    DT_REGISTRO_SERV;

-- Consultar os dados de um único registro de investimento de um usuário
-- (filtrar a partir do código do usuário e do código de investimento).
SELECT
    *
FROM
    T_INVESTIMENTO
WHERE
    ID_USUARIO = [ID USUÁRIO]
    AND ID_INVESTIMENTO = [ID INVESTIMENTO];

-- Consultar os dados de todos os registros de investimentos de um  usuário,
-- ordenando-os dos registros mais recentes para os mais antigos (filtrar a
-- partir do seu código).
SELECT
    *
FROM
    T_INVESTIMENTO
WHERE
    ID_USUARIO = [ID USUÁRIO]
ORDER BY
    DT_INICIO DESC;

-- Consultar os dados básicos de um usuário, o último investimento registrado e
-- a última despesa registrada (filtrar a partir do código de usuário – consulta
-- necessária para o dashboard. Dica: veja consulta com junções).
SELECT
    U.ID_USUARIO,
    U.NOME,
    SU.ID_SERV_UNICO,
    SU.DATA_SERVICO,
    SU.A_PAGAR,
    INV.ID_INVESTIMENTO,
    INV.DATA_INVESTIMENTO
FROM
    T_USUARIO U
    LEFT JOIN (
        SELECT
            ID_SERV_UNICO,
            ID_USUARIO,
            A_PAGAR,
            DATA_SERVICO
        FROM
            T_SERV_UNICO
        WHERE
            A_PAGAR = 'Y'
            AND ID_USUARIO = [ID USUÁRIO]
        ORDER BY
            DT_SERVICO DESC LIMIT 1
    ) SU
    ON U.ID_USUARIO = SU.ID_USUARIO
    LEFT JOIN (
        SELECT
            ID_INVESTIMENTO,
            ID_USUARIO,
            DATA_INVESTIMENTO
        FROM
            T_INVESTIMENTO
        WHERE
            ID_USUARIO = [ID USUÁRIO]
        ORDER BY
            DATA_INVESTIMENTO DESC LIMIT 1
    ) INV
    ON U.ID_USUARIO = INV.ID_USUA;