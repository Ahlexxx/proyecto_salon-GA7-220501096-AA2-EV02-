package com.salonbelleza;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CitasServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String servicio = request.getParameter("servicio");
        String funcionario = request.getParameter("funcionario");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        Cita cita = new Cita();
        cita.setUsuario(usuario);
        cita.setServicio(servicio);
        cita.setFuncionario(funcionario);
        cita.setFecha(fecha);
        cita.setHora(hora);

        try {
            CitaDAO insertarCitaDAO = new CitaDAO();
            insertarCitaDAO.insertarCita(cita);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\":\"success\"}");
        } catch (SQLException e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"status\":\"error\",\"message\":\"" + e.getMessage() + "\"}");
        }
    }
}

