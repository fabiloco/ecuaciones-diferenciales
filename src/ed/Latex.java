/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed;

import org.scilab.forge.jlatexmath.*;

public class Latex {

    TeXFormula Ecuacion;
    TeXIcon Icono;
    String Math;
    int Tamaño;

    public Latex(String M, int tam) {
        this.Math = M;
        this.Tamaño = tam;
    }

    public TeXIcon getIcono() {
        try {
            this.Ecuacion = new TeXFormula(Math);
            this.Icono = this.Ecuacion.createTeXIcon(TeXConstants.ALIGN_LEFT, this.Tamaño);
            return this.Icono;
        } catch (ParseException e) {
            System.out.println("Error LaTex: " + e.getMessage());
            this.Icono = null;
            return this.Icono;
        }

    }

}
