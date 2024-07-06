package Application;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StatServlet extends HttpServlet {
    ApplicationService appService = new ApplicationService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        int totalCvs = appService.getTotalCountCVs();
        int averageAge = appService.getAverageAge();

        req.setAttribute("totalCvs", totalCvs);
        req.setAttribute("averageAge", averageAge);

        try {
            req.getRequestDispatcher("stat.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            System.out.println(e);
        }
    }
}
