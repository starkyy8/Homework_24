package Homework_24;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "CityServlet", value = "/minsk", loadOnStartup = 1)
public class CityServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html; charset=UTF-8");
        ZoneId minskTime = ZoneId.of("Europe/Minsk");
        ZoneId washingtonTime = ZoneId.of("America/New_York");
        ZoneId beijingTime = ZoneId.of("Asia/Shanghai");


        String timeReq = req.getServletPath();
        ZonedDateTime dateTime;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");



        switch (timeReq){
            case "/minsk" -> dateTime = ZonedDateTime.now(minskTime);
            case "/washington" -> dateTime = ZonedDateTime.now(washingtonTime);
            case "/beijing" -> dateTime = ZonedDateTime.now(beijingTime);
            default -> dateTime = ZonedDateTime.now();
        }
        res.getWriter().println(dateTimeFormatter.format(dateTime));
    }
}
