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
public class SensorNivel extends Sensor {
    private double alturaMax;
    private LedRGB led;
    private Buzzer buzzer;

    public SensorNivel(double alturaMax,String nombre) {
        super(nombre,"m");
        this.alturaMax = alturaMax;
        this.led = new LedRGB("Led"+nombre);
        this.buzzer =new  Buzzer("baja","buzzer"+nombre);
    }

    public LedRGB getLed() {
        return led;
    }

    public Buzzer getBuzzer() {
        return buzzer;
    }
    
    
    public void registrarNivel(double nivel){
        valorActual =nivel;
    }
    
    public double calcularPorcentaje(){
        return (valorActual/alturaMax)*100;
    }
    
    
}
