idade = int(input("Qual é a sua idade atual?\n"))
bpm_atual = int(input("Qual é o seu número de batimentos por minuto(BPM) atual?\n"))

if idade > 0 and idade <= 2:
    if bpm_atual >= 120 and bpm_atual <= 140:
        print("\nSeus batimentos cardíacos estão adequados.")
    else:
        print("\nSeus batimentos não estão adequados.")
    exit

elif idade > 2 and idade < 8:
    if bpm_atual >= 80 and bpm_atual <= 100:
        print("\nSeus batimentos cardíacos estão adequados.")
    else:
        print("\nSeus batimentos não estão adequados.")
    exit

elif idade >= 8 and idade <= 17:
    if bpm_atual >= 75 and bpm_atual <= 120:
        print("\nSeus batimentos cardíacos estão adequados.")
    else:
        print("\nSeus batimentos não estão adequados.")
    exit

elif idade > 17 and idade <= 50:
    if bpm_atual >= 70 and bpm_atual <= 80:
        print("\nSeus batimentos cardíacos estão adequados.")
    else:
        print("\nSeus batimentos não estão adequados.")
    exit

elif idade > 50:
    if bpm_atual >= 50 and bpm_atual <= 60:
        print("\nSeus batimentos cardíacos estão adequados.")
    else:
        print("\nSeus batimentos não estão adequados.")
    exit


