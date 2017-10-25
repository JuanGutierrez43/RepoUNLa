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
dimensiones = (700, 500)
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
    pantalla.fill(BLANCO)
    '''mi código para gráficos'''

    # rectangulo
    pygame.draw.rect(pantalla, ROJO, [50, 50, 50, 25], 2)
    pygame.draw.rect(pantalla, NEGRO, [20, 20, 250, 100], 2)
    
    # triangulo
    pygame.draw.line(pantalla, NEGRO, [10, 100], [100, 100], 3)
    pygame.draw.line(pantalla, NEGRO, [10, 100], [10, 10], 3)
    pygame.draw.line(pantalla, NEGRO, [100, 100], [10, 10], 3)
    #Desplazar recta
    desplazar_y = 0
    while  desplazar_y < 100:
        pygame.draw.line(pantalla, ROJO, [150, 10 + desplazar_y], [200 + desplazar_y, 110 + desplazar_y], 3)
        desplazar_y = desplazar_y + 10
    #Coseno
    for i in range(200):

        radianes_x = i / 20
        radianes_y = i / 6
     
        x = int( 75 * math.sin(radianes_x)) + 100
        y = int( 75 * math.cos(radianes_y)) + 200
        
        pygame.draw.line(pantalla, NEGRO, [x, y], [x + 5, y], 5)

    #Campana
    y = 0
    x = 0
    a = -100
    b = ((a * a) + (2 * a) - 1)
    for i in range(-100 ,200 ,1):
        x = i
        y = ((x * x) + (2 * x) - 1) 
        pygame.draw.line(pantalla, AZUL, [x+100, y+350], [a+100, b+350], 3)
        a = x
        b = y
    #Circulo FEO
    y = 1
    x = 1
    a = 1
    b = 1
    c = 1
    for i in range(-400 ,400 ,1):
        x = i
        
        for j in range(-400 ,400 ,1):
            y = j
            c = (x )** 2 + (y )** 2
            if c == 400:
                pygame.draw.line(pantalla, CIAN, [x+200, y+350], [a+200, b+350], 3)
                a = y
            b = x

    # Elipse
    pygame.draw.ellipse(pantalla, AZUL, [20, 20, 250, 100], 2)

    # ARCO
    pygame.draw.arc(pantalla, VERDE, [100, 100, 250, 200], PI/2, PI, 2)
    pygame.draw.arc(pantalla, NEGRO, [100, 100, 250, 200], 0, PI/2, 2)
    pygame.draw.arc(pantalla, ROJO, [100, 100, 250, 200], 3*PI/2, 2*PI, 2)
    pygame.draw.arc(pantalla, AZUL, [100, 100, 250, 200], PI, 3*PI/2, 2)

    # triángulo
    pygame.draw.polygon(pantalla, NEGRO, [[100, 100],[0, 200],[200, 200]], 5)

    # Selecciona la fuente. Fuente Default, tamaño 25 pt.
    fuente = pygame.font.Font(None, 25)
     
    # Reproduce el texto. "True" significa texto suavizado(anti-aliased).
    # El color es Negro. Recordemos que ya hemos definido anteriormente la variable NEGRO
    # como una lista de (0, 0, 0)
    # Observación: Esta línea crea una imagen de las letras,
    # Pero aún no la pone sobre la pantalla.
    texto = fuente.render("Hola mundo", True, NEGRO)
    # Coloca la imagen del texto sobre la pantalla en 250 x 250
    pantalla.blit(texto, [250, 250])

    numero = 100
    texto = fuente.render("Número: " + str(numero), True, AZUL)
    pantalla.blit(texto, [250, 275])
    
    
    # --- Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
    pygame.display.flip()
    # TODO EL CÓDIGO DE DIBUJO DEBERÍA IR ENCIMA DE ESTE COMENTARIO
 
    # --- Limitamos a 60 fotogramas por segundo (frames per second)
    reloj.tick(60)

#Cierre correcto de un programa Pygame
pygame.quit()
