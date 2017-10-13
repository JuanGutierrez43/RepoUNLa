''' Constante '''
pi = 3.141592653589

''' Procedimientos ''' 
def volumen_esfera(radio):
    """Devuelve el volumen de una esfera, conocidos su radio."""
    volumen = (4 / 3) * pi * radio ** 3
    return volumen
def volumen_cilindro(radio, altura):
    """Devuelve el volumen de un cilindro, conocidos su radio y altura."""
    volumen = pi * radio ** 2 * altura
    return volumen
def suma_dos_numeros(a, b):
    """Devuelve la suma de dos numeros."""
    resultado = a + b
    return resultado
def calcular_promedio(a, b):
    """ Calcula el promedio de dos números usando la función de suma"""
    resultado = suma_dos_numeros(a,b) / 2
    return resultado
def imprimir_instrucciones():
    print("Bienvenido a la Batalla del Barro! El objetivo es darle al otro jugado con una bola de barro.")
    print("Introduce el ángulo (en grados) y la cantidad de PSI para cargar tu arma")
def retornar_dual(x, y):
    """ Retorna dos valores """
    x = x + 1
    y = y + 1
    return x, y


''' inicio de la aplicación '''
def main():
    print("Hola mundo.")
    print("El volumen de la esfera es:", volumen_esfera(22))
    print("El volumen del cilindro es:", volumen_cilindro(12, 3))
    # Almacenamos el resultado de la función en un variable
    mi_resultado = suma_dos_numeros(22, 15)
    print("La suma es:",mi_resultado)
    # Imagina que aquí hay algo de código
    x = 45
    y = 56
    promedio = calcular_promedio(x, y)
    print("El promedio de",x,"y",y,"es:",promedio)
    x = 10
    y = 20
    z1,z2 = retornar_dual(x, y)
    print("Retornar dual:",z1,"y",z2)
# sirve para llamar a la función cuendo lo use
if __name__ == "__main__":
    main()
