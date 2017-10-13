''' inicio de la aplicación '''

# Importa  la libraría de funciones llamada 'pygame'
import pygame
import math

# Inicializa el motor de juegos
pygame.init()

# Definir algunos colores
'''constante'''
NEGRO  = (  0,   0,   0)
BLANCO = (255, 255, 255)
AMARILLO = (255, 255, 0)
CIAN = (0,255,255)
AZUL   = (0,   0,   255)
VERDE  = (0,   255,   0)
ROJO   = (255,   0,   0)

PI = 3.141592653

# Abrir y establecer las dimensiones de una ventana
dimensiones = (400, 400)
pantalla = pygame.display.set_mode(dimensiones)

# Establecer el título de la ventana
pygame.display.set_caption("GameofThrones")


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

    
    #modulo top
    pygame.draw.line(pantalla, AMARILLO, [100, 110], [100, 60], 10)# |
    pygame.draw.polygon(pantalla, ROJO, [[100, 100],[0, 200],[200, 200]], 0)
    #modulo alas
    pygame.draw.line(pantalla, CIAN, [125, 225], [200, 300], 30)# |
    pygame.draw.line(pantalla, CIAN, [125, 225+30], [200, 300+30], 30)# |
    pygame.draw.line(pantalla, CIAN, [200, 300], [200, 300+30], 30)# |
    pygame.draw.line(pantalla, CIAN, [75, 225], [0, 300], 30)# |
    pygame.draw.line(pantalla, CIAN, [75, 225+30], [0, 300+30], 30)# |
    pygame.draw.line(pantalla, CIAN, [0, 300], [0, 300+30], 30)# |
    #modulo Medio
    pygame.draw.rect(pantalla, CIAN, pygame.Rect((75, 200, 50, 150)), 0)
    pygame.draw.rect(pantalla, NEGRO, pygame.Rect((85, 201, 25, 145)), 0)
    #modulo alas
    #pygame.draw.rect(pantalla, BLANCO, pygame.Rect((175, 225, 35, 150)), 0)
    #pygame.draw.rect(pantalla, CIAN, pygame.Rect((185, 235, 20, 120)), 0)

    
    # --- Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
    pygame.display.flip()
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
    # --- Limitamos a 60 fotogramas por segundo (frames per second)
    reloj.tick(60)
    
#Cierre correcto de un programa Pygame
pygame.quit()
