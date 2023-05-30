/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Modelo;

/**
 *
 * @author Silfredo
 */


public class Estudiantes {
   
    private String numeroDoc;
    private String apellidos;
    private String nombre;
    private int edad;
    private String direccion;
    private String estadoCivil;
    private String genero;
    private String telefono;
    private String correo;

    public Estudiantes(){
        
    }
    public Estudiantes(String numeroDoc, String apellidos, String nombre, int edad, String direccion, String estadoCivil, String genero, String telefono, String correo) {
        this.numeroDoc = numeroDoc;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.telefono = telefono;
        this.correo = correo;
    }

  

    @Override
    public String toString() {
        return "Estudiantes{" + "numeroDoc=" + numeroDoc + ", apellidos=" + apellidos + ", nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", estadoCivil=" + estadoCivil + ", genero=" + genero + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
