# Progama creado el dia 30/09/2017
# Por José Victor Ibáñez
# Estudio de Python para hacer un juego
#
''' inicio del Programa '''

# Clase Personaje constructor sin parametros
class Personaje():
    """ Esta es una clase que representa al protagonista principal del juego. """
    def __init__(self):
        """ Este es un método que establece las variables del objeto. """
        self.name = "Luis"
        self.sexo = "Varon"
        self.puntos_impacto_max = 50
        self.puntos_impacto_actuales = 50
        self.vel_max = 10
        self.cantidad_escudos = 8

# Clase Direccion constructor sin parametros
class Direccion():
    """ Contiene todos los campos para una dirección postal. """
    def __init__(self):
        """ Establece los campos de la dirección. """
        self.nombre = ""
        self.via1 = ""
        self.via2 = ""
        self.ciudad = ""
        self.provincia = ""
        self.cod_postal = ""

    # Imprime una dirección en pantalla Métodos
    def imprimir_direccion(direccion):
        print(direccion.nombre)
        # Si existe una via1 en esa dirección, imprímela
        if( len(direccion.via1) > 0 ):
            print (direccion.via1)
        # Si existe una via2 en esa dirección, imprímela
        if( len(direccion.via2) > 0 ):
            print( direccion.via2 )
        print( direccion.ciudad+", "+direccion.provincia+" "+direccion.cod_postal )

# Clase Perro constructor
class Perro():
    
    # sin parametros
    #def __init__(self):
    #    self.edad = 0
    #    self.nombre = ""
    #   self.peso = 0
        
    # Llamada al constructor cuando creamos un objeto de este tipo
    # con parametros
    def __init__(self,nombre_nuevo):
        self.edad = 0
        self.nombre = nombre_nuevo
        self.peso = 0
        print("Ha nacido un perro nuevo!")
    # Métodos
    def ladra(self):
        print("Guau", self.nombre )

# Clase Persona referencias
class Persona:
    def __init__(self):
        self.nombre = ""
        self.dinero = 0
# Herencia
class Barco():
    def __init__(self):
        self.tonelaje = 0
        self.nombre = ""
        self.esta_atracado = True
 
    def atracar(self):
        if self.esta_atracado:
            print("Ya has atracado.")
        else:
            self.esta_atracado = True
            print("Atracando")
 
    def desatracar(self):
        if not self.esta_atracado:
            print("No estás atracado.")
        else:
            self.esta_atracado = False
            print("Desatracando")
            
# Herencia: Clase hija
class Submarino(Barco): # ¡Así de fácil es la herencia!
    def sumergirse(self):
        print("Sumergirse!")


## Funciones
def dameDinero2(persona):
    persona.dinero += 100

''' inicio de la aplicación '''
def main():
    # Crea una dirección
    casa_direccion = Direccion()

    # Establece los campos de la direccion
    casa_direccion.nombre = "John Smith"
    casa_direccion.via1 = "701 N. C Street"
    casa_direccion.via2 = "Carver Science Building"
    casa_direccion.ciudad = "Indianola"
    casa_direccion.provincia = "IA"
    casa_direccion.cod_postal = "50125"

    # Crea otra dirección
    casa_vacaciones_direccion = Direccion()
     
    #Establece los campos de la nueva dirección
    casa_vacaciones_direccion.nombre = "John Smith"
    casa_vacaciones_direccion.via1 = "1122 Main Street"
    casa_vacaciones_direccion.via2 = ""
    casa_vacaciones_direccion.ciudad = "Panama City Beach"
    casa_vacaciones_direccion.provincia = "FL"
    casa_vacaciones_direccion.cod_postal = "32407"

    casa_direccion.imprimir_direccion()
    print()
    casa_vacaciones_direccion.imprimir_direccion()
    
    print("La dirección principal del cliente está en " + casa_direccion.ciudad)
    print("Su casa de vacaciones está en " + casa_vacaciones_direccion.ciudad)

    mi_perro = Perro("Spot")
    mi_perro.ladra()


    #12.4 referencias
    bob = Persona()
    bob.nombre = "Bob"
    bob.dinero = 100

    nancy = Persona()
    nancy.nombre = "Nancy"
    print(bob.nombre, "tiene", bob.dinero, "dólares.")
    print(nancy.nombre, "tiene", nancy.dinero, "dólares.")
    dameDinero2(bob)
    print(bob.dinero)

    #12.6 Herencia
    b = Barco()
 
    b.atracar()
    b.desatracar()
    b.desatracar()
    b.atracar()
    b.atracar()

    
if __name__ == "__main__":
    main()
