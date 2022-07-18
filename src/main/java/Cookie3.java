import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cookie3")
public class Cookie3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        String time = req.getParameter("time");
        int timeAsInt = 60 * 60 * Integer.parseInt(time);

        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(timeAsInt);

        resp.addCookie(cookie);
    }
}
