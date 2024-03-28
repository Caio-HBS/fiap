# Dicionário com a quantidade de parcelas como chaves e a porcentagem de acréscimo
# como valores.
ACRESCIMO_PRECO_FINAL = {
    6: 3, 
    12: 6, 
    18: 9, 
    24: 12, 
    30: 15, 
    36: 18, 
    42: 21, 
    48: 24, 
    54: 27, 
    60: 30
}

# Garante que o usuário digite um número válido no programa.
while True:
    preco_carro = input("\nDigite o preço do carro (somente números): ")
    if preco_carro.isnumeric():
        preco_carro = abs(float(preco_carro))
        break
    else:
        continue

print(f"O preço final à vista com desconto de 20% é de R${0.2 * preco_carro}")

for num_parcelas, porcentagem in ACRESCIMO_PRECO_FINAL.items():
    preco_final = preco_carro + (preco_carro * (porcentagem/100))
    preco_parcelas = preco_final/num_parcelas
    print(f"O preço final parcelado em {num_parcelas}x é de R${preco_final} com parcelas de R${preco_parcelas:.2f}")
