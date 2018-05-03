
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/convert")
public class ConverterServlet extends HttpServlet {
    @EJB
    Konwerter fahrenheitConverter;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temperature = request.getParameter("temperature");
        String direction = request.getParameter("direction");
        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            if(validate(temperature)){
                out.println("Direction: "+direction);
                if (direction.equals("fahrenheit"))
                    out.println(fahrenheitConverter.cels2fahr(Double.parseDouble(temperature)));
                else if (direction.equals("cels"))
                    out.println(fahrenheitConverter.fahr2cels(Double.parseDouble(temperature)));
            }
            else
                out.println("Zle wprowadzona temperatura");
        }
    }

    private boolean validate(String number){
        return number.matches("(-?)(0|([1-9][0-9]*))((.)?[0-9]+)?");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
