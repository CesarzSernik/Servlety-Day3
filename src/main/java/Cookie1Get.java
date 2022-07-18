import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = {"/showCookie"})
public class Cookie1Get extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (Objects.nonNull(cookies)) {
            for (Cookie c : cookies) {
                if (c.getName().equals("User")) {
                    resp.getWriter().println(c.getValue());
                }
            }
        }else {
            resp.getWriter().println("BRAK");
        }
    }
}
