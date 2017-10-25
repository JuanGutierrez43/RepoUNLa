print("Tu nueva puntuación es ",1030 + 10)
print("Quiero imprimir comillas dobles \" por alguna razón.")
print("El archivo está guardado en C:\\nueva carpeta")

# Esto es un comentario que comienza con el signo #  y
# y el compilador lo ignorará.
print("Hola") # Esto es un comentario al final de una línea
'''
comentario
docstrings
'''
print("Hecho")

x = 5
print(x) # Imprime 5
x -= 1 
print(x) # Imprime 6

#constante
MAX_VELOCIDAD = 100
'''
bien nombrado
'''
print(MAX_VELOCIDAD)
maxPuntos=0
'''
mal nombrado
'''
a = 10 // 3
print (a)


# Esto funciona
y=1
'''
mal tipeado, dejar espacio
'''
x = 5 * y
x = 5 * (3 / 2)

media = (90 + 86 + 71 + 100 + 98) / 5
print("media=",media)

# Importar la biblioteca math
# Esta linea se usa una sola vez y al principio del
# del programa.

from math import *

x = sin(0) + cos(0)
print(x)

'''
mejor se entiende ->
'''
millas_recorridas = 294
galones_usados = 10.5
mpg = millas_recorridas / galones_usados  # Aquí empleamos variables
print(mpg)

