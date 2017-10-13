''' Dividir Cadenas de Texto '''

''' Acceder a una cadena de texto como una lista '''
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

''' Añadiendo y multiplicando cadenas de texto '''
a = "Hola"
b = "Qué tal"
c = "!"
print(a + b)
print(a + b + c)
print(3 * a)
print(a * 3)
print((a * 2) + (b * 2))

''' Obtener la longitud de una cadena o de una lista '''
a = "Hola, qué tal"
print(len(a))
 
b = [3, 4, 5, 6, 76, 4, 3, 3]
print(len(b))

for caracter in "Esto es una prueba":
    print (caracter)

''' Imprime la abreviatura '''
meses = "EneFebMarAbrMayJunJulAgoSepOctNovDic"
n = int(input("Introduce un número de mes: "))
print (meses[(n-1)*3]+meses[(n-1)*3+1]+meses[(n-1)*3+2])

