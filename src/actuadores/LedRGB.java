/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actuadores;

/**
 *
 * @author rodolfo
 */
public class LedRGB extends Actuador{
    public String Color;

    public LedRGB(String nombre) {
        super(nombre);
        this.Color ="Verde";
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    
    @Override
    public String ejecutar(){
    if(!activo){
        return "LedRGB desactivado";
    }
    else{
        return "LedRGB encendido de color " + Color;
    }
}
}
