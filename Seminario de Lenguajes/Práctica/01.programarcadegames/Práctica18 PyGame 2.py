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

# Abrir y establecer las dimensiones de una ventana
dimensiones = (640, 480)
pantalla = pygame.display.set_mode(dimensiones)

# Establecer el título de la ventana
pygame.display.set_caption("Primer Game 2017")

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
            hecho = True  # Esto que indica que hemos acabado y sale de este bucle
    # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR ENCIMA DE ESTE COMENTARIO


    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
    # TODA LA LÓGICA DEL JUEGO DEBERÍA IR ENCIMA DE ESTE COMENTARIO


    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR DEBAJO DE ESTE COMENTARIO
    pantalla.fill(NEGRO)
    

    pygame.draw.rect(pantalla, AZUL, [110, 70, 350, 85], 2)
    fuente = pygame.font.Font(None, 45)
    texto = fuente.render("My Game", True, CIAN)
    pantalla.blit(texto, [156, 101])
    fuente = pygame.font.Font(None, 45)
    texto = fuente.render("My Game", True, AZUL)
    pantalla.blit(texto, [155, 100])


    pygame.draw.rect(pantalla, VERDE, [190, 170, 180, 140], 2)
    fuente = pygame.font.Font(None, 35)
    texto = fuente.render("Play", True, BLANCO)
    pantalla.blit(texto, [250, 180])

    fuente = pygame.font.Font(None, 35)
    texto = fuente.render("Options", True, BLANCO)
    pantalla.blit(texto, [230, 220])
    
    fuente = pygame.font.Font(None, 35)
    texto = fuente.render("Exit", True, BLANCO)
    pantalla.blit(texto, [250, 260])


    fuente = pygame.font.Font(None, 30)
    texto = fuente.render("Por Victor Y Juan (°_°)", True, BLANCO)
    pantalla.blit(texto, [180, 420])


    pygame.display.flip()
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
    reloj.tick(60)
pygame.quit()







    
