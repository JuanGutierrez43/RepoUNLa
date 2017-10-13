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
def dibujar_hombredenieve(pantalla, x, y):
    # Dibuja un círculo para la cabeza
    pygame.draw.ellipse(pantalla,BLANCO, [35 + x, y, 25, 25])
    # Dibuja un círculo para la parte central del hombre
    pygame.draw.ellipse( pantalla,BLANCO, [23 + x, 20 + y, 50, 50])
    # Dibuja un círculo para la parte baja del hombre
    pygame.draw.ellipse( pantalla,BLANCO, [x, 65 + y, 100, 100])
def dibuja_hombrepalitos(pantalla, x, y):
    # Cabeza
    pygame.draw.ellipse(pantalla, NEGRO, [1 + x, y, 10, 10], 0)
    # Piernas
    pygame.draw.line(pantalla, NEGRO ,[5 + x, 17 + y], [10 + x, 27 + y], 2)
    pygame.draw.line(pantalla, NEGRO, [5+ x, 17 + y], [x, 27 + y], 2)
    # Cuerpo
    pygame.draw.line(pantalla, ROJO, [5 + x, 17 + y], [5 + x, 7 + y], 2)
    # Brazos
    pygame.draw.line(pantalla, ROJO, [5 + x, 7 + y], [9 + x, 17 + y], 2)
    pygame.draw.line(pantalla, ROJO, [5 + x, 7 + y], [1 + x, 17 + y], 2)
    
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
                print("El usuario presionó un botón del ratón",pos)
            
        # --- LA LÓGICA DEL JUEGO DEBERÍA IR AQUÍ
        ''' mi código general '''
        # coordenadas del raton
        pos = pygame.mouse.get_pos()
        x = pos[0]
        y = pos[1]
        # Ocultar el cursor del ratón
        pygame.mouse.set_visible(False)
        
        # --- EL CÓDIGO DE DIBUJO DEBERÍA IR AQUÍ
        pantalla.fill(BLANCO)
        ''' mi código para gráficos '''
        dibuja_hombrepalitos(pantalla,x,y)

                
        # --- Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
        pygame.display.flip()
        # --- Limitamos a 60 fotogramas por segundo (frames per second)
        reloj.tick(60)
    # Cerramos la ventana y salimos.
    pygame.quit()


if __name__ == "__main__":
    main()
    
