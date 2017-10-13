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
def dibujar_pelota(pantalla, x, y):
    # Dibuja un círculo
    imagen_defondo = pygame.image.load("Pelota3.png").convert()
    imagen_defondo.set_colorkey(BLANCO)
    pantalla.blit(imagen_defondo, [x, y])
    #pygame.draw.ellipse(pantalla,BLANCO, [35 + x, y, 15, 15])


class Pelota():
    def __init__(self):
    # --- Atributos de la Clase ---
        # Posición de la pelota
        self.x = 0
        self.y = 0
 
        # vector Pelota
        self.cambio_x = 0
        self.cambio_y = 0
 
        # Dimensiones de la Pelota
        self.talla = 10
 
        # color de la Pelota
        self.color = [255,255,255]
 
        # --- Métodos para la Clase ---
    def mover(self):
        self.x += self.cambio_x
        self.y += self.cambio_y
 
    def dibujar(self, pantalla):
        pygame.draw.circle(pantalla, self.color, [self.x, self.y], self.talla )
    

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
    # Velocidad en píxeles por fotograma
    x_speed = 0
    y_speed = 0
    # Posición actual
    x_coord = 10
    y_coord = 10
    
    """ Función principal del juego. """
    # Inicializamos el motor de juegos.
    pygame.init()

    # Establecer las dimensiones de una ventana
    dimensiones = (700, 500)
    pantalla = pygame.display.set_mode(dimensiones)
    # Establecer el título de la ventana
    pygame.display.set_caption("Captain Tsubasa 2017")
    # Iteramos hasta que el usuario haga click sobre le botón de salida.
    hecho = False
    # Se usa para establecer cuan rápido se actualiza la pantalla
    reloj = pygame.time.Clock()
    ''' imagen de fondo '''
    imagen_defondo = pygame.image.load("Campo.jpg").convert()
    ''' sonidos '''
    pulsar_sonido = pygame.mixer.Sound("laser5.ogg")
    sonido = pygame.mixer.Sound("Captain Tsubasa Vol 2 Hack Trinity.ogg")
    sonido.play()
    ''' uso de clase Pelota'''
    laPelota = Pelota()
    laPelota.x = 100
    laPelota.y = 100
    laPelota.cambio_x = 2
    laPelota.cambio_y = 1
    laPelota.color = [255,0,0]
    
    # -------- Bucle principal del Programa -----------
    while not hecho:
        
        # TODOS LOS EVENTOS DE PROCESAMIENTO DEBERÍAN IR DEBAJO DE ESTE COMENTARIO
        for evento in pygame.event.get(): # El usuario hizo algo
            if evento.type == pygame.QUIT:
                hecho = True
            if evento.type == pygame.QUIT: # Si el usuario pincha sobre cerrar
                hecho = True # Esto que indica que hemos acabado y sale de este bucle

            elif evento.type == pygame.KEYDOWN:
                # Resuelve que ha sido una tecla de flecha, por lo que
                # ajusta la velocidad.
                if evento.key == pygame.K_LEFT:
                    x_speed = -3
                if evento.key == pygame.K_RIGHT:
                    x_speed = 3
                if evento.key == pygame.K_UP:
                    y_speed = -3
                if evento.key == pygame.K_DOWN:
                    y_speed = 3
                print("El usuario presionó una tecla.")

            elif evento.type == pygame.KEYUP:
                # Si se trata de una tecla de flecha, devuelve el vector a cero
                if evento.key == pygame.K_LEFT:
                    x_speed = 0
                if evento.key == pygame.K_RIGHT:
                    x_speed = 0
                if evento.key == pygame.K_UP:
                    y_speed = 0
                if evento.key == pygame.K_DOWN:
                    y_speed = 0
                print("El usuario soltó una tecla.")
            elif evento.type == pygame.MOUSEBUTTONDOWN:
                # sonido
                pulsar_sonido.play()
                print("El usuario presionó un botón del ratón")
            
        # --- LA LÓGICA DEL JUEGO DEBERÍA IR AQUÍ
        ''' mi código general '''
        # Mueve el objeto de acuerdo a la velocidad del vector.
        x_coord += x_speed
        y_coord += y_speed
        # coordenadas del raton
        pos = pygame.mouse.get_pos()
        x = pos[0]
        y = pos[1]
        # Ocultar el cursor del ratón
        pygame.mouse.set_visible(False)

        laPelota.x = pos[0]
        laPelota.y = pos[1]
        
        # --- EL CÓDIGO DE DIBUJO DEBERÍA IR AQUÍ
        ''' pinto la pantalla de'''
        pantalla.blit(imagen_defondo, [0, 0])
        #pantalla.fill(VERDE)
        ''' mi código para gráficos '''
        dibuja_hombrepalitos(pantalla,x_coord,y_coord)
        #dibujar_pelota(pantalla,x,y)

        
        laPelota.mover()
        laPelota.dibujar(pantalla)
        
        # --- Avanzamos y actualizamos la pantalla con lo que hemos dibujado.
        pygame.display.flip()
        # --- Limitamos a 60 fotogramas por segundo (frames per second)
        reloj.tick(60)
    # Cerramos la ventana y salimos.
    pygame.quit()


if __name__ == "__main__":
    main()
