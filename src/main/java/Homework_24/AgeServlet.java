package Homework_24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AgeServlet", value = "/age", loadOnStartup = 2)
public class AgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        int age = Integer.parseInt(request.getParameter("age"));

        if (age >= 18){
            response.getWriter().println("Вы совершеннолетний");
        }else {
            response.getWriter().println("Вы не совершеннолетний");
        }
    }

}
