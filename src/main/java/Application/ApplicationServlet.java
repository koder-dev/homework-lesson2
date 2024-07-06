package Application;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class ApplicationServlet extends HttpServlet {
    private ApplicationService appService = new ApplicationService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Work");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String phoneNumber = req.getParameter("phoneNumber");
        String education = req.getParameter("education");
        String workExperience = req.getParameter("workExperience");
        String skills = req.getParameter("skills");

        CV cv = appService.createCV(fullName, email, age, phoneNumber, education, workExperience, skills);
        if (appService.saveCvToDatabase(cv)) {
            try {
                resp.sendRedirect("thank-you-page.html");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                resp.sendRedirect("fail-page.html");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
