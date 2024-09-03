/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static util.DatabaseConnection.getConnection;
/**
 *
 * @author camper
 */
public class NinjaModel {

    public boolean createNinja(String name, int identificador, String cumpleanos, String estado, int habilidadesId, Integer misionId, Integer actividadNinjaId) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO staff (name, identifier, birthdate, status, role_id, event_id, personal_activity_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setInt(2, identificador);
                statement.setString(3, cumpleanos);
                statement.setString(4, estado);
                statement.setInt(5, habilidadesId);
                if (misionId != null) {
                    statement.setInt(6, misionId);
                } else {
                    statement.setNull(6, java.sql.Types.INTEGER);
                }
                if (actividadNinjaId != null) {
                    statement.setInt(7, actividadNinjaId);
                } else {
                    statement.setNull(7, java.sql.Types.INTEGER);
                }
                return statement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

public List<String> getAllNinja() {
        List<String> ninjaList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM staff";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ninjaList.add(resultSet.getInt("ninja_id") + 
                            ": " + resultSet.getString("name") +
                            "," + resultSet.getInt("identificador") +
                            "," + resultSet.getString("cumpleanos") +
                            "," + resultSet.getString("estado") +
                            "," + resultSet.getInt("habilildes_id") +
                            "," + resultSet.getInt("mision_id") +
                            "," + resultSet.getInt("actividadNinja_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ninjaList;
    }

    public boolean updateNinja(int ninjaId, String name, Integer identificador, String cumpleanos, String estado, Integer HabilidadesId, Integer misionId, Integer actividadNinjaId) {
        try (Connection connection = getConnection()) {
            StringBuilder queryBuilder = new StringBuilder("UPDATE staff SET ");
            boolean needComma = false;

            if (name != null && !name.isEmpty()) {
                queryBuilder.append("name = ?");
                needComma = true;
            }

            if (identificador != null) {
                if (needComma) queryBuilder.append(", ");
                queryBuilder.append("identifier = ?");
                needComma = true;
            }

            if (cumpleanos != null && !cumpleanos.isEmpty()) {
                if (needComma) queryBuilder.append(", ");
                queryBuilder.append("birthdate = ?");
                needComma = true;
            }

            if (estado != null && !estado.isEmpty()) {
                if (needComma) queryBuilder.append(", ");
                queryBuilder.append("estado = ?");
                needComma = true;
            }

            if (habilidadesId != null) {
                if (needComma) queryBuilder.append(", ");
                queryBuilder.append("habilidades_id = ?");
                needComma = true;
            }

            if (misionId != null) {
                if (needComma) queryBuilder.append(", ");
                queryBuilder.append("Mision_id = ?");
                needComma = true;
            }

            if (actividadNinjaId != null) {
                if (needComma) queryBuilder.append(", ");
                queryBuilder.append("personal_activity_id = ?");
                needComma = true;
            }

            queryBuilder.append(" WHERE staff_id = ?");
            try (PreparedStatement statement = connection.prepareStatement(queryBuilder.toString())) {
                int index = 1;

                if (name != null && !name.isEmpty()) {
                    statement.setString(index++, name);
                }

                if (identificador != null) {
                    statement.setInt(index++, identificador);
                }

                if (cumpleanos != null && !cumpleanos.isEmpty()) {
                    statement.setString(index++, cumpleanos);
                }

                if (estado!= null && !estado.isEmpty()) {
                    statement.setString(index++, estado);
                }

                if (habilidadesId != null) {
                    statement.setInt(index++, habilidadesId);
                }

                if (misionId != null) {
                    statement.setInt(index++, misionId);
                }

                if (actividadNinjaId != null) {
                    statement.setInt(index++, actividadNinja);
                }

                statement.setInt(index, ninjaId);
                return statement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNinja(int ninjaId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM staff WHERE staff_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, ninjaId);
                return statement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getNinjaDetails(int ninjaId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM staff WHERE staff_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, ninjaId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("ninja_id") + ": " + resultSet.getString("name") +
                                ", Identificador: " + resultSet.getInt("identificador") +
                                ", Cumpleanos: " + resultSet.getString("cumpleanos") +
                                ", Estado: " + resultSet.getString("estado") +
                                ", Habilidades ID: " + resultSet.getInt("habilidades_id") +
                                ", Mision ID: " + resultSet.getInt("mision_id") +
                                ", ActividadNinja ID: " + resultSet.getInt("actividadNinja_id");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
