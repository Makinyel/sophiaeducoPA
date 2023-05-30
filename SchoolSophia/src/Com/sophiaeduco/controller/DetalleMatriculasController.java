/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.sophiaeduco.controller;

import Com.Modelo.DetalleMatriculas;
import Com.Modelo.Matricula;
import Com.sophia.edu.cop.conexion.SchoolConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usurario
 */
public class DetalleMatriculasController {

    private final SchoolConnection sc = new SchoolConnection();
    private final Connection connection = sc.getConnection();
    private String sql = "";
    private PreparedStatement ps;
    private ResultSet rs;
    private final MatriculasController mc = new MatriculasController();

    public List<DetalleMatriculas> getDetallesMatriculas(int a) {
        List<DetalleMatriculas>dtm = new ArrayList<>();
        sql = "select * from matriculas_materias where matricula_id = '" + a + "'";
        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleMatriculas dm = new DetalleMatriculas(rs.getString("idMateria"));
                dtm.add(dm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dtm;
    }

    public static void main(String[] args) {
        DetalleMatriculasController dtmc = new DetalleMatriculasController();
        System.out.println( dtmc.getDetallesMatriculas(1));
    }
}
