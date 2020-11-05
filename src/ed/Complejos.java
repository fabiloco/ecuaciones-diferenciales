package ed;

public class Complejos {

    private double Real;
    private double Imaginario;

    public Complejos() {
        Real = 0;
        Imaginario = 0;
    }

    public double getReal() {
        return Real;
    }

    public double getImaginario() {
        return Imaginario;
    }
    
    
    

    public Complejos FormulaGeneralPositiva(double a, double b, double c) {
        Complejos Resultado = new Complejos();
        Resultado.Real = ((-1 * b) / (2 * a));
        Resultado.Imaginario = (Math.sqrt(-1 * ((b * b) - 4 * a * c))) / (2 * a);
        return Resultado;
    }

    public Complejos FormulaGeneralNegativa(double a, double b, double c) {
        Complejos Resultado = new Complejos();
        Resultado.Real = ((-b) / (2 * a));
        Resultado.Imaginario = -(Math.sqrt(-1 * ((b * b) - 4 * a * c))) / (2 * a);
        return Resultado;
    }

}
