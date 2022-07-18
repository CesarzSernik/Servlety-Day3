import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/session1Get")
public class Session1Get extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object counter = session.getAttribute("counter");
        if (Objects.nonNull(counter)) {
            int counterInt = (int) counter;
            resp.getWriter().print(counter);
            session.setAttribute("counter", counterInt + 1);
        }
    }
}
