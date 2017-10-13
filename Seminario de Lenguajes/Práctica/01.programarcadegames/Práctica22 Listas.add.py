'''--------------------'''
''' Añadir a una Lista '''


''' funcion append '''
mi_lista = [2, 4, 5, 6]
print(mi_lista)
mi_lista.append(9)
print(mi_lista)


''' funcion por teclado '''
#mi_lista = [] # Lista vacía
#for i in range(5):
#    entrada_usuario = input("Introducir un número entero: ")
##    entrada_usuario = int(entrada_usuario)
#    mi_lista.append(entrada_usuario)
#    print(mi_lista)


''' Crear un array de 100 de ceros.  '''
mi_lista = [0] * 100
print(mi_lista)


''' Suma acumulada de los valores de una lista v1 '''
# Copia de un array a una suma
mi_lista = [5, 76, 8, 5, 3, 3, 56, 5, 23]
 
# La suma inicial debería ser cero
total_lista = 0
 
# Itera desde 0 hasta el total del número de elementos
# en el array:
for i in range(len(mi_lista)):
    # Añade el elemento 0, después el 1, luego el 2, etc.
    total_lista += mi_lista[i]
     
# Imprime el resultado
print(total_lista)


''' Duplicando todos los números en una lista '''
# Copia del array a modificar
mi_lista = [5, 76, 8, 5, 3, 3, 56, 5, 23]
 
# Itera desde 0 hasta el total del número de elementos en el array:
for i in range(len(mi_lista)):
    # Modifica el elemento duplicándolo
    mi_lista[i] = mi_lista[i] * 2
    
# Imprime el resultado
print(mi_lista)


x = "Esta es una cadena de ejemplo"
#x = "0123456789"
 
print("x=", x)
 
# Acceso a un carácter individual
print("x[0] = ", x[0])
print("x[1] = ", x[1])
 
# Acceso desde la derecha
print("x[-1] = ", x[-1])
 
# Acceso 0 - 5
print("x[:6] = ", x[:6])
# Acceso 6
print("x[6:] = ", x[6:])
# Acceso 6 - 8
print("x[6:9] = ", x[6:9])

