Algoritmo CasaDeCambioYanneMinuto
	
    // Declaraciones GLOBALES (visibles desde todos los subprocesos)
    Dimension transMonto[100]
    Dimension transOrigen[100]
    Dimension transDestino[100]
    Dimension transResultado[100]
	
    Definir opcion, contador, i Como Entero
    Definir basura, origen, destino Como Cadena
    Definir monto, resultado Como Real
	
    contador <- 0
	
    // Mensaje de bienvenida
    Escribir "======================================"
    Escribir "   Bienvenido a Casa de Cambio"
    Escribir "           Yanne.Minuto"
    Escribir "======================================"
    Escribir "Presione ENTER para iniciar..."
    Leer basura
	
    Repetir
		
        Escribir ""
        Escribir "----------- MENU PRINCIPAL -----------"
        Escribir "1. Simular conversion"
        Escribir "2. Registrar transaccion"
        Escribir "3. Ver historial"
        Escribir "4. Borrar historial"
        Escribir "5. Salir"
        Escribir "Seleccione una opcion:"
        Leer opcion
		
        Segun opcion Hacer
			
            1:
                SimularConversion()
				
            2:
                RegistrarTransaccion()
				
            3:
                VerHistorial()
				
            4:
                BorrarHistorial()
				
            5:
                Escribir "Saliendo del sistema..."
				
            De Otro Modo:
                Escribir "Opcion no valida. Intente de nuevo."
				
        FinSegun
		
    Hasta Que opcion = 5
	
FinAlgoritmo


// ===== SUBPROCESOS =====

// Conversión: recibe monto, origen, destino (como parámetros implícitos en PSeInt estilo devolviendo valor)
SubProceso resultado <- Convertir(monto, origen, destino)
    Definir valorCOP, valorDIR Como Real
	
    Segun origen Hacer
        "COP": valorCOP <- 1
        "USD": valorCOP <- 4100
        "EUR": valorCOP <- 4500
        De Otro Modo: valorCOP <- 1
    FinSegun
	
    Segun destino Hacer
        "COP": valorDIR <- 1
        "USD": valorDIR <- 4100
        "EUR": valorDIR <- 4500
        De Otro Modo: valorDIR <- 1
    FinSegun
	
    resultado <- (monto * valorCOP) / valorDIR
FinSubProceso


SubProceso SimularConversion
    Definir montoLoc, resultadoLoc Como Real
    Definir origenLoc, destinoLoc Como Cadena
	
    Escribir "Ingrese monto:"
    Leer montoLoc
	
    Escribir "Moneda origen (COP-USD-EUR):"
    Leer origenLoc
	
    Escribir "Moneda destino (COP-USD-EUR):"
    Leer destinoLoc
	
    resultadoLoc <- Convertir(montoLoc, origenLoc, destinoLoc)
	
    Escribir "Resultado de la conversion: ", resultadoLoc
FinSubProceso


SubProceso RegistrarTransaccion
    Definir montoLoc, resultadoLoc Como Real
    Definir origenLoc, destinoLoc Como Cadena
	
    Escribir "Ingrese monto:"
    Leer montoLoc
	
    Escribir "Moneda origen (COP-USD-EUR):"
    Leer origenLoc
	
    Escribir "Moneda destino (COP-USD-EUR):"
    Leer destinoLoc
	
    resultadoLoc <- Convertir(montoLoc, origenLoc, destinoLoc)
	
    // Guardar en vectores globales
    transMonto[contador] <- montoLoc
    transOrigen[contador] <- origenLoc
    transDestino[contador] <- destinoLoc
    transResultado[contador] <- resultadoLoc
	
    contador <- contador + 1
	
    Escribir "Transaccion registrada."
FinSubProceso


SubProceso VerHistorial
    Si contador = 0 Entonces
        Escribir "No hay transacciones registradas."
    SiNo
        Para i <- 0 Hasta contador - 1 Con Paso 1
            Escribir "-----------------------------"
            Escribir "Monto: ", transMonto[i]
            Escribir "Origen: ", transOrigen[i]
            Escribir "Destino: ", transDestino[i]
            Escribir "Resultado: ", transResultado[i]
        FinPara
    FinSi
FinSubProceso


SubProceso BorrarHistorial
    Definir respuesta Como Cadena
	
    Escribir "¿Desea borrar todo el historial? (SI/NO)"
    Leer respuesta
	
    Si respuesta = "SI" Entonces
        contador <- 0
        Escribir "Historial borrado."
    SiNo
        Escribir "Accion cancelada."
    FinSi
FinSubProceso





