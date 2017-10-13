# Iteración hasta acabar el juego o hasta recibir una petición de salida.

hecho = False
while not hecho:
    salir = input ("¿Quieres salir? ")
    if salir == "y" :
        hecho = True;
    else:
        ataque = input ("Es que tu elfo ha atacado al dragón? ")
        if ataque == "y":
            print ("Pésima opción, estás muerto.")
            hecho = True;

# Iteración hasta alcanzar 1

valor = 0
incremento = 0.5
while valor < 0.999:
    valor += incremento
    incremento *= 0.5
    print(valor)

# cuenta atrás desde 10.

i = 10
while i > 0:
    print (i)
    i -= 1
