/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed;

public class Raices {

    private double a, b, c;

    public Raices() {
        a = 0;
        b = 0;
        c = 0;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double Discriminante(double a, double b, double c) {
        double dis;
        dis = Math.sqrt((b * b) - (4 * a * c));
        return dis;
    }

    private double FormulaEstudiantePositiva() {
        return ((-b + Discriminante(a, b, c)) / (2 * a));
    }

    private double FormulaEstudianteNegativa() {
        return ((-b - Discriminante(a, b, c)) / (2 * a));
    }

    public double[] SolucionesDobles() {
        double Sol[];
        if (Discriminante(a, b, c) > 0) {
            Sol = new double[2];
            Sol[0] = FormulaEstudiantePositiva();
            Sol[1] = FormulaEstudianteNegativa();
        } else {
            Sol = null;
        }
        return Sol;
    }

    public double UnicaSolucion() {
        if (Discriminante(a, b, c) == 0) {
            return ((-b) / (2 * a));
        } else {
            return 0;
        }
    }

}
