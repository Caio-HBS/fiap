# Coleta e checagem do tipo de investimento.
while True:
    tipo_investimento = input(
        "Qual é o tipo de investimento? (1 para CDB, 2 para LCI e 3 para LCA)\n"
    )
    if tipo_investimento.isnumeric():
        tipo_investimento = int(tipo_investimento)
        if tipo_investimento > 0 and tipo_investimento < 4:
            # Investimento possui isenção de IR, portanto, informa o usuário e
            # para a execução.
            if tipo_investimento != 1:
                print("\nEsse tipo de investimento é isento de imposto de renda.")
                exit()
            else:
                break
        # Checagens no input para previnir erros.
        else:
            print("\nAVISO: Digite um número de 1 a 3.")
            continue
    else:
        print("\nAVISO: Somente números.")
        continue


# Coleta e checagem do valor a ser resgatado.
while True:
    valor_resgatado = input("Qual é o valor a ser resgatado?\n")
    try:
        valor_resgatado = abs(int(valor_resgatado))
        break
    except:
        print("AVISO: Apenas números")
        continue


# Coleta e checagem do período de tempo.
while True:
    periodo_tempo = input("Qual foi o período de tempo da aplicação em dias?\n")
    try:
        periodo_tempo = abs(int(periodo_tempo))
        break
    except:
        print("AVISO: Apenas números.")
        continue


# Aplicação das porcentagens da alíquota baseado no período do investimento.
valor_ir = 0
if periodo_tempo >= 181 and periodo_tempo <= 360:
    aliquota_ir = 0.20
elif periodo_tempo >= 361 and periodo_tempo <= 720:
    aliquota_ir = 0.175
elif periodo_tempo > 720:
    aliquota_ir = 0.15
else:
    aliquota_ir = None


# Cálculo da alíquota.
if aliquota_ir is not None:
    valor_ir = valor_resgatado * aliquota_ir


print(
    f"\nValor do Imposto de Renda: R${valor_ir}|Valor a ser resgatado: R${valor_resgatado}|Período de tempo investido: {periodo_tempo} dias"
)
