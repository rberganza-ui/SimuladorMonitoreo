/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actuadores;

/**
 *
 * @author rodolfo
 */
public class Ventilador extends Actuador {
    public int velocidad;

    public Ventilador(String nombre) {
        super(nombre);
        this.velocidad =0;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
    
    @Override
public String ejecutar(){
    if(!activo){
        return "Ventilador desactivado";
    }
    else{
        return "Ventilador encendido al " + velocidad + "%";
    }
}

}
