# Dicionário com os dias válidos e o número de votos como valores.
dias_da_semana = {
    "segunda-feira": 0,
    "terça-feira": 0,
    "quarta-feira": 0,
    "quinta-feira": 0,
    "sexta-feira": 0
}

# Pega a quantidade de colaboladores que irão votar e garante que é um número.
while True:
    num_colaboradores = input("Quantos colaboradores estão participando da votação?\n")
    try:
        num_colaboradores = int(num_colaboradores)
        break
    except:
        print("\nAVISO: Apenas números.")
        continue

# Pergunta a cada colaborador o dia que prefere e guarda o voto no dicionário.
for colaborador in range(num_colaboradores):
    while True:
        dia_escolhido = input("Qual DIA DA SEMANA seria o melhor para as lives?\n").strip().lower()
        if dia_escolhido in dias_da_semana.keys():
            dias_da_semana[dia_escolhido] += 1
            break
        else:
            print("\nAVISO: Dia inválido. Ex: segunda-feira.")
            continue

# Lida com casos onde a votação resulta num empate.
contagem = 0
maior_num_votos = max(dias_da_semana.values())
for value in dias_da_semana.values():
    if value == maior_num_votos:
        contagem += 1
        if contagem >= 2:
            print("\nAVISO: A votação terminou num empate.")
            exit()

# Conta os votos e dá o resultado.
num_votos = None
for dia, voto in dias_da_semana.items():
    if num_votos is None or voto > num_votos:
        num_votos = voto
        dia_vencedor = dia

print(f"\n\nA vencedora da votação é a {dia_vencedor.upper()}, com {num_votos} votos!")
