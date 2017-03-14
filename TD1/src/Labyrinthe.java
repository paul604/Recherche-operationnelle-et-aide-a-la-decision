import java.util.Arrays;

/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe Labyrinthe : pour représenter un labyrinthe.
 *
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */


public class Labyrinthe {
	/**
	 * Le tableau représentant un labyrinthe avec ses cases accessibles.
	 */
	private boolean[][] _labyrinthe;


	/**
	 * L'abscisse de l'entrée du labyrinthe.
	 */
	private int _xEntree;

	/**
	 * L'ordonnée de l'entrée du labyrinthe.
	 */
	private int _yEntree;

	/**
	 * L'abscisse de la sortie du labyrinthe.
	 */
	private int _xSortie;

	/**
	 * L'ordonnée de la sortie du labyrinthe.
	 */
	private int _ySortie;


	/**
	 * Constructeur.
	 * @param lab : le labyrinthe courant.
	 * @param xEnt : l'abscisse de l'entrée du labyrinthe.
	 * @param yEnt : l'ordonnée de l'entrée du labyrinthe.
	 * @param xSor : l'abscisse de la sortie du labyrinthe.
	 * @param ySor : l'ordonnée de la sortie du labyrinthe.
	 */
	public Labyrinthe(boolean[][] lab, int xEnt, int yEnt, int xSor, int ySor){
		assert lab!=null && lab.length>0 && lab[0].length>0;
		this._labyrinthe=lab;
		this._xEntree=xEnt;
		this._yEntree=yEnt;
		this._xSortie=xSor;
		this._ySortie=ySor;
	}


	/**
	 * Méthode qui donne l'abscisse de la case d'entrée du labyrinthe.
	 * @return l'abscisse de la case d'entrée.
	 */
	public int getXEntree(){
		return this._xEntree;
	}


	/**
	 * Méthode qui donne l'ordonnée de la case d'entrée du labyrinthe.
	 * @return l'ordonnée de la case d'entrée.
	 */
	public int getYEntree(){
		return this._yEntree;
	}


	/**
	 * Méthode qui donne l'abscisse de la case de sortie du labyrinthe.
	 * @return l'abscisse de la case de sortie.
	 */
	public int getXSortie(){
		return this._xSortie;
	}


	/**
	 * Méthode qui donne l'ordonnée de la case de sortie du labyrinthe.
	 * @return l'ordonnée de la case de sortie.
	 */
	public int getYSortie(){
		return this._ySortie;
	}

	/**
	 * Méthode qui indique si la case de coordonnées données est accessible ou non.
	 * @param x : l'abscisse de la case.
	 * @param y : l'ordonnée de la case.
	 * @return vrai si la case courante est accessible et faux si c'est un mur.
	 */
	public boolean estAccessible(int x, int y){
		return x>0 && x<this._labyrinthe.length && y>0 && y<this._labyrinthe[0].length && this._labyrinthe[x][y];
	}


	/**
	 * Méthode qui retourne vrai si le labyrinthe donné
	 * est le même que le labyrinthe courant.
	 * @param lab le labyrinthe à comparer.
	 * @return vrai si le labyrinthe donné et le labyrinthe courant sont les mêmes.
	 */
	public boolean equals(Object lab) {
		if (this == lab) return true;
		if (lab == null || getClass() != lab.getClass()) return false;

		Labyrinthe that = (Labyrinthe) lab;

		if (_xEntree != that._xEntree) return false;
		if (_yEntree != that._yEntree) return false;
		if (_xSortie != that._xSortie) return false;
		if (_ySortie != that._ySortie) return false;
		return Arrays.deepEquals(_labyrinthe, that._labyrinthe);

	}

	@Override
	public String toString() {
		return "Labyrinthe{" +
				"_labyrinthe=" + Arrays.toString(_labyrinthe) +
				", _xEntree=" + _xEntree +
				", _yEntree=" + _yEntree +
				", _xSortie=" + _xSortie +
				", _ySortie=" + _ySortie +
				'}';
	}
}
