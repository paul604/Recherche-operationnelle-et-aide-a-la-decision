import org.junit.Test;

/**
 * Created by E155441H on 15/03/17.
 */
public class EtatTest {

    public static final boolean[][] TAB_LABYRINTHE_1 = {
            {true, true, true, true, true},
            {true, true, false, true, false},
            {false, true, false, true, false},
            {false, true, false, true, true},
            {true, true, false, false, true},
            {true, true, true, true, true}};
    public static final int ENTREE_X = 0;
    public static final int ENTREE_Y = 1;
    public static final int SORTIE_X = 4;
    public static final int SORTIE_Y = 3;


    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("test Etat");
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void etendEtat() throws Exception {
        Labyrinthe lab1 = new Labyrinthe(TAB_LABYRINTHE_1, ENTREE_X, ENTREE_Y, SORTIE_X, SORTIE_Y);

        Etat e1 = new Etat(lab1);

        Etat e2 = e1.etendEtat(Deplacement.bas,new HeuristiqueEuclidienne());
        Etat e3 = e1.etendEtat(Deplacement.droite,new HeuristiqueEuclidienne());

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

    }

    @Test
    public void getSuccesseurs() throws Exception {
        Labyrinthe lab1 = new Labyrinthe(TAB_LABYRINTHE_1, ENTREE_X, ENTREE_Y, SORTIE_X, SORTIE_Y);

        Etat e1 = new Etat(lab1);
        for (Etat etat : e1.getSuccesseurs(new HeuristiqueManhattan())) {
            System.out.println(etat);
            System.out.println(" ");
        }
    }

    @Test
    //V
    public void deplacementPossible() throws Exception {
        Labyrinthe lab1 = new Labyrinthe(TAB_LABYRINTHE_1, ENTREE_X, ENTREE_Y, SORTIE_X, SORTIE_Y);


        Etat e1 = new Etat(lab1);
        System.out.println(e1.deplacementPossible(Deplacement.haut));
        System.out.println(" ");
        System.out.println(e1.deplacementPossible(Deplacement.bas));
        System.out.println(" ");
        System.out.println(e1.deplacementPossible(Deplacement.gauche));
        System.out.println(" ");
        System.out.println(e1.deplacementPossible(Deplacement.droite));
    }
}