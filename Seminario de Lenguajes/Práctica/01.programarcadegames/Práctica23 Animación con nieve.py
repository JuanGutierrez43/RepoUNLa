# Importamos las bibliotecas llamadas 'pygame' y 'random'.
import pygame
import random
 
# Definimos algunos colores
NEGRO = (0, 0 ,0)
BLANCO = (255, 255, 255)
VERDE = (0, 255, 0)
ROJO = (255, 0, 0)
AZUL = (0, 0, 255)
VIOLETA = (98, 0, 255)
  
# Inicializamos el motor de juegos.
pygame.init()
   
# Establecemos las dimensiones de la pantalla [largo,altura]
dimensiones = [700,500]

pantalla = pygame.display.set_mode(dimensiones) 
pygame.display.set_caption("Está Nevando")

# Creamos un array vacío
lista_nieve = []

# Iteramos 50 veces y añadimos un copo de nieve en una ubicación (x,y) aleatoria.
for i in range(50):
    x = random.randrange(0, 400)
    y = random.randrange(0, 400)
    lista_nieve.append([x, y])

# Iteramos hasta que el usuario haga click sobre le botón de salida.
hecho = False

# Se usa para establecer cuan rápido se actualiza la pantalla
reloj = pygame.time.Clock()

# -------- Bucle principal del Programa -----------
while not hecho:
    # --- Bucle principal de eventos
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT: 
            hecho = True
     
    # --- LA LÓGICA DEL JUEGO DEBERÍA IR AQUÍ
  
    # --- EL CÓDIGO DE DIBUJO DEBERÍA IR AQUÍ
     
    # Primero, limpia la pantalla con blanco. No vayas a poner otros comandos de dibujo encima 
    # de esto, de otra forma serán borrados por este comando:
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


    # --- Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
    pygame.display.flip()
 
    # --- Limitamos a 60 fotogramas por segundo (frames per second)
    reloj.tick(60)
     
# Cerramos la ventana y salimos.
# Si te olvidas de esta última línea, el programa se 'colgará'
# al salir si lo hemos estado ejecutando desde el IDLE.
pygame.quit()
