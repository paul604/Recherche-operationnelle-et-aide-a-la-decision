/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe ApplicationTaquin
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */


public class ApplicationLabyrinthes {
	/**
	 * Le tableau représentant le labyrinthe.
	 */
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
	
	
	
	/**
	 * Méthode principale pour tester les deux heuristiques sur des labyrinthes.
	 */
	public static void main(String[] args){
		/* algo A* avec le 1er labyrinthe */
		System.out.println("\n\t***** En partant du premier état initial *****\n\n");
		
		//heuristique 1
		System.out.println("Algorithme A* avec l'heuristique euclidienne");
		Labyrinthe lab1 = new Labyrinthe(TAB_LABYRINTHE_1, ENTREE_X, ENTREE_Y, SORTIE_X, SORTIE_Y); 
		ResolutionLabyrinthe resolLab1 = new ResolutionLabyrinthe(new Etat(lab1), new HeuristiqueEuclidienne());
		Etat etatFinal1 = resolLab1.getEtatFinal();
		if(etatFinal1 != null){
			System.out.println("Nombre de déplacements : " + etatFinal1.getNbCoups());
			etatFinal1.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}
		System.out.println("\n**********\n");
		
		//heuristique 2
		System.out.println("Algorithme A* avec l'heuristique de Manhattan");
		Labyrinthe lab2 = new Labyrinthe(TAB_LABYRINTHE_1, ENTREE_X, ENTREE_Y, SORTIE_X, SORTIE_Y); 
		ResolutionLabyrinthe resolLab2 = new ResolutionLabyrinthe(new Etat(lab2), new HeuristiqueManhattan());
		Etat etatFinal2 = resolLab2.getEtatFinal();
		if(etatFinal2 != null){
			System.out.println("Nombre de déplacements : " + etatFinal2.getNbCoups());
			etatFinal2.afficherParcours();
		}
		else{
			System.out.println("Aucune solution");
		}		

		
		//algo A* avec d'autres labyrinthes
		//TODO
	}
}
