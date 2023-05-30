/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Com.Modelo.services;

import Com.Modelo.Carreras;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Usurario
 */
public interface CarrerasService {
    
    boolean addCarreras(Carreras carreras) throws SQLException;
    boolean existCarrera(String name)throws SQLException;
    boolean updateDegree(String name1, String name2);
    List<Carreras>getAllCarreras(String n)throws SQLException;
    boolean deleteByName(String name);
}
