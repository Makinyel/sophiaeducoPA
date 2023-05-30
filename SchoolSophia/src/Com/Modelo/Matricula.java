package Com.Modelo;

import java.util.Date;

/**
 *
 * @author Silfredo
 */
public class Matricula {

    private int idMatricula;
    private String estudiante;
    private String carrara;
    private String niveles;
    private String periodo;
    private Date fechaNow;

    public Matricula() {
    }

    public Matricula(int idMatricula, String estudiante, String carrara, String niveles, String periodo, Date fechaNow) {
        this.idMatricula = idMatricula;
        this.estudiante = estudiante;
        this.carrara = carrara;
        this.niveles = niveles;
        this.periodo = periodo;
        this.fechaNow = fechaNow;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getCarrara() {
        return carrara;
    }

    public void setCarrara(String carrara) {
        this.carrara = carrara;
    }

    public String getNiveles() {
        return niveles;
    }

    public void setNiveles(String niveles) {
        this.niveles = niveles;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFechaNow() {
        return fechaNow;
    }

    public void setFechaNow(Date fechaNow) {
        this.fechaNow = fechaNow;
    }

    @Override
    public String toString() {
        return "Matricula{" + "idMatricula=" + idMatricula + ", estudiante=" + estudiante + ", carrara=" + carrara + ", niveles=" + niveles + ", periodo=" + periodo + ", fechaNow=" + fechaNow + '}';
    }

    
    
}
