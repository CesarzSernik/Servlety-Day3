import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/getForm3"})
public class Form3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        int pageInt = Integer.parseInt(page);
        for (int i = 1; i <= pageInt; i++) {
            if (pageInt % i == 0) {
                resp.getWriter().append(String.valueOf(i)).append(" ");
            }
        }
    }
}
