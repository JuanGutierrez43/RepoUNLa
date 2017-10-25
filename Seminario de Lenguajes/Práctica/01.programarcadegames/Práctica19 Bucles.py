i = 0
print(i, end=" ")
i = 1
print(i, end=" ")

print("Pulpo", end=" ")
print("Rosa")

x = 10
for i in range(x):
    print("*", end=" ")
print("")
print("")

x = [10,5,20]
for i in range(3):
    for j in range(x[i]):
        print("*", end=" ")
    print("")
print("")

x = 10
for i in range(x):
    for j in range(x):
        print("*", end=" ")
    print("")
print("")

x = 5
y = 10
for i in range(y):
    for j in range(x):
        print("*", end=" ")
    print("")
print("")

x = 20
y = 5
for i in range(y):
    for j in range(x):
        print("*", end=" ")
    print("")
print("")

# muestra matriz de numeros 0-9
x = 10
y = 10
for i in range(y):
    for j in range(x):
        print(j, end=" ")
    print("")
print("")

# muestra matriz de numeros triangulo izq
x = 10
y = 11
for i in range(y):
    for j in range(i):
        print(j, end=" ")
    print("")
print("")

# muestra matriz de numeros triangulo derc
x = 10
y = 11
for i in range(y):
    for k in range(i):
        print(" ",end=" ")
    for j in range(x-i):
        print(j, end=" ")
    print("")
print("")

# muestra matriz de numeros triangulo izq
x = 10
y = 11
for i in range(y):
    for j in range(x-i):
        print(j, end=" ")
    for k in range(i):
        print(" ",end=" ")
    print("")
print("")

# muestra matriz de numeros x*y
x = 10
y = 10
for i in range(1,y):
    for j in range(1,x):
        if j*i < 10:
            print("  ",j*i, end="")
        else:
            print(" ",j*i, end="")
    print("")
print("")
