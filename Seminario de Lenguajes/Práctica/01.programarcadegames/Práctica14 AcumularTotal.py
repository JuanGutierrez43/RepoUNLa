# Mantener un total acumulado

total = 0
for i in range (5):
    nuevo_numero = int(input("Introduce un número -> "))
    total += nuevo_numero
print("El total es: ", total)

# suma = (100) Σ (n=1) -> n
total = 0
for i in range (20):
    print("parcial total es: ", total)
    total+=i
print("El total es: ", total)

