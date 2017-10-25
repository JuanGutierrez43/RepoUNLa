# Triángulo de números
x = 10
y = 11
for i in range(y):

    for k in range(x-i,0,-1):
        print(" ", end=" ")
    for j in range(1,i):
        print(j, end=" ")
    for k in range(i-2,0,-1):
        print(k, end=" ")

    print("")
print("")


# Triángulo de números
x = 10
y = 10
for i in range(y):

    for k in range(x-i,0,-1):
        print(" ", end=" ")
    for j in range(1,i+1):
        print(j, end=" ")
    for k in range(i-1,0,-1):
        print(k, end=" ")

    print("")
print("")


# Triángulo de números 1 caras + 1/2
x = 10
y = 10
for i in range(y):

    for k in range(x-i,0,-1):
        print(" ", end=" ")
    for j in range(1,i+1):
        print(j, end=" ")
    for k in range(i-1,0,-1):
        print(k, end=" ")
    print("")

for i in range(y):
    for k in range(i+2):
        print(" ", end=" ")
    for j in range(1,x-i-1):
        print(j, end=" ")

    print("")
print("")

# Triángulo de números dos caras
x = 10
y = 10
for i in range(y):

    for k in range(x-i,0,-1):
        print(" ", end=" ")
    for j in range(1,i+1):
        print(j, end=" ")
    for k in range(i-1,0,-1):
        print(k, end=" ")
    print("")

for i in range(y):
    for k in range(i+2):
        print(" ", end=" ")
    for j in range(1,x-i-1):
        print(j, end=" ")
    for k in range(x-i-3,0,-1):
        print(k, end=" ")
    print("")
print("")

