''' inicio de la aplicación '''

# Importa  la libraría de funciones llamada 'pygame'
import pygame
import math
import random

from pygame.locals import*

''' clases '''
from Pantalla import *
from Colores import *

#Inciamos el "mixer"
pygame.mixer.init()

# Inicializa el motor de juegos
pygame.init()

# Abrir y establecer las dimensiones de una ventana

LARGO_PANTALLA  = 700
ALTO_PANTALLA = 500
screen_resolution = Pantalla(LARGO_PANTALLA,ALTO_PANTALLA) # clase pantalla
dimensiones = [LARGO_PANTALLA, ALTO_PANTALLA]
pantalla = pygame.display.set_mode(dimensiones)

# Establecer el título de la ventana
pygame.display.set_caption("Espacio")

''' inicio del programa '''

#Itera hasta que el usuario pincha sobre el botón de cierre.
hecho = False

# Se usa para gestionar cuan rápido se actualiza la pantalla
reloj = pygame.time.Clock()
 
# -------- Bucle Principal del Programa -----------
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

    # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR ENCIMA DE ESTE COMENTARIO
 
 
    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
 
    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
 
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
    # --- Primero, limpia la pantalla con blanco. No vayas a poner otros comandos de dibujo encima 
    # de esto, de otra forma serán borrados por este comando:
    pantalla.fill(NEGRO)

    
    #Estrella
    
    x=random.randrange(screen_resolution.LARGO_PANTALLA/2)
    y=random.randrange(screen_resolution.ALTO_PANTALLA/2)
    z=random.randrange(screen_resolution.LARGO_PANTALLA/2)
    e=random.randrange(screen_resolution.ALTO_PANTALLA/2)

    #Estrella dinámicas
    pygame.draw.line(pantalla, CIAN, [8*x, 8*y], [8*x, 8*y], random.randrange(3))# *
    pygame.draw.line(pantalla, BLANCO, [2*z, 2*x], [2*z, 2*x], random.randrange(5))# *
    pygame.draw.line(pantalla, CIAN, [3*e, 3*z], [3*e, 3*z], random.randrange(3))# *
    pygame.draw.line(pantalla, BLANCO, [4*e, 4*z], [4*e, 4*z], random.randrange(5))# *
    pygame.draw.line(pantalla, BLANCO, [5*e, 5*z], [5*e, 5*z], random.randrange(5))# *
    pygame.draw.line(pantalla, CIAN, [7*z, 7*x], [7*z, 7*x], random.randrange(3))# *
    #Estrella estáticas
    a=screen_resolution.LARGO_PANTALLA/2
    b=screen_resolution.ALTO_PANTALLA/3
    pygame.draw.line(pantalla, BLANCO, [a, b], [a, b], 1+random.randrange(3))# *
    a=a/2
    pygame.draw.line(pantalla, BLANCO, [a, b], [a, b], 1+random.randrange(2))# *
    b=b/3
    pygame.draw.line(pantalla, BLANCO, [a, b], [a, b], 1+random.randrange(3))# *
    a=a/5
    pygame.draw.line(pantalla, BLANCO, [a, b], [a, b], 1+random.randrange(2))# *
    a=a*7
    b=b*5
    pygame.draw.line(pantalla, BLANCO, [a, b], [a, b], 1+random.randrange(2))# *
    a=a*2
    b=b+100
    pygame.draw.line(pantalla, CIAN, [a, b], [a, b+2], 1+random.randrange(5))# *

    # --- Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
    pygame.display.flip()
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
    # --- Limitamos a 60 fotogramas por segundo (frames per second)
    reloj.tick(3)
    
#Cierre correcto de un programa Pygame
pygame.quit()
