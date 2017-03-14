/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe HeuristiqueEuclidienne : utilisation de la distance euclidienne pour calculer
 * la distance de l'état donné au plus proche état final.
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class HeuristiqueEuclidienne implements FonctionHeuristique {

	/**
	 * Méthode qui calcule la valeur de la fonction heuristique, 
	 * pour l'état e, en utilisant la distance euclidienne, c'est-à-dire
	 * la distance euclidienne de la case courante à la case de sortie.
	 * @return  la distance euclidienne.
	 */
	public int heuristique(Etat e) {
		int xCour = e.getX();
		int yCour = e.getY();
		int xFin = e.get_labyrinthe().getXSortie();
		int yFin = e.get_labyrinthe().getYSortie();

		return (int) sqrt( pow(xFin - xCour,2) + pow(yFin - yCour, 2));
	}

}
