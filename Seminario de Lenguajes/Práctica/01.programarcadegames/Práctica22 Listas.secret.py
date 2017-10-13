''' Unicode '''

texto_llano = "Esto es una prueba. ABC abc"
for c in texto_llano:
    print (c, end=" ")

''' valor UTF-8 '''
texto_llano = "Esto es una prueba. ABC abc"
for c in texto_llano:
    print (ord(c), end=" ")

''' modifico el valor UTF-8 '''
texto_plano = "Esto es una prueba. ABC abc"
texto_cifrado = ""
for c in texto_plano:
    x = ord(c)
    x = x + 1
    c2 = chr(x)
    texto_cifrado = texto_cifrado + c2
print(texto_cifrado)

''' modifico el valor UTF-8 '''
texto_cifrado = "Ftup!ft!vob!qsvfcb/!BCD!bcd"
texto_plano= ""
for c in texto_cifrado:
    x = ord(c)
    x = x - 1
    c2 = chr(x)
    texto_plano = texto_plano + c2
print(texto_plano)
