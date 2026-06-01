/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actuadores;

/**
 *
 * @author rodolfo
 */
public class Buzzer extends Actuador{
    public String intensidad;

    public Buzzer(String intensidad, String nombre) {
        super(nombre);
        this.intensidad = intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }
    
    
    
    @Override
public String ejecutar(){
    if(!activo){
        return "Buzzer desactivado";
    }
    else{
        return "Buzzer sonando a " + intensidad +" intensidad";
    }
}
    
}
