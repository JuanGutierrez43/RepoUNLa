#este programa calcula la energia cinetica
print("calculo de energia cinetica")
m_string=input("Introduce la masa del objeto en kilogramos: ")
m=float(m_string)
v_string=input("Introduce la velocidad en metros por segundos: ")
v=float(v_string)

ec=(1/2)*m*(v*v)
print("el objeto tiene "+str(ec)+" joules de energia.")

