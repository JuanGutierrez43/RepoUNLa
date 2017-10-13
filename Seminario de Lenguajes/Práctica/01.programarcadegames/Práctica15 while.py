# Bucles While

print ("Suma ")
i = 0
while i < 10:
    print (i)
    '''i = i + 1'''
    i += 1
'''
La función range solo funciona con los bucles for.
No vayas a usarla con un bucle while!
'''
print ("producto ")
i = 1
while i < 10:
    print (i)
    '''i = i * 2'''
    i *= 2

# El Usuario quiere salir
salir = "n"
while salir.lower() == "n":
    salir = input ("¿Quieres salir? ")

