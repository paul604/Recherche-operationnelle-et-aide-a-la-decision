/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Interface FonctionHeuristique
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */


public interface FonctionHeuristique {
	/**
	 * Méthode qui calcule la valeur de la fonction heuristique, 
	 * pour l'état e.
	 * @param e : l 'état pour lequel calculer la valeur de la fonction heuristique.
	 * @return la valeur de l'état e par la fonction heuristique.
	 */
	public int heuristique(Etat e);
}
