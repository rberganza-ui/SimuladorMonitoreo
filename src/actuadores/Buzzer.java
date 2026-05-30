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
    protected String intensidad;

    public Buzzer(String intensidad, String nombre) {
        super(nombre);
        this.intensidad = intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }
    
    
    
    @Override
    public void ejecutar(){
        if(!activo){
            System.out.println("Buzzer esta desactivado");
            
        }
        else{
            System.out.println("Buzzer esta sonando "+intensidad);
            
        }
    };
    
}
