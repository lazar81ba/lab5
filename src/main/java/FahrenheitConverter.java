
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class FahrenheitConverter implements Konwerter {
    public double fahr2cels(double temp) {
        return (5.0/9.0)*(temp-32.0);
    }

    public double cels2fahr(double temp) {
        return (9.0/5.0)*temp+32.0;
    }
}
