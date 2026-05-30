/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sensores;

import interfaces.Activable;

/**
 *
 * @author rodolfo
 */
public class Sensor implements Activable{
    protected String nombre;
    protected double valorActual;
    protected String UnidadMedida;
    protected boolean activo;

    public Sensor(String nombre, String UnidadMedida) {
        this.nombre = nombre;
        this.valorActual=0;
        this.UnidadMedida = UnidadMedida;
        this.activo=true;
        
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorActual() {
        return valorActual;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
    public void leervalor(double entrada){
        valorActual=entrada;
        
    }
    @Override
    public void activar(){
        activo=true;
    }
    @Override
    public void desactivar(){
        activo=false;
    }

    @Override
    public String toString() {
        return "Sensor{" + "nombre=" + nombre + ", valorActual=" + valorActual + ", UnidadMedida=" + UnidadMedida + ", activo=" + activo + '}';
    }
    
    
   
    
}
