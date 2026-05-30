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
    protected String Color;

    public LedRGB(String nombre) {
        super(nombre);
        this.Color ="Verde";
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    
    @Override
    public void ejecutar(){
        if(!activo){
            System.out.println("LedRGB esta desactivado");
            
        }
        else{
            System.out.println("LedRGB esta encendido de color "+Color);
            
        }
    };
}
