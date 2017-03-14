/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe ResolutionLabyrinthe : pour représenter une partie de jeu de labyrinthe.
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */


public class ResolutionLabyrinthe {
	/**
	 * L'état initial du labyrinthe.
	 */
	private Etat _etatInitial;
	
	/**
	 * La fonction heuristique utilisée pour évaluer les états.
	 */
	private FonctionHeuristique _heuristique;
	
	
	/**
	 * Constructeur d'une partie de résolution autmatique de labyrinthe.
	 * @param etatInitial : l'état initial du jeu.
	 * @param heuristique : l'heuristique utilisée pour évaluer les états du jeu.
	 */
	public ResolutionLabyrinthe(Etat etatInitial, FonctionHeuristique heuristique) {
		this._etatInitial = etatInitial;
		this._heuristique = heuristique;
	}

	/**
	 * Méthode qui calcule l'état final atteint à partir de l'état initial, en utilisant
	 * l'algorithme A* avec l'heuristique considérée.
	 * @return l'état final s'il est accessible ou null sinon;
	 */
	public Etat getEtatFinal(){
		return AEtoile.algoAEtoile(_etatInitial, _heuristique);
	}
}
