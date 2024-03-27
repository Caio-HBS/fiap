# Tabela onde o número de parcelas são chaves e a porcentagem de juros os valores.
TABELA_JUROS = {
    1: 0,
    3: 10,
    6: 15,
    9: 20,
    12: 25
}

# Garante que o dado fornecido pelo usuário é válido.
while True:
    valor_divida = input("Digite o valor da dívida: ")
    try:
        valor_divida = float(valor_divida)
        break
    except:
        print("AVISO: Apenas números.")
        continue

# Executa as computações e monta a tabela.
for i in range(len(TABELA_JUROS)):
    num_parcelas = list(TABELA_JUROS.keys())[i]
    juros = valor_divida * (list(TABELA_JUROS.values())[i]/100)
    total = valor_divida + juros
    valor_parcela = total/num_parcelas
    
    print(f"Total: R${total:,.2f}|Juros: R${juros:,.2f}|Número de parcelas: {num_parcelas}|Valor da parcela: R${valor_parcela:,.2f}")
