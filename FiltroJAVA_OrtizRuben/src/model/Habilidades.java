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
public class HabilidadesModel {

    public boolean createHabilidades(String name) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO roles (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                return statement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String> getAllHabilidades() {
        List<String> roles = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM roles";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    roles.add(resultSet.getInt("role_id") + ": " + resultSet.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public boolean updateHabilidades(int roleId, String name) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE roles SET name = ? WHERE role_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setInt(2, roleId);
                return statement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteHabilidades(int roleId) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM roles WHERE role_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, roleId);
                return statement.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean HabilidadesExists(int roleId) {
        try (Connection connection = getConnection()) {
            String query = "SELECT COUNT(*) AS count FROM roles WHERE role_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, roleId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("count") > 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
