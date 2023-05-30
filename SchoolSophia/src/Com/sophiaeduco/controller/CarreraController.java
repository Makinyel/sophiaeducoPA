/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sophiaeduco.controller;

import Com.Modelo.Carreras;
import Com.Modelo.services.CarrerasService;
import Com.sophia.edu.cop.conexion.SchoolConnection;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JComboBox;

/**
 *
 * @author Silfredo
 */
public class CarreraController implements CarrerasService {

    private final SchoolConnection sc = new SchoolConnection();
    private final Connection connection = sc.getConnection();
    private String sql = "";
    private PreparedStatement ps;
    private ResultSet rs;

    public void setComboBoxItems(String table, String value, JComboBox b) {
        String sql = "select * from " + table;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                b.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean addCarreras(Carreras carrera) throws SQLException {
        sql = "insert into carreras (nombre) values(?)";
        ps = connection.prepareStatement(sql);
        ps.setString(1, carrera.getNombre());
        return ps.execute();
    }

    @Override
    public boolean existCarrera(String name) throws SQLException {
        boolean result = false;
        sql = "select * from carreras where nombre = '" + name + "'";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        if (rs.next()) {

            result = true;
        }

        return result;
    }

    @Override
    public boolean updateDegree(String name1, String name) {
        sql = "update carreras set nombre = ? where nombre = '" + name1 + "'";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.execute();
            return true;

        } catch (SQLException ex) {
            return false;
        }
    }

    //update carreras set nombre = ? where nombre = 
    @Override
    public List<Carreras> getAllCarreras(String name) throws SQLException {
        sql = name.isEmpty() ? "SELECT * FROM carreras;" : "SELECT * FROM carreras WHERE nombre LIKE '%" + name + "%'";
        List<Carreras> listOfCarreras = new ArrayList<>();
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            listOfCarreras.add(new Carreras(rs.getInt("id"), rs.getString("nombre"), rs.getBoolean("estado")));
        }
        return listOfCarreras.stream().filter(x -> x.getEstado() == true).collect(Collectors.toList());
    }

    @Override
    public boolean deleteByName(String name) {
        sql = "delete from carreras where nombre ='" + name + "'";
        try {
            ps = connection.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
