import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addToSession")
public class session3Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter()
                .println("<html><body><form action=\"/addToSession\" method=\"GET\">\n" +
                        "    <label>\n" +
                        "        Klucz:\n" +
                        "        <input type=\"text\" name=\"key\">\n" +
                        "    </label>\n" +
                        "    <label>\n" +
                        "        Wartość:\n" +
                        "        <input type=\"text\" name=\"value\">\n" +
                        "    </label>\n" +
                        "    <input type=\"submit\">\n" +
                        "</form></html></body>\n");

        String key = req.getParameter("key");
        String value = req.getParameter("value");
        HttpSession session = req.getSession();
        if (session.isNew()) {
            ArrayList<String> keys = new ArrayList<>();
            keys.add(key);
            session.setAttribute("keys", keys);
        }else{
            List<String> keys = (List<String>)session.getAttribute("keys");
            keys.add(key);
            session.setAttribute("keys",keys);
            session.setAttribute(key, value);
        }


    }
}
