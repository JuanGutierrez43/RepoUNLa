# Progama creado el dia 30/09/2017
# Por José Victor Ibáñez
# Estudio de Python para hacer un juego
#
''' inicio del Programa '''

# Clase
# Herencia: multiples
class Persona():
    def __init__(self):
        self.nombre = ""
    def informe(self):
        # Informe básico
        print("Informe para", self.nombre)
        
class Empleado(Persona):
    def __init__(self):
        # Llamamos primero a la clase consstructor padre
        super().__init__()
         
        # Ahora establecemos las variables
        self.nombre_del_puesto= ""
    def informe(self):
        # Aquí solo sobreescribimos informe:
        print("Informe para", self.nombre)

class Cliente(Persona):
    def __init__(self):
        super().__init__()
        self.email = ""
    def informe(self):
        # Ejecutamos el informe padre:
        super().informe()
        # Añadimos ahora nuestro propio código al final, de forma que hacemos los dos
        print("e-mail del Cliente:", self.email)

# variables estáticas vs Variables de instancias
# Ejemplo de una variable de instancia
class ClaseA():
    def __init__(self):
        self.y = 3
 
# Ejemplo de una variable estática
class ClaseB():
    x = 7

''' inicio de la aplicación '''
def main():
    #12.6 Herencia
    john_smith = Persona()
    john_smith.nombre = "John Smith"
     
    jane_empleado = Empleado()
    jane_empleado.nombre = "Empleado Jane"
    jane_empleado.nombre_del_puesto = "Desarrollador Web"
     
    bob_cliente = Cliente()
    bob_cliente.nombre = "Bob Cliente"
    bob_cliente.email = "enviame@spam.com"

    john_smith.informe() ## llama al método padre
    jane_empleado.informe() ## llama al método propio
    bob_cliente.informe() ## llama al método padre mas el método propio

    # Creamos las instancias de clase
    a = ClaseA()
    b = ClaseB()
     

    # imprimir de forma correcta un variable estática.
    print(ClaseB.x)
    
    # forma de imprimir una variable de instancia
    print(a.y)

    #12.7 Variables
    '''  Variables de Instancia. Ocultando Variables Estáticas '''
    # Asignamos un nuevo valor a x usando el nombre de clase
    ClaseB.x = 8

    # Esto imprime 8
    print(ClaseB.x)
    b.x = 9
    # Esto imprime 9
    print(b.x)
    print(ClaseB.x)
    
if __name__ == "__main__":
    main()
