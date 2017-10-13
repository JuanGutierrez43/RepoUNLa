"""
Este es un simple juego de texto para mostrar el uso de funciones.
El juego se llama "BolaDeBarro", donde los jugadores, por turnos, se
lanzan bolas de barro unos contra otros, hasta que alguien es alcanzado.
"""
 
import math
import random
 
def imprimir_instrucciones():
    """ Esta función imprimirá las instrucciones. """
     
    # En una declaración print, puedes usar comillas triples para
    # imprimir varias líneas.
    print("""
Bienvenido a Bolas de Barro! El objetivo es darle al otro jugador con una bola de barro.
Introduce el ángulo (en grados) y la presión en PSI para cargar tu arma.
        """)
 
def calcular_distancia(psi, angulo_en_grados):
    """ Calcula la distancia que vuela la bola de barro. """
    angulo_en_radianes = math.radians(angulo_en_grados)
    distancia = psi * math.sin(angulo_en_radianes) * 15
    return distancia
 
def obtener_datosdel_usuario(nombre):
    """ Obtiene del usuario los valores para la presión y el ángulo. Lo devuelve como una lista con dos 
    números. """
    # Más adelante, en el capítulo sobre 'excepciones', aprenderemos como
    # modificar este código para que no se cuelgue cuando el usuario escriba
    # algo que no sea un número válido.
     
    psi = float(input(nombre + " ¿con cuántos psi cargamos el arma? "))
    angulo = float(input(nombre + " ¿con qué ángulo quieres apuntar el arma? "))
    return psi, angulo
 
def obtener_nombres_jugadores():
    """ Obtenemos una lista con los nombres de los jugadores. """
    print("Introduce los nombres de los jugadores. Puedes introducir cuantos quieras.")
    hecho = False
    jugadores = []
    while not hecho:
        jugador = input("Introducir jugador (presiona intro para salir): ")
        if len(jugador) > 0:
            jugadores.append(jugador)
        else:
            hecho = True
             
    print()    
    return jugadores
             
def procesa_turno_jugador(jugador_nombre, distancia_aparte):
    """ El código ejecuta el turno para cada jugador.
    Si devuelve False, continuamos con el juego.
    Si devuelve True, alguien ha ganado así que paramos. """
    psi, angulo = entrada_usuario = obtener_datosdel_usuario(jugador_nombre)            
 
    distancia_boladebarro = calcular_distancia(psi, angulo)
    diferencia = distancia_boladebarro - distancia_aparte
     
    # Si echamos un vistazo al capítulo de formatos de impresión, estas líneas
    # podrían imprimir números en un bonito formato.
     
    if diferencia > 1:
        print("Ha caído", diferencia, "metros muy lejos!")
    elif diferencia < -1:
        print("Te has quedado", diferencia * -1, "metros corto!")
    else:
        print("Bingo!", jugador_nombre, "gana!")
        return True
     
    print()
    return False
 
def main():
    """ Programa Principal. """
     
    # Comenzamos el juego.
    imprimir_instrucciones()
    jugador_nombres = obtener_nombres_jugadores()
    distancia_aparte = random.randrange(50, 150)
     
    # Se mantiene alerta hasta que alguien gana
    hecho = False
    while not hecho:
        # Iteramos para cada jugador
        for jugador_nombre in jugador_nombres:
            # Procesamos sus turnos
            hecho = procesa_turno_jugador(jugador_nombre, distancia_aparte)
            # Si alguien gana, 'rompemos' el bucle y finalizamos el juego.
            if hecho:
                break
             
if __name__ == "__main__":
    main()
