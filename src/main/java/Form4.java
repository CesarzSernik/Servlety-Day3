import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/post4"})
public class Form4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer a = Integer.parseInt(req.getParameter("a"));
        Integer b = Integer.parseInt(req.getParameter("b"));
        Integer c = Integer.parseInt(req.getParameter("c"));

        Integer result = 0;
    }
}
