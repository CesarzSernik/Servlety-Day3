import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(urlPatterns = {"/post2"})
public class Form2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userText = req.getParameter("userText");
        String agreement = req.getParameter("agreement");
        if (Objects.nonNull(agreement)) {
            resp.getWriter().append(userText);
        }else{
            ArrayList<String> swearing = new ArrayList<String>();
            swearing.add("cholera");
            swearing.add("kurwa");
            swearing.add("motyla noga");

            for (String swear:swearing){
                userText = userText.replaceAll(swear,swear.replaceAll("[a-zA-Z]", "*"));
            }
            resp.getWriter().append(userText);
        }
    }
}
