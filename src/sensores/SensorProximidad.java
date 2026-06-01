/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sensores;

import actuadores.Buzzer;
import actuadores.LedRGB;

/**
 *
 * @author rodolfo
 */
public class SensorProximidad extends Sensor{
    protected int cantidadBotellasDetectadas;
    private LedRGB led;
    private Buzzer buzzer;

    public SensorProximidad(String nombre) {
        super(nombre,"botellas");
        this.cantidadBotellasDetectadas = 0;
        this.led = new LedRGB("Led"+nombre);
        this.buzzer =new  Buzzer("baja","buzzer"+nombre);
    }

    public LedRGB getLed() {
        return led;
    }

    public Buzzer getBuzzer() {
        return buzzer;
    }

    public int getCantidadBotellasDetectadas() {
        return cantidadBotellasDetectadas;
    }

    
    
    public void detectarBotella(){
        cantidadBotellasDetectadas++;
        valorActual = cantidadBotellasDetectadas;
    }
    
    
    
}
