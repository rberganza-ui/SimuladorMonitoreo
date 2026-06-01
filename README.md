SimuladorMonitoreo
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



¿Cómo se usa?

Se crea un SistemaMonitoreo y se le agregan los sensores que se necesiten.
Cada sensor puede activarse o desactivarse desde la interfaz (Grafica).
Al registrar una lectura, el sensor ejecuta sus actuadores asociados automáticamente según el valor obtenido.
Si el valor está fuera de rango o el sensor está apagado, el sistema lanza una excepción que la interfaz captura y muestra al usuario.
Las lecturas quedan guardadas en archivos de texto a través del GestorArchivos.

