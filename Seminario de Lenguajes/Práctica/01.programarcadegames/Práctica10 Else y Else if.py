
temperatura = int(input("¿Cuál es la temperatura en Fahrenheit? "))
if temperatura > 90 and temperatura < 111:
    print("Hace calor fuera")
elif temperatura > 110:
    print("¡Caramba, casi podemos freír un huevo sobre el asfalto!")
elif temperatura < 30:
    print("Hace frío fuera")
else:
    print("Si está bien afuera")

