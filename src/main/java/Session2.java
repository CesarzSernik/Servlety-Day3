import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/session2")
public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.getWriter()
               .println("<html><body><form action=\"/session2\" method = \"post\">" +
               "<input name=\"ocena\"><br><button type=\"submit\">wyslij</button></form></body></html>");

       resp.getWriter().println("------------------------------------");
        HttpSession session = req.getSession();

        if (session.isNew()){
        List<Integer> oceny = new ArrayList<>();
        session.setAttribute("ocena",oceny);

        }else{

            Integer sumaOcen = 0;
            String ocena = req.getParameter("ocena");

            List <Integer> oceny =(List<Integer>) session.getAttribute("oceny");
            oceny.add(Integer.valueOf(ocena));
            session.setAttribute("oceny",oceny);

            for (Integer o : oceny){
                sumaOcen += o;
                resp.getWriter().println(o);
            }
            resp.getWriter().println("Średnia:" + (double) sumaOcen/oceny.size());
        }
    }
}
