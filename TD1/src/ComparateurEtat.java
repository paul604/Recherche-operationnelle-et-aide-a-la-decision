/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe ComparateurEtat
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */

import java.util.Comparator;


public class ComparateurEtat implements Comparator<Etat> {

	@Override
	/**
	 * Méthode qui compare les états e1 et e2 selon la valeur de la fonction d'évaluation f().
	 * En cas d'égalité sur la valeur donnée par f(), il faut utiliser la valeur donnée par
	 * la fonction g().
	 * @param e1 : le premier état à comparer.
	 * @param e2 : le second état à comparer.
	 * @return 1 si e1 est inférieur à e2, 0 si e1 et e2 sont égaux et -1 si e1 est supérieur à e2.
	 */
	public int compare(Etat e1, Etat e2) {
		//TODO
		return 0;
	}
	
}
