/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sensores;

import excepciones.SensorDesactivadoException;
import interfaces.Activable;

/**
 *
 * @author rodolfo
 */
public class Sensor implements Activable{
    protected String nombre;
    protected double valorActual;
    protected String UnidadMedida;
    protected boolean activo;

    public Sensor(String nombre, String UnidadMedida) {
        this.nombre = nombre;
        this.valorActual=0;
        this.UnidadMedida = UnidadMedida;
        this.activo=true;
        
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorActual() {
        return valorActual;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
    public void leervalor(double entrada) throws SensorDesactivadoException {
    if (!activo) {
        throw new SensorDesactivadoException();
    }
    valorActual = entrada;
}
    @Override
    public void activar(){
        activo=true;
    }
    @Override
    public void desactivar(){
        activo=false;
    }
    public String obtenerEstado(Sensor s) {
    if (s instanceof SensorTemperatura st) {
        double v = st.getValorActual();
        if (v >= 40) {
            return "ALARMA";
        } else if (v >= 30) {
            return "ADVERTENCIA";
        } else {
            return "NORMAL";
        }
    } else if (s instanceof SensorNivel sn) {
        double p = sn.calcularPorcentaje();
        if (p >= 95) {
            return "ALARMA";
        } else if (p >= 80) {
            return "ADVERTENCIA";
        } else {
            return "NORMAL";
        }
    } else if (s instanceof SensorPresion sp) {
        double v = sp.getValorActual();
        if (v >= 8) {
            return "ALARMA";
        } else if (v >= 5) {
            return "ADVERTENCIA";
        } else {
            return "NORMAL";
        }
    } else if (s instanceof SensorCaudal sc) {
        double v = sc.getValorActual();
        if (v < 50) {
            return "ALARMA";
        } else if (v < 100) {
            return "ADVERTENCIA";
        } else {
            return "NORMAL";
        }
    } else if (s instanceof SensorProximidad sp) {
        int b = sp.getCantidadBotellasDetectadas();
        if (b < 150) {
            return "ALARMA";
        } else if (b < 250) {
            return "ADVERTENCIA";
        } else {
            return "NORMAL";
        }
    }
    return "NORMAL";
}

    @Override
    public String toString() {
        return "Sensor{" + "nombre=" + nombre + ", valorActual=" + valorActual + ", UnidadMedida=" + UnidadMedida + ", activo=" + activo + '}';
    }
    
    
   
    
}
