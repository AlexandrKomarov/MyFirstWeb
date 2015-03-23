package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: komarov.as
 * Date: 12.03.15
 * Time: 17:33
 * To change this template use File | Settings | File Templates.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getRequestDispatcher("index.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean rightParametrs = true;
        String answer = "Неверный формат";
        String a = (String) req.getParameter("a");
        String b = (String) req.getParameter("b");
        String c = (String) req.getParameter("c");
        double A = 0, B = 0, C = 0;
        try {
            A = Double.parseDouble(a);
        } catch (Exception e) {
            req.setAttribute("aStyle", "style=\"border-color:red\"");
            rightParametrs = false;
        } finally {

            try {
                B = Double.parseDouble(b);
            } catch (Exception e) {
                req.setAttribute("bStyle", "style=\"border-color:red\"");
                rightParametrs = false;
            } finally {

                try {
                    C = Double.parseDouble(c);
                } catch (Exception e) {
                    req.setAttribute("cStyle", "style=\"border-color:red\"");
                    rightParametrs = false;
                }
            }

        }
        if (rightParametrs) {
            if (A == 0) {
                answer = "Invalid format";
            } else if (B * B - 4 * A * C < 0) {
                answer = "Equation hasn't roots";
            } else if (B * B - 4 * A * C == 0) {
                answer = "x = " + String.valueOf((-B + Math.sqrt(B * B - 4 * A * C)) / (2 * A));
            } else {
                answer = "x1 = " + String.valueOf((-B + Math.sqrt(B * B - 4 * A * C)) / (2 * A)) + "    x2 = " + String.valueOf((-B - Math.sqrt(B * B - 4 * A * C)) / (2 * A));
            }
            req.setAttribute("answer", answer);
            req.getRequestDispatcher("answer.jsp").include(req, resp);
        }  else {
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }
    }

}
