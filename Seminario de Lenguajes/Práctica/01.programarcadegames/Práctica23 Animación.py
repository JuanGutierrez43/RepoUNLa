
# Importamos las bibliotecas llamadas 'pygame' y 'random'.
import pygame
import random
 
# Inicializamos el motor de juegos.
pygame.init()
 
NEGRO = [0, 0, 0]
BLANCO = [255, 255, 255]
 
# Establecemos el largo y ancho de la pantalla.
dimensiones = [400, 400]
 
pantalla = pygame.display.set_mode(dimensiones)
pygame.display.set_caption("Está Nevando")
 
# Creamos un array vacío
lista_nieve = []
 
# Iteramos 50 veces y añadimos un copo de nieve en una ubicación (x,y) aleatoria.
for i in range(50):
    x = random.randrange(0, 400)
    y = random.randrange(0, 400)
    lista_nieve.append([x, y])
 
reloj = pygame.time.Clock()
 
# Iteramos hasta que el usuario haga click sobre le botón de salida.
hecho = False
while not hecho:
     
    for evento in pygame.event.get():  # El usuario realizó alguna acción.
        if evento.type == pygame.QUIT: # Si el usuario hizo click sobre salir.
            hecho = True # Marcamos que hemos acabado y abandonamos este bucle.
 
    # Establecemos el color de fondo.
    pantalla.fill(NEGRO)
 
    # Procesamos cada copo de la lista.
    for i in range(len(lista_nieve)):
    
        # Dibujamos el copo de nieve
        pygame.draw.circle(pantalla, BLANCO, lista_nieve[i], 2)
         
        # Desplazamos un píxel hacia abajo el copo de nieve.
        lista_nieve[i][1] += 1
         
        # Si el copo se escapa del fondo de la pantalla.
        if lista_nieve[i][1] > 400:
            # Lo movemos justo encima del todo
            y = random.randrange(-50, -10)
            lista_nieve[i][1] = y
            # Le damos una nueva ubicación x
            x = random.randrange(0, 400)
            lista_nieve[i][0] = x
             
    # Avanzamos y actualizamos con lo que hemos dibujado.
    pygame.display.flip()
    reloj.tick(60)
             
# Pórtate bien con el IDLE. Si nos olvidamos de esta línea, el programa se 'colgará'
# en la salida.
pygame.quit ()
