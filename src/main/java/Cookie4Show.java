import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//Przy każdym z nich wygeneruj link do drugiego servletu Cookie4Del.
//Pamiętaj o przekazaniu w danych GET nazwy tego ciasteczka.

@WebServlet(urlPatterns = "/showAllCookies")
public class Cookie4Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie c:cookies) {
            resp.getWriter().append(c.toString()).append("\n");
            c.getPath();
        }
    }
}
