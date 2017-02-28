//réaliser par kajja mohammed



import java.util.*;

public class Automate {

    private String Nombre;
    private int numEtat;
    private int EtatInitial;
    private int EtatActuel;
    private TreeSet<String> Alphabet;
    private TreeSet<Integer> EtatFinale;
    private TreeSet<Integer>[][] Tablettrensitions;

    public Automate() {
        super();
        Alphabet = new TreeSet<String>();
        EtatFinale = new TreeSet<Integer>();


    }

    public Automate(String nombre, int nEtats, TreeSet<String> Alphabet, int q0,
            TreeSet<Integer> qend, TreeSet<Integer>[][] Tablettrensitions) {
        super();
        Nombre = nombre;
        this.numEtat = nEtats;
        Alphabet = Alphabet;
        this.EtatInitial = q0;
        EtatFinale = qend;
        Tablettrensitions = Tablettrensitions;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getnumEtat() {
        return numEtat;
    }

    public void setnumEtat(int nEtats) {
        this.numEtat = nEtats;
    }

    public TreeSet<String> getAlphabet() {
        return Alphabet;
    }

    public void setAlphabet(TreeSet<String> Alphabet) {
        Alphabet = Alphabet;
    }

    public int getEtatInitial() {
        return EtatInitial;
    }

    public void setEtatInitial(int q0) {
        this.EtatInitial = q0;
    }

    public TreeSet<Integer> getEtatFinale() {
        return EtatFinale;
    }

    public void setEtatFinale(TreeSet<Integer> qend) {
        EtatFinale = qend;
    }

    public TreeSet<Integer>[][] getTablettrensitions() {
        return Tablettrensitions;
    }

    public void setTablettrensitions(TreeSet<Integer>[][] Tablettrensitions) {
        Tablettrensitions = Tablettrensitions;
    }

    public void addEtatFinale(int q) {
        EtatFinale.add(q);
    }

    public int getEtatActuel() {
        return EtatActuel;
    }

    @SuppressWarnings("unchecked")
    public void addlettreAlphabet(String lettre) {
        Alphabet.add(lettre);
        Tablettrensitions = new TreeSet[numEtat][Alphabet.size()];
        
        initialTablettrensitions();
    }

    private void initialTablettrensitions() {
        for (int x = 0; x < numEtat; x++) {
            for (int y = 0; y < Alphabet.size(); y++) {
                Tablettrensitions[x][y] = new TreeSet<Integer>();
            }
        }
    }

    public void addTransition(int q0, String e, int q1) {
        Vector<String> a = new Vector<String>();
        a.addAll(Alphabet);
        Tablettrensitions[q0][a.indexOf(e)].add(q1);
    }

    public boolean AnaliserMot(String mot) {

        EtatActuel = EtatInitial;
        String[] lettres = mot.split("");

        for (String l : lettres) {
            if (!l.equals("")) {
                EtatActuel = funcion(EtatActuel, l);
                if (EtatActuel == -1) {
                    return false;
                }
            }
        }
        if (EtatFinale.contains(EtatActuel)) {
            return true;
        }

        return false;
    }

    private int funcion(int EtatActuel, String e) {
        Vector<String> a = new Vector<String>();
        a.addAll(Alphabet);
        if (Tablettrensitions[EtatActuel][a.indexOf(e)].isEmpty()) {
            return -1;
        } else {
            return Tablettrensitions[EtatActuel][a.indexOf(e)].first();
        }

    }
}

