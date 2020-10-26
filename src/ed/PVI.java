package ed;

/**
 *
 * @author Sebastian Ricardo
 */
public class PVI {

    double[] ConsI;
    double[] ConsII;
    double[] ConsIII;

    public PVI() {
        ConsI = new double[2];
        ConsII = new double[2];
        ConsIII = new double[2];
    }

    public double[] ConstantesCasoI(double a, double b, double z, double d, Raices R) {
        double C1, C2;
        double r1 = R.SolucionesDobles()[0];
        double r2 = R.SolucionesDobles()[1];
        C2 = (b - r1 * d * Math.pow(Math.E, (r1 * (a - z)))) / (-r1 * Math.pow(Math.E, (r1 * a) + (r2 * z) - (r1 * z)) + (r2 * Math.pow(Math.E, r2 * a)));
        C1 = (d - C2 * Math.pow(Math.E, (r2 * z))) / (Math.pow(Math.E, (r1 * z)));
        ConsI[0] = C1;
        ConsI[1] = C2;
        return ConsI;
    }

    public double[] ConstantesCasoII(double a, double b, double z, double d, Raices R) {
        double C1, C2;
        double r = R.UnicaSolucion();
        C2 = (b - (r * d)) / (Math.exp(r * z) * (1 - z + (r * a)));
        C1 = (d - (C2 * z * Math.exp(r * z))) / (Math.exp(r * z));
        ConsII[0] = C1;
        ConsII[1] = C2;
        return ConsII;
    }
    //public double[] ConstantesCasoIII(double a, double b, double z, double d, Raices R) {}
}
