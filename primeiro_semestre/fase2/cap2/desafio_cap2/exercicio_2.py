CATEGORIAS_VALIDAS_ASSENTOS = ["economico", "executivo", "primeira classe"]

num_viajantes = int(input("Qual é a quantidade de pessoas que viajarão?\n"))
assentos = input("\nEm qual categoria de assentos eles têm interesse em viajar? (Economico, Executivo ou Primeira classe)\n")

if assentos.lower() not in CATEGORIAS_VALIDAS_ASSENTOS:
    print("\nERRO: Esse não é um tipo válido de assento.")
    exit()

valor_bruto = int(input("\nQual é o valor bruto do pacote?\n"))


if assentos == CATEGORIAS_VALIDAS_ASSENTOS[0]:
    if num_viajantes == 2:
        desconto = valor_bruto * 0.03
    elif num_viajantes == 3:
        desconto = valor_bruto * 0.04
    elif num_viajantes >= 4:
        desconto = valor_bruto * 0.05

elif assentos == CATEGORIAS_VALIDAS_ASSENTOS[1]:
    if num_viajantes == 2:
        desconto = valor_bruto * 0.05
    elif num_viajantes == 3:
        desconto = valor_bruto * 0.07
    elif num_viajantes >= 4:
        desconto = valor_bruto * 0.08

elif assentos == CATEGORIAS_VALIDAS_ASSENTOS[2]:
    if num_viajantes == 2:
        desconto = valor_bruto * 0.10
    elif num_viajantes == 3:
        desconto = valor_bruto * 0.15
    elif num_viajantes >= 4:
        desconto = valor_bruto * 0.20

else:
    print("\nERRO: Algo deu errado. :(")
    exit()

liquido = valor_bruto - desconto
media_por_viajante = liquido/num_viajantes

print("\n" +
f"""
###########################################

Valor BRUTO do pacote: R${float(valor_bruto)}
Valor do DESCONTO: R${desconto}
Valor LÍQUIDO da viagem: R${liquido}
Valor MÉDIO por viajante: R${media_por_viajante:.2f}

###########################################
"""
)