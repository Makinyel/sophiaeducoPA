package com.sophiaeduco.controller;

import Com.Modelo.Estudiantes;
import Com.sophia.edu.cop.conexion.SchoolConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Silfredo
 */
public class AlumnoController {

    private final SchoolConnection sc = new SchoolConnection();
    private final Connection connection = sc.getConnection();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql = "";

    public boolean addStudent(Estudiantes estudiantes) {
        sql = "INSERT INTO estudiantes (numero_doc, nombre, edad, direccion, genero, estado, estadoCivil, apellidos, telefono, correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            ps = connection.prepareStatement(sql);
            ps.setString(1, estudiantes.getNumeroDoc());
            ps.setString(2, estudiantes.getNombre());
            ps.setInt(3, estudiantes.getEdad());
            ps.setString(4, estudiantes.getDireccion());
            ps.setString(5, estudiantes.getGenero());
            ps.setBoolean(6, true);
            ps.setString(7, estudiantes.getEstadoCivil());
            ps.setString(8, estudiantes.getApellidos());
            ps.setString(9, estudiantes.getTelefono());
            ps.setString(10, estudiantes.getCorreo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateStudent(String id, Estudiantes estudiantes) {
        sql = "update estudiantes set id = ?,nombre = ?, edad = ?, direccion = ?, genero = ?,estadoCivil = ?,apellidos = ?,telefono = ?,correo = ? where id = '" + id + "'";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, estudiantes.getNumeroDoc());
            ps.setString(2, estudiantes.getNombre());
            ps.setInt(3, estudiantes.getEdad());
            ps.setString(4, estudiantes.getDireccion());
            ps.setString(5, estudiantes.getGenero());
            ps.setString(6, estudiantes.getEstadoCivil());
            ps.setString(7, estudiantes.getApellidos());
            ps.setString(8, estudiantes.getTelefono());
            ps.setString(9, estudiantes.getCorreo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean existUserByEmail(Estudiantes estudiantes) {
        boolean result = false;
        sql = "select * from estudiantes where correo= ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, estudiantes.getCorreo());

            rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }

    public Estudiantes findById(String id) throws SQLException {
        sql = "select * from estudiantes where numero_doc ='" + id + "'";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        Estudiantes estudiante = new Estudiantes();

        if (rs.next()) {
            estudiante.setApellidos(rs.getString("apellidos"));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setCorreo(rs.getString("correo"));
            estudiante.setTelefono(rs.getString("telefono"));
            estudiante.setEdad(rs.getInt("edad"));
            estudiante.setEstadoCivil(rs.getString("estado_civil"));
            estudiante.setDireccion(rs.getString("direccion"));
            estudiante.setGenero(rs.getString("genero"));
            estudiante.setNumeroDoc(id);
        }
        return estudiante;
    }

    public void addItemsInCombobox(String table, String value, JComboBox jComboBox) {
        sql = "select * from " + table;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                jComboBox.addItem(rs.getString(value));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public boolean deleteById(String id) throws SQLException {
        sql = "delete from estudiantes where numero_doc ='" + id + "'";
        ps = connection.prepareStatement(sql);
        return ps.execute();
    }

    public boolean existUserById(Estudiantes estudiantes) {
        boolean result = false;
        sql = "select * from estudiantes where numero_doc= ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, estudiantes.getNumeroDoc());

            rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return result;
    }

    public List<Estudiantes> getAllStudents(String id) {
        sql = id.isEmpty() ? "SELECT * FROM estudiantes;" : "SELECT * FROM estudiantes WHERE numero_doc LIKE '%" + id + "%'";
        List<Estudiantes> listOfStudents = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiantes estudiantes = new Estudiantes();
                estudiantes.setNumeroDoc(rs.getString("numero_doc"));
                estudiantes.setApellidos(rs.getString("apellidos"));
                estudiantes.setNombre(rs.getString("nombre"));
                estudiantes.setEdad(rs.getInt("edad"));
                estudiantes.setDireccion(rs.getString("direccion"));
                estudiantes.setGenero(rs.getString("genero"));
                estudiantes.setEstadoCivil(rs.getString("estadoCivil"));
                estudiantes.setCorreo(rs.getString("correo"));

                listOfStudents.add(estudiantes);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listOfStudents;

    }

    public List<Estudiantes> getAllStudentsFiltrados(String id, String as) {
        sql = id.isEmpty() ? "SELECT * FROM estudiantes;" : "SELECT * FROM estudiantes WHERE " + as + " LIKE '%" + id + "%'";
        List<Estudiantes> listOfStudents = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Estudiantes estudiantes = new Estudiantes();
                estudiantes.setNumeroDoc(rs.getString("id"));
                estudiantes.setApellidos(rs.getString("apellidos"));
                estudiantes.setNombre(rs.getString("nombre"));
                estudiantes.setEdad(rs.getInt("edad"));
                estudiantes.setDireccion(rs.getString("direccion"));
                estudiantes.setGenero(rs.getString("genero"));
                estudiantes.setEstadoCivil(rs.getString("estadoCivil"));
                estudiantes.setCorreo(rs.getString("correo"));

                listOfStudents.add(estudiantes);
            }
            return listOfStudents;
        } catch (SQLException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        AlumnoController ac = new AlumnoController();
        ac.getAllStudents("").forEach(System.out::println);
    }
}
