// réaliser par Kajja Mohammed




import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Transformateur {

    private String nombre;
    private int numEtat;
    private int EtatInitial;
    private TreeSet<String> Alphabet;
    private TreeSet<Integer> EtatFinal;
    private TreeSet<Integer>[][] tabtrans;

    public Automate minimiser(Automate Automate) {

        nombre = Automate.getNombre();
        numEtat = Automate.getnumEtat();
        Alphabet = Automate.getAlphabet();
        EtatInitial = Automate.getEtatInitial();
        EtatFinal = Automate.getEtatFinale();
        tabtrans = Automate.getTablettrensitions();

        if (Alphabet.contains("E")) {
            JOptionPane.showMessageDialog(null, "Retrait des transitions vides");

            SuppTransVide();
            JOptionPane.showMessageDialog(null, "les transitions vides sont supprimées");

        } else {
            JOptionPane.showMessageDialog(null, " pas de transitions  vides");


        }
        if (NonDeterministe()) {
            JOptionPane.showMessageDialog(null, "votre automate est non déterministe");

            SuppIndéterminisme();
            JOptionPane.showMessageDialog(null, "indéterminisme enlevé");

        } else {
            JOptionPane.showMessageDialog(null, "elle est déterministe");

        }

        while (!VeriMinimal()) {
            minimiser();
        }
        JOptionPane.showMessageDialog(null, "Elle est minimal");

        return new Automate(nombre, numEtat, Alphabet, EtatInitial, EtatFinal, tabtrans);

    }

    private void SuppIndéterminisme() {

        Vector<TreeSet> NouvelleEtat = new Vector<TreeSet>();
        TreeSet<Integer> ts;
        TreeSet<Integer> ts2;

        TreeSet<Integer> c = new TreeSet<Integer>();
        c.add(0);
        NouvelleEtat.add(c);

        for (String s : Alphabet) {
            for (int cont = 0; cont < numEtat; cont++) {
                ts = obtenerTransition(cont, s);
                if (ts.size() != 0 && !NouvelleEtat.contains(ts)) {
                    NouvelleEtat.add(ts);
                }
            }
        }
        Vector<TreeSet> temporaire = (Vector<TreeSet>) NouvelleEtat.clone();

        for (TreeSet<Integer> t : temporaire) {
            ts2 = new TreeSet<Integer>();
            for (String s : Alphabet) {
                for (Integer i : t) {
                    ts2.addAll(obtenerTransition(i, s));
                }
                if (ts2.size() != 0 && !NouvelleEtat.contains(ts2)) {
                    NouvelleEtat.add(ts2);
                }
            }
        }

        TreeSet<Integer>[][] tableaux = new TreeSet[NouvelleEtat.size()][Alphabet.size()];


        TreeSet<Integer> tranO, tran;
        for (String s : Alphabet) {
            for (TreeSet<Integer> t : NouvelleEtat) {
                tranO = new TreeSet<Integer>();
                tran = new TreeSet<Integer>();
                for (Integer i : t) {
                    tranO.addAll(obtenerTransition(i, s));
                }

                //new
                if (NouvelleEtat.indexOf(tranO) != -1) {
                    tran.add(NouvelleEtat.indexOf(tranO));
                }

                Vector<String> a = new Vector<String>();
                a.addAll(Alphabet);
                tableaux[NouvelleEtat.indexOf(t)][a.indexOf(s)] = tran;
            }
        }

        TreeSet<Integer> finales = new TreeSet<Integer>();

        for (TreeSet<Integer> t : NouvelleEtat) {
            for (Integer i : EtatFinal) {
                if (t.contains(i)) {
                    finales.add(NouvelleEtat.indexOf(t));
                }
            }
        }

        numEtat = NouvelleEtat.size();
        EtatFinal = finales;
        tabtrans = tableaux;
        System.out.println();
    }

    private boolean NonDeterministe() {
        boolean b = false;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (String s : Alphabet) {
            for (int cont = 0; cont < numEtat; cont++) {
                ts = obtenerTransition(cont, s);
                if (ts != null && ts.size() > 1) {
                    b = true;
                }
            }
        }
        return b;
    }

    private void SuppTransVide() {
        TreeSet<Integer> tran;
        TreeSet<Integer> clau;
        TreeSet<Integer> clau2;

        TreeSet<String> AlphabetTemp = (TreeSet<String>) Alphabet.clone();
        AlphabetTemp.remove("E");
        TreeSet<Integer>[][] TablettrensitionsTemp = new TreeSet[numEtat][AlphabetTemp.size()];

        for (int a = 0; a < AlphabetTemp.size(); a++) {
            for (int q = 0; q < numEtat; q++) {
                TablettrensitionsTemp[q][a] = new TreeSet<Integer>();
            }

        }

        for (String s : Alphabet) {
            if (!s.equals("E")) {
                for (int cont = 0; cont < numEtat; cont++) {
                    

                    tran = new TreeSet<Integer>();
                    clau = FerVid(cont);
                    clau2 = new TreeSet<Integer>();
                    for (Integer i : clau) {
                        tran.addAll(obtenerTransition(i.intValue(), s));
                    }
                    for (Integer i : tran) {
                        clau2.addAll(FerVid(i.intValue()));

                        Vector<String> a = new Vector<String>();
                        a.addAll(AlphabetTemp);
                        TablettrensitionsTemp[cont][a.indexOf(s)].addAll(clau2);
                    }
                }
            }
        }

        TreeSet<Integer> f = FerVid(EtatInitial);
        boolean cq0F = false;

        for (Integer i : EtatFinal) {
            if (f.contains(i)) {
                cq0F = true;
            }
        }

        if (cq0F) {
            EtatFinal.add(EtatInitial);
        }
        Alphabet = AlphabetTemp;
        tabtrans = TablettrensitionsTemp;

        System.out.println();
    }

    private TreeSet<Integer> FerVid(int q) {
        TreeSet<Integer> Fermiture = new TreeSet<Integer>();
        TreeSet<Integer> ts = new TreeSet<Integer>();
        Stack<TreeSet<Integer>> pile = new Stack<TreeSet<Integer>>();
        pile.push(obtenerTransition(q, "E"));
        Fermiture.add(q);

        while (!pile.isEmpty()) {
            ts = pile.pop();

            for (Integer i : ts) {
                if (!Fermiture.contains(i.intValue())) {
                    pile.push(obtenerTransition(i.intValue(), "E"));
                }
            }
            Fermiture.addAll(ts);
        }
        return Fermiture;
    }

    private TreeSet<Integer> obtenerTransition(int q0, String e) {
        Vector<String> a = new Vector<String>();
        a.addAll(Alphabet);
        return tabtrans[q0][a.indexOf(e)];
    }

    private boolean VeriMinimal() {
        boolean f = true;

        int[][] etat = new int[numEtat][numEtat];
        TreeSet<Integer> r;
        TreeSet<Integer> t;
        int y;
        int x;
        int auto = 0;
        for (int cont = 1; cont < numEtat; cont++) {
            for (int cont2 = 0; cont2 < cont; cont2++) {
                if ((EtatFinal.contains(cont) && !EtatFinal.contains(cont2)) || (EtatFinal.contains(cont2) && !EtatFinal.contains(cont))) {
                    etat[cont][cont2] = 1;
                }
                auto = 0;
                for (String s : Alphabet) {
                    r = obtenerTransition(cont, s);
                    t = obtenerTransition(cont2, s);
                    if (r.size() > 0 && t.size() > 0) {
                    	auto++;
                        y = r.first().intValue();
                        x = t.first().intValue();

                        if (x < y) {
                            if (etat[y][x] == 1) {
                                etat[cont][cont2] = 1;
                            }
                        } else {
                            if (etat[x][y] == 1) {
                                etat[cont][cont2] = 1;
                            }
                        }
                        if (y != x) {
                            etat[cont][cont2] = 1;
                        }
                    }
                }
                if (auto != Alphabet.size()) {
                    etat[cont][cont2] = 1;
                }
            }
        }

        for (int cont = 1; cont < numEtat; cont++) {
            for (int cont2 = 0; cont2 < cont; cont2++) {
                if (etat[cont][cont2] == 0) {
                    f = false;
                }
            }
        }

        return f;

    }

    private void minimiser() {

        int[][] etat = new int[numEtat][numEtat];
        TreeSet<Integer> r;
        TreeSet<Integer> t;
        int x;
        int y;
        int auto = 0;
        for (int cont = 1; cont < numEtat; cont++) {
            for (int cont2 = 0; cont2 < cont; cont2++) {
                if ((EtatFinal.contains(cont) && !EtatFinal.contains(cont2)) || (EtatFinal.contains(cont2) && !EtatFinal.contains(cont))) {
                    etat[cont][cont2] = 1;
                }
                auto = 0;
                for (String s : Alphabet) {
                    r = obtenerTransition(cont, s);
                    t = obtenerTransition(cont2, s);
                    if (r.size() > 0 && t.size() > 0) {
                    	auto++;
                        x = r.first().intValue();
                        y = t.first().intValue();

                        if (y < x) {
                            if (etat[x][y] == 1) {
                                etat[cont][cont2] = 1;
                            }
                        } else {
                            if (etat[y][x] == 1) {
                                etat[cont][cont2] = 1;
                            }
                        }
                        if (x != y) {
                            etat[cont][cont2] = 1;
                        }
                    }
                }
                if (auto != Alphabet.size()) {
                    etat[cont][cont2] = 1;
                }
            }
        }
        Vector<TreeSet> vector = new Vector<TreeSet>();
        TreeSet<Integer> ts;
        boolean f;

        for (int cont = 1; cont < numEtat; cont++) {
            for (int cont2 = 0; cont2 < cont; cont2++) {
                if (etat[cont][cont2] == 0) {
                    ts = new TreeSet<Integer>();
                    f = true;

                    ts.add(cont);
                    ts.add(cont2);

                    for (TreeSet<Integer> tsmod : vector) {
                        if (tsmod.contains(cont) || tsmod.contains(cont)) {
                            tsmod.addAll(ts);
                            f = false;
                        }
                    }
                    if (f) {
                        vector.add(ts);
                    }
                }
            }
        }

        f = true;

        for (int cont = 0; cont < numEtat; cont++) {
            f = true;
            for (TreeSet<Integer> tsmod : vector) {
                if (tsmod.contains(cont)) {
                    f = false;
                }
            }
            if (f) {
                ts = new TreeSet<Integer>();
                ts.add(cont);
                vector.add(ts);
            }
        }

        TreeSet<Integer>[][] tableTemp = new TreeSet[vector.size()][Alphabet.size()];

        TreeSet<Integer> tran;
        int t0;
        TreeSet<Integer> t1;
        for (String s : Alphabet) {
            for (TreeSet<Integer> tsi : vector) {
                tran = new TreeSet<Integer>();
                for (Integer i : tsi) {
                    tran.addAll(obtenerTransition(i, s));
                }

                t0 = vector.indexOf(tsi);
                t1 = new TreeSet<Integer>();
                for (TreeSet<Integer> tsi2 : vector) {
                    if (tran.size() > 0 && tsi2.containsAll(tran)) {
                        t1.add(vector.indexOf(tsi2));
                    }
                }

                Vector<String> a = new Vector<String>();
                a.addAll(Alphabet);
                tableTemp[t0][a.indexOf(s)] = t1;

            }
        }

        TreeSet<Integer> finales = new TreeSet<Integer>();
        int q00 = EtatInitial;

        for (TreeSet<Integer> i : vector) {
            if (i.contains(EtatInitial)) {
                q00 = vector.indexOf(i);
            }

            for (Integer ii : EtatFinal) {
                if (i.contains(ii)) {
                    finales.add(vector.indexOf(i));
                }
            }
        }

        EtatInitial = q00;
        numEtat = vector.size();
        EtatFinal = finales;
        tabtrans = tableTemp;

        System.out.println();

    }
}
