/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sensores;

import actuadores.Buzzer;
import actuadores.LedRGB;
import excepciones.SensorDesactivadoException;
import excepciones.ValorFueraDeRangoException;

/**
 *
 * @author rodolfo
 */
public class SensorCaudal extends Sensor{
    private LedRGB led;
    private Buzzer buzzer;

    public SensorCaudal(String nombre) {
        super(nombre,"L/min");
        this.led = new LedRGB("Led"+nombre);
        this.buzzer =new  Buzzer("baja","buzzer"+nombre);
    }

    public LedRGB getLed() {
        return led;
    }

    public Buzzer getBuzzer() {
        return buzzer;
    }
   
    public void registrarCaudal(double caudal) throws ValorFueraDeRangoException, SensorDesactivadoException {
    if (!activo) {
        throw new SensorDesactivadoException();
    }
    if (caudal < 0) {
        throw new ValorFueraDeRangoException();
    }
    valorActual = caudal;
}
    
    public double calcularVolumen(double minutos){
        return (valorActual*minutos);
        
    }
}
