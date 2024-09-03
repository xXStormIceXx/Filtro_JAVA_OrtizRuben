/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.DatabaseConnection;
/**
 *
 * @author camper
 */
public class MisionModel {

    public boolean createMision(String name, String continente, String aldea, String distrito, int maxCapacidadNinja, int maxCapacidadMision, LocalDate date, Time time, String organizador, int rango_clasificacion, String estado) {
        if (isMisionNameTaken(name)) {
            System.out.println("\nName déjà vu! An event with this name already exists. How about a creative twist for your new event?");
            return false;
        }

        if (!isValidDate(date)) {
            System.out.println("\nHold your horses! Events need to be at least 7 days into the future. Time travel not supported!");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO event (name, continente, aldea, distrito, max_capacidad_ninja, max_capacidad_mision, date, time, organizador, rango_clasificacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, continente);
            pstmt.setString(3, aldea);
            pstmt.setString(4, distrito);
            pstmt.setInt(5, maxCapacidadNinja);
            pstmt.setInt(6, maxCapacidadMision);
            pstmt.setDate(8, Date.valueOf(date));
            pstmt.setTime(9, time);
            pstmt.setString(10, organizador);
            pstmt.setInt(11, rango_clasificacion);
            pstmt.setString(12, estado);
            pstmt.executeUpdate();
            System.out.println("╚═> Event successfully created!\n");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<String, Object> getMisionDetails(int misionId) {
        Map<String, Object> details = new HashMap<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM event WHERE event_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, misionId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                details.put("mision_id", rs.getInt("mision_id"));
                details.put("name", rs.getString("name"));
                details.put("continente", rs.getString("continente"));
                details.put("aldea", rs.getString("aldea"));
                details.put("distrito", rs.getString("distrito"));
                details.put("max_capacidad_ninja", rs.getInt("max_capacidad_ninja"));
                details.put("max_capacidad_mision", rs.getInt("max_capacidad_mision"));
                details.put("date", rs.getDate("date").toString());
                details.put("time", rs.getTime("time").toString());
                details.put("organizador", rs.getString("organizador"));
                details.put("rango_clasificacion", rs.getInt("rango_clasificacion"));
                details.put("estado", rs.getString("estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

    public List<String> getAllMisionWithDetails() {
        List<String> events = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM event";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                StringBuilder event = new StringBuilder();
                event.append("\n");
                event.append("ID: ").append(rs.getInt("event_id")).append("\n");
                event.append("Name: ").append(rs.getString("name")).append("\n");
                event.append("Country: ").append(rs.getString("country")).append("\n");
                event.append("City: ").append(rs.getString("city")).append("\n");
                event.append("Address: ").append(rs.getString("address")).append("\n");
                event.append("Max People: ").append(rs.getInt("max_people_capacity")).append("\n");
                event.append("Max Stores: ").append(rs.getInt("max_store_capacity")).append("\n");
                event.append("Max Restaurants: ").append(rs.getInt("max_restaurant_capacity")).append("\n");
                event.append("Date: ").append(rs.getDate("date").toString()).append("\n");
                event.append("Time: ").append(rs.getTime("time").toString()).append("\n");
                event.append("Organizer: ").append(rs.getString("organizer")).append("\n");
                event.append("Age Rating: ").append(rs.getInt("age_rating")).append("\n");
                event.append("Status: ").append(rs.getString("status")).append("\n");
                event.append("-----------------------------\n");

                events.add(event.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public boolean updateEventStatus(int eventId, String status) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE event SET status = ? WHERE event_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setInt(2, eventId);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEvent(int eventId, String name, String country, String city, String address, int maxPeople, int maxStores, int maxRestaurants, LocalDate date, Time time, String organizer, int ageRating, String status) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE event SET name = ?, country = ?, city = ?, address = ?, max_people_capacity = ?, max_store_capacity = ?, max_restaurant_capacity = ?, date = ?, time = ?, organizer = ?, age_rating = ?, status = ? WHERE event_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.setString(3, city);
            pstmt.setString(4, address);
            pstmt.setInt(5, maxPeople);
            pstmt.setInt(6, maxStores);
            pstmt.setInt(7, maxRestaurants);
            pstmt.setDate(8, Date.valueOf(date));
            pstmt.setTime(9, time);
            pstmt.setString(10, organizer);
            pstmt.setInt(11, ageRating);
            pstmt.setString(12, status);
            pstmt.setInt(13, eventId);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un evento y todas sus dependencias
    public boolean deleteEventAndDependencies(int eventId) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Inicia la transacción

            // Eliminar dependencias en tablas relacionadas
            deleteAccountingByEventId(conn, eventId);
            deleteClientsByEventId(conn, eventId);
            deleteCommerceByEventId(conn, eventId);
            deleteUtilityItemsByEventId(conn, eventId);
            deleteStaffByEventId(conn, eventId);
            deleteTicketReportByEventId(conn, eventId);

            // Finalmente, elimina el evento
            deleteEvent(conn, eventId);

            conn.commit(); // Confirma la transacción
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback(); // Revierte la transacción en caso de error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // Cierra la conexión después de completar
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void deleteStaffByEventId(Connection conn, int eventId) throws SQLException {
        String sql = "DELETE FROM staff WHERE event_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }

    private void deleteUtilityItemsByEventId(Connection conn, int eventId) throws SQLException {
        String sql = "DELETE FROM utility_item WHERE event_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }

    private void deleteClientsByEventId(Connection conn, int eventId) throws SQLException {
        String sql = "DELETE FROM client WHERE event_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }

    private void deleteAccountingByEventId(Connection conn, int eventId) throws SQLException {
        String sql = "DELETE FROM accounting WHERE event_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }

    private void deleteCommerceByEventId(Connection conn, int eventId) throws SQLException {
        String sql = "DELETE FROM commerce WHERE event_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }

    private void deleteTicketReportByEventId(Connection conn, int eventId) throws SQLException {
        String sql = "DELETE FROM ticket_report WHERE event_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }

    private void deleteEvent(Connection conn, int eventId) throws SQLException {
        String sql = "DELETE FROM event WHERE event_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventId);
            pstmt.executeUpdate();
        }
    }

    private boolean isEventNameTaken(String name) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT COUNT(*) FROM event WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    private boolean isValidDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return date.isAfter(currentDate.plusDays(6));
    }
}
