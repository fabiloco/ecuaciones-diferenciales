/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Ricardo
 */
public class TVentana extends javax.swing.JFrame {
    
    private Raices Root;
    private Complejos Complex;
    private final int AnchoOriginal;
    private int AnchoAlterado;
    private Dimension Screen;
    private PVI pv;
    private Latex L, L2;
    Fraccion f;
    private InfoExtra In;
    
    public TVentana() {
        initComponents();
        AnchoOriginal = this.getWidth();
        AnchoAlterado = AnchoOriginal + 280;
        Screen = Toolkit.getDefaultToolkit().getScreenSize();
        add(Pan3);
        Pan3.setVisible(false);
        Root = new Raices();
        Complex = new Complejos();
        pv = new PVI();
        L2 = new Latex("La~solución~general~es:", 40);
        Solu.setIcon(L2.getIcono());
        f = new Fraccion();
    }

    //Metodo para redondear los numeros a sus 4 cifras decimales
    public static double RedondearNumeros(double Num) {
        return (double) Math.round(Num * 1000d) / 1000d;
    }

    //Encapsulamos Las soluciones imaginarias en un vector
    public double[] SolucionesImaginarias() {
        double[] Sol = new double[2];
        Sol[0] = Complex.FormulaGeneralPositiva(Root.getA(), Root.getB(), Root.getC()).getReal();
        Sol[1] = Complex.FormulaGeneralPositiva(Root.getA(), Root.getB(), Root.getC()).getImaginario();
        return Sol;
    }

    //Metodo Para mostrar las soluciones generales y particulares de todos los casos
    private void MostrarSoluciones() {
        if (jCheckBox1.isSelected()) {
            if (Root.Discriminante(Root.getA(), Root.getB(), Root.getC()) > 0) {
                if (PVICaso1()[1] < 0) {
                    L = new Latex("y(x) = " + f.toFraccion(RedondearNumeros(PVICaso1()[0])) + "e^{(" + f.toFraccion(RedondearNumeros(Root.SolucionesDobles()[0])) + ")x} -"
                            + f.toFraccion(RedondearNumeros(Math.abs(PVICaso1()[1]))) + "e^{(" + f.toFraccion(RedondearNumeros(Root.SolucionesDobles()[1])).toString() + ")x}", 28);
                    LaLatex.setIcon(L.getIcono());
                } else {
                    L = new Latex("y(x) = " + f.toFraccion(RedondearNumeros(PVICaso1()[0])) + "e^{(" + f.toFraccion(RedondearNumeros(Root.SolucionesDobles()[0])) + ")x} +"
                            + f.toFraccion(RedondearNumeros(PVICaso1()[1])) + "e^{(" + f.toFraccion(RedondearNumeros(Root.SolucionesDobles()[1])).toString() + ")x}", 28);
                    LaLatex.setIcon(L.getIcono());
                }
            } else if (Root.Discriminante(Root.getA(), Root.getB(), Root.getC()) == 0) {
                if (PVICaso2()[1] < 0) {
                    L = new Latex("y(x) = " + f.toFraccion(RedondearNumeros(PVICaso2()[0])) + "e^{(" + f.toFraccion(RedondearNumeros(Root.UnicaSolucion())).toString() + ")x} "
                            + "-" + f.toFraccion(RedondearNumeros(Math.abs(PVICaso2()[1]))) + "xe^{(" + f.toFraccion(RedondearNumeros(Root.UnicaSolucion())).toString() + ")x}", 28);
                    LaLatex.setIcon(L.getIcono());
                } else {
                    L = new Latex("y(x) = " + f.toFraccion(RedondearNumeros(PVICaso2()[0])) + "e^{(" + f.toFraccion(RedondearNumeros(Root.UnicaSolucion())) + ")x} "
                            + "+" + f.toFraccion(RedondearNumeros(PVICaso2()[1])) + "xe^{(" + f.toFraccion(RedondearNumeros(Root.UnicaSolucion())) + ")x}", 28);
                    LaLatex.setIcon(L.getIcono());
                    
                }
            } else {
                //Metodo de Constantes tipo 3
                if (PVICaso3()[1] < 0) {
                    L = new Latex("y(x) =~(" + f.toFraccion(RedondearNumeros(PVICaso3()[0])) + ")e^{(" + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[0])))
                            + ")x}cos[(" + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[1]))) + ")x] - ("
                            + f.toFraccion(Math.abs(RedondearNumeros(PVICaso3()[1]))) + " )e^{(" + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[0]))) + ")x} sen[("
                            + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[1]))) + ")x]", 28);
                    LaLatex.setIcon(L.getIcono());
                } else {
                    L = new Latex("y(x) = ~ (" + f.toFraccion(RedondearNumeros(PVICaso3()[0])) + ")e^{(" + f.toFraccion(RedondearNumeros(SolucionesImaginarias()[0]))
                            + ")x}cos[(" + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[1]))).toString() + ")x] + ("
                            + f.toFraccion(Math.abs(RedondearNumeros(PVICaso3()[1]))) + " )e^{(" + f.toFraccion(RedondearNumeros(SolucionesImaginarias()[0])) + ")x} sen[("
                            + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[1]))) + ")x]", 28);
                    LaLatex.setIcon(L.getIcono());
                }
            }
        } else {
            if (Root.Discriminante(Root.getA(), Root.getB(), Root.getC()) > 0) {
                L = new Latex("y(x) = C_{1} e^{(" + f.toFraccion(RedondearNumeros(Root.SolucionesDobles()[0])) + ")x} "
                        + "+ C_{2} e^{(" + f.toFraccion(RedondearNumeros(Root.SolucionesDobles()[1])) + ")x}", 28);
                LaLatex.setIcon(L.getIcono());
            } else if (Root.Discriminante(Root.getA(), Root.getB(), Root.getC()) == 0) {
                L = new Latex("y(x) = C_{1} e^{(" + f.toFraccion(RedondearNumeros(Root.UnicaSolucion())) + ")x} "
                        + "+ C_{2} xe^{(" + f.toFraccion(RedondearNumeros(Root.UnicaSolucion())) + ")x}", 28);
                LaLatex.setIcon(L.getIcono());
            } else {
                L = new Latex("y(x) = C_1 e^{(" + f.toFraccion(RedondearNumeros(SolucionesImaginarias()[0]))
                        + ")x}cos[(" + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[1]))) + ")x] + "
                        + "C_2 e^{(" + f.toFraccion(RedondearNumeros(SolucionesImaginarias()[0])) + ")x} sen[("
                        + f.toFraccion(RedondearNumeros(Math.abs(SolucionesImaginarias()[1]))) + ")x]", 28);
                LaLatex.setIcon(L.getIcono());
            }
        }
    }

    //Cambiamos el tamaño de la ventana y añadimos el panel de los PVI's
    private void AñadirPanel() {
        if (jCheckBox1.isSelected()) {
            Pan3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            Pan3.setVisible(true);
            Pan3.setLocation(939, 11);
            Pan3.setSize(315, 200);
        } else {
            Pan3.setVisible(false);
        }
    }

    //Encapsulamos en los siguientes metodos, todas las constantes de los PVI's
    private double[] PVICaso1() {
        double a, b, z, d, Vec[];
        a = Double.parseDouble(Ca.getText());
        b = Double.parseDouble(Cb.getText());
        z = Double.parseDouble(Cz.getText());
        d = Double.parseDouble(Cd.getText());
        Vec = pv.ConstantesCasoI(a, b, z, d, Root);
        return Vec;
    }
    
    private double[] PVICaso2() {
        double a, b, z, d, Vec[];
        a = Double.parseDouble(Ca.getText());
        b = Double.parseDouble(Cb.getText());
        z = Double.parseDouble(Cz.getText());
        d = Double.parseDouble(Cd.getText());
        Vec = pv.ConstantesCasoII(a, b, z, d, Root);
        return Vec;
    }
    
    private double[] PVICaso3() {
        double a, b, z, d, Vec[];
        a = Double.parseDouble(Ca.getText());
        b = Double.parseDouble(Cb.getText());
        z = Double.parseDouble(Cz.getText());
        d = Double.parseDouble(Cd.getText());
        Vec = pv.ConstantesCasoIII(a, b, z, d, Root, Complex);
        return Vec;
    }

    //Cambiamos el tamaño de la ventana
    private void CambiarTamaño() {
        if (jCheckBox1.isSelected()) {
            setSize(AnchoAlterado + 55, getHeight());
        } else {
            setSize(AnchoOriginal, getHeight());
        }
        setLocation((Screen.width - getWidth()) / 2, (Screen.height - getHeight()) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pan3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Cd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Cz = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Ca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Cb = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        Pan1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ct = new javax.swing.JTextField();
        at = new javax.swing.JTextField();
        bt = new javax.swing.JTextField();
        Pan2 = new javax.swing.JPanel();
        Solu = new javax.swing.JLabel();
        LaLatex = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        Pan3.setBackground(new java.awt.Color(204, 204, 255));
        Pan3.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel1.setText(") =");

        Cd.setFont(new java.awt.Font("Dialog", 0, 45)); // NOI18N
        Cd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CdKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel5.setText("y(");

        Cz.setFont(new java.awt.Font("Dialog", 0, 45)); // NOI18N
        Cz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CzActionPerformed(evt);
            }
        });
        Cz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CzKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel6.setText("y'(");

        Ca.setFont(new java.awt.Font("Dialog", 0, 45)); // NOI18N
        Ca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CaKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 60)); // NOI18N
        jLabel7.setText(") =");

        Cb.setFont(new java.awt.Font("Dialog", 0, 45)); // NOI18N
        Cb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CbKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout Pan3Layout = new javax.swing.GroupLayout(Pan3);
        Pan3.setLayout(Pan3Layout);
        Pan3Layout.setHorizontalGroup(
            Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pan3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pan3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Cz, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(Pan3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cb, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        Pan3Layout.setVerticalGroup(
            Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pan3Layout.createSequentialGroup()
                .addGroup(Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(Cd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(Cz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(Cb, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        txt.setEditable(false);
        txt.setColumns(20);
        txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt.setRows(5);
        txt.setEnabled(false);
        jScrollPane1.setViewportView(txt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecuaciones Diferenciales");
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Calcular solución");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("PVI");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        Pan1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 68)); // NOI18N
        jLabel2.setText("y'' + ");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 70)); // NOI18N
        jLabel3.setText("y' + ");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 70)); // NOI18N
        jLabel4.setText("y = 0");

        ct.setFont(new java.awt.Font("Dialog", 0, 60)); // NOI18N
        ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctActionPerformed(evt);
            }
        });
        ct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ctKeyTyped(evt);
            }
        });

        at.setFont(new java.awt.Font("Dialog", 0, 60)); // NOI18N
        at.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        at.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                atKeyTyped(evt);
            }
        });

        bt.setFont(new java.awt.Font("Dialog", 0, 60)); // NOI18N
        bt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout Pan1Layout = new javax.swing.GroupLayout(Pan1);
        Pan1.setLayout(Pan1Layout);
        Pan1Layout.setHorizontalGroup(
            Pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(at, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ct, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        Pan1Layout.setVerticalGroup(
            Pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pan1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addGroup(Pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(at, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ct, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Pan2.setBackground(new java.awt.Color(255, 255, 255));
        Pan2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout Pan2Layout = new javax.swing.GroupLayout(Pan2);
        Pan2.setLayout(Pan2Layout);
        Pan2Layout.setHorizontalGroup(
            Pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Pan2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(Pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Solu, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LaLatex, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        Pan2Layout.setVerticalGroup(
            Pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(Pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Pan2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Solu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(LaLatex, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton4.setText("Información Adicional");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1))
                    .addComponent(Pan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addGap(29, 29, 29)))
                .addComponent(Pan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        CambiarTamaño();
        AñadirPanel();
        if (!jCheckBox1.isSelected()) {
            L2 = new Latex("La~solución~general~es:", 40);
            Solu.setIcon(L2.getIcono());
        } else {
            L2 = new Latex("La~solución~particular~es:", 40);
            Solu.setIcon(L2.getIcono());
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        at.setText("");
        bt.setText("");
        ct.setText("");
        Cz.setText("");
        Ca.setText("");
        Cb.setText("");
        Cd.setText("");
        jButton4.setEnabled(false);
        L = new Latex("", 0);
        LaLatex.setIcon(L.getIcono());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Double.parseDouble(at.getText()) != 0) {
            Root.setA(Double.parseDouble(at.getText()));
            Root.setB(Double.parseDouble(bt.getText()));
            Root.setC(Double.parseDouble(ct.getText()));
            JOptionPane.showMessageDialog(null, "ATENCIÓN\nAlgunos de los numeros puede estar aproximado a 4 cifras decimales");
            MostrarSoluciones();
        } else {
            JOptionPane.showMessageDialog(null, "Cuidado, el coeficiente " + "'a'" + " no puede ser 0", "Alerta", 0, null);
        }
        jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AcercaDe.AcercaDe();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void CzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CzActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CzActionPerformed

    private void ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctActionPerformed
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_ctActionPerformed

    private void atKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atKeyTyped
        char tecla = evt.getKeyChar();    //Agarra la tecla presionada en el evento

        if (Character.isLetter(tecla) || Character.isSpaceChar(tecla)) //Determina si es una letra o si es un espacio
        {
            getToolkit().beep();    //Hace un sonidito
            evt.consume();  //Consume el evento, lo elimina
        }
    }//GEN-LAST:event_atKeyTyped

    private void btKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btKeyTyped
        char tecla = evt.getKeyChar();    //Agarra la tecla presionada en el evento

        if (Character.isLetter(tecla) || Character.isSpaceChar(tecla)) //Determina si es una letra o si es un espacio
        {
            getToolkit().beep();    //Hace un sonidito
            evt.consume();  //Consume el evento, lo elimina
        }
    }//GEN-LAST:event_btKeyTyped

    private void ctKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ctKeyTyped
        char tecla = evt.getKeyChar();    //Agarra la tecla presionada en el evento

        if (Character.isLetter(tecla) || Character.isSpaceChar(tecla)) //Determina si es una letra o si es un espacio
        {
            getToolkit().beep();    //Hace un sonidito
            evt.consume();  //Consume el evento, lo elimina
        }
    }//GEN-LAST:event_ctKeyTyped

    private void CzKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CzKeyTyped
        char tecla = evt.getKeyChar();    //Agarra la tecla presionada en el evento

        if (Character.isLetter(tecla) || Character.isSpaceChar(tecla)) //Determina si es una letra o si es un espacio
        {
            getToolkit().beep();    //Hace un sonidito
            evt.consume();  //Consume el evento, lo elimina
        }
    }//GEN-LAST:event_CzKeyTyped

    private void CaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CaKeyTyped
        char tecla = evt.getKeyChar();    //Agarra la tecla presionada en el evento

        if (Character.isLetter(tecla) || Character.isSpaceChar(tecla)) //Determina si es una letra o si es un espacio
        {
            getToolkit().beep();    //Hace un sonidito
            evt.consume();  //Consume el evento, lo elimina
        }
    }//GEN-LAST:event_CaKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        In = new InfoExtra(null, true);
        In.LlenarEcuacion(Root);
        In.LlenarRaices(Root, Complex);
        In.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void CbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CbKeyTyped
        char tecla = evt.getKeyChar();    //Agarra la tecla presionada en el evento

        if (Character.isLetter(tecla) || Character.isSpaceChar(tecla)) //Determina si es una letra o si es un espacio
        {
            getToolkit().beep();    //Hace un sonidito
            evt.consume();  //Consume el evento, lo elimina
        }
    }//GEN-LAST:event_CbKeyTyped

    private void CdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CdKeyTyped
        char tecla = evt.getKeyChar();    //Agarra la tecla presionada en el evento

        if (Character.isLetter(tecla) || Character.isSpaceChar(tecla)) //Determina si es una letra o si es un espacio
        {
            getToolkit().beep();    //Hace un sonidito
            evt.consume();  //Consume el evento, lo elimina
        }
    }//GEN-LAST:event_CdKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ca;
    private javax.swing.JTextField Cb;
    private javax.swing.JTextField Cd;
    private javax.swing.JTextField Cz;
    private javax.swing.JLabel LaLatex;
    private javax.swing.JPanel Pan1;
    private javax.swing.JPanel Pan2;
    private javax.swing.JPanel Pan3;
    private javax.swing.JLabel Solu;
    private javax.swing.JTextField at;
    private javax.swing.JTextField bt;
    private javax.swing.JTextField ct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
