package com.example.el1.controller;

import com.example.el1.model.Empleado;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Recibimos el parametro de la peticion get (Link)
        String noEmp = request.getParameter("noEmpleado");
        Empleado pagoBean = new Empleado(Integer.parseInt(noEmp));
        // Llenamos JavaBean (podriamos utilizar una bd)
        pagoBean.setNombre("Jose Antonio");
        pagoBean.setHorasTrabajadas(4);
        pagoBean.setPrecioHora(75);
        request.setAttribute("pago", pagoBean);
        RequestDispatcher rd = request.getRequestDispatcher("salario.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
