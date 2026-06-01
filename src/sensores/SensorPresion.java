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
public class SensorPresion extends Sensor{
    private LedRGB led;
    private Buzzer buzzer;

    public SensorPresion(String nombre) {
        super(nombre,"Pa");
        this.led = new LedRGB("Led"+nombre);
        this.buzzer =new  Buzzer("baja","buzzer"+nombre);
    }

    public LedRGB getLed() {
        return led;
    }

    public Buzzer getBuzzer() {
        return buzzer;
    }
    
    

    public void registrarPresion(double presion) throws ValorFueraDeRangoException, SensorDesactivadoException {
    if (!activo) {
        throw new SensorDesactivadoException();
    }
    if (presion < 0) {
        throw new ValorFueraDeRangoException();
    }
    valorActual = presion;
}
    
}
