/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sensores;

import actuadores.Buzzer;
import actuadores.LedRGB;
import actuadores.Ventilador;
import excepciones.SensorDesactivadoException;
import excepciones.ValorFueraDeRangoException;
import java.util.ArrayList;

/**
 *
 * @author rodolfo
 */
public class SensorTemperatura extends Sensor{
    private ArrayList<Double> historial;
    private LedRGB led;
    private Buzzer buzzer;
    private Ventilador ventilador;

    public SensorTemperatura(String nombre) {
        super(nombre,"C");
        this.historial = new ArrayList<>();
        this.led = new LedRGB("Led"+nombre);
        this.buzzer = new Buzzer("baja", "Buzzer_" + nombre);
        this.ventilador = new Ventilador("Ventilador_" + nombre);
    }

    public LedRGB getLed() {
        return led;
    }

    public Buzzer getBuzzer() {
        return buzzer;
    }

    public Ventilador getVentilador() {
        return ventilador;
    }
    
    public void registrarTemperatura(double temperatura) throws ValorFueraDeRangoException, SensorDesactivadoException {
    if (!activo) {
        throw new SensorDesactivadoException();
    }
    if (temperatura < -50 || temperatura > 150) {
        throw new ValorFueraDeRangoException();
    }
    valorActual = temperatura;
    historial.add(temperatura);
}
    
   
    public double calcularPromedio(){
    if (historial.isEmpty()) return 0;
    double suma = 0;
    for (Double c : historial) {
        suma = suma + c;
    }
    return suma / historial.size();
}
    
    
    
}
