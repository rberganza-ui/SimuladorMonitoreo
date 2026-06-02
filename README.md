Simulador de Monitoreo de Fabrica enbotelladora
Sistema de monitoreo desarrollado en Java que simula la lectura de sensores físicos y el control automático de actuadores de respuesta.

¿De qué trata?
El proyecto modela un entorno donde distintos sensores capturan datos del mundo real (temperatura, nivel de líquido, presión, caudal, presencia de objetos) y,
según lo que detecten, activan o configuran dispositivos de respuesta como luces LED, buzzers y ventiladores. Todo se gestiona desde una interfaz gráfica 
y los registros se guardan en archivos.

¿Para qué se puede usar algo así?
Un sistema con esta arquitectura es aplicable en contextos como:

Industria — monitoreo de temperatura en maquinaria, control de presión en tuberías, medición de caudal en plantas de producción
Líneas de producción — detección y conteo de objetos (como botellas) con SensorProximidad
Depósitos y tanques — control del nivel de llenado con alerta visual y sonora automática



¿Cómo funciona?

Se crea un SistemaMonitoreo y se le agregan los sensores que se necesiten.
Cada sensor puede activarse o desactivarse desde la interfaz (Grafica).
Al registrar una lectura, el sensor ejecuta sus actuadores asociados automáticamente según el valor obtenido.
Si el valor está fuera de rango o el sensor está apagado, el sistema lanza una excepción que la interfaz captura y muestra al usuario.
Las lecturas quedan guardadas en archivos de texto a través del GestorArchivos.


¿Cómo se usa?
Panel principal (pestaña 1)
Muestra la información del sensor seleccionado en la lista. Incluye el tipo de sensor, su valor actual con unidad de medida y su estado (normal, advertencia o alarma). 
También muestra el estado de los actuadores asociados: color del LED, intensidad del buzzer y velocidad del ventilador (solo temperatura).
Según el tipo de sensor, aparecen controles adicionales como el promedio histórico (temperatura), el porcentaje de llenado (nivel), el contador de botellas (proximidad) o el cálculo de volumen (debido al caudal). 
El botón Activar/Desactivar permite cambiar el estado del sensor desde esta misma pestaña.

Registrar valor (pestaña 2)
Permite ingresar una lectura manual para el sensor seleccionado.

Seleccionar un sensor en la lista de la izquierda.
Escribir el valor en el campo de texto.
Presionar Registrar.
El sistema evalúa automáticamente la lectura y actualiza los actuadores.
Nota: Si el sensor está desactivado o el valor está fuera de rango, se muestra un mensaje de error.

Historial (pestaña 3)
Muestra el registro de eventos del sistema (sensores agregados, activaciones, advertencias y alarmas) leídos desde historial.txt.

Presionar Actualizar para refrescar la vista.
Los eventos más recientes aparecen primero.

Agregar sensor (pestaña 4)
Permite agregar nuevos sensores en tiempo de ejecución.

Seleccionar el tipo de sensor en el combo.
Escribir un nombre personalizado en el campo de texto (opcional).
Presionar Agregar.
El nuevo sensor queda disponible de inmediato en la lista.

TIPOS DE SENSORES
SensorTemperatura | Unidad: C | Rango: -50 a 150 | Actuadores: LED, Buzzer, Ventilador
SensorNivel | Unidad: m | Rango: 0 a 10 (altura max.) | Actuadores: LED, Buzzer
SensorPresion | Unidad: Pa | Rango: >= 0 | Actuadores: LED, Buzzer
SensorCaudal | Unidad: L/min | Rango: >= 0 | Actuadores: LED, Buzzer
SensorProximidad | Unidad: botellas | Rango: contador | Actuadores: LED, Buzzer
LOGICA DE ALERTAS
Cada sensor cambia el color del LED y la intensidad del buzzer segun umbrales:
SensorTemperatura

Menos de 30 C: LED verde, ventilador apagado
Entre 30 y 40 C: LED amarillo, ventilador al 50% - ADVERTENCIA
40 C o mas: LED rojo, ventilador al 100% - ALARMA

SensorNivel (porcentaje del tanque)

Menos del 80%: LED verde
Entre 80% y 95%: LED amarillo - ADVERTENCIA
95% o mas: LED rojo - ALARMA (riesgo de desborde)

SensorPresion

Menos de 5 Pa: LED verde
Entre 5 y 8 Pa: LED amarillo - ADVERTENCIA
8 Pa o mas: LED rojo - ALARMA

SensorCaudal

100 L/min o mas: LED verde
Entre 50 y 99 L/min: LED amarillo - ADVERTENCIA
Menos de 50 L/min: LED rojo - ALARMA (posible obstruccion)

SensorProximidad (botellas detectadas)

Mas de 250: LED verde
Entre 150 y 250: LED amarillo - ADVERTENCIA (produccion reducida)
Menos de 150: LED rojo - ALARMA (produccion baja)

PERSISTENCIA
Todos los eventos relevantes (agregar sensor, activar/desactivar, advertencias, alarmas) se escriben automaticamente en historial.txt con marca de tiempo (HH:mm:ss). 
El archivo se crea en el directorio de trabajo al momento de la primera ejecucion.
