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
    1,
    'Jose',
    'Amaro',
    TO_DATE('20/03/1989', 'dd/mm/yyyy'),
    'exemplo@email.com',
    'jose_amaro',
    'senha-segura'
)
 -- Cadastrar os dados para a conta do usuário.
INSERT INTO T_USUARIO_INFO (
    ID_USUARIO,
    DT_REGISTRO,
    EMAIL_VERIFICADO,
    ENVIAR_NOVIDADES,
    PRONOMES
) VALUES (
    1,
    TO_DATE('25/10/2023', 'dd/mm/yyyy'),
    'N',
    'Y',
    'ELE/DELE'
)
 -- Alterar todos os dados do usuário.
UPDATE T_USUARIO SET NOME = 'Eduarda',
SOBRENOME = 'Souza',
DT_NASCIMENTO = TO_DATE(
    '11/08/2001',
    'dd/mm/yyyy'
),
EMAIL = 'souza_edu@email.com',
NM_USUARIO = 'souza_edu',
SENHA = 'nova-senha' WHERE ID_USUARIO = 1;

-- Cadastrar as receitas do usuário.
INSERT INTO T_SERV_UNICO (
    ID_SERV_UNICO,
    ID_USUARIO,
    ID_CONTA_BANCARIA,
    NM_SERVICO,
    DESC_SERVICO,
    DT_REGISTRO_SERV
    DT_OPERACAO,
    VALOR_OPERACAO,
    A_PAGAR,
    A_RECEBER
) VALUES (
    1,1,1,'Salário', 'Salário mensal', TO_DATE('05/09/2024', 'dd/mm/yyyy'), TO_DATE('05/09/2024','dd/mm/yyyy'), 6600.00, 'N', 'Y'
)

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
    2,1,1,'Conta água', 'Pagamento mensal pela água',TO_DATE('09/09/2024','dd/mm/yyyy'),TO_DATE('10/09/2024','dd/mm/yyyy','mensal',148.91,'Y','Y','N')
)

-- Alterar todos os dados das receitas do usuario.
UPDATE T_SERV_UNICO
SET ID_SERV_UNICO = 100,
    ID_USUARIO = 2,
    ID_CONTA_BANCARIA = 5,
    NM_SERVICO = 'Pagamento por serviço',
    DESC_SERVICO = 'Pagamento por serviço de assistência de computadores',
    DT_REGISTRO_SERV = TO_DATE('01/01/2001','dd/mm/yyyy'),
    DT_OPERACAO = TO_DATE('02/02/2002','dd/mm/yyyy'),
    VALOR_OPERACAO = 215.02,
    A_PAGAR = 'Y',
    A_RECEBER = 'N',
WHERE ID_SERV_UNICO = 1

UPDATE T_SERV_RECORRENTE
SET ID_SERV_UNICO = 195,
    ID_USUARIO = 2,
    ID_CONTA_BANCARIA = 5,
    NM_SERVICO = 'Anuidade cartão de crédito',
    DESC_SERVICO = 'Taxa anual pelo cartão de crédito',
    DT_REGISTRO_SERV = TO_DATE('01/01/2021','dd/mm/yyyy'),
    DT_LIMITE = TO_DATE('31/12/2024','dd/mm/yyyy'),
    FREQUENCIA = 'anual',
    VALOR_OPERACAO = 35.00,
    OPERACAO_EFETUADA = 'N',
    A_PAGAR = 'Y',
    A_RECEBER = 'N'
WHERE ID_SERV_RECORRENTE = 1

-- Cadastrar as despesas do usuário.
INSERT INTO T_SERV_UNICO (
    ID_SERV_UNICO,
    ID_USUARIO,
    ID_CONTA_BANCARIA,
    NM_SERVICO,
    DESC_SERVICO,
    DT_REGISTRO_SERV
    DT_OPERACAO,
    VALOR_OPERACAO,
    A_PAGAR,
    A_RECEBER
) VALUES (
    2,1,1,'Jantar', 'Jantar em restaurante japonês', TO_DATE('10/01/2024','dd/mm/yyyy'), TO_DATE('05/01/2024','dd/mm/yyyy'), 218.13, 'Y', 'N'
)

-- Alterar todos os dados das despesas do usuário.


-- Cadastrar os dados para investimentos.


-- Alterar todos os dados para investimentos do usuario.




-- Consultas

-- Consultar os dados de um usuário (filtrar a partir do seu código).


-- Consultar os dados de um único registro de despesa de um  usuário (filtrar a partir do código do usuário e do código da despesa).


-- Consultar os dados de todos os registros de despesas de um  usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).


-- Consultar os dados de um único registro de investimento de um  usuário (filtrar a partir do código do usuário e do código de investimento).


-- Consultar os dados de todos os registros de investimentos de um  usuário, ordenando-os dos registros mais recentes para os mais antigos (filtrar a partir do seu código).


-- Consultar os dados básicos de um usuário, o último investimento registrado e a última despesa registrada (filtrar a partir do código de usuário – consulta necessária para o dashboard. Dica: veja consulta com junções).