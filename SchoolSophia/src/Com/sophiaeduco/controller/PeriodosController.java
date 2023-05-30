package com.sophiaeduco.controller;

/**
 *
 * @author Silfredo
 */
import Com.Modelo.Periodos;
import Com.sophia.edu.cop.conexion.SchoolConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PeriodosController {

    SchoolConnection sc = new SchoolConnection();
    Connection connection = sc.getConnection();
    String sql = "";
    PreparedStatement ps;

    public List<Periodos> getAllPeriodos() {
        List<Periodos> allPeriodos = new ArrayList<>();
        sql = "SELECT * FROM periodos;";
        try {
            ps = connection.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Periodos periodo = new Periodos(rs.getString("fechaInicio"), rs.getString("fechaFinal"));
                allPeriodos.add(periodo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return allPeriodos;
    }

    public boolean updatePeriodo(String fechaInicio, String fechaFinal, String fechaInicioC, String fechaFinalC) {
        sql = "update periodos set fechaInicio = ?, fechaFinal = ? where fechaInicio = '" + fechaInicio + "' and fechaFinal = '" + fechaFinal + "'";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, fechaInicioC);
            ps.setString(2, fechaFinalC);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean addPeriodo(Periodos periodos) throws SQLException {
        sql = "INSERT INTO periodos (fechaInicio, fechaFinal) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, String.valueOf(periodos.getFechaInicio()));
            ps.setString(2, String.valueOf(periodos.getFechaFin()));

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static final String date(Date date1) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(date1);
    }

    public static void main(String[] args) throws SQLException {
        Periodos periodo = new Periodos();
        Date date1 = new Date();
        System.out.println(
                PeriodosController.date(date1)
        );
        periodo.setFechaInicio("2023-01-01"); // Reemplaza con el valor correspondiente
        periodo.setFechaFin("2023-12-31"); // Reemplaza con el valor correspondiente
        SimpleDateFormat sdf = new SimpleDateFormat();
        PeriodosController pc = new PeriodosController();
        System.out.println(pc.addPeriodo(periodo));
    }

}
