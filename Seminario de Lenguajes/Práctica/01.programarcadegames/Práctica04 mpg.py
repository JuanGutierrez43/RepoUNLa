# Sample Python/Pygame Programs
# Simpson College Computer Science
# http://programarcadegames.com/
# http://simpson.edu/computer-science/
 
(10)
 
# Calcular las millas por galon
print("Este programa calcula mpg.")
 
# Obtener del usuario las millas recorridas
millas_recorridas = input("Introduce las millas recorridas: ")
# Convertimos el texto introducido a
# número en coma flotante (número real)
millas_recorridas = float(millas_recorridas)
 
#Obtener del usuario los galones consumidos
galones_usados = input("Introduce los galones usados: ")
# Convertimos el texto introducido a
# número en coma flotante (número real)
galones_usados = float(galones_usados)
 
# Calculamos e imprimimos la respuesta
mpg = millas_recorridas / galones_usados
print ("Millas por galon:",mpg)
