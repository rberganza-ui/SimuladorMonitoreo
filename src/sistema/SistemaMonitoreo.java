/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

/**
 *
 * @author rodolfo
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import persistencia.GestorArchivos;
import sensores.*;
public class SistemaMonitoreo {
    private ArrayList<Sensor> sensores;
    private GestorArchivos gestorArchivos;

    public SistemaMonitoreo() {
        sensores = new ArrayList<>();
        gestorArchivos = new GestorArchivos();
    }

    public void agregarSensor(Sensor sensor) {
        sensores.add(sensor);
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        try {
            gestorArchivos.agregarLinea("historial.txt",
                    hora + " - " + sensor.getNombre() + " (" + sensor.getClass().getSimpleName() + ") agregado.");
        } catch (Exception e) {
            System.out.println("Error al escribir historial: " + e.getMessage());
        }
    }

    public void activarSensor(Sensor sensor) {
        sensor.activar();
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        try {
            gestorArchivos.agregarLinea("historial.txt",
                    hora + " - " + sensor.getNombre() + " activado.");
        } catch (Exception e) {
            System.out.println("Error al escribir historial: " + e.getMessage());
        }
    }

    public void desactivarSensor(Sensor sensor) {
        sensor.desactivar();
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        try {
            gestorArchivos.agregarLinea("historial.txt",
                    hora + " - " + sensor.getNombre() + " desactivado.");
        } catch (Exception e) {
            System.out.println("Error al escribir historial: " + e.getMessage());
        }
    }

    public void mostrarSensores() {
        for (Sensor sensor : sensores) {
            System.out.println(sensor);
        }
    }

    public void evaluarSistema() {
    String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    for (Sensor sensor : sensores) {
        if (!sensor.isActivo()) continue;

        // TEMPERATURA
        if (sensor instanceof SensorTemperatura st) {
            double temperatura = st.getValorActual();
            if (temperatura < 30) {
                st.getLed().setColor("VERDE");
                st.getVentilador().setVelocidad(0);
                st.getBuzzer().setIntensidad("baja");
            } else if (temperatura < 40) {
                st.getLed().setColor("AMARILLO");
                st.getVentilador().setVelocidad(50);
                st.getBuzzer().setIntensidad("MEDIA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ADVERTENCIA: temperatura elevada en " + st.getNombre()); } catch (Exception e) {}
            } else {
                st.getLed().setColor("ROJO");
                st.getVentilador().setVelocidad(100);
                st.getBuzzer().setIntensidad("ALTA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ALARMA: temperatura crítica en " + st.getNombre()); } catch (Exception e) {}
            }
            st.getLed().ejecutar();
            st.getVentilador().ejecutar();
            st.getBuzzer().ejecutar();
        }

        // NIVEL
        else if (sensor instanceof SensorNivel sn) {
            double porcentaje = sn.calcularPorcentaje();
            if (porcentaje < 80) {
                sn.getLed().setColor("VERDE");
                sn.getBuzzer().setIntensidad("baja");
            } else if (porcentaje < 95) {
                sn.getLed().setColor("AMARILLO");
                sn.getBuzzer().setIntensidad("MEDIA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ADVERTENCIA: tanque casi lleno en " + sn.getNombre()); } catch (Exception e) {}
            } else {
                sn.getLed().setColor("ROJO");
                sn.getBuzzer().setIntensidad("ALTA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ALARMA: riesgo de desborde en " + sn.getNombre()); } catch (Exception e) {}
            }
            sn.getLed().ejecutar();
            sn.getBuzzer().ejecutar();
        }

        // PRESION
        else if (sensor instanceof SensorPresion sp) {
            double presion = sp.getValorActual();
            if (presion < 5) {
                sp.getLed().setColor("VERDE");
                sp.getBuzzer().setIntensidad("baja");
            } else if (presion < 8) {
                sp.getLed().setColor("AMARILLO");
                sp.getBuzzer().setIntensidad("MEDIA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ADVERTENCIA: presión elevada en " + sp.getNombre()); } catch (Exception e) {}
            } else {
                sp.getLed().setColor("ROJO");
                sp.getBuzzer().setIntensidad("ALTA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ALARMA: presión crítica en " + sp.getNombre()); } catch (Exception e) {}
            }
            sp.getLed().ejecutar();
            sp.getBuzzer().ejecutar();
        }

        // CAUDAL
        else if (sensor instanceof SensorCaudal sc) {
            double caudal = sc.getValorActual();
            if (caudal >= 100) {
                sc.getLed().setColor("VERDE");
                sc.getBuzzer().setIntensidad("baja");
            } else if (caudal >= 50) {
                sc.getLed().setColor("AMARILLO");
                sc.getBuzzer().setIntensidad("MEDIA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ADVERTENCIA: caudal reducido en " + sc.getNombre()); } catch (Exception e) {}
            } else {
                sc.getLed().setColor("ROJO");
                sc.getBuzzer().setIntensidad("ALTA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ALARMA: posible obstrucción en " + sc.getNombre()); } catch (Exception e) {}
            }
            sc.getLed().ejecutar();
            sc.getBuzzer().ejecutar();
        }

        // PROXIMIDAD
        else if (sensor instanceof SensorProximidad sp) {
            int botellas = sp.getCantidadBotellasDetectadas();
            if (botellas > 250) {
                sp.getLed().setColor("VERDE");
                sp.getBuzzer().setIntensidad("baja");
            } else if (botellas >= 150) {
                sp.getLed().setColor("AMARILLO");
                sp.getBuzzer().setIntensidad("MEDIA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ADVERTENCIA: producción reducida."); } catch (Exception e) {}
            } else {
                sp.getLed().setColor("ROJO");
                sp.getBuzzer().setIntensidad("MEDIA");
                try { gestorArchivos.agregarLinea("historial.txt", hora + " - ALARMA: producción baja."); } catch (Exception e) {}
            }
            sp.getLed().ejecutar();
            sp.getBuzzer().ejecutar();
        }
    }
}
    
}
