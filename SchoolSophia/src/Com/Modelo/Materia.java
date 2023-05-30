/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Modelo;

/**
 *
 * @author Silfredo
 */
public class Materia {
   
    private int id;
    private String nombreCurso;
    private String nombreCarrera;
    private String nivelCarrera;

    public Materia() {
    }

    
    public Materia(int id, String nombreCurso, String nombreCarrera, String nivelCarrera) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.nombreCarrera = nombreCarrera;
        this.nivelCarrera = nivelCarrera;
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
     * @return the nombreCarrera
     */
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    /**
     * @param nombreCarrera the nombreCarrera to set
     */
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    /**
     * @return the nivelCarrera
     */
    public String getNivelCarrera() {
        return nivelCarrera;
    }

    /**
     * @param nivelCarrera the nivelCarrera to set
     */
    public void setNivelCarrera(String nivelCarrera) {
        this.nivelCarrera = nivelCarrera;
    }

    /**
     * @return the nombreCurso
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * @param nombreCurso the nombreCurso to set
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombreCurso=" + nombreCurso + ", nombreCarrera=" + nombreCarrera + ", nivelCarrera=" + nivelCarrera + '}';
    }

}
