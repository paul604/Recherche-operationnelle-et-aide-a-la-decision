import static java.lang.Math.abs;

/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe HeuristiqueManhattan : utilisation de la distance de Manhattan pour calculer
 * la distance de l'état donné au plus proche état final (parmi les 2 états finaux).
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */


public class HeuristiqueManhattan implements FonctionHeuristique {

	/**
	 * Méthode qui calcule la valeur de la fonction heuristique, 
	 * pour l'état e, en utilisant la distance de Manhattan
	 * pour chaque plaquette, c'est-à-dire la distance 
	 * de Manhattan de la case courante à la case de sortie.
	 * @return la distance de Manhattan. 
	 */
	public int heuristique(Etat e) {
		int xCour = e.getX();
		int yCour = e.getY();
		int xFin = e.get_labyrinthe().getXSortie();
		int yFin = e.get_labyrinthe().getYSortie();

		return abs(xCour-xFin)+abs(yCour-yFin);
	}

}
