/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Modelo;

import java.util.Date;

/**
 *
 * @author Silfredo
 */
public class Periodos {
    
    private int id;
    private String fechaInicio;
    private String fechaFin;
    private String fechaCreacion;

    public Periodos( String fechaInicio, String fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Periodos() {
    }
    
    
    /**
     *@return the fechaCreacion 
     */
    private String getFechaCreacion(){
        return fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
