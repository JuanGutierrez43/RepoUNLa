''' inicio de la aplicación '''
# Importamos las bibliotecas llamadas 'pygame' y 'random'.
import pygame
import random
import math

''' constante '''
# Definimos algunos colores
NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
AMARILLO = (255, 255, 0)
CIAN = (0,255,255)
AZUL   = (0,   0,   255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)
MARRON = (121,  85,  61)

''' Funciones '''
def dibujar_arbol(pantalla, x, y):
    pygame.draw.rect(pantalla, MARRON, [60+x, 170+y, 30, 45])
    pygame.draw.polygon(pantalla, VERDE, [[150+x,170+y],[75+x,20+y], [x,170+y]])
    pygame.draw.polygon(pantalla, VERDE, [[140+x,120+y], [75+x,y], [10+x,120+y]])

''' inicio de la aplicación '''
def main():
    """ Función principal del juego. """
    # Inicializamos el motor de juegos.
    pygame.init()

    # Establecer las dimensiones de una ventana
    dimensiones = (700, 500)
    pantalla = pygame.display.set_mode(dimensiones)
    # Establecer el título de la ventana
    pygame.display.set_caption("Funcion")
    # Iteramos hasta que el usuario haga click sobre le botón de salida.
    hecho = False
    # Se usa para establecer cuan rápido se actualiza la pantalla
    reloj = pygame.time.Clock()
    # -------- Bucle principal del Programa -----------
    while not hecho:
        # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR DEBAJO DE ESTE COMENTARIO
        for evento in pygame.event.get(): # El usuario hizo algo
            if evento.type == pygame.QUIT: # Si el usuario pincha sobre cerrar
                hecho = True # Esto que indica que hemos acabado y sale de este bucle
            elif evento.type == pygame.KEYDOWN:
                print("El usuario presionó una tecla.")
            elif evento.type == pygame.KEYUP:
                print("El usuario soltó una tecla.")
            elif evento.type == pygame.MOUSEBUTTONDOWN:
                print("El usuario presionó un botón del ratón")
        # --- LA LÓGICA DEL JUEGO DEBERÍA IR AQUÍ
        ''' mi código general '''
        # --- EL CÓDIGO DE DIBUJO DEBERÍA IR AQUÍ
        pantalla.fill(BLANCO)
        ''' mi código para gráficos '''
        dibujar_arbol(pantalla,0,230)
        dibujar_arbol(pantalla,100,230)


        
        # --- Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
        pygame.display.flip()
        # --- Limitamos a 60 fotogramas por segundo (frames per second)
        reloj.tick(60)
    # Cerramos la ventana y salimos.
    pygame.quit()


if __name__ == "__main__":
    main()
    
