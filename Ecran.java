
// réaliser par Kajja Mohammed




import java.util.TreeSet;

/**
 *
 * @author kajja
 */
public class Ecran extends javax.swing.JFrame {

    /** Creates new form  */
    public Ecran() {
        z.setNombre("Automate");

        Integer numEtat = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("entrer le nombre des états"));
        z.setnumEtat(numEtat);
        z.setEtatInitial(0);


        int estFinales = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("entrer le nombre  des états finaux"));
        for (int i = 0; i < estFinales; i++) {
            int EtatFinale = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("entrer l'état final"));
            z.addEtatFinale(EtatFinale);
        }

        int alf = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Entrez le nombre des lettres de l'alphabet"));

        for (int i = 0; i < alf; i++) {
            z.addlettreAlphabet(javax.swing.JOptionPane.showInputDialog("entrer lettre "));
        }

        initComponents();

        this.txtnumEtat.setText(numEtat.toString());
        this.txtestFinales.setText(z.getEtatFinale().toString());
        this.txtAlphabet.setText(z.getAlphabet().toString());



    }

    
    
    @SuppressWarnings("unchecked")
   
    
    
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtestFinales = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtnumEtat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtAlphabet = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnumEtat1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtestFinales1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAlphabet1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Eliminer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        jLabel1.setFont(new java.awt.Font("Virtual DJ", 0, 14)); 
        jLabel1.setText("Automate fini non deterministe");

        jLabel2.setText("# états:");

        jLabel4.setText("etats finaux:");

        txtestFinales.setText("aucun");

        jButton1.setText("transformer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtnumEtat.setText("aucun");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("alphabet:");

        txtAlphabet.setText("aucun");

        jButton3.setText("Ajouter transition");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Virtual DJ", 0, 14));
        jLabel3.setText("automate fini deterministe");

        jLabel6.setText("# etats:");

        txtnumEtat1.setText("aucun");

        jLabel7.setText("etats finaux:");

        txtestFinales1.setText("aucun");

        jLabel8.setText("Alphabet:");

        txtAlphabet1.setText("aucun");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(443, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(txtnumEtat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtestFinales1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(txtAlphabet1)
                .addGap(292, 292, 292))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(5, 5, 5)
                                        .addComponent(txtnumEtat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtestFinales)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAlphabet))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(281, 281, 281)))
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumEtat)
                    .addComponent(jLabel4)
                    .addComponent(txtestFinales)
                    .addComponent(jLabel5)
                    .addComponent(txtAlphabet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtnumEtat1)
                            .addComponent(jLabel7)
                            .addComponent(txtestFinales1)
                            .addComponent(jLabel8)
                            .addComponent(txtAlphabet1))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(25, 25, 25)
                        .addComponent(jButton2))))
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        trans = new Transformateur().minimiser(z);
        table2();
        this.txtnumEtat1.setText(String.valueOf(trans.getnumEtat()));
        this.txtAlphabet1.setText(trans.getAlphabet().toString());
        this.txtestFinales1.setText(trans.getEtatFinale().toString());
    }
    public void table1() {
        table1 = "\t" + z.getAlphabet().toString() + "\n";

        for (int i = 0; i < z.getTablettrensitions().length; i++) {
            for (int j = 0; j < z.getTablettrensitions()[i].length; j++) {
                if (j == 0) {
                    table1 = table1 + i + "\t" + (z.getTablettrensitions()[i][j].toString());
                } else {

                    table1 = table1 + (z.getTablettrensitions()[i][j].toString());
                }
            }
            table1 = table1 + "\n";
        }
        this.jTextArea1.setText(table1);
    }

    public void table2() {
        table2 = "\t" + trans.getAlphabet().toString() + "\n";
        TreeSet<Integer> table = new TreeSet<Integer>();
        table.add(0);

        for (int i = 0; i < trans.getTablettrensitions().length; i++) {
            for (int j = 0; j < trans.getTablettrensitions()[i].length; j++) {
                if (trans.getTablettrensitions()[i][j].isEmpty()) {
                    trans.getTablettrensitions()[i][j] = table;
                }
            }
        }



        for (int i = 0; i < trans.getTablettrensitions().length; i++) {
            for (int j = 0; j < trans.getTablettrensitions()[i].length; j++) {
                if (j == 0) {
                    table2 = table2 + i + "\t" + (trans.getTablettrensitions()[i][j].toString());
                } else {

                    table2 = table2 + (trans.getTablettrensitions()[i][j].toString());
                }
            }
            table2 = table2 + "\n";
        }
        this.jTextArea2.setText(table2);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int ei = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Entrez état initial"));
        String transi = javax.swing.JOptionPane.showInputDialog("Entrez transition");
        int ef = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Entrez état final"));
        z.addTransition(ei, transi, ef);
        table1();

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ecran().setVisible(true);
            }
        });
    }
    
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel txtAlphabet;
    private javax.swing.JLabel txtAlphabet1;
    private javax.swing.JLabel txtnumEtat;
    private javax.swing.JLabel txtnumEtat1;
    private javax.swing.JLabel txtestFinales;
    private javax.swing.JLabel txtestFinales1;
    
    
    
    public static Automate z = new Automate();
    String table1 = "";
    public Automate trans = new Automate();
    String table2 = "";
}
