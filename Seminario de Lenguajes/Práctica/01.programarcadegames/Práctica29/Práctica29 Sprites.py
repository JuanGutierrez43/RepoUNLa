# Progama creado el dia 30/09/2017
# Por José Victor Ibáñez
# Estudio de Python para hacer un juego
#
''' inicio del Programa '''
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

pantalla_largo = 700
pantalla_alto = 400

''' clases '''
class Bloque(pygame.sprite.Sprite):
    """
    Esta clase representa la pelota        
    Deriva de la clase "Sprite" en Pygame
    """
     
    def __init__(self, color, largo, alto):
        """ Constructor. Pasa el color al bloque, 
        y su posición x e y """
        # Llama al constructor de la clase padre (Sprite) 
        super().__init__() 
        # Crea una imagen del bloque y lo rellena de color.
        # Esto podría ser también una imagen cargada desde el disco duro.
        self.image = pygame.Surface([largo, alto])
        self.image.fill(color)
        # Obtenemos el objeto rectángulo que posee las dimensiones de la imagen
        # Actualizamos la posición de ese objeto estableciendo los valores para 
        # rect.x y rect.y
        self.rect = self.image.get_rect()

    def reset_pos(self):
        """ Reseteamos la posición en la parte superior de la pantalla en ubicaciones aleatorias de x.
        Llamada por update() o por el bucle principal si ocurre una colisión. """
        self.rect.y = random.randrange(-100, -10)
        self.rect.x = random.randrange(0, pantalla_largo)
    def update(self):
        """ Llamado en cada fotograma. """
        # Desplazamos un píxel hacia abajo el bloque  
        self.rect.y += 1
        # Si el bloque está muy abajo, lo devuelve a la parte superior de la pantalla.
        if self.rect.y > pantalla_alto:
            self.reset_pos()
        
''' inicio de la aplicación '''
def main():

    # Inicializamos Pygame
    pygame.init()
     
    # Establecemos el alto y largo de la pantalla
    pantalla=pygame.display.set_mode([pantalla_largo,pantalla_alto])

    
    # Esta es una lista de 'sprites.' Cada bloque en el programa es
    # añadido a la lista. La lista es gestionada por una clase llamada 'Group.'
    bloque_lista = pygame.sprite.Group()
    
    # Esta es una lista de cada uno de los sprites. Así como del resto de bloques
    # y el bloque protagonista..
    listade_todoslos_sprites = pygame.sprite.Group()
    
    for i in range(50):
        # Esto representa un bloque
        bloque = Bloque(NEGRO, 20, 15)
     
        # Establecemos una ubicación aleatoria para el bloque
        bloque.rect.x = random.randrange(pantalla_largo)
        bloque.rect.y = random.randrange(pantalla_alto/4)
         
        # Añadimos el  bloque a la lista de objetos
        bloque_lista.add(bloque)                # - sirve para colisiones - 
        listade_todoslos_sprites.add(bloque)    # - util para dibujar -
     
    # Creamos un bloque protagonista ROJO
    protagonista = Bloque(ROJO, 20, 15)
    #bloque_lista.add(protagonista)             # mal si queres agregarlo en colisiones
    listade_todoslos_sprites.add(protagonista)  # - util para dibujar -
     
    #Iteramos hasta que el usuario pulse el botón de salida
    hecho = False
     
    #  Se usa para establecer cuan rápido se actualiza la pantalla
    reloj = pygame.time.Clock()
     
    marcador = 0


    # -------- Bucle principal del Programa -----------
    while not hecho:

        # --- TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR DEBAJO DE ESTE COMENTARIO ---
        for evento in pygame.event.get(): # El usuario hizo algo
            if evento.type == pygame.QUIT: # Si el usuario pulsó salir
                hecho = True # Marcamos que hemos terminado y salimos del bucle


        # --- LA LÓGICA DEL JUEGO DEBERÍA IR AQUÍ ---
        # Ocultar el cursor del ratón
        pygame.mouse.set_visible(False)
        
        # Obtenemos la posición actual del ratón. Esto devuelve la posición
        # como una lista de dos números.
        pos = pygame.mouse.get_pos()
         
        # Extraemos la x e y de la lista, 
        # Tal como si extrajéramos letras de una cadena de texto.
        # Colocamos al objeto protagonista en la ubicación del ratón.
        protagonista.rect.x = pos[0]
        protagonista.rect.y = pos[1]
        
        # Observamos si el bloque protagonista ha colisionado con algo.
        ''' devuelve una lista de sprites de colisiones y los elimina de bloque_lista '''
        lista_impactos_bloques = pygame.sprite.spritecollide(protagonista, bloque_lista, True)  
        
        # Comprobamos la lista de colisiones
        for bloque in lista_impactos_bloques:
            marcador += 1
            print( marcador,bloque ) # nueva colision
            bloque.reset_pos()

        # Llamamos al método update() para todos los bloques en bloque_lista
        ''' hace un update de toda la lista :)'''
        bloque_lista.update()
       
        # --- EL CÓDIGO DE DIBUJO DEBERÍA IR AQUÍ ---
        # Limpiamos la pantalla
        pantalla.fill(BLANCO)
        
        # Dibujamos todos los sprites
        listade_todoslos_sprites.draw(pantalla)
         
        # Limitamos a 60 fotogramas por segundo
        reloj.tick(60)
     
        # Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
        pygame.display.flip()
     
    pygame.quit()

''' llamada a inicio de la aplicación '''
if __name__ == "__main__":
    main()
