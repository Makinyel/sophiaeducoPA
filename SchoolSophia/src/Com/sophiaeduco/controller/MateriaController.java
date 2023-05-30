package com.sophiaeduco.controller;

import Com.Modelo.Materia;
import Com.sophia.edu.cop.conexion.SchoolConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Silfredo
 */
public class MateriaController {

    private final SchoolConnection sc = new SchoolConnection();
    private final Connection connection = sc.getConnection();
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql = "";
    private final CarreraController cc = new CarreraController();

    public boolean añadirMateria(Materia materias) {
        sql = "insert into materias (nombre,carrrera,nivel) values (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, materias.getNombreCarrera());
            ps.setString(2, materias.getNombreCarrera());
            ps.setString(3, materias.getNivelCarrera());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    
    public List<Materia> getAllMaterias(String s) {
        sql = s.isEmpty() ? "select * from materias" : "SELECT * FROM materias WHERE nombre LIKE '%" + s + "%';";
        List<Materia> materias = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Materia mat = new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("carrera"), rs.getString("nivel"));
                materias.add(mat);
            }
            return materias;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return materias;
    }
    
    
//
//    public void insertAll() {
//        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Sofía", "Diego", "Valeria", "Andrés", "Camila", "Roberto", "Isabella", "Miguel", "Gabriela", "Javier", "Daniela", "Alejandro", "Lucía", "Ricardo", "Paula", "Fernando", "Valentina", "Mario", "Carolina", "Gonzalo", "Natalia", "Héctor", "Mariana"};
//        int[] edades = {30, 35, 40, 28, 33, 42, 27, 31, 39, 36, 34, 29, 32, 37, 41, 38, 26, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55};
//        String[] telefonos = {"1234567890", "9876543210", "5678901234", "4321098765", "9012345678", "3456789012", "7890123456", "2109876543", "6543210987", "8901234567", "2345678901", "6789012345", "0123456789", "4567890123", "8901234567", "2345678901", "6789012345", "0123456789", "4567890123", "8901234567", "2345678901", "6789012345", "0123456789", "4567890123", "8901234567", "2345678901", "6789012345", "0123456789", "4567890123", "8901234567"};
//        String[] generos = {"Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino", "Femenino", "Masculino"};
//        String[] correos = {"juan@example.com", "maria@example.com", "pedro@example.com", "ana@example.com", "luis@example.com", "laura@example.com", "carlos@example.com", "sofia@example.com", "diego@example.com", "valeria@example.com", "andres@example.com", "camila@example.com", "roberto@example.com", "isabella@example.com", "miguel@example.com", "gabriela@example.com", "javier@example.com", "daniela@example.com", "alejandro@example.com", "lucia@example.com", "ricardo@example.com", "paula@example.com", "fernando@example.com", "valentina@example.com", "mario@example.com", "carolina@example.com", "gonzalo@example.com", "natalia@example.com", "hector@example.com", "mariana@example.com"};
//        Boolean[] estados = {true, true, true, true, true, true, true, true, true, true,true, true, true, true, true,true, true, true, true, true,true, true, true, true, true,true, true, true, true, true,};
//        String sql = "INSERT INTO profesores (numeroId, nombre, edad, telefono, genero, correo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            for (int i = 0; i < 30; i++) {
//                ps.setInt(1, i + 1);
//                ps.setString(2, nombres[i]);
//                ps.setInt(3, edades[i]);
//                ps.setString(4, telefonos[i]);
//                ps.setString(5, generos[i]);
//                ps.setString(6, correos[i]);
//                ps.setBoolean(7, estados[i]);
//                ps.executeUpdate();
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    public void insertAllMaterias() {
//        String[] nombres = {"Programación I", "Matemáticas Discretas", "Estructuras de Datos", "Bases de Datos", "Análisis de Algoritmos", "Redes de Computadoras", "Ingeniería de Software", "Sistemas Operativos", "Inteligencia Artificial", "Arquitectura de Computadoras", "Seguridad Informática", "Sistemas Distribuidos", "Interacción Humano-Computadora", "Desarrollo Web", "Ingeniería de Requisitos"};
//        String carrera = "Ingeniería en Sistemas";
//        String[] niveles = {"Quinto", "Segundo", "Séptimo", "Tercero", "Décimo", "Cuarto", "Noveno", "Primero", "Sexto", "Octavo", "Segundo", "Quinto", "Tercero", "Séptimo", "Cuarto"};
//
//        Random random = new Random();
//
//        for (int i = 0; i < 15; i++) {
//            int nivelIndex = random.nextInt(niveles.length);
//            String nivel = niveles[nivelIndex];
//
//            String s = "INSERT INTO materias (nombre, carrera, nivel) VALUES (?, ?, ?)";
//
//            try (PreparedStatement p = connection.prepareStatement(s)) {
//                p.setString(1, nombres[i]);
//                p.setString(2, carrera);
//                p.setString(3, nivel);
//                p.executeUpdate();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public void llenarComboBox(String tabla,String valor,JComboBox combobox){
        sql ="select * from "+tabla;
        try{
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                combobox.addItem(rs.getString(valor));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
//    public void insertAllMedicinaMateries() {
//        String[] nombresMedicina = {"Anatomía", "Fisiología", "Bioquímica", "Farmacología", "Microbiología", "Patología", "Ginecología", "Pediatría", "Cirugía", "Cardiología", "Neurología", "Dermatología", "Psiquiatría", "Radiología", "Oftalmología"};
//        String carreraMedicina = "Medicina";
//        String[] nivelesMedicina = {"Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo", "Octavo", "Noveno", "Décimo", "Undécimo", "Duodécimo", "Decimotercero", "Decimocuarto", "Decimoquinto", "Decimosexto"};
//
//        Random randomMedicina = new Random();
//
//        for (int i = 0; i < 15; i++) {
//            int nivelIndex = randomMedicina.nextInt(nivelesMedicina.length);
//            String nivel = nivelesMedicina[nivelIndex];
//
//            String sqlMedicina = "INSERT INTO materias (nombre, carrera, nivel) VALUES (?, ?, ?)";
//
//            try (PreparedStatement ps = connection.prepareStatement(sqlMedicina)) {
//                ps.setString(1, nombresMedicina[i]);
//                ps.setString(2, carreraMedicina);
//                ps.setString(3, nivel);
//                ps.executeUpdate();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    public void addAllIngCivil() {
//        String[] nombresIngenieriaCivil = {"Mecánica de Suelos", "Estructuras", "Hidráulica", "Geotecnia", "Transporte", "Construcción", "Topografía", "Ingeniería de Costos", "Planeamiento Urbano", "Cimentaciones", "Diseño Estructural", "Materiales de Construcción", "Gestión de Proyectos", "Ingeniería Sísmica", "Hidrología"};
//        String carreraIngenieriaCivil = "Ingeniería Civil";
//        String[] nivelesIngenieriaCivil = {"Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Séptimo", "Octavo", "Noveno", "Décimo", "Undécimo", "Duodécimo", "Decimotercero", "Decimocuarto", "Decimoquinto", "Decimosexto"};
//
//        Random randomIngenieriaCivil = new Random();
//
//        for (int i = 0; i < 15; i++) {
//            int nivelIndex = randomIngenieriaCivil.nextInt(nivelesIngenieriaCivil.length);
//            String nivel = nivelesIngenieriaCivil[nivelIndex];
//
//            String sqlIngenieriaCivil = "INSERT INTO materias (nombre, carrera, nivel) VALUES (?, ?, ?)";
//
//            try (PreparedStatement ps = connection.prepareStatement(sqlIngenieriaCivil)) {
//                ps.setString(1, nombresIngenieriaCivil[i]);
//                ps.setString(2, carreraIngenieriaCivil);
//                ps.setString(3, nivel);
//                ps.executeUpdate();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//    }

}
