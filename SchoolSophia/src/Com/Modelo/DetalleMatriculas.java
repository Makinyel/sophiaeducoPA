package Com.Modelo;


/**
 *
 * @author Silfredo
 */
public class DetalleMatriculas {
    
    private int idDetalle;
    private int idMatricula;
    private String asignatura;

    public DetalleMatriculas() {
    }

    
    public DetalleMatriculas(String a){
        this.asignatura = a;
    }
    
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    @Override
    public String toString() {
        return "DetalleMatricula [idDetalle=" + idDetalle + ", matricula=" + idMatricula + ", asignatura=" + asignatura
                + "]";
    }
}


