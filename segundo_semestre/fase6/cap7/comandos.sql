-- Cadastro e alteração

-- Cadastro de dados usuário.
INSERT INTO t_usuario (
    id_usuario,
    nome,
    sobrenome,
    dt_nascimento,
    email,
    nm_usuario,
    senha
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
INSERT INTO t_usuario_info (
    id_usuario,
    dt_registro,
    email_verificado,
    enviar_novidades,
    pronomes,
    apelido
) VALUES (
    [ID USUÁRIO],
    TO_DATE('[DATA DE REGISTRO]', 'dd/mm/yyyy'),
    '[EMAIL VERIFICADO]',
    '[ENVIAR NOVIDADES]',
    '[PRONOMES]',
    '[APELIDO]'
);

-- Alterar todos os dados do usuário.
UPDATE t_usuario
SET
    nome = '[NOVO NOME]',
    sobrenome = '[NOVO SOBRENOME]',
    dt_nascimento = TO_DATE('[NOVA DATA DE NASCIMENTO]','dd/mm/yyyy'),
    email = '[NOVO EMAIL]',
    nm_usuario = '[NOVO NOME DE USUÁRIO]',
    senha = '[NOVA SENHA CRIPTOGRAFADA]'
WHERE
    id_usuario = [ID USUÁRIO];

COMMIT;

-- Cadastrar as receitas do usuário.
INSERT INTO t_serv_unico (
    id_serv_unico,
    id_usuario,
    id_conta_bancaria,
    nm_servico,
    desc_servico,
    dt_registro_serv,
    dt_operacao,
    valor_operacao,
    a_pagar,
    a_receber
) VALUES (
    [ID SERVICO UNICO],
    [ID USUÁRIO],
    [ID CONTA BANCÁRIA],
    '[NOME SERVICO ÚNICO]',
    '[DESCRIÇÃO SERVICO ÚNICO]',
    TO_DATE('[DATA REGISTRO DO SERVIÇO]', 'dd/mm/yyyy'),
    TO_DATE('[DATA DA OPERAÇÃO]', 'dd/mm/yyyy'),
    [VALOR DA OPERAÇÃO],
    'N',
    'Y'
);

INSERT INTO t_serv_recorrente (
    id_serv_recorrente,
    id_usuario,
    id_conta_bancaria,
    nm_servico,
    desc_servico,
    dt_registro_serv,
    dt_limite,
    frequencia,
    valor_operacao,
    operacao_efetuada,
    a_pagar,
    a_receber
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
    '['Y' OU 'N']',
    'N',
    'Y'
);

-- Alterar todos os dados das receitas do usuario.
UPDATE t_serv_unico
SET
    id_serv_unico = [NOVO ID SERVIÇO],
    id_usuario = [NOVO ID USUARIO],
    id_conta_bancaria = [NOVO ID CONTA],
    nm_servico = '[NOVO NOME DO SERVIÇO]',
    desc_serv = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    dt_registro_serv = TO_DATE('[NOVA DATA DE REGISTRO DO SERVIÇO]','dd/mm/yyyy'),
    dt_operacao = TO_DATE('[NOVA DATA DA OPERAÇÃO BANCÁRIA]','dd/mm/yyyy'),
    valor_operacao = [NOVO VALOR DA OPERAÇÃO],
WHERE
    id_serv_unico = [ID SERVIÇO];

COMMIT;

UPDATE t_serv_recorrente
SET
    id_serv_recorrente = [NOVO ID SERVIÇO],
    id_usuario = [NOVO ID USUÁRIO],
    id_conta_bancaria = [NOVO ID CONTA],
    nm_servico = '[NOVO NOME DO SERVIÇO]',
    desc_servico = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    dt_registro_serv = TO_DATE('[NOVA DATA DE REGISTRO DO SERVIÇO]','dd/mm/yyyy'),
    dt_limite = TO_DATE('[NOVA DATA LIMITE]','dd/mm/yyyy'),
    frequencia = '[NOVA FREQUÊNCIA]',
    valor_operacao = [NOVO VALOR OPERAÇÃO],
    operacao_efetuada = '['Y' OU 'N']',
WHERE
    id_serv_recorrente = [ID SERVIÇO];

COMMIT;

-- Cadastrar as despesas do usuário.
INSERT INTO t_serv_unico (
    id_serv_unico,
    id_usuario,
    id_conta_bancaria,
    nm_servico,
    desc_servico,
    dt_registro_serv,
    dt_operacao,
    valor_operacao,
    a_pagar,
    a_receber
) VALUES (
    [ID SERVIÇO ÚNICO],
    [ID USUÁRIO],
    [ID CONTA BANCÁRIA],
    '[NOME DO SERVIÇO]',
    '[Jantar em restaurante japonês]',
    TO_DATE('[DATA DE REGISTRO SERVIÇO]', 'dd/mm/yyyy'),
    TO_DATE('[DATA DA OPERAÇÃO]', 'dd/mm/yyyy'),
    [VALOR OPERAÇÃO],
    'Y',
    'N'
);

INSERT INTO t_serv_recorrente (
    id_serv_recorrente,
    id_usuario,
    id_conta_bancaria,
    nm_servico,
    desc_servico,
    dt_registro_serv,
    dt_limite,
    frequencia,
    valor_operacao,
    operacao_efetuada,
    a_pagar,
    a_receber
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
    '['Y' OU 'N']',
    'Y',
    'N'
);

-- Alterar todos os dados das despesas do usuário.
UPDATE t_serv_unico
SET
    id_serv_unico = [NOVO ID SERVIÇO],
    id_usuario = [NOVO ID USUARIO],
    id_conta_bancaria = [NOVO ID CONTA],
    nm_servico = '[NOVO NOME DO SERVIÇO]',
    desc_servico = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    dt_registro_serv = TO_DATE('[NOVA DATA DE REGISTRO DO SERVIÇO]','dd/mm/yyyy'),
    dt_operacao = TO_DATE('[NOVA DATA DA OPERAÇÃO BANCÁRIA]','dd/mm/yyyy'),
    valor_operacao = [NOVO VALOR DA OPERAÇÃO],
WHERE
    id_serv_unico = [ID SERVIÇO];

COMMIT;

UPDATE t_serv_recorrente
SET
    id_serv_recorrente = [NOVO ID SERVIÇO],
    id_usuario = [NOVO ID USUÁRIO],
    id_conta_bancaria = [NOVO ID CONTA],
    nm_servico = '[NOVO NOME DO SERVIÇO]',
    desc_servico = '[NOVA DESCRIÇÃO DO SERVIÇO]',
    dt_registro_serv = TO_DATE('[NOVA DATA DE REGISTRO DO SERVIÇO]','dd/mm/yyyy'),
    dt_limite = TO_DATE('[NOVA DATA LIMITE]','dd/mm/yyyy'),
    frequencia = '[NOVA FREQUÊNCIA]',
    valor_operacao = [NOVO VALOR OPERAÇÃO],
    operacao_efetuada = '['Y' OU 'N']',
WHERE
    id_serv_recorrente = [ID SERVIÇO];

COMMIT;

-- Cadastrar os dados para investimentos.
INSERT INTO t_investimento (
    id_investimento,
    id_usuario,
    nm_investimento,
    desc_investimento,
    dt_inicio,
    valor_inicial,
    percent_mensal
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
UPDATE t_investimento
SET
    id_investimento = [NOVO ID INVESTIMENTO],
    id_usuario = [NOVO ID USUÁRIO],
    nm_investimento = '[NOVO NOME DO INVESTIMENTO]',
    desc_investimento = '[NOVA DESCRIÇÃO DO INVESTIMENTO]',
    dt_inicio = TO_DATE('[NOVA DATA DE INÍCIO DO INVESTIMENTO]','dd/mm/yyyy'),
    valor_inicial = [NOVO VALOR INICIAL],
    percent_mensal = [PERCENTUAL MENSAL]
WHERE
    id_investimento = [ID INVESTIMENTO];

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