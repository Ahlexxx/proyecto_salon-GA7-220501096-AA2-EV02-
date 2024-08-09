package com.salonbelleza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CitaDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/salon_de_belleza";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public void insertarCita(Cita cita) throws SQLException {
        // Cargar el driver JDBC de MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC no encontrado", e);
        }

        String sql = "INSERT INTO citas (usuario, servicio, funcionario, fecha, hora) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cita.getUsuario());
            stmt.setString(2, cita.getServicio());
            stmt.setString(3, cita.getFuncionario());
            stmt.setString(4, cita.getFecha());
            stmt.setString(5, cita.getHora());
            stmt.executeUpdate();
        }
    }

    void actualizarCita(Cita citaActualizar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void eliminarCita(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<Cita> listarCitas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


