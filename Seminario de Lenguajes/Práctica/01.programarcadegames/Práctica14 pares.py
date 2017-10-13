# formas de imprimit los numeros pares del 2 al 10

for i in range(2,12,2):
    print(i)
for y in range(5):
    print((y+1)*2)
for n in range(1,11):
    if(n%2) == 0:
        print(n)

# Cuenta atrás desde 10 hasta 1

for i in range (10, 0, -1):
    print(i)

# Imprimte números de una lista

for i in [2,6,4,2,4,6,7,4]:
    print(i)

# ¿Qué es lo que esto imprime? ¿Por qué?

#for i in range(3):
#    print ("a")
#for j in range(3):
#    print ("b")

# ¿Qué es lo que esto imprime? ¿Por qué?

for i in range(3):
    print("a")
    for j in range(3):
        print("b")
 
print("Hecho")
