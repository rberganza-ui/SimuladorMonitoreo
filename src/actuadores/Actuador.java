/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actuadores;

import interfaces.Activable;

/**
 *
 * @author rodolfo
 */
public abstract class Actuador implements Activable{
    protected String nombre;
    protected boolean activo;
    
    @Override
    public void activar(){
        activo=true;
    }
    @Override
    public void desactivar(){
        activo=false;
    }

    public Actuador(String nombre) {
        this.nombre = nombre;
        this.activo = true;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public abstract void ejecutar();
    
    
}
