package Com.sophiaeduco.controller;


/**
 *
 * @author Silfredo
 */
import Com.Modelo.DetalleMatriculas;
import Com.Modelo.Materia;
import Com.Modelo.Matricula;
import Com.sophia.edu.cop.conexion.SchoolConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculasController {

    private final SchoolConnection sc = new SchoolConnection();
    private final Connection connection = sc.getConnection();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql = "";

    public int getMaxId(){
        sql  ="select max(id) as maxId from matriculas";
        int numero = 0;
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                numero = rs.getInt("maxId");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return numero;
    }
    public boolean addNewMatricula(Matricula matricular) {
        sql = "INSERT INTO matriculas ( id_estudiante, carrera, nivel, periodo) VALUES ( ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, matricular.getEstudiante());
            ps.setString(2, matricular.getCarrara());
            ps.setString(3, matricular.getNiveles());
            ps.setString(4, matricular.getPeriodo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean addNewDetalleMatricula(DetalleMatriculas dm) {
        sql = "insert into matriculas_materias (idMatricula,idMateria) values (?,?)";
        try {
            ps = connection.prepareStatement(sql);
                ps.setInt(1, dm.getIdMatricula());
                ps.setString(2, dm.getAsignatura());
                ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Matricula> getMatriculaById(int id){
        List<Matricula>getMatricula = new ArrayList<>();
        sql  ="select * from matriculas where id_matricula = '"+id+"'";
        Matricula matricula = null;
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                 matricula = new Matricula(rs.getInt("id"), rs.getString("id_estudiante"), rs.getString("carrera"), rs.getString("nivel"), rs.getString("periodo"), rs.getDate("fechaCreacion"));
                 getMatricula.add(matricula);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return getMatricula;
    }
    public static void main(String[] args) throws SQLException {

        MatriculasController mc = new MatriculasController();
        List<Matricula> m = new ArrayList<>();
//        m.setCarrara("Ingeniería en sistema");
//        m.setEstudiante("Ismael Trocha");
//        m.setNiveles("Primer");
//        m.setPeriodo("Hoy Hasta Mañana");
//        mc.addNewMatricula(m);
//        Materia materia = new Materia();
//        materia.setNivelCarrera("Primer");
//        materia.setNombreCarrera("Ingeniería en sistema");
//        materia.setNombreCurso("Programacion Orientada a Objetos");}
    
    m = mc.getMatriculaById(1);
        System.out.println(mc.getMaxId());
    }
}
